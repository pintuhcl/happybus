package com.bus24.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bus24.beans.Coupon;
import com.bus24.web.service.CouponService;
@Controller
public class CouponController {
	@Autowired
	private CouponService couponService; 

	/*@RequestMapping(value="loginUser",method=RequestMethod.POST)
	public ModelAndView 
	loginUser(@ModelAttribute User user,
			HttpServletRequest req){
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.setViewName("loginUser");
	modelAndView.addObject("message","Login Failure!Please Try Again.");
 if(user!=null && user.getUserName()!=null && user.getPassword()!=null){
	
Response response=couponService.loginUser(user);
//response contain status,message ,data
  //data is nothing but  userobj(userId,username,token,userRole) in json
  if(response.getStatus().equals(StatusUtil.STATUS_SUCCESS)){
	 String jsonUser=response.getData();
	 //convert jsonUser into User object
	user=JsonUtil.convertJsonToJava(jsonUser,User.class);
	//start session (OR) get existed session
	HttpSession session=req.getSession();
	session.setAttribute("userId",user.getUserId());
	session.setAttribute("userName",user.getUserId());
	session.setAttribute("userRole",user.getUserId());
	//session.setAttribute("token",user.getUserId());
//if role is passenger then check user status is Active (OR) Mobile Not Verified
  if(user.getUserRole().equals(Roles.ROLE_SUPER_ADMIN)){	
	  if(user.getStatus().equals((byte)0)){
		//show OTP form
		 modelAndView.setViewName("otpForm");
 modelAndView.addObject("mobile",user.getMobile());
 modelAndView.addObject("userId",user.getUserId());
 modelAndView.addObject("message",response.getMessage());
 	  }  
	  
	//for other roles not required to be check user status
modelAndView.setViewName("adminDashboard");			  
  }
	
	
	
  }else{
	modelAndView.setViewName("loginUser");
	modelAndView.addObject("message",response.getMessage());
	
  }
 }
      return modelAndView;
	
	}*/
	@RequestMapping(value="addCoupon",method=RequestMethod.GET)
	public String addCoupon(@ModelAttribute("coupon") Coupon coupon){
		return "addCoupon";
	}
	@RequestMapping(value="addCoupon",method=RequestMethod.POST)
	public String addCoupon(Model model,@ModelAttribute("coupon") Coupon coupon){
		System.out.println("coupon before ");
		String jsonResponse=couponService.addCoupon(coupon);
		System.out.println("coupon after");
		model.addAttribute("coupon",jsonResponse);
		return jsonResponse;
	}
	}

	

	

	
 
 
