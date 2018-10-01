/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.AgentService;

@RestController
@RequestMapping(value = "agents")
public class AgentHandler {
	@Autowired
	private AgentService agentService;

	@ResponseBody
	@RequestMapping(value = "registerAgent", method = RequestMethod.POST)
	public String registerAgent(@RequestBody String jsonAgent, @RequestParam("userId") Long userId,
			@RequestParam("token") String token) {
		String jsonResponse = agentService.registerAgent(jsonAgent,userId, token);
		return jsonResponse;

	}

	@ResponseBody
	@RequestMapping(value = "searchAgent/{agencyname}", produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public String searchAgent(@PathVariable("agencyname")String agencyName)
	{
		String jsonResponse = agentService.searchAgent(agencyName);
		return jsonResponse;

	}
	@ResponseBody
	@RequestMapping(value ="editAgent",method=RequestMethod.POST)
	public String editAgent(@RequestBody String jsonAgent)
	{
		 return agentService.editAgent(jsonAgent);
		
		
	}

	
}
