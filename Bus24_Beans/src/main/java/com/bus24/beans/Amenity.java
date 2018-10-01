/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.beans;

/**
 * This class is used to hold BusType information and send across the n.w
 * 
 * @author Mulayam
 * @since 1.0
 */
public class Amenity {

	private Integer amenityId;
	private String amenityName;

	/**
	 * @return the amenityId
	 */
	public Integer getAmenityId() {
		return amenityId;
	}

	/**
	 * @param amenityId
	 *            the amenityId to set
	 */
	public void setAmenityId(Integer amenityId) {
		this.amenityId = amenityId;
	}

	/**
	 * @return the amenityName
	 */
	public String getAmenityName() {
		return amenityName;
	}

	/**
	 * @param amenityName the amenityName to set
	 */
	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}
	

}
