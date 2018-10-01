package com.bus24.web.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingServiceImpl implements BookingService {

	Logger logger = Logger.getLogger(BookingServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getAllPassengers(Integer routeId) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the passengers list!Please Try Again.\"}";
		logger.info("Entered into searchBusForPassenger");
		final String REST_GET_ALL_PASSENGERS = "http://localhost:8081/Bus24Webservice/booking/getAllPassengers/"
				+ routeId;
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_PASSENGERS, String.class);
		} catch (RestClientException re) {
			logger.error("Exception occured while  geting Passengers List:: " + re);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from getAllPassenger :: " + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String bookTicket(String jsonBooking) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could Book the ticket!Please Try Again.\"}";
		logger.info("Entered into bookTicket");
		final String REST_POST_BOOKING = "http://localhost:8081/Bus24Webservice/booking/bookTicket";
		try {
			jsonResponse = restTemplate.postForObject(REST_POST_BOOKING, jsonBooking, String.class);

		} catch (RestClientException re) {
			logger.error("Exception occured while calling webserbice to bookTicket:: " + re);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";
		}
		logger.info("Response from bookTicket :: " + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String searchBookings() {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the Bookings list!Please Try Again.\"}";
		logger.info("Entered into searchBookings");
		final String REST_GET_ALL_BOOKINGS = "http://localhost:8081/Bus24Webservice/booking/searchBookings/";
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_BOOKINGS, String.class);
		} catch (RestClientException e) {
			logger.error("Exception occured while get Bookings" + e);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";

		}
		logger.info("Response from Booking" + jsonResponse);
		return jsonResponse;
	}

	@Override
	public String searchBookings(Integer travelId) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the Bookings list!Please Try Again.\"}";
		logger.info("Entered into searchBookings");
		final String REST_GET_ALL_BOOKINGS_BY_TRAVELID = "http://localhost:8081/Bus24Webservice/booking/searchBookingsByTravelId/"
				+ travelId;
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_BOOKINGS_BY_TRAVELID, String.class);
		} catch (RestClientException e) {
			logger.error("Exception occured while get Bookings" + e);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";

		}
		logger.info("Response from Booking" + jsonResponse);

		return jsonResponse;
	}

	@Override
	public String searchBookings(Date fromDate, Date toDate) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the Bookings list!Please Try Again.\"}";
		logger.info("Entered into searchBookings");
		final String REST_GET_ALL_BOOKINGS_BY_FDATE_TDATE = "http://localhost:8081/Bus24Webservice/booking/searchBookingsByFromDateAndToDate/"
				+ fromDate + "/" + toDate;
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_BOOKINGS_BY_FDATE_TDATE, String.class);
		} catch (RestClientException e) {
			logger.error("Exception occured while get Bookings" + e);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";

		}
		logger.info("Response from Booking" + jsonResponse);

		return jsonResponse;

	}

	@Override
	public String searchBookings(Integer travelId, Date fromDate, Date toDate) {
		String jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Could not get the Bookings list!Please Try Again.\"}";
		logger.info("Entered into searchBookings");
		final String REST_GET_ALL_BOOKINGS_BY_TRAVELID_FDATE_TDATE = "http://localhost:8081/Bus24Webservice/booking/searchBookingsByTravelIdFromDateAndToDate/"
				+ travelId + "/" + fromDate + "/" + toDate;
		try {
			jsonResponse = restTemplate.getForObject(REST_GET_ALL_BOOKINGS_BY_TRAVELID_FDATE_TDATE, String.class);
		} catch (RestClientException e) {
			logger.error("Exception occured while get Bookings" + e);
			jsonResponse = "{\"status\":\"FAILURE\",\"message\":\"Unable to process your request!please try again.\"}";

		}
		logger.info("Response from Booking" + jsonResponse);

		return jsonResponse;
	}

}
