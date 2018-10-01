package com.bus24.service;

import java.util.List;

import com.bus24.beans.Route;

public interface RoutesService {
	/**
	 * UserService is used to implement Bussiness Logic for Users
	 * 
	 * @author sahoo
	 * @since 1.0
	 */

	/**
	 * the method contain logic for User Login
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 * @author sathish.bandi
	 */

	public String addRoute(String json, String userRole, Long userId, String token);

	/**
	 * Get List of all sources
	 * 
	 * @return
	 * @author mulayam
	 */
	public String getSourceList();

	/**
	 * Get List of all destination
	 * 
	 * @return
	 * @author mulayam
	 */

	public String getDestinationList();

	/**
	 * the method contain logic for searching the routes
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 * @author
	 */
	public String searchRoute(String jsonRoute, Long userId, String token);

	/**
	 * the method contain logic for searching the routes
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 * 
	 */
	public String editRoute(String jsonRoute);

}
