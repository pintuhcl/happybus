package com.bus24.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bus24.beans.Route;
import com.bus24.util.JsonUtil;

/**
 * 
 * @author mulayam
 *
 */
@Service
public class RouteServiceImpl implements RouteService {
	
	private static Logger logger = Logger.getLogger(RouteServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getSouceList() {

		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the source list!Please Try Again.\"}";

		logger.info("Entered into sourceList");

		final String REST_GET_ALL_SOURCE = "http://localhost:8081/Bus24Webservice/Routes/sourceList";
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_SOURCE, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  getting sourceList: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from getSouceList:: " + jsonResponse);
		return jsonResponse;

	}

	@Override
	public String getDestinationList() {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the destinaton list!Please Try Again.\"}";

		logger.info("Entered into getDEstinationList");

		final String REST_GET_ALL_SOURCE = "http://localhost:8081/Bus24Webservice/Routes/destinationList";
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_SOURCE, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  getting sourceList: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from getDestinationList:: " + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String searchRoute(Route route, Long userId, String token) {

		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Searching Travel is Failure!Please Try Again.\"}";
		//convert java to json
		String jsonRoute = JsonUtil.convertJavaToJson(route);
		logger.info("Entered into searchTravel :: " + jsonRoute);
       String REST_SEARCH_TRAVEL = "http://localhost:8081/Bus24Webservice/Routes/searchRoute?userId="+userId+"&token="+token;
       try {
			jsonResponse = restTemplate.postForObject(REST_SEARCH_TRAVEL, jsonRoute, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  searchingTravel:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from searchTravel :: " + jsonResponse);

		return jsonResponse;


	}

	@Override
	public String addRoute(Route route, Object userId, Object token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRoute(Route route, Long userId, String token) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"update Route is Failure!Please Try Again.\"}";
		//convert java to json
		String jsonRoute= JsonUtil.convertJavaToJson(route);
		logger.info("Entered into updateTravel :: " + jsonRoute);
       String REST_UPDATE_TRAVEL = "http://localhost:8081/Bus24Webservice/routes/editRoute?userId="+userId+"&token="+token;
       try {
			jsonResponse = restTemplate.postForObject(REST_UPDATE_TRAVEL, jsonRoute, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  updating Routes:: " + re);

			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from updateRoutes :: " + jsonResponse);
		return jsonResponse;
	}//method
	

}
