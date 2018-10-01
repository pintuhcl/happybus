/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bus24.beans.Travel;
import com.bus24.util.JsonUtil;

/**
 * @author mulayam
 * @version 1.0
 */
@Service
public class TravelServiceImp implements TravelService {

	private static Logger logger = Logger.getLogger(TravelServiceImp.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getAllTravel() {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the travel list!Please Try Again.\"}";

		logger.info("Entered into getAllTravel");

		final String REST_GET_ALL_TRAVEL = "http://localhost:8081/Bus24Webservice/travels/getAllTravel";
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_TRAVEL, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  fetching travel list:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from getAllTravel :: " + jsonResponse);
		return jsonResponse;
	}
	

	/**
	 * @author Eshwar,Abdul
	 * @version 1.0
	 */
	@Override
	public String searchTravel(Travel travel,Long userId,String token) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Searching Travel is Failure!Please Try Again.\"}";
		//convert java to json
		String jsonTravel = JsonUtil.convertJavaToJson(travel);
		logger.info("Entered into searchTravel :: " + jsonTravel);
       String REST_SEARCH_TRAVEL = "http://localhost:8081/Bus24Webservice/travels/searchTravel?userId="+userId+"&token="+token;
       try {
			jsonResponse = restTemplate.postForObject(REST_SEARCH_TRAVEL, jsonTravel, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  searchingTravel:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from searchTravel :: " + jsonResponse);

		return jsonResponse;
	}//method


	@Override
	public String addTravel(Travel travel, Object userId, Object token) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Travel Registration is Failure!Please Try Again.\"}";
		//convert java to json
		String jsonTravel = JsonUtil.convertJavaToJson(travel);
		logger.info("Entered into addTravel :: " + jsonTravel+" "+userId+" "+token);
       String REST_ADD_TRAVEL = "http://localhost:8081/Bus24Webservice/travels/registerTravel?userId="+userId+"&token="+token;
       try {
			jsonResponse = restTemplate.postForObject(REST_ADD_TRAVEL, jsonTravel, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  adding the Travel:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from addTravel :: " + jsonResponse);

		return jsonResponse;
	}

	@Override
	public String updateTravel(Travel travel, Long userId, String token) {
String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"update Travel is Failure!Please Try Again.\"}";
		//convert java to json
		String jsonTravel = JsonUtil.convertJavaToJson(travel);
		logger.info("Entered into updateTravel :: " + jsonTravel);
       String REST_UPDATE_TRAVEL = "http://localhost:8081/Bus24Webservice/travels/editTravel?userId="+userId+"&token="+token;
       try {
			jsonResponse = restTemplate.postForObject(REST_UPDATE_TRAVEL, jsonTravel, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  updating Travel:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from updateTravel :: " + jsonResponse);
		return jsonResponse;
	}//method

}
