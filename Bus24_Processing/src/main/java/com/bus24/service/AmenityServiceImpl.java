package com.bus24.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bus24.beans.Amenity;
import com.bus24.beans.Response;
import com.bus24.dao.AmenityDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;

/**
 * 
 * @author mulayam
 * @version 1.0
 */
@Service
public class AmenityServiceImpl implements AmenityService {

	private static Logger logger = Logger.getLogger(AmenityServiceImpl.class);
	
	@Autowired
	private AmenityDAO amenityDAO;

	/**
	 * @author mulayam
	 * @since 1.0
	 */
	@Override
	public String addAmenity(String jsonAmenity) {

		logger.info("Entered in addAmenity method");

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("New Amenity Could Not Add! Please Try Again");
		Amenity amenity = null;
		try {

			logger.info("JsonAmenity: " + jsonAmenity);
			amenity = JsonUtil.convertJsonToJava(jsonAmenity, Amenity.class);

			if (amenity != null) {
				Integer count = amenityDAO.addAmenity(amenity);
				if (count != null && count > 0) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("New Amenity Successfully Added");
					logger.info("Successfully Saved");

				} else {
					response.setMessage("Unable to process your request! Pleaes try again");
					logger.error("Could Not Save");
				}
			} else {
				response.setMessage("Invalid Data! Pleaes try again");
				logger.error("Invalid Data");
			}
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			if (e.getMessage().contains("uk_amenity")) {
				response.setMessage(amenity.getAmenityName() + " already exists");
			} else
				response.setMessage("Unable to process your request! Pleaes try again");

		} catch (Exception e) {
			response.setMessage("Unable to process your request! Pleaes try again");
		}
		String jsonResposne = JsonUtil.convertJavaToJson(response);
		return jsonResposne;
	}

	/**
	 * @author mulayam
	 * @since 1.0
	 */
	@Override
	public String getAllAmenities() {

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Could Not Fetch Amenities! Please try again");
		try {
			List<Amenity> amenities = amenityDAO.getAllAmenities();
			if (amenities != null && amenities.size() > 0) {
				logger.info(amenities);
				String jsonStr = JsonUtil.convertJavaToJson(amenities);
				response.setData(jsonStr);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("Amenities found");
			} else {
				response.setMessage("Data Not Found In Database");
			}
		} catch (DataAccessException e) {
			logger.error("DataAcessEx", e);
			response.setMessage("Unable to process your request please try again");
		} catch (Exception e) {
			logger.error("Ex:", e);
			response.setMessage("Unable to process your request please try again");
		}

		String jsonResponse = JsonUtil.convertJavaToJson(response);

		return jsonResponse;
	}

	/**
	 * @author mulayam
	 * @since 1.0
	 */
	@Override
	public String updateAmenity(String jsonAmenity) {
		logger.info("Entered in addAmenity method");

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Could not update! Please Try Again");
		try {

			logger.info("JsonAmenity: " + jsonAmenity);
			Amenity amenity = JsonUtil.convertJsonToJava(jsonAmenity, Amenity.class);

			if (amenity != null && amenity.getAmenityId() != null && amenity.getAmenityId() > 0) {
				Integer count = amenityDAO.updateAmenity(amenity);
				if (count != null && count > 0) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Sucessfully Update");
					logger.info("Successfully Updated");

				} else {
					// If id
					response.setMessage("Unable to process your request! Pleaes try again");
					logger.error("Could not update");
				}
			} else {
				response.setMessage("Invalid Data! Pleaes try again");
				logger.error("Invalid Data");
			}
		} catch (DataAccessException e) {
			response.setMessage("Unable to process your request! Pleaes try again");
		} catch (Exception e) {
			response.setMessage("Unable to process your request! Pleaes try again");
		}
		String jsonResposne = JsonUtil.convertJavaToJson(response);
		return jsonResposne;
	}

}
