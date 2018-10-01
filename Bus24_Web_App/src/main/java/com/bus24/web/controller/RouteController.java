/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bus24.beans.Route;
import com.bus24.web.service.RouteService;

/**
 * @author mulayam
 */
@Controller
public class RouteController {

	@Autowired
	private RouteService routeService;

	@GetMapping("sourceList")
	@ResponseBody
	public String getSouceList() {
		return routeService.getSouceList();

	}

	@GetMapping("destinationList")
	@ResponseBody
	public String getDestinationList() {
		return routeService.getDestinationList();
	}

	/**this method is used to get the searchRoute page
	 * @author shankar sarkar
	 * @version 1.0
	 */
	@RequestMapping(value="searchRoute",method=RequestMethod.GET)
	public String getSearchPage(){
		return "search_route";
	}
	/**this method is used to search the Route 
	 * @author shankar sarkar
	 * @version 1.0
	 */
	@ResponseBody
	@RequestMapping(value="searchroute",method=RequestMethod.POST)
	public String searchRoute(@ModelAttribute Route route,HttpServletRequest req){
		 if(req.getSession(false)!=null){
			 return  routeService.searchRoute(route,(Long)req.getSession(false).getAttribute("userId"),(String)req.getSession(false).getAttribute("token"));
	        }
	        else{
	        	String jsonResponse = "{\"status\":\"SESSIONEXPIRED\",\"message\":\"Your Session Expired.Please Login!\"}";
	       	 return jsonResponse;		
	        }	
		
	}//method	
	
	
	/**this method is used to update Route 
	 * @author 
	 * @version 1.0
	 */
	@ResponseBody
	@RequestMapping(value="updateRoute",method=RequestMethod.POST)
	public String updateRoute(@ModelAttribute Route route,HttpServletRequest req){
        if(req.getSession(false)!=null){
        	return  routeService.updateRoute(route,(Long)req.getSession(false).getAttribute("userId"),(String)req.getSession(false).getAttribute("token"));
        }
        else{
        	String jsonResponse = "{\"status\":\"SESSIONEXPIRED\",\"message\":\"Your Session Expired.Please Login!\"}";
       	 return jsonResponse;		
        }	
	}//method

}
