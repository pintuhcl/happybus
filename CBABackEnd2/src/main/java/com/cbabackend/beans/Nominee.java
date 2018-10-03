/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;

import java.sql.Date;

/**
 * This class is used to hold Type of Nomine Information
 * 
 * @author Sathish
 * @since CBABE 1.0
 */

public class Nominee {

	private Integer nomineeId;
	private String nomineeName;
	private Date nomineeDOB;
	private String gender;
	private String relationship;
	private String address;
	private Integer createdBy;
	private Date createDate;
	private Date lastModifiedDate;
	private Integer lastModifiedBy;

	/**
	 * @return the nomineeId
	 */
	public Integer getNomineeId() {
		return nomineeId;
	}

	/**
	 * @param nomineeId
	 *            the nomineeId to set
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
	 * @param nomineeName
	 *            the nomineeName to set
	 */
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	/**
	 * @return the nomineeDOB
	 */
	public Date getNomineeDOB() {
		return nomineeDOB;
	}

	/**
	 * @param nomineeDOB
	 *            the nomineeDOB to set
	 */
	public void setNomineeDOB(Date nomineeDOB) {
		this.nomineeDOB = nomineeDOB;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
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
	 * @param relationship
	 *            the relationship to set
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
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
}// class
