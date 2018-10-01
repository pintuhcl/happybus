/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.service;

/**
 * This interface is gather amenity module requirements
 * 
 * @author Mulayam
 * @since 1.0
 */
public interface AmenityService {

	/**
	 * This method is used to add new amenity
	 * 
	 * @param jsonAmenity
	 * @return jsonResponse
	 */
	public String addAmenity(String jsonAmenity);

	/**
	 * This method return all amenities
	 * 
	 * @return jsnonResponse
	 */
	public String getAllAmenities();

	/**
	 * This method is used to update existing amenity
	 * 
	 * @param jsonAmenity
	 * @return jsonResponse
	 */
	public String updateAmenity(String jsonAmenity);

}
