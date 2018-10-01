/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Amenity;

/**
 * 
 * @author mulayam
 * @version 1.0
 */
public interface AmenityDAO {

	/**
	 * Add new amenity into database
	 * 
	 * @param amenity
	 * @return
	 */
	public Integer addAmenity(Amenity amenity);

	/**
	 * get all amenities
	 * 
	 * @return List<Amenity>
	 */
	public List<Amenity> getAllAmenities();

	/**
	 * Update existing Amenity
	 * 
	 * @param amenity
	 * @return
	 */
	public Integer updateAmenity(Amenity amenity);

}
