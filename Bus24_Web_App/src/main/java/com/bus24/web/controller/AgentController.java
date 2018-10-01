/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import com.bus24.beans.Agents;
import com.bus24.beans.BankDetails;
import com.bus24.beans.User;
import com.bus24.util.Roles;
import com.bus24.web.service.AgentService;

/**
 * 
 * @author damodar,sekhar
 * @version 1.0
 */
@Controller
public class AgentController {

	@Autowired
	private AgentService agentService;

	/**
	 * this method is used to get the searchTravel page
	 * 
	 * @author damodar,sekhar
	 * @version 1.0
	 */
	@RequestMapping(value = "searchAgent", method = RequestMethod.GET)
	public String showSearchPage() {
		return "searchAgent";
	}

	/**
	 * this method is used to search the Travel
	 * 
	 * @author damodar,sekhar
	 * @version 1.0
	 */

	@RequestMapping(value = "searchAgent", method = RequestMethod.POST)
	public String searchAgent(@RequestParam("agencyName") String agencyName) {

		return agentService.searchAgent(agencyName);

	}

	/**
	 * this method is used to show the register_Agent jsp page
	 * 
	 * @author pramod
	 * @version 1.0
	 */

	@RequestMapping(value = "registerAgent", method = RequestMethod.GET)
	public String showRegisterAgentPage() {
		return "register_Agent";

	}

	/**
	 * this method is used to register the Agent
	 * 
	 * @author pramod
	 * @version 1.0
	 */
	@ResponseBody
	@RequestMapping(value = "registerAgent", method = RequestMethod.POST)
	public String registerAgent(@ModelAttribute Agents agent, @ModelAttribute User user,
			@ModelAttribute BankDetails bankDetails, HttpServletRequest req) {

		
		if(req.getSession(false)!=null){
			user.setAddress(agent.getAddressLine1());
			user.setEmail(user.getEmail());
			user.setUserName(agent.getEmail());
			user.setUserRole(Roles.ROLE_AGENT);
			user.setStatus((byte) 1);
			agent.setStatus((byte) 1);
			agent.setCreatedBy((Long) req.getSession(false).getAttribute("userId"));
			agent.setUser(user);
			agent.setBankDetails(bankDetails);

			System.out.println("Userstatus===>" + user.getStatus());
			System.out.println("Agentstatus===>" + agent.getStatus());
			System.out.println("userRole===>" + user.getUserRole());
		return agentService.registerAgent(agent, (Long) req.getSession(false).getAttribute("userId"),(String) req.getSession(false).getAttribute("token"));

		} else {
			String jsonResponse = "{\"status\":\"SESSIONEXPIRED\",\"message\":\"Your Session Expired.Please Login!\"}";
			 return jsonResponse;		
			}
		
	}

	@RequestMapping(value = "editAgent", method = RequestMethod.POST)
	public String editAgent(@RequestBody String jsonAgent) {
		return agentService.editAgent(jsonAgent);

	}

}
