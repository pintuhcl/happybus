/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.beans;

import java.io.Serializable;

/**
 * This class is used to hold Travel information and send across the n.w
 * 
 * @author rakhi
 * @since 1.0
 */

public class Insurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer comapnyId;
	private Travel travel;
	private String companyName;
	private Float amount;

	public Integer getComapnyId() {
		return comapnyId;
	}

	public void setComapnyId(Integer comapnyId) {
		this.comapnyId = comapnyId;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
