
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

/**
 * @author mulayam
 * @version 1.0
 */
@Service
public class BusServiceImpl implements BusService {

	private static Logger logger = Logger.getLogger(BusServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getAllBusListByTravelId(Integer travelId) {

		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the travel list!Please Try Again.\"}";

		logger.info("Entered into getAllBusListByTravelId");

		final String REST_GET_ALL_TRAVEL = "http://localhost:8081/Bus24Webservice/bus/searchBusByTravelid/" + travelId;
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_TRAVEL, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  get BusListForAdmin:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from etAllBusListByTravelId :: " + jsonResponse);
		return jsonResponse;
	}

	/**
	 * This is search buses for passenger
	 * 
	 * @author mulayam
	 */

	@Override
	public String searchBusForPassenger(String source, String destination, String journeyDate) {

		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the travel list!Please Try Again.\"}";
		logger.info("Entered into searchBusForPassenger");
		final String REST_GET_ALL_BUS = "http://localhost:8081/Bus24Webservice/bus/searchBusesForPassenger/" + source
				+ "/" + destination + "/" + journeyDate;

//		logger.info("Source:" + source);
//		logger.info("destination:" + destination);

		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_BUS, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  get BusListForPassenger:: " + re);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from seachBusForPassenger :: " + jsonResponse);
		return jsonResponse;
	}
}
