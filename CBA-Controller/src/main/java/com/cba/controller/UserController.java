package com.cba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView showLoginPage(
		@RequestParam(name="error",required=false)  String error){
	  System.out.println("show Login page");
	  String status="";
	  if(error!=null && error.equals("invalid")){
		  status="Invalid UserName And Password";
	  }
	  
		return new ModelAndView("loginForm","status",status);
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public ModelAndView logout(){
	String status="You Are Logged Out Successfully ";
	return new ModelAndView("loginForm","status",status);
	}
	@RequestMapping(value="sessionExpired",method=RequestMethod.GET)
	public ModelAndView sessionExpired(){
		String status="Your Session Expired!Please Login."; 
		return new ModelAndView("loginForm","status",status); 
	}
}
