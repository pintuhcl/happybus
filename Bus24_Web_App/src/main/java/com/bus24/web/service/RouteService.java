package com.bus24.web.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bus24.beans.Route;

/**
 * 
 * @author mulayam
 *
 */
public interface RouteService {

	/**
	 * @author shankar
	 * @version 1.0
	 */
	public String searchRoute(Route route, Long userId, String token);

	public String addRoute(Route route, Object userId, Object token);

	/**
	 * @author shankar sarkar
	 * @version 1.0
	 */
	public String updateRoute(Route route, Long userId, String token);

	/**
	 * Get all list of sources
	 * 
	 * @return
	 */
	public String getSouceList();

	/**
	 * Get All list of destination
	 * 
	 * @return
	 */
	public String getDestinationList();

}
