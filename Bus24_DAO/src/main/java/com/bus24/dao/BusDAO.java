/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Amenity;
import com.bus24.beans.Bus;
import com.bus24.beans.SearchedBus;

/**
 * 
 * @author mulayam
 *
 */
public interface BusDAO {

	
	
	
	public int saveBus(Bus bus, Long userId);
	/**
	 * Get All amenities list of specified busId
	 * 
	 * @param busId
	 * @return List<Amenity>
	 * @since 1.0
	 */
	public List<Amenity> getBusAmenities(Integer busId);

	/**
	 * Get All Buses list of specified travelId
	 * 
	 * @param travelId
	 * @return List<Bus>
	 * @since 1.0
	 */
	public List<Bus> searchBusesByTravelId(Integer travelId);

	/**
	 * This method is used to search busses for passenger
	 * 
	 * @param source
	 * @param destination
	 * @param date
	 * @return {@link List<SearchedBus>}
	 * @author Mulayam
	 */
	public List<SearchedBus> searchBusesForPassenger(String source, String destination, String date);

}
