/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.beans;

import java.io.Serializable;
import java.util.Map;

/**
 * This class is used to hold the Working hours of a Common Wealth Bank Branches
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@SuppressWarnings("serial")
public class WorkingHours implements Serializable {
	private Integer id;
	private Map<String, String> openingHours;
	private Map<String, String> closingHours;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the openingHours
	 */
	public Map<String, String> getOpeningHours() {
		return openingHours;
	}

	/**
	 * @param openingHours
	 *            the openingHours to set
	 */
	public void setOpeningHours(Map<String, String> openingHours) {
		this.openingHours = openingHours;
	}

	/**
	 * @return the closingHours
	 */
	public Map<String, String> getClosingHours() {
		return closingHours;
	}

	/**
	 * @param closingHours
	 *            the closingHours to set
	 */
	public void setClosingHours(Map<String, String> closingHours) {
		this.closingHours = closingHours;
	}

}
