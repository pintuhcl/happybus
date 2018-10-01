/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.BusService;

/**
 * 
 * @author mulayam
 * @version 1.0
 */
@RestController
@RequestMapping("bus")
public class BusHandler {
	@Autowired
	private BusService busService;

	@RequestMapping(value = "saveBus", method = RequestMethod.POST)
	@ResponseBody
	public String saveBus(@RequestBody String jsonBus, @RequestParam("userId") Long userId,
			@RequestParam("token") String token) {
		return busService.saveBus(jsonBus, userId, token);
	}

	/**
	 * 
	 * @param travelId
	 * @return jsonTravel
	 * @author mulayam
	 */
	@ResponseBody
	@GetMapping("searchBusByTravelid/{travelId}")
	public String searchBusesByTravelId(@PathVariable("travelId") Integer travelId) {
		String jsonResponse = busService.searchBusesByTravelId(travelId);
		return jsonResponse;
	}

	/**
	 * This method return the json of buses list for passenger
	 * 
	 * @param source
	 * @param destination
	 * @param date
	 * @return jsonBussesListForPassenger
	 * @author mulayam
	 */
	@ResponseBody
	@GetMapping("searchBusesForPassenger/{source}/{destination}/{date}")
	public String searchBusesForPassenger(@PathVariable("source") String source,
			@PathVariable("destination") String destination, @PathVariable("date") String date) {

		String jsonResponse = busService.searchBusesForPassenger(source, destination, date);
		return jsonResponse;
	}

}
