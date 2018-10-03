/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.

 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;
import java.io.Serializable;
/**
 * This class is used to hold Type of bank information
 * 
 * @author Sathish
 * @since CBABE 1.0
 */

@SuppressWarnings("serial")
public class Bank implements Serializable{
private Integer bankId;
private String bankName;
private String bankDesc;
/**
 * @return the bankId
 */
public Integer getBankId() {
	return bankId;
}
/**
 * @param bankId the bankId to set
 */
public void setBankId(Integer bankId) {
	this.bankId = bankId;
}
/**
 * @return the bankName
 */
public String getBankName() {
	return bankName;
}
/**
 * @param bankName the bankName to set
 */
public void setBankName(String bankName) {
	this.bankName = bankName;
}
/**
 * @return the bankDesc
 */
public String getBankDesc() {
	return bankDesc;
}
/**
 * @param bankDesc the bankDesc to set
 */
public void setBankDesc(String bankDesc) {
	this.bankDesc = bankDesc;
}

}
