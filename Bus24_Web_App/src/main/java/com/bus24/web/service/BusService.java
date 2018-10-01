
/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.service;

/**
 * 
 * @author mulayam
 * @version 1.0
 */
public interface BusService {
	public String getAllBusListByTravelId(Integer travelId);

	/**
	 * This method return list of buses for passenger based on
	 * source,destination and journeyDate
	 * 
	 * @param source
	 * @param destination
	 * @param journeyDate
	 * @return
	 */
	public String searchBusForPassenger(String source, String destination, String journeyDate);

}
