package com.bus24.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bus24.beans.LoginLog;
import com.bus24.beans.Response;
import com.bus24.beans.User;
import com.bus24.util.JsonUtil;
import com.bus24.util.Roles;
import com.bus24.util.StatusUtil;
import com.bus24.web.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private static final String WEB_PASSENGER_USER_FORGOT_PASSWORD = "forgot_password";

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showPassengerRegistrationPage() {
		return "passengerRegistration";
	}

	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPassenger(@ModelAttribute User user) {
		String jsonResponse = userService.registerPassenger(user);
		return jsonResponse;
	}

	@ResponseBody
	@RequestMapping(value = "validateOtp", method = RequestMethod.POST)
	public String validateOtp(@RequestBody String jsonOtp) {
		String jsonResponse = userService.validateOtp(jsonOtp);
		return jsonResponse;
	}

	@ResponseBody
	@RequestMapping(value = "resendOtp", method = RequestMethod.POST)
	public String resendOtp(@RequestBody String jsonUser) {
		String jsonResponse = userService.resendOtp(jsonUser);
		return jsonResponse;
	}

	/**
	 * this method is used to get the login page
	 * 
	 * @author Eshwar
	 * @version 1.0
	 */
	@RequestMapping(value = "loginUser", method = RequestMethod.GET)
	public String showUserLoginPage() {
		return "loginUser";
	}

	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute User user, HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginUser");

		if (user != null && user.getUserName() != null && user.getPassword() != null) {
			String userAgent = req.getHeader("user-agent");
			if (userAgent == null) {
				userAgent = "UNKNOWN";
			}
			String ipAddress = req.getRemoteAddr();
			String sessionId = req.getSession().getId();

			LoginLog loginLog = new LoginLog();
			loginLog.setIpAddress(ipAddress);
			loginLog.setLogoutStatus((byte) 0);
			loginLog.setUserAgent(userAgent);
			loginLog.setSessionId(sessionId);

			user.setLoginLog(loginLog);
			Response response = userService.loginUser(user);
			// response contain status,message ,data
			// data is nothing but userobj(userId,username,token,userRole) in
			// json
			if (response.getStatus().equals(StatusUtil.STATUS_SUCCESS)) {
				String jsonUser = response.getData();
				// convert jsonUser into User object
				user = JsonUtil.convertJsonToJava(jsonUser, User.class);
				// start session (OR) get existed session
				HttpSession session = req.getSession();
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("userRole", user.getUserRole());
				session.setAttribute("token", user.getToken());
				// if role is passenger then check user status is Active (OR)
				// Mobile Not Verified
				if (user.getUserRole().equals(Roles.ROLE_PASSENGER)) {
					if (user.getStatus().equals((byte) 0)) {
						// show OTP form
						modelAndView.setViewName("otpForm");
						modelAndView.addObject("mobile", user.getMobile());
						modelAndView.addObject("userId", user.getUserId());
						modelAndView.addObject("message", response.getMessage());
					} else {
						// forward to passengerDashboard
						modelAndView.setView(new RedirectView("passengerDashboard"));
					}
				} else {
					// for other roles not required to be check user status
					modelAndView.setView(new RedirectView("adminDashboard"));
				}

			} else {
				modelAndView.setViewName("loginUser");
				modelAndView.addObject("message", response.getMessage());

			}
		} else {
			modelAndView.addObject("message", "Login Failure!Please Try Again.");
		}
		return modelAndView;
	}

	/**
	 * the method used to show forgotpasswordForm
	 * 
	 * @param
	 * @return forgot_password
	 * @author Pradeep
	 */
	@RequestMapping(value = "forgotForm", method = RequestMethod.GET)
	public String showForgotPasswordForm() {
		return WEB_PASSENGER_USER_FORGOT_PASSWORD;
	}

	/**
	 * the method contain logic for call service to send email or mobile
	 * 
	 * @param
	 * @return jsonResponse
	 */
	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
	@ResponseBody
	public String forgotPassword(@RequestParam("email") String forgotinput) {
		String jsonResponse = "";
		jsonResponse = userService.forgotPassword(forgotinput);
		return jsonResponse;
	}

	@RequestMapping(value = "logoutUser", method = RequestMethod.GET)
	public ModelAndView logoutUser(HttpServletRequest req) {
		String status = "Your Session Already Expired";
		HttpSession session = req.getSession(false);
		if (session != null) {
			// get userId from session
			Long userId = (Long) session.getAttribute("userId");
			String jsonResponse = userService.updateLogoutStatus(userId);
			session.invalidate();
			status = "Your Are Logged out Successfully";
		}
		return new ModelAndView("home", "status", status);
	}

	@RequestMapping(value = "passengerDashboard", method = RequestMethod.GET)
	public ModelAndView showPassengerDashboard() {
		return new ModelAndView("passengerDashboard");// viewName
	}

	@RequestMapping(value = "adminDashboard", method = RequestMethod.GET)
	public ModelAndView showAdminDashboard() {
		return new ModelAndView("adminDashboard");// viewName
	}

	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String checkUserAccount(@ModelAttribute User user) {
		String jsonResponse = "";
		jsonResponse = userService.checkUserAccount(user);
		return jsonResponse;
	}
	/*@RequestMapping(value="myProfile",method=RequestMethod.GET)
	public String getSearchPage(){
		return "editPassengerDetails";
	}*/
	@RequestMapping(value = "myProfile", method = RequestMethod.GET)
	public ModelAndView myProfile(HttpServletRequest req) {     
      String username = JsonUtil.convertJavaToJson(req.getSession(false).getAttribute("userName"));
       
       User user = userService.myProfile(username);
      
    //  String jsonresp=JsonUtil.convertJavaToJson(user);
       
		ModelAndView modelAndView = new ModelAndView("editPassengerDetails","user",user);
		//return jsonresp;
		return modelAndView;
		
		 
		 
		


	}

	@RequestMapping(value = "updateProfile", method = RequestMethod.POST)
	@ResponseBody
	public String updateProfile(@ModelAttribute User user) {
		String jsonResponse = "";
		jsonResponse = userService.updateProfile(user);
		return jsonResponse;
	}
	@RequestMapping(value="changePassword",method=RequestMethod.GET)
	public String getSearchPage(){
		return "changePassword";
	}
	
	@RequestMapping(value="changePassword",method=RequestMethod.POST)
	@ResponseBody
	public String changePassword( HttpServletRequest request,
			@RequestParam("currentpassword") String currentPassword,
			@RequestParam("newpassword") String newPassword,
			@RequestParam("confirmpassword") String confirmPassword){
		String userName=(String)request.getSession(false).getAttribute("userName");
		String jsonResponse=""; 
		jsonResponse=userService.changePassword(userName,currentPassword,newPassword,confirmPassword); 
		return jsonResponse;

	}
}
