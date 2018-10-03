/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.beans;



import java.util.Date;


/**
 * This class is used to hold Account-Transaction Information
 * 
 * @author Sathish
 * @since CBABE 1.0
 */
public class AccountTransactions {
	private Integer accountTransactionId;
	private Integer accountId;
	private String transactionType;
	private Date transactionDate;
	private Double transactionAmount;
	private String transactionStatus;
	private String transactionMode;
	private String transactionDesc;
	private Integer updatedBy; // empid
    private String ddORChequeNumber;
    private String issuedBy;
    private Date issuedDate;
    private  String issuedBranch;
    
	/**
	 * @return the ddORChequeNumber
	 */
	public String getDdORChequeNumber() {
		return ddORChequeNumber;
	}

	/**
	 * @param ddORChequeNumber the ddORChequeNumber to set
	 */
	public void setDdORChequeNumber(String ddORChequeNumber) {
		this.ddORChequeNumber = ddORChequeNumber;
	}

	/**
	 * @return the issuedBy
	 */
	public String getIssuedBy() {
		return issuedBy;
	}

	/**
	 * @param issuedBy the issuedBy to set
	 */
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	/**
	 * @return the issuedDate
	 */
	public Date getIssuedDate() {
		return issuedDate;
	}

	/**
	 * @param issuedDate the issuedDate to set
	 */
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	/**
	 * @return the issuedBranch
	 */
	public String getIssuedBranch() {
		return issuedBranch;
	}

	/**
	 * @param issuedBranch the issuedBranch to set
	 */
	public void setIssuedBranch(String issuedBranch) {
		this.issuedBranch = issuedBranch;
	}

	
	
	/**
	 * @return the accountTransactionId
	 */
	public Integer getAccountTransactionId() {
		return accountTransactionId;
	}

	/**
	 * @param accountTransactionId the accountTransactionId to set
	 */
	public void setAccountTransactionId(Integer accountTransactionId) {
		this.accountTransactionId = accountTransactionId;
	}

	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate
	 *            the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the transactionAmount
	 */
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount
	 *            the transactionAmount to set
	 */
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @param transactionStatus
	 *            the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @return the transactionMode
	 */
	public String getTransactionMode() {
		return transactionMode;
	}

	/**
	 * @param transactionMode
	 *            the transactionMode to set
	 */
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	/**
	 * @return the transactionDesc
	 */
	public String getTransactionDesc() {
		return transactionDesc;
	}

	/**
	 * @param transactionDesc
	 *            the transactionDesc to set
	 */
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

  
}
