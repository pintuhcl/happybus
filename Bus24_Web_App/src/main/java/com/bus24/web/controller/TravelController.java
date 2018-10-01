
/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bus24.beans.BankDetails;
import com.bus24.beans.Travel;
import com.bus24.beans.User;
import com.bus24.util.Roles;
import com.bus24.web.service.TravelService;

/**
 * 
 * @author mulayam
 * @version 1.0
 */
@Controller
public class TravelController {

	@Autowired
	private TravelService travelService;

	/**
	 * this method get all travel
	 * @author mulayam
	 * @return json of travelist
	 */
	@GetMapping("getAllTravel")
	@ResponseBody
	public String getAllTravel() {
		return travelService.getAllTravel();
	}
	
	/**this method is used to get the searchTravel page
	 * @author Eshwar
	 * @version 1.0
	 */
	@RequestMapping(value="searchTravel",method=RequestMethod.GET)
	public String getSearchPage(){
		return "search_travel";
	}
	/**this method is used to search the Travel 
	 * @author Eshwar
	 * @version 1.0
	 */
	@ResponseBody
	@RequestMapping(value="searchTravel",method=RequestMethod.POST)
	public String searchTravel(@ModelAttribute Travel travel,HttpServletRequest req){
		 if(req.getSession(false)!=null){
			 return  travelService.searchTravel(travel,(Long)req.getSession(false).getAttribute("userId"),(String)req.getSession(false).getAttribute("token"));
	        }
	        else{
	        	String jsonResponse = "{\"status\":\"SESSIONEXPIRED\",\"message\":\"Your Session Expired.Please Login!\"}";
	       	 return jsonResponse;		
	        }	
		
	}//method	
	
	/**this method is used to update Travel 
	 * @author Eshwar
	 * @version 1.0
	 */
	@ResponseBody
	@RequestMapping(value="updateTravel",method=RequestMethod.POST)
	public String updateTravel(@ModelAttribute Travel travel, @ModelAttribute BankDetails  bankDetails,HttpServletRequest req){
        travel.setBankDetails(bankDetails);
        if(req.getSession(false)!=null){
        	return  travelService.updateTravel(travel,(Long)req.getSession(false).getAttribute("userId"),(String)req.getSession(false).getAttribute("token"));
        }
        else{
        	String jsonResponse = "{\"status\":\"SESSIONEXPIRED\",\"message\":\"Your Session Expired.Please Login!\"}";
       	 return jsonResponse;		
        }	
	}//method
	@ResponseBody
@RequestMapping(value="addTravel",method=RequestMethod.POST)
	public String addTravel(@ModelAttribute Travel travel,
			@ModelAttribute	BankDetails bankDetails,
			@ModelAttribute User user,HttpServletRequest request){

	if(request.getSession(false)!=null){
  user.setUserRole(Roles.ROLE_TRAVEL_ADMIN);
  user.setAddress(travel.getCity());
  user.setEmail(travel.getEmail());
  user.setStatus((byte)1);
  user.setCreatedDate(new Date());
  user.setCreatedBy((Long)request.getSession(false).getAttribute("userId"));
	user.setZipCode(travel.getZipcode());
  travel.setStatus((byte)1);
  travel.setUser(user);
		travel.setBankDetails(bankDetails);
	return travelService.addTravel(travel,request.getSession(false).getAttribute("userId"),request.getSession(false).getAttribute("token"));
		
	}else{
	String jsonResponse = "{\"status\":\"SESSIONEXPIRED\",\"message\":\"Your Session Expired.Please Login!\"}";
	 return jsonResponse;		
	}
	}
	
	@RequestMapping(value="addTravel",method=RequestMethod.GET)
	public String showTravelPage(){
		return "addTravel";
	}
}



