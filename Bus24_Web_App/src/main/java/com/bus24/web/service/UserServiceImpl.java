package com.bus24.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bus24.beans.Response;
import com.bus24.beans.User;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String registerPassenger(User user) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Your Registration is Failure!Please Try Again.\"}";
		String jsonUser = JsonUtil.convertJavaToJson(user);
		logger.info("Entered into registerPassenger :: " + jsonUser);

		String REST_REGISTER_USER = "http://localhost:8081/Bus24Webservice/user/registerPassenger";
		try {
			jsonResponse = restTemplate.postForObject(REST_REGISTER_USER, jsonUser, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  registerPassenger :: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from registerPassenger :: " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public String validateOtp(String jsonOtp) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";

		logger.info("Entered into validateOtp :: " + jsonOtp);

		String REST_VALIDATE_OTP = "http://localhost:8081/Bus24Webservice/user/validateOtp";
		try {
			jsonResponse = restTemplate.postForObject(REST_VALIDATE_OTP, jsonOtp, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while validating OTP :: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from validateOtp :: " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public String resendOtp(String jsonOtp) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";

		logger.info("Entered into resendOtp :: " + jsonOtp);

		String REST_VALIDATE_OTP = "http://localhost:8081/Bus24Webservice/user/resendOtp";
		try {
			jsonResponse = restTemplate.postForObject(REST_VALIDATE_OTP, jsonOtp, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while resending OTP :: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from resendOtp :: " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public Response loginUser(User user) {
		logger.info("Entered into loginUser :: " + user.getUserName() + " " + user.getPassword());

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to Process your Request !Please Try Again.");
		try {
			String jsonUser = JsonUtil.convertJavaToJson(user);
			String REST_LOGIN_USER = "http://localhost:8081/Bus24Webservice/user/loginUser";
			String jsonResponse = restTemplate.postForObject(REST_LOGIN_USER, jsonUser, String.class);
			logger.info("response of loginUser :: " + jsonResponse);

			response = JsonUtil.convertJsonToJava(jsonResponse, Response.class);
		} catch (RestClientException re) {
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to Process your Request !Please Try Again.");
			logger.error("Exception occured while login :: " + re.getMessage());
		}
		return response;
	}

	@Override
	public String forgotPassword(String forgotinput) {
		User user = new User();
		if (forgotinput.endsWith(".com") || forgotinput.endsWith(".in")) {
			user.setEmail(forgotinput);
		} else {
			user.setMobile(forgotinput);
		}
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again\"}";
		//

		String REST_USER_FORGOTPASSWORD = "http://localhost:8081/Bus24Webservice/users/forgotPassword";
		// RestURL.WEB_SERVICE_URL + "user/forgotPassword";
		logger.info("Entered into forgotPassword() " + forgotinput);
		String jsonUser = JsonUtil.convertJavaToJson(user);
		try {
			jsonResponse = restTemplate.postForObject(REST_USER_FORGOTPASSWORD, jsonUser, String.class);
		} catch (RestClientException e) {
			jsonResponse = "{\"status\":\"EXCEPTION\",\"message\":\"Unable to process your request!please try again\"}";
			logger.error("Exception occured while accessing resource " + REST_USER_FORGOTPASSWORD);

		}
		logger.info("response of forgotPassword() " + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String updateLogoutStatus(Long userId) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";

		logger.info("Entered into updateLogoutStatus :: " + userId);

		String REST_UPDATE_LOGOUT_STATUS = "http://localhost:8081/Bus24Webservice/user/logout?userId=" + userId;
		try {
			jsonResponse = restTemplate.getForObject(REST_UPDATE_LOGOUT_STATUS, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while updating the logout status :: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from updateLogoutStatus :: " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public String checkUserAccount(User user) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";

		logger.info("Entered into checkUserAccount:: " + user.getEmail() + " " + user.getMobile());
		String jsonUser = JsonUtil.convertJavaToJson(user);
		String REST_CHECK_USER_ACCOUNT = "http://localhost:8081/Bus24Webservice/user/checkUser";
		try {
			jsonResponse = restTemplate.postForObject(REST_CHECK_USER_ACCOUNT, jsonUser, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while checking the userAccount :: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response of checkUserAccount:: " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public User myProfile(String userName) {
		logger.info("Entered into myProfile");
		System.out.println("JSON RESPONSE:"+userName);
		User user = null;
		

		Response response = new Response();
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";

		String REST_MY_PROFILE = "http://localhost:8081/Bus24Webservice/user/showProfile";
		try {

			


			jsonResponse = restTemplate.postForObject(REST_MY_PROFILE,userName,String.class);
			
			System.out.println("JSON RESPONSE:"+jsonResponse);
		 user=JsonUtil.convertJsonToJava(jsonResponse, User.class);
			System.out.println(user.getFirstName());
			
			

		} catch (RestClientException re) {
			logger.error("Exception occured while getting my profile :: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";

		}
		logger.info("My Profile response " + jsonResponse);
		return user;
	}

	@Override
	public String updateProfile(User user) {

		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";
		String REST_PASSENGER_UPDATE = "http://localhost:8081/Bus24Webservice/user/updateProfile";
		String jsonUser = JsonUtil.convertJavaToJson(user);
		try {
			logger.info("Entered into updateProfile() " + jsonUser);
			jsonResponse = restTemplate.postForObject(REST_PASSENGER_UPDATE, jsonUser, String.class);
		} catch (RestClientException rs) {
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable To Process !Please Try Again.\"}";
			logger.error("Exception occured while accessing resource " + REST_PASSENGER_UPDATE);
		}
		logger.info("response of updateProfile() " + jsonResponse);
		return jsonResponse;
	}
	
	@Override
	public String changePassword(String userName, String currentPassword, String newPassword, String confirmPassword) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again\"}";
		String REST_PASSENGER_CHANGEPASSWORD="http://localhost:8081/Bus24Webservice/user/changePassword";
		

		try {
			if (newPassword.equals(confirmPassword)) {
				User user = new User();
					user.setUserName(userName);
					user.setPassword(currentPassword);
					user.setNewpassword(newPassword); 
				String jsonUser = JsonUtil.convertJavaToJson(user);
				jsonResponse = restTemplate.postForObject(REST_PASSENGER_CHANGEPASSWORD, jsonUser, String.class);
			} else {
				jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Passwords are Not Matching PleaseTry Again!!!\"}";
			}
		} catch (RestClientException e) {
			jsonResponse = "{\"status\":\"EXCEPTION\",\"message\":\"Unable to process your request!please try again\"}";
			logger.error("Exception occured while accessing resource ");

		}

		return jsonResponse;	
		
	}
}
