
// * Copyright (c) 2017- 2018, HappyBus and/or its affiliates. All rights reserved.

//* HappyBus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.

package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Route;

/**
 * RoutesDAO is used to perform persistence operations on Routes Table
 * 
 * @author sahoo
 * @since 1.0
 */

public interface RoutesDAO {
	/**
	 * this method contain logic searching routes for admin
	 * 
	 * @param save_Routes
	 * 
	 * @author sahoo
	 */

	public int addRoute(Route route);

	/**
	 * This method get the Route Details of specific routeId
	 * 
	 * @param routeId
	 * @return Route Object
	 * @author mulayam
	 */
	public Route getRoute(Integer routeId);

	/**
	 * this method used to search the route by the source and edit
	 * 
	 * @param route
	 * @return
	 */
	public List<Route> searchRouteBySource(Route route);

	public Integer editRoute(Route route);

	/**
	 * Get List of all sources
	 * 
	 * @return
	 * @author mulayam
	 */
	public List<String> getSourceList();

	/**
	 * Get List of all destination
	 * 
	 * @return
	 * @author mulayam
	 */

	public List<String> getDestinationList();

}
