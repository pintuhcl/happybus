/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.beans;
/**
 * This class is used to hold Type of Nomine Information
 * 
 * @author Sathish
 * @since CBABE 1.0
 */

public class Nomine {
	
private Integer nomineeId;
private String nomineeName;
private String nomineeDOB;
private String gender;
private String relationship;
private String address;

/**
 * @return the nomineeId
 */
public Integer getNomineeId() {
	return nomineeId;
}
/**
 * @param nomineeId the nomineeId to set
 */
public void setNomineeId(Integer nomineeId) {
	this.nomineeId = nomineeId;
}
/**
 * @return the nomineeName
 */
public String getNomineeName() {
	return nomineeName;
}
/**
 * @param nomineeName the nomineeName to set
 */
public void setNomineeName(String nomineeName) {
	this.nomineeName = nomineeName;
}
/**
 * @return the nomineeDOB
 */
public String getNomineeDOB() {
	return nomineeDOB;
}
/**
 * @param nomineeDOB the nomineeDOB to set
 */
public void setNomineeDOB(String nomineeDOB) {
	this.nomineeDOB = nomineeDOB;
}
/**
 * @return the gender
 */
public String getGender() {
	return gender;
}
/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
	this.gender = gender;
}
/**
 * @return the relationship
 */
public String getRelationship() {
	return relationship;
}
/**
 * @param relationship the relationship to set
 */
public void setRelationship(String relationship) {
	this.relationship = relationship;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
}
