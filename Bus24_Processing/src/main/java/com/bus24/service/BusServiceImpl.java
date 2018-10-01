
package com.bus24.service;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author mulayam
 */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bus24.beans.Bus;
import com.bus24.beans.Response;
import com.bus24.beans.SearchedBus;
import com.bus24.dao.BusDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;

@Service
public class BusServiceImpl implements BusService {
	private static Logger logger = Logger.getLogger(TravelServiceImpl.class);

	@Autowired
	private BusDAO busDao;

	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@Override
	public String searchBusesByTravelId(Integer travelId) {

		Response response = new Response();
		response.setMessage("Could not Fetch Buses Detials!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);

		try {

			if (travelId != null && travelId > 0) {
				List<Bus> list = busDao.searchBusesByTravelId(travelId);
				if (list != null && list.size() > 0) {

					String jsonBusList = JsonUtil.convertJavaToJson(list);
					if (jsonBusList != null) {
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Buses List Fetched");
						response.setData(jsonBusList);

					} else {
						logger.error("bus list conversion from list json failed");
					}
				} else {
					response.setMessage("Bus Details Not Found");
					response.setStatus(StatusUtil.STATUS_SUCCESS);
				}
			}

		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Bus Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Bus Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}

		String jsonResponse = JsonUtil.convertJavaToJson(response);

		logger.info(jsonResponse);

		// jsonResponse = jsonResponse.replaceAll("\\\\", "");

		return jsonResponse;
	}

	/**
	 * This method is used to search busses for passenger
	 * 
	 * @param source
	 * @param destination
	 * @param date
	 * @return jsonSeachedBusList
	 * @author Mulayam
	 */
	@Override
	public String searchBusesForPassenger(String source, String destination, String journeyDate) {

		Response response = new Response();
		response.setMessage("Could not Fetch Buses Detials!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);

		try {

			if (source != null && destination != null && journeyDate != null) {

				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Date d = format.parse(journeyDate);

				format = new SimpleDateFormat("yyyy-MM-dd");
				journeyDate = format.format(d);

				System.out.println(journeyDate);
				List<SearchedBus> list = busDao.searchBusesForPassenger(source, destination, journeyDate);
				if (list != null && list.size() > 0) {

					String jsonBusList = JsonUtil.convertJavaToJson(list);
					if (jsonBusList != null) {
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Buses List Fetched");
						response.setData(jsonBusList);

					} else {
						logger.error("bus list conversion from list json failed");
					}
				} else {
					response.setMessage("Bus Details Not Found");
					response.setStatus(StatusUtil.STATUS_SUCCESS);
				}
			}

		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Bus Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Bus Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		String jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info(jsonResponse);
		return jsonResponse;
	}

	@Override
	public String saveBus(String jsonBus, Long userId, String token) {
		String jsonResponse = "";
		logger.info("Entered into saveBus() " + jsonBus + " " + userId + " " + token);

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Bus not added! Please try again.");

		try {

			if (userAuthenticationService.isAuthenticated(userId, token)) {
				Bus bus = JsonUtil.convertJsonToJava(jsonBus, Bus.class);

				if (bus != null && bus.getBusType() != null && bus.getListAmenities() != null && userId != null) {
					if (busDao.saveBus(bus, userId) > 0) {
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Bus added successfully");
					}
				}

			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Registering the Travel : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Registering the Travel : " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		jsonResponse = JsonUtil.convertJavaToJson(response);
		// logger.info("saveBus() method endded. Response from saveBus " +
		// jsonResponse);
		return jsonResponse;

	}

}
