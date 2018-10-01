/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.web.service.BusService;

/**
 * 
 * @author mulayam
 * @version 1.0
 */
@Controller
public class BusController {

	@Autowired
	private BusService busService;

	/**
	 * This method return the searchPassengerBus view
	 * 
	 * @return
	 * @author mulayam
	 */

	@PostMapping("/searchBusPage")
	public String searchBusPage() {
		return "searchPassengerBus";
	}

	/**
	 * This method return the bus list for passenger
	 * 
	 * @return jsonBus
	 * @author mulayam
	 */

	@GetMapping("/searchBus/{source}/{destination}/{journeyDate}")
	@ResponseBody
	public String searchBusList(@PathVariable String source, @PathVariable String destination,
			@PathVariable String journeyDate) {
		return busService.searchBusForPassenger(source, destination, journeyDate);

	}

	/**
	 * This method return page to search bus for admin
	 * 
	 * @return searchBusAdmin Page
	 * @author mulayam
	 */
	@GetMapping("/searchBusAdmin")
	public String showSearchBusForAdminPage() {
		return "searchBusAdmin";
	}

	/**
	 * This method return the list of buses for specified travelId
	 * 
	 * @param travelId
	 * @return jsonBusList
	 * @author mulayam
	 */
	@GetMapping("/searchBusListAdmin/{travelId}")
	@ResponseBody
	public String getAllBusListByTravelId(@PathVariable("travelId") Integer travelId) {
		return busService.getAllBusListByTravelId(travelId);
	}

	/**
	 * This method return all amenities list of specified bus
	 * 
	 * @param busId
	 * @return jsonAmenities
	 * @author mulayam
	 */
	@GetMapping("amenity/{busId}")
	@ResponseBody
	public String getAmenities(Integer busId) {
		return null;
	}
}
