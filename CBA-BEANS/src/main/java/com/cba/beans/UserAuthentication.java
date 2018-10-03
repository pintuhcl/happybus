/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.


 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cba.beans;

/**
 * This class is used to hold User-Authontication Information
 * 
 * @author Anant
 * @since CBABE 1.0
 */

public class UserAuthentication {

	private String userId;
	private String password;
	private String operationalManager;
	private String branchManager;
	private String financeManager;
	private String customerManager;

	/**
	 * @return the userId
	 */

	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the UserId to set
	 */

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the operationalManager
	 */

	public String getOperationalManager() {
		return operationalManager;
	}

	/**
	 * @param operationalManager
	 *            the operationalManager to set
	 */
	public void setOperationalManager(String operationalManager) {
		this.operationalManager = operationalManager;
	}

	/**
	 * @return the branchManager
	 */

	public String getBranchManager() {
		return branchManager;
	}

	/**
	 * @param branchManager
	 *            the branchManager to set
	 */
	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}

	/**
	 * @return the financeManager
	 */

	public String getFinanceManager() {
		return financeManager;
	}

	/**
	 * @param financeManager
	 *            the financeManager to set
	 */
	public void setFinanceManager(String financeManager) {
		this.financeManager = financeManager;
	}

	/**
	 * @return the customerManager
	 */
	public String getCustomerManager() {
		return customerManager;
	}

	/**
	 * @param customerManager
	 *            the customerManager to set
	 */
	public void setCustomerManager(String customerManager) {
		this.customerManager = customerManager;
	}

}
