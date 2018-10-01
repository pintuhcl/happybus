/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Passenger;

/**
 * 
 * @author mulayam
 *
 */
public interface PassengerDAO {

	/**
	 * This method take the list passenger and bookingId and persist passenger
	 * list into database
	 * 
	 * @param listPassenegrs
	 * @param newBookingId
	 * @return array of int type
	 */
	int[] addPassengers(List<Passenger> listPassenegrs, Integer newBookingId);

	/**
	 * This method get the list of all passenger of specific routeId
	 * 
	 * @param routeId
	 * @return List<Passenger>
	 */
	List<Passenger> getAllPassengers(Integer routeId);

}
