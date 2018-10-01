/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bus24.util.JsonUtil;

/**
 * @author mulayam
 */
@Service
public class AmenityServiceImp implements AmenityService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String addNewAmenity(String jsonAmenity) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Your Registration is Failure!Please Try Again.\"}";
		logger.info("Entered into addNewAmenity :: " + jsonAmenity);

		String REST_ADD_AMENITY = "http://localhost:8081/Bus24Webservice/amenity/add";
		try {
			jsonResponse = restTemplate.postForObject(REST_ADD_AMENITY, jsonAmenity, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  adding newAmenity :: " + re);
		}
		logger.info("Response from addNewAmenity :: " + jsonResponse);
		return jsonResponse;

	}

	@Override
	public String getAllAmenities() {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Your Registration is Failure!Please Try Again.\"}";
		logger.info("Entered into getAllAminities ");

		String REST_ADD_AMENITY = "http://localhost:8081/Bus24Webservice/amenity/list";
		try {
			jsonResponse = restTemplate.getForObject(REST_ADD_AMENITY, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  adding newAmenity :: " + re);
		}
		logger.info("Response from getAllAmenities :: " + jsonResponse);
		return jsonResponse;

	}
}
