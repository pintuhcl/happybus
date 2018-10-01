/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.bus24.beans.LoginLog;
import com.bus24.beans.OtpBean;
import com.bus24.beans.Response;
import com.bus24.beans.User;
import com.bus24.dao.LoginLogDAO;
import com.bus24.dao.OtpLogDAO;
import com.bus24.dao.UserAuthenticationDAO;
import com.bus24.dao.UsersDAO;
import com.bus24.integration.UserSmsServiceClient;
import com.bus24.util.JsonUtil;
import com.bus24.util.OTPGenerator;
import com.bus24.util.Roles;
import com.bus24.util.SmsTemplates;
import com.bus24.util.StatusUtil;
import com.bus24.util.TokenUtil;
import com.bus24.util.ValidationUtil;

/**
 * This interface is gather user module requirements
 * 
 * @author sathish
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	private static final String DBConstants = null;
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private OtpLogDAO otpLogDAO;
	@Autowired
	private UserSmsServiceClient smsServiceClient;
	@Autowired
	private UserAuthenticationDAO userAuthenticationDAO;
     @Autowired
	private LoginLogDAO loginLogDAO;
	/**
	 * this method is used to registerPassenger
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 */
	@Override
	public String registerPassenger(String jsonUser) {
		logger.info("Entered into registerPassenger : " + jsonUser);
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Registration is Failure!Please Try Again");
		// convert jsonUser into java object
		User user = JsonUtil.convertJsonToJava(jsonUser, User.class);
		try {
			if (user != null) {
				// server side validations
				if (ValidationUtil.isValidEmail(user.getEmail()) && ValidationUtil.isValidMobile(user.getMobile())
						&& ValidationUtil.isValidPassword(user.getPassword())) {
					// set userName,userRole,status
					user.setUserName(user.getEmail());
					user.setUserRole(Roles.ROLE_PASSENGER);
					user.setStatus((byte) 0);
					// encrypt the password
					user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
					// call userDao method
					Long userId = (Long) usersDAO.registerPassenger(user);
					if (userId != null && userId > 0) {
						// generate OTP ,send sms and email and save into db
						int otp = OTPGenerator.generateOtp();
						Integer count = otpLogDAO.saveOtp(otp, userId);

						if (count != null && count > 0) {
							logger.info("Sending Sms ....." + count);
							// send sms
							String sms = "Dear user OTP(One Time Password) for registration is " + otp
									+ ". Please use this OTP to complete the registration. - MythriBus;";
							String smsStatus = smsServiceClient.sendSms(user.getMobile(), sms,
									SmsTemplates.SMS_TEMP_ID_OTP);
							logger.info("Sms Status : " + smsStatus);
						}
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Please Enter OTP Sent to registered mobile");
						user.setUserId(userId);
						user.setPassword(null);
						user.setMobile("XXXXXX" + user.getMobile().substring(6));
						jsonUser = JsonUtil.convertJavaToJson(user);
						response.setData(jsonUser);
					}
				} else {
					// prepare jsonResponse as Please Enter Valid inputs
					response.setStatus(StatusUtil.STATUS_FAILURE);
					response.setMessage("Please Enter Valid Input");
				}
			}

		}

		catch (DataAccessException de) {
			response.setStatus(StatusUtil.STATUS_FAILURE);

			logger.error("Exception occured while registering the Passenger :: " + de.getMessage());
			if (de.getMessage().contains("user_email_uk")) {
				response.setMessage("Email Already Existed.");

			} else if (de.getMessage().contains("user_mobile_uk")) {
				response.setMessage("Mobile Already Existed.");

			} else {
				response.setMessage("Unable to process your request!Please Try Again");

			}

		} catch (Exception e) {
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process your request!Please Try Again");
			logger.error("Exception occured while registering the Passenger :: " + e.getMessage());
		}
		// convert Response obj into json
		String jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info("Response from register User :: " + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String loginUser(String jsonUser) {
		logger.info("Entered into loginUser : " + jsonUser);

		Response response = new Response();
		response.setMessage("Login Failure!Please Try Again");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		// convert jsonUser into java obj
		try {
			User user = JsonUtil.convertJsonToJava(jsonUser, User.class);
		LoginLog loginLog=user.getLoginLog();	
			if (user != null && user.getUserName() != null && user.getPassword() != null) {
				String hashPwd = usersDAO.getHashPassword(user.getUserName());
				if (BCrypt.checkpw(user.getPassword(), hashPwd)) {
					// call DAO to get user details
					user = usersDAO.getUserDetails(user.getUserName());
					if (user.getUserId() != null && user.getUserId() > 0 && user.getStatus() != null
							&& user.getUserRole() != null) {
						if (!user.getUserRole().equals(Roles.ROLE_SUPER_ADMIN) && user.getStatus().equals((byte) 2)) {
							response.setMessage("Your Account is blocked!Please contact helpdesk@bus24.com");
							response.setStatus(StatusUtil.STATUS_FAILURE);
						} else if (!user.getUserRole().equals(Roles.ROLE_SUPER_ADMIN)
								&& user.getStatus().equals((byte) 3)) {
							response.setMessage("Your Account is Inactive!Please contact helpdesk@bus24.com");
							response.setStatus(StatusUtil.STATUS_FAILURE);
						} else if (user.getStatus().equals((byte) 1) 
								|| user.getStatus().equals((byte) 0)) {
							
				// generate random token,,save into db
				String token=TokenUtil.generateToken();
							Integer count = 
				userAuthenticationDAO.saveToken(token,
									user.getUserId());
							if (count != null && count > 0) {
								user.setToken(token);
								user.setPassword(null);
								response.setStatus(StatusUtil.STATUS_SUCCESS);
								response.setMessage("Login Success");
								// convert user into json
								jsonUser = JsonUtil.convertJavaToJson(user);
								response.setData(jsonUser);
								if (user.getUserRole().equals(Roles.ROLE_PASSENGER)
										&& user.getStatus().equals((byte) 0)) {
									// generate the OTP save into db ,send sms
									int otp = OTPGenerator.generateOtp();
									count = otpLogDAO.saveOtp(otp, user.getUserId());
									logger.info("Sending Sms ....." + count);
									String sms = "Dear user OTP(One Time Password) for registration is " + otp
											+ ". Please use this OTP to complete the registration. - MythriBus;";
									String status = smsServiceClient.sendSms(user.getMobile(), sms,
											SmsTemplates.SMS_TEMP_ID_OTP);
									logger.info("Sms status ....." + status);
								}
       //save loginLog info into db
		 if(loginLog!=null){
			try{ 
	logger.info("Saving LoginLog Details into db :"+user.getUserId());			
	count=loginLogDAO.saveLoginLogDetails(loginLog,user.getUserId());	 
			}catch(Exception e){
	logger.error("Exception Occured while Saving the LoginLog Details "+e.getMessage());			
			}
			}
								
							} else {
								response.setMessage("Unable to process your request!Please Try Again");
								response.setStatus(StatusUtil.STATUS_FAILURE);
							}
							
							
							
							
							
							
							
						}
					} else {
						response.setMessage("Unable to process your request!Please Try Again");
						response.setStatus(StatusUtil.STATUS_FAILURE);
					}
				} else {
					response.setMessage("Please Enter Valid UserName and Password");
					response.setStatus(StatusUtil.STATUS_FAILURE);
				}
				
			}

		} catch (DataAccessException de) {
			logger.error("Exception Occured while Login User :: " + de.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process your request!Please Try Again.");
		} catch (Exception e) {
			logger.error("Exception Occured while Login User :: " + e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process your request!Please Try Again.");
		}
		// convert response obj into json
		String jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info("response from Login User : " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public String showMyprofile(String jsonuser) {
		String jsonresponse = "";
		logger.info("Entered into Showmyprofile : " + jsonuser);
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to process your request!Please Try Again.");
		if (jsonuser != null) {
			try {
				String userName = JsonUtil.convertJsonToJava(jsonuser, String.class);
				User user = usersDAO.showMyprofile(userName);
				jsonresponse = JsonUtil.convertJavaToJson(user);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("Please Makesure Update your Profile");
				response.setData(jsonresponse);
			}

			catch (DataAccessException de) {
				response.setStatus(StatusUtil.STATUS_FAILURE);
				response.setMessage("unable to process your request!please try again");
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(StatusUtil.STATUS_FAILURE);
				response.setMessage("Unable to process!Please Try Again");
				logger.error("Exception Occured while Getting The Profile ::" + e.getMessage());
			}

		}

		return jsonresponse;
	}

	@Override
	public String updateMyprofile(String jsonUser) {
		String jsonResponse = "";
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Updating MyProfile is Failure!Please Try Again.");
		try {
			if (jsonUser != null) {
				User user = JsonUtil.convertJsonToJava(jsonUser, User.class);
				if (user != null) {
					Integer count = usersDAO.updateMyprofile(user);
					if (count > 0) {
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Your Profile Updated Successfully");

						jsonResponse = JsonUtil.convertJavaToJson(response);
					}
				}

			}
		} catch (DataAccessException de) {
			de.printStackTrace();
			logger.error("Exception occured while Updating Profile");
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("unable to process your request!please try again");

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process!Please Try Again");
		}

		return jsonResponse;
	}

	@Override
	public String validateOtp(String jsonOtp) {
		Response response=new Response();
	logger.info("Entered into validateOTP() "+jsonOtp);
		// convert json into OTP obj
		try{
		OtpBean otpBean=JsonUtil.convertJsonToJava(jsonOtp,OtpBean.class);	
		
// call DAO
   Map<String,Object> resultMap
   =otpLogDAO.validateOtp(otpBean.getUserId());
   if(resultMap!=null && resultMap.size()>0){
	Integer dbOtp=(Integer)resultMap.get("otp");
	 Long minutes=(Long)resultMap.get("minute_diff");
	if(otpBean.getOtp().equals(dbOtp)){ 
		if(minutes<=20){
//update user status in db
	Integer count=usersDAO.updateUserStatus(otpBean.getUserId(),1);
		if(count!=null && count>0){
	response.setMessage("Your Registration Successfully completed.Please Login!");	
	response.setStatus(StatusUtil.STATUS_SUCCESS);
		}else{
			response.setMessage("Unable to process your Request!Please Try Again.");	
			response.setStatus(StatusUtil.STATUS_FAILURE);
				
		}
		}else{
	response.setMessage("Your OTP Expired!");		
	response.setStatus(StatusUtil.STATUS_FAILURE);

		}
	}else{
		response.setMessage("Invalid OTP");
		response.setStatus(StatusUtil.STATUS_FAILURE);

	}
	
   }
		}catch(DataAccessException de){
	response.setStatus(StatusUtil.STATUS_FAILURE);		
	response.setMessage("Unable to process Your Request !Please Try Again");	
	logger.error("Exception Occured while validateOTP() "+de.getMessage());
	
		}
		catch(Exception e){	
			logger.error("Exception Occured while validateOTP() "+e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);	
			response.setMessage("Unable to process Your Request !Please Try Again");	
			}
   // produce jsonResponse
String jsonResponse=JsonUtil.convertJavaToJson(response);
logger.info("Response from validateOTP() "+jsonResponse);
	
return jsonResponse;
	}

	@Override
	public String resendOTP(String jsonUser) {

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Could not send message");

		try {
			if (jsonUser != null) {

				User user = JsonUtil.convertJsonToJava(jsonUser, User.class);

				int otp = OTPGenerator.generateOtp();
				Integer count = otpLogDAO.saveOtp(otp, user.getUserId());
				if (count != null && count > 0) {

					// get User Details

					user.setMobile(usersDAO.getUserByUserId(user.getUserId()).getMobile());
					
					String sms = "Dear user OTP(One Time Password) for registration is " + otp
							+ ". Please use this OTP to complete the registration. - MythriBus;";
					String status = smsServiceClient.sendSms(user.getMobile(), sms, SmsTemplates.SMS_TEMP_ID_OTP);
					logger.info("Messages sent to mobile");
					
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage(status);

				}
			}
		} catch (DataAccessException e) {
			logger.error("Exception ", e);
			
			response.setMessage("Unable to process request");
		} catch (Exception e) {
			logger.error("Exception ", e);
			
			response.setMessage("Unable to process request");
		}
		return JsonUtil.convertJavaToJson(response);
		}

	@Override
	public String forgotPassword(String jsonUser) {
		
		String jsonResponse = "";
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Forgot Password Failure!Please Try Again.");
		logger.info("Entered into Forgot Password Method  :: " + jsonUser);
		User user = JsonUtil.convertJsonToJava(jsonUser, User.class);
		return jsonResponse;
		
		
		}

	@Override
	public String changePassword(String jsonUser) {
		String jsonResponse ="";
		Integer count ;
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Change Password Failure!Please Try Again.");
		logger.info("Entered into Change Password Method  :: " + jsonUser);
		User user = JsonUtil.convertJsonToJava(jsonUser, User.class);
		if (user != null) {
			try {
				String hasPwd = usersDAO.getHashPassword(user.getUserName());
				if (BCrypt.checkpw(user.getPassword(), hasPwd)) {
					user.setNewpassword(BCrypt.hashpw(user.getNewpassword(), BCrypt.gensalt()));
					 count = usersDAO.changePassword(user);
			
				if (count > 0) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Your Password is Updated Successfully!!!");
				} else {
					response.setStatus(StatusUtil.STATUS_FAILURE);
					response.setMessage("Problem occured While Accessing Please Try Again");
				}
			}
			else {
				response.setStatus(StatusUtil.STATUS_FAILURE);
				response.setMessage("Your CurrentPassword is Wrong Please Try again!!");
			}
		
			}	catch (IncorrectResultSizeDataAccessException ie) {
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Invalid Password Details");
			logger.info("Invalid Password Details");
		} catch (DataAccessException de) {
			de.printStackTrace();
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process!Please Try Again");
			logger.error("Exception Occured while Changing The Password ::" + de.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process!Please Try Again");
			logger.error("Exception Occured while Changing The Password ::" + e.getMessage());
		}
	}
	jsonResponse = JsonUtil.convertJavaToJson(response);
	logger.info("Response of Change Password :: " + jsonResponse);
	return jsonResponse;
	}

	@Override
	public String updateLogoutStatus(Long userId) {
	String jsonResponse="";	
	Response response=new Response();
	response.setStatus(StatusUtil.STATUS_FAILURE);
	response.setMessage("Logout Status Updating is Failure");
	try{	
	if(userId!=null){
	int count=usersDAO.updateLogoutStatus(userId,1);
	      /*
		  * logout status ->0 means not logged out
		  *               ->1 means logged out successfuly
		  */
	if(count>0){
		response.setStatus(StatusUtil.STATUS_SUCCESS);
		response.setMessage("Logout Status Updated successfully");
	}
}
	}catch(DataAccessException de){
logger.error("Exception occured while updating the Logout Status "+de.getMessage());
response.setStatus(StatusUtil.STATUS_FAILURE);
response.setMessage("Unable to process your request");

	}
	catch(Exception de){
		logger.error("Exception occured while updating the Logout Status "+de.getMessage());
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to process your request");
		}
jsonResponse=JsonUtil.convertJavaToJson(response);	
		return jsonResponse;
	}
@Override
	public String checkUserAccount(String jsonUser) {
String jsonResponse="";
Response response=new Response();

  logger.info("Entered into checkUserAccount ::"+jsonUser);
  try{
  User user=JsonUtil.convertJsonToJava(jsonUser,User.class);		
 if(user!=null && user.getEmail()!=null && user.getMobile()!=null){
	 if(usersDAO.checkEmail(user.getEmail())){
  response.setMessage("Email Already Registered!");
  response.setStatus(StatusUtil.STATUS_SUCCESS);
	 }else if(usersDAO.checkMobile(user.getMobile())) {
		 response.setMessage("Mobile Already Registered!");
		  response.setStatus(StatusUtil.STATUS_SUCCESS);			 
	 }
 }
  }catch(DataAccessException de){
	  logger.error("Exception occured while checking UserAccount "+de.getMessage());
	  response.setStatus(StatusUtil.STATUS_FAILURE);
	  response.setMessage("Unable to process your request!Please try Again.");

	  	}
	  	catch(Exception de){
	  		logger.error("Exception occured while Checking UserAccount "+de.getMessage());
	  		response.setStatus(StatusUtil.STATUS_FAILURE);
	  		response.setMessage("Unable to process your request!Please try Again.");
	  		}
	  jsonResponse=JsonUtil.convertJavaToJson(response);	
	  		return jsonResponse;
	}
}



