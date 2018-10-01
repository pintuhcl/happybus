package com.bus24.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bus24.beans.Response;
import com.bus24.beans.Route;
import com.bus24.beans.Travel;
import com.bus24.beans.User;
import com.bus24.dao.RoutesDAO;
import com.bus24.exceptions.UserNotAuthenticatedException;
import com.bus24.util.JsonUtil;
import com.bus24.util.Roles;
import com.bus24.util.StatusUtil;

@Service
public class RoutesServiceImpl implements RoutesService {

	private static Logger logger = Logger.getLogger(RoutesServiceImpl.class);
	@Autowired
	private RoutesDAO routesDAO;
	@Autowired
	private UserAuthenticationService userAuthenticationService;

	// to search the routes by travel admin and super admin

	public String addRoute(String json, String userRole, Long userId, String token) {
		// creating response object and defining default values
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("unable to process, plz try again with valid inputs");

		logger.info("entered into routesservice.addroute()");

		// Business Logic

		try {
			if (userAuthenticationService.isAuthenticated(userId, token)) {
				logger.info("entered into outer if");

				if (userRole.equals(Roles.ROLE_SUPER_ADMIN) || userRole.equals(Roles.ROLE_TRAVEL_ADMIN)) {
					logger.info("entered into outer if");

					// converting json into domain object
					Route route = JsonUtil.convertJsonToJava(json, Route.class);

					// calling DAO layer
					Integer count = routesDAO.addRoute(route);
					if (count > 0 || count != null) {
						response.setMessage("added successfully");
						response.setStatus(StatusUtil.STATUS_SUCCESS);
					} else
						response.setMessage("unable to add");

				} else {
					logger.info("entered into inner else");
					response.setMessage("you are not adimin, please check your userName and PassWord");

				} // inner if-else

			} else {// Actually no need of writing this else
				logger.info("entered into inner else");
				// write proper msg in response object
				// for not authenticated user
				response.setMessage("Authentication Failed, please login again");
			} // outer if- else
		} catch (UserAuthenticationException e) {
			logger.info("Exception occured while Authentication of userId and token");
			response.setMessage("Unable to process");
		}

		return JsonUtil.convertJavaToJson(response);
	}

	@Override
	public String searchRoute(String jsonRoute, Long userId, String token) {
		Route route = null;
		Response response = new Response();
		String jsonResponse = " ";
		List<Route> listRoutes = null;
		response.setMessage("Searching Route  Failure!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		// convert json to java
		route = JsonUtil.convertJsonToJava(jsonRoute, Route.class);
		try {
			if (route != null) {
				// Authentication check
				if (userAuthenticationService.isAuthenticated(userId, token)) {
					// call DAOTravel
					listRoutes = routesDAO.searchRouteBySource(route);
					response.setStatus(StatusUtil.STATUS_SUCCESS);
				} // if
			} // if
		} catch (UserNotAuthenticatedException ue) {
			logger.info("Exception occured when user  Authentication fail ", ue);
			response.setMessage(ue.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		catch (DataAccessException de) {
			logger.info("Exception occured when problm come from DB", de);
			response.setMessage(de.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
		catch (Exception e) {
			logger.fatal("exception occured when Unknown Exception come", e);
			response.setMessage(e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} // catch
			// convert list of routes to list of jsonResponse

		jsonResponse = JsonUtil.convertJavaToJson(listRoutes);
		response.setData(jsonResponse);
		return jsonResponse;

	}

	@Override
	public String editRoute(String jsonRoute) {
		String jsonResponse = "";
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("editing route is Failure!Please Try Again.");
		try {
			if (jsonRoute != null) {
				Route route = JsonUtil.convertJsonToJava(jsonRoute, Route.class);
				if (route != null) {
					Integer count = routesDAO.editRoute(route);
					if (count > 0) {
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Your Route Updated Successfully");

						jsonResponse = JsonUtil.convertJavaToJson(response);
					}
				}

			}
		} catch (DataAccessException de) {
			de.printStackTrace();
			logger.error("Exception occured while editing Route");
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("unable to process your request!please try again");

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process!Please Try Again");
		}

		return jsonResponse;
	}

	@Override
	public String getSourceList() {
		Response response = new Response();
		response.setMessage("Could not Source !Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {
			List<String> list = routesDAO.getSourceList();
			if (list != null && list.size() > 0) {
				String jsonSourceList = JsonUtil.convertJavaToJson(list);
				if (jsonSourceList != null) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Source List Fetched");
					response.setData(jsonSourceList);
				}
			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Source Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		return JsonUtil.convertJavaToJson(response);
	}

	@Override
	public String getDestinationList() {
		Response response = new Response();
		response.setMessage("Could not Source !Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {
			List<String> list = routesDAO.getDestinationList();
			if (list != null && list.size() > 0) {
				String jsonSourceList = JsonUtil.convertJavaToJson(list);
				if (jsonSourceList != null) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Destination List Fetched");
					response.setData(jsonSourceList);
				}
			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Destination Details : " + de.getMessage());
			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Destination Details: " + e.getMessage());
			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		String jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info(jsonResponse);
		return jsonResponse;
	}

}
