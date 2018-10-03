/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.

 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;
/**
* This class is used to hold Type of bankloan information
* 
* @author Sathish.
* @since CBABE 1.0
*/
public class Loan_Type {
	private Integer loan_type_Id;
	private String loan_type_Name;
    private String loan_type_descr;
    /**
     * @return the loantypeId
     */
	public Integer getLoan_type_Id() {
		return loan_type_Id;
	}
	/**
	 * @param bankId the loantypeId to set
	 */
	public void setLoan_type_Id(Integer loan_type_Id) {
		this.loan_type_Id = loan_type_Id;
	}
	/**
	 * @return the loantypeName
	 */
	public String getLoan_type_Name() {
		return loan_type_Name;
	}
	/**
	 * @param bankName the loantypeName to set
	 */
	public void setLoan_type_Name(String loan_type_Name) {
		this.loan_type_Name = loan_type_Name;
	}
	
	/**
	 * @return the loan_type_descr
	 */
	public String getLoan_type_descr() {
		return loan_type_descr;
	}
	/**
	 * @param bankDesc the loan_type_descr to set
	 */
	public void setLoan_type_descr(String loan_type_descr) {
		this.loan_type_descr = loan_type_descr;
	}
    
}
