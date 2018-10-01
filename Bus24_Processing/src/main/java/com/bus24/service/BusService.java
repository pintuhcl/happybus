/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.service;

import java.util.List;

import com.bus24.beans.Bus;
import com.bus24.beans.SearchedBus;

/**
 * 
 * @author mulayam
 * @version 1.0
 */

public interface BusService {

	public String saveBus(String jsonBus, Long userId, String token);

	public String searchBusesByTravelId(Integer travelId);

	/**
	 * This method is used to search busses for passenger
	 * 
	 * @param source
	 * @param destination
	 * @param date
	 * @return jsonSeachedBusList
	 * @author Mulayam
	 */
	public String searchBusesForPassenger(String source, String destination, String date);

}
