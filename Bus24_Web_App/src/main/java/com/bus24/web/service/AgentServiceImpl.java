package com.bus24.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bus24.beans.Agents;
import com.bus24.util.JsonUtil;

@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	private RestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(AgentServiceImpl.class);

	@Override
	public String searchAgent(String agencyName) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Your Search is Failure!Please Try Again.\"}";
		logger.info("entered into searchAgent method: " + agencyName);
		if (agencyName != null) {
			try {
				String SEARCH_AGENT = "http://localhost:8081/Bus24Webservice/agents/searchAgent/" + agencyName;
				jsonResponse = restTemplate.getForObject(SEARCH_AGENT, String.class);
			} catch (Exception e) {
				logger.error("Exception occured while  searching agent :: " + e);
				jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
			}
		}
		logger.info("Response from searchAgent :: " + jsonResponse);
		return jsonResponse;
	}

	/**
	 * this method is used to register Agents
	 * 
	 * @author Pramod
	 * @param jsonAgent,userId,token
	 * @return jsonResponse
	 */
	@Override
	public String registerAgent(Agents agent, Long userId, String token) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again\"}";
		  String REST_REGISTER_AGENT = "http://localhost:8081/Bus24Webservice/agents/registerAgent?userId="+userId+"&token="+token;
		System.out.println("Userstatus"+agent.getStatus());
		System.out.println("Agentstatus"+agent.getStatus());
		System.out.println("userRole"+agent.getUser().getUserRole());
		try {
			logger.info("Entered into registerAgent() try");
			// convert java to json
			String jsonAgent = JsonUtil.convertJavaToJson(agent);
			logger.info("Enter into registerAgent->" + jsonAgent);
			jsonResponse=restTemplate.postForObject(REST_REGISTER_AGENT, jsonAgent, String.class);
		} catch (RestClientException re) {
			jsonResponse = "{\"status\":\"EXCEPTION\",\"message\":\"Unable to process your request!please try again\"}";
			logger.error("Exception occured while accessing resource " + REST_REGISTER_AGENT);
		
		}
		logger.info("response of registerUser() " + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String editAgent(String jsonAgent) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Your Search is Failure!Please Try Again.\"}";
		logger.info("entered into searchAgent method: " + jsonAgent);
		if (jsonAgent != null) {
			try {
				String EDIT_AGENT = "http://localhost:8081/Bus24Webservice/agents/editAgent/" + jsonAgent;
				jsonResponse = restTemplate.getForObject(EDIT_AGENT, String.class);
			} catch (Exception e) {
				logger.error("Exception occured while  editing agent :: " + e);
				jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
			}
		}
		logger.info("Response from searchAgent :: " + jsonResponse);
		return jsonResponse;
	}
		//return null;
	

}
