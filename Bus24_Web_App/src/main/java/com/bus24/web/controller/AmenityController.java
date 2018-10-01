/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bus24.web.service.AmenityService;

/**
 * 
 * @author mulayam
 *
 */
@Controller
@RequestMapping("amenity")
public class AmenityController {

	@Autowired
	private AmenityService amenityService;

	@GetMapping
	public String amenityPage() {
		return "amenityPage";
	}

	@PostMapping("/addNewAmenity")
	@ResponseBody
	public String addNewAmenity(@RequestBody String amenityName) {
		return amenityService.addNewAmenity(amenityName);
	}

	@GetMapping("/getAllAmenities")
	@ResponseBody
	public String getAllAmenities() {
		 return amenityService.getAllAmenities();
	}
}
