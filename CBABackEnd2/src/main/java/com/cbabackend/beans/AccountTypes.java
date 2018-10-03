/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.beans;

import java.io.Serializable;
/**
 * This class is used to hold Type of Accounts Information
 * 
 * @author Sathish
 * @since CBABE 1.0
 */
@SuppressWarnings("serial")
public class AccountTypes implements Serializable{
private Integer accountTypeId;
private String accountTypeName;
private String minBalance;
private String desc;
/**
 * @return the accountTypeId
 */
public Integer getAccountTypeId() {
	return accountTypeId;
}
/**
 * @param accountTypeId the accountTypeId to set
 */
public void setAccountTypeId(Integer accountTypeId) {
	this.accountTypeId = accountTypeId;
}
/**
 * @return the accountTypeName
 */
public String getAccountTypeName() {
	return accountTypeName;
}
/**
 * @param accountTypeName the accountTypeName to set
 */
public void setAccountTypeName(String accountTypeName) {
	this.accountTypeName = accountTypeName;
}
/**
 * @return the minBalance
 */
public String getMinBalance() {
	return minBalance;
}
/**
 * @param minBalance the minBalance to set
 */
public void setMinBalance(String minBalance) {
	this.minBalance = minBalance;
}
/**
 * @return the desc
 */
public String getDesc() {
	return desc;
}
/**
 * @param desc the desc to set
 */
public void setDesc(String desc) {
	this.desc = desc;
}

}