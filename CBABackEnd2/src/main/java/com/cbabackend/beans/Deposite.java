/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.

 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;

import java.io.Serializable;

/**
 * This class is used to hold Type of bankloan information
 * 
 * @author Anitha.
 * @since CBABE 1.0
 */
public class Deposite implements Serializable {

	private Integer depositeId;
	private String depositeTypeName;
	private Integer rateOfInterest;
	private Integer accountNumber; // FK

	/**
	 * @return the depositeId
	 */
	public Integer getDepositeId() {
		return depositeId;
	}

	/**
	 * @param depositeId
	 *            the depositeId to set
	 */
	public void setDepositeId(Integer depositeId) {
		this.depositeId = depositeId;
	}

	/**
	 * @return the depositeTypeName
	 */
	public String getDepositeTypeName() {
		return depositeTypeName;
	}

	/**
	 * @param depositeTypeName
	 *            the depositeTypeName to set
	 */
	public void setDepositeTypeName(String depositeTypeName) {
		this.depositeTypeName = depositeTypeName;
	}

	/**
	 * @return the rateOfInterest
	 */
	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	/**
	 * @param rateOfInterest
	 *            the rateOfInterest to set
	 */
	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	/**
	 * @return the accountNumber
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

}
