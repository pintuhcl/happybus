/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.web.service;

import org.springframework.stereotype.Service;

/**
 * @author mulayam
 */
public interface AmenityService {

	public String addNewAmenity(String amenityName);
	public String getAllAmenities();
	
}
