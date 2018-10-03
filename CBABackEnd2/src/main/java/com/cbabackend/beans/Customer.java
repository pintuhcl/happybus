/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.

 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;

import java.util.Date;
/**
 * This class is used to hold the Customer Details of Common Wealth Bank
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public class Customer {
private Integer customerId;
private String firstName;
private String lastName;
private String middleName;
private Date  dateOfBirth;
private String gender;
private String maritalStatus;
private String occupation;
private String incomeRange;
private String email;
private String alternativeEmail;
private String mobile;
private String alternativeMobile;
private String citizenship;
private String passportNumber;
private String passportType;
private String drivingLicence;
private String drivingLicenceType;
private String otherIdDesc;
private String taxFileNumber;
private String australianBusinessNumber;
private Address address;
private Byte[] image;
private Byte[] signature;
private Nominee nominee;
private String existingAccountNumber;
/**
 * @return the customerId
 */
public Integer getCustomerId() {
	return customerId;
}
/**
 * @param customerId the customerId to set
 */
public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}
/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the middleName
 */
public String getMiddleName() {
	return middleName;
}
/**
 * @param middleName the middleName to set
 */
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
/**
 * @return the dateOfBirth
 */
public Date getDateOfBirth() {
	return dateOfBirth;
}
/**
 * @param dateOfBirth the dateOfBirth to set
 */
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
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
 * @return the maritalStatus
 */
public String getMaritalStatus() {
	return maritalStatus;
}
/**
 * @param maritalStatus the maritalStatus to set
 */
public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
}
/**
 * @return the occupation
 */
public String getOccupation() {
	return occupation;
}
/**
 * @param occupation the occupation to set
 */
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
/**
 * @return the incomeRange
 */
public String getIncomeRange() {
	return incomeRange;
}
/**
 * @param incomeRange the incomeRange to set
 */
public void setIncomeRange(String incomeRange) {
	this.incomeRange = incomeRange;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the alternativeEmail
 */
public String getAlternativeEmail() {
	return alternativeEmail;
}
/**
 * @param alternativeEmail the alternativeEmail to set
 */
public void setAlternativeEmail(String alternativeEmail) {
	this.alternativeEmail = alternativeEmail;
}
/**
 * @return the mobile
 */
public String getMobile() {
	return mobile;
}
/**
 * @param mobile the mobile to set
 */
public void setMobile(String mobile) {
	this.mobile = mobile;
}
/**
 * @return the alternativeMobile
 */
public String getAlternativeMobile() {
	return alternativeMobile;
}
/**
 * @param alternativeMobile the alternativeMobile to set
 */
public void setAlternativeMobile(String alternativeMobile) {
	this.alternativeMobile = alternativeMobile;
}
/**
 * @return the citizenship
 */
public String getCitizenship() {
	return citizenship;
}
/**
 * @param citizenship the citizenship to set
 */
public void setCitizenship(String citizenship) {
	this.citizenship = citizenship;
}
/**
 * @return the passportNumber
 */
public String getPassportNumber() {
	return passportNumber;
}
/**
 * @param passportNumber the passportNumber to set
 */
public void setPassportNumber(String passportNumber) {
	this.passportNumber = passportNumber;
}
/**
 * @return the passportType
 */
public String getPassportType() {
	return passportType;
}
/**
 * @param passportType the passportType to set
 */
public void setPassportType(String passportType) {
	this.passportType = passportType;
}
/**
 * @return the drivingLicence
 */
public String getDrivingLicence() {
	return drivingLicence;
}
/**
 * @param drivingLicence the drivingLicence to set
 */
public void setDrivingLicence(String drivingLicence) {
	this.drivingLicence = drivingLicence;
}
/**
 * @return the drivingLicenceType
 */
public String getDrivingLicenceType() {
	return drivingLicenceType;
}
/**
 * @param drivingLicenceType the drivingLicenceType to set
 */
public void setDrivingLicenceType(String drivingLicenceType) {
	this.drivingLicenceType = drivingLicenceType;
}
/**
 * @return the otherIdDesc
 */
public String getOtherIdDesc() {
	return otherIdDesc;
}
/**
 * @param otherIdDesc the otherIdDesc to set
 */
public void setOtherIdDesc(String otherIdDesc) {
	this.otherIdDesc = otherIdDesc;
}
/**
 * @return the taxFileNumber
 */
public String getTaxFileNumber() {
	return taxFileNumber;
}
/**
 * @param taxFileNumber the taxFileNumber to set
 */
public void setTaxFileNumber(String taxFileNumber) {
	this.taxFileNumber = taxFileNumber;
}
/**
 * @return the australianBusinessNumber
 */
public String getAustralianBusinessNumber() {
	return australianBusinessNumber;
}
/**
 * @param australianBusinessNumber the australianBusinessNumber to set
 */
public void setAustralianBusinessNumber(String australianBusinessNumber) {
	this.australianBusinessNumber = australianBusinessNumber;
}
/**
 * @return the address
 */
public Address getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(Address address) {
	this.address = address;
}
/**
 * @return the image
 */
public Byte[] getImage() {
	return image;
}
/**
 * @param image the image to set
 */
public void setImage(Byte[] image) {
	this.image = image;
}
/**
 * @return the signature
 */
public Byte[] getSignature() {
	return signature;
}
/**
 * @param signature the signature to set
 */
public void setSignature(Byte[] signature) {
	this.signature = signature;
}
/**
 * @return the nominee
 */
public Nominee getNomine() {
	return nominee;
}
/**
 * @param nominee the nominee to set
 */
public void setNomine(Nominee nominee) {
	this.nominee = nominee;
}
/**
 * @return the existingAccountNumber
 */
public String getExistingAccountNumber() {
	return existingAccountNumber;
}
/**
 * @param existingAccountNumber the existingAccountNumber to set
 */
public void setExistingAccountNumber(String existingAccountNumber) {
	this.existingAccountNumber = existingAccountNumber;
}




}
