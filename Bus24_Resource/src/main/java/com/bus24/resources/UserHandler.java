package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.UserService;
import com.bus24.util.JsonUtil;

@RestController
@RequestMapping(value = "user")
public class UserHandler {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "registerPassenger", method = RequestMethod.POST)
	@ResponseBody
	public String registerPassenger(@RequestBody String jsonUser) {
		String jsonResponse = userService.registerPassenger(jsonUser);
		return jsonResponse;
	}

	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	@ResponseBody
	public String loginUser(@RequestBody String jsonUser) {
		return userService.loginUser(jsonUser);
	}

	@RequestMapping(value = "showProfile", method = RequestMethod.POST)
	@ResponseBody
	public String showProfile(@RequestBody String jsonUser) {
	
		String jsonresp;
		jsonresp = userService.showMyprofile(jsonUser);
		System.out.println(jsonresp);
		return  jsonresp;
		  

	}

	@RequestMapping(value = "updateProfile", method = RequestMethod.POST)
	@ResponseBody
	public String updateProfile(@RequestBody String jsonUser) {
		return userService.updateMyprofile(jsonUser);

	}

	@RequestMapping(value = "validateOtp", method = RequestMethod.POST)
	@ResponseBody
	public String validateOtp(@RequestBody String jsonOtp) {
		return userService.validateOtp(jsonOtp);
	}

	@RequestMapping(value = "resendOtp", method = RequestMethod.POST)
	@ResponseBody
	public String resendOtp(@RequestBody String jsonUser) {
		return userService.resendOTP(jsonUser);
	}
	/** 
	 * the method is a resource method for ForgotPassword
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 * @author Pradeep
	 */
	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
	@ResponseBody
	public String forgotPassword(@RequestBody String jsonUser) {
		return userService.forgotPassword(jsonUser);

	}
	/**
	 * the method is a resource method for changePassword
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 * @author manohar
	 */
	@RequestMapping(value = "changepassword", method = RequestMethod.POST)
	@ResponseBody
	public String changePassword(@RequestBody String jsonUser) {
		return userService.changePassword(jsonUser);

	}


	@RequestMapping(value = "logout", 
			method = RequestMethod.GET)
	@ResponseBody
	public String updateLogoutStatus(@RequestParam("userId") Long userId) {
		String jsonResponse = userService.updateLogoutStatus(userId);
		return jsonResponse;
	}
	
	
	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String checkUserAccount(@RequestBody String jsonUser) {
		String jsonResponse = userService.checkUserAccount(jsonUser);
		return jsonResponse;
	}
}
