package com.bus24.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.bus24.beans.Response;
import com.bus24.beans.Travel;
import com.bus24.beans.User;
import com.bus24.dao.TravelsDAO;
import com.bus24.exceptions.UserNotAuthenticatedException;
import com.bus24.integration.UserSmsServiceClient;
import com.bus24.util.JsonUtil;
import com.bus24.util.PasswordGenerator;
import com.bus24.util.SmsTemplates;
import com.bus24.util.StatusUtil;

@Service
public class TravelServiceImpl implements TravelService {
	private static Logger logger = Logger.getLogger(TravelServiceImpl.class);
	@Autowired
	private TravelsDAO travelsDAO;
	@Autowired
	private UserAuthenticationService userAuthenticationService;
	@Autowired
	private UserSmsServiceClient smsServiceClient;
      @Autowired
	  private MailService mailService;
	public String registerTravel(String jsonTravel, Long userId, String token) {
		Response response = new Response();
		String jsonResponse = " ";
		response.setMessage("Travel Registration Failure!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {
	logger.info("Entered into registerTravel : "+jsonTravel+" "+userId+" "+token);		
			if (userAuthenticationService.isAuthenticated(userId, token)) {
				Travel travel = JsonUtil.convertJsonToJava(jsonTravel, Travel.class);
				// check user is authenticated (OR) not
				if (travel != null && travel.getUser() != null && travel.getBankDetails() != null) {
					User user = travel.getUser();
					user.setUserName(travel.getEmail());
					user.setEmail(travel.getEmail());
					String password = PasswordGenerator.generatePassword();
					// encrypt the password
					user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
					travel.setUser(user);

					// if user authenticated then call DAO's
					Long travelId = (Long) travelsDAO.registerTravel(travel);

					if (travelId != null && travelId > 0) {
						response.setMessage("Travel " + travel.getTravelName() + "  is registered successfully");
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						// send sms
						String sms = "Dear Travel Use this UserName=" + travel.getUser().getUserName()
								+ " and   Password=" + password + " for Login - Thank you Bus24.com";
						String smsStatus = smsServiceClient.sendSms(travel.getUser().getMobile(), sms,
								SmsTemplates.SMS_TEMP_ID_OTP);
						logger.info("Sms Status : " + smsStatus);
						// send email
   String subject="Registration Confirmation";
   String emailBody=" Thank you for Choosing Bus24.com."+"\n "+"Dear Travel Use this UserName=" + travel.getUser().getUserName()
			+ " and   Password=" + password + " for Login - Thank you Bus24.com";
				
	String status=mailService.sendEmail(travel.getEmail(), subject,emailBody);		
				
	logger.info("Email Status : "+status);				
					}
				}
			}
		} catch (UserNotAuthenticatedException e) {
			logger.info("Exception Occured while Authenticating of User : " + e.getMessage());
			response.setMessage(e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Registering the Travel : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Registering the Travel : " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info("Response from Register Travel : " + jsonResponse);
		return jsonResponse;
	}

	/**
	 * this method is used to search for travel
	 * 
	 * @author Eshwar,Abdul
	 * @param jsonTravel
	 * @return String
	 */

	@Override
	public String searchTravel(String jsonTravel, Long userId, String token) {
		Travel travel = null;
		Response response = new Response();
		String jsonResponse = " ";
		List<Travel> listTravels = null;
		response.setMessage("Searching Travels  Failure!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		// convert json to java
		travel = JsonUtil.convertJsonToJava(jsonTravel, Travel.class);
		try {
			if (travel != null) {
				// Authentication check
				if (userAuthenticationService.isAuthenticated(userId, token)) {
					// call DAOTravel
					listTravels = travelsDAO.searchTravel(travel);
					response.setStatus(StatusUtil.STATUS_SUCCESS);
				} // if
			} // if
		} catch (UserNotAuthenticatedException ue) {
			logger.info("Exception occured when user  Authentication fail ", ue);
			response.setMessage(ue.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		catch (DataAccessException de) {
			logger.info("Exception occured when problm come from DB", de);
			response.setMessage(de.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		catch (Exception e) {
			logger.fatal("exception occured when Unknown Exception come", e);
			response.setMessage(e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
			// convert list of travels to list of jsonResponse

		jsonResponse = JsonUtil.convertJavaToJson(listTravels);
		response.setData(jsonResponse);
		return jsonResponse;

	}

	/**
	 * this method is used to get all travel
	 * 
	 * @author Eshwar,Abdul
	 * @param String,Long,String
	 * @return String
	 */
	@Override
	public String editTravel(String jsonTravel, Long userId, String token) {
		Travel travel = null;
		Integer count = null;
		Response response = new Response();
		String jsonResponse = "";
		logger.info("Entered into editTravel() of TravelServiceImpl class ");
		response.setMessage(" Travel Updated Failure!Plz Try again");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {
			if (userAuthenticationService.isAuthenticated(userId, token)) {
				travel = JsonUtil.convertJsonToJava(jsonTravel, Travel.class);
				if (travel != null) {
					count = (Integer)travelsDAO.editTravel(travel);
					if (count > 0) {
						response.setMessage("Travel Updated Successfully");
						response.setStatus(StatusUtil.STATUS_SUCCESS);
					} // if
				} // if
			} // if
		} // try
		catch (UserNotAuthenticatedException ue) {
			logger.info("Exception occured when user  Authentication fail ", ue);
			response.setMessage(ue.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		catch (DataAccessException de) {
			logger.info("Exception occured when problm come from DB", de);
			response.setMessage("Unable to process the request");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		catch (Exception e) {
			logger.fatal("exception occured when Unknown Exception come", e);
			response.setMessage(e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info("En of the editTravel() of TravelServiceImpl class ");
		return jsonResponse;
	}

	/**
	 * this method is used to get all travel
	 * 
	 * @author Mulayam
	 * @return List<Travel>
	 */
	@Override
	public String getAllTravel() {

		Response response = new Response();
		response.setMessage("Could not get travel list !Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);

		try {

			List<Travel> list = travelsDAO.getAllTravel();

			if (list != null && list.size() > 0) {
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("Travel Data Fetched");
				response.setData(JsonUtil.convertJavaToJson(list));

			} else {
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("Travel Data Not Found");

			}

		} catch (DataAccessException de) {
			logger.info("Exception occured while fetching trave list from database", de);
			response.setMessage("Unable to process your request ! please try again");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} catch (Exception e) {
			logger.info("Exception occured while fetching trave list from database", e);
			response.setMessage("Unable to process your request ! please try again");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		return JsonUtil.convertJavaToJson(response);

	}

}
