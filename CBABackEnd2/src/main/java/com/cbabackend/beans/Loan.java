/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.

 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;
import java.util.Date;
/**
 * This class is used to hold the LoanDetails of Common Wealth Bank
 * 
 * @author Sathish
 * @since CBABE 1.0
 */
public class Loan {
	private Integer loan_Id;
	private Date intrest_Date;
	private Date start_Date;
	private Integer loan_type_Id;
	/**
	 * @return the loanId
	 */
	public Integer getLoan_Id() {
		return loan_Id;
	}
	/**
	 * @param loanId the loanId to set
	 */
	public void setLoan_Id(Integer loan_Id) {
		this.loan_Id = loan_Id;
	}
	/**
	 * @return the IntrestDate
	 */
	
	public Date getIntrest_Date() {
		return intrest_Date;
	}
	/**
	 * @param intrestDate the intrestDate to set
	 */
	public void setIntrest_Date(Date intrest_Date) {
		this.intrest_Date = intrest_Date;
	}
	/**
	 * @return the startDate
	 */
	public Date getStart_Date() {
		return start_Date;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}
	/**
	 * @return the LoantypeId
	 */
	public Integer getLoan_type_Id() {
		return loan_type_Id;
	}
	/**
	 * @param  LoantypeId the LoantypeId to set
	 */
	public void setLoan_type_Id(Integer loan_type_Id) {
		this.loan_type_Id = loan_type_Id;
	}
	

}
