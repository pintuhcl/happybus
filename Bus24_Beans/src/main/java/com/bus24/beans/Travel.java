/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.beans;

import java.io.Serializable;
import java.util.List;

/**
 * This class is used to hold Travel information and send across the n.w
 * 
 * @author sathish.bandi
 * @since 1.0
 */
public class Travel implements Serializable {
	/**
		 * 
		 */
	private static long serialVersionUID = 1L;
	private Integer travelId;
	private String travelRegNumber;
	private String travelName;
	private String phoneNumber1;
	private String phoneNumber2;
	private String website;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private Integer zipcode;
	private Byte status;
	private User user;
	private BankDetails bankDetails;
	private List<Bus> busList;
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	/**
	 * @param serialVersionUID the serialVersionUID to set
	 */
	public static void setSerialVersionUID(long serialVersionUID) {
		Travel.serialVersionUID = serialVersionUID;
	}
	/**
	 * @return the travelId
	 */
	public Integer getTravelId() {
		return travelId;
	}
	/**
	 * @param travelId the travelId to set
	 */
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	/**
	 * @return the travelRegNumber
	 */
	public String getTravelRegNumber() {
		return travelRegNumber;
	}
	/**
	 * @param travelRegNumber the travelRegNumber to set
	 */
	public void setTravelRegNumber(String travelRegNumber) {
		this.travelRegNumber = travelRegNumber;
	}
	/**
	 * @return the travelName
	 */
	public String getTravelName() {
		return travelName;
	}
	/**
	 * @param travelName the travelName to set
	 */
	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}
	/**
	 * @return the phoneNumber1
	 */
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	/**
	 * @param phoneNumber1 the phoneNumber1 to set
	 */
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	/**
	 * @return the phoneNumber2
	 */
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	/**
	 * @param phoneNumber2 the phoneNumber2 to set
	 */
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
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
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipcode
	 */
	public Integer getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the status
	 */
	public Byte getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the bankDetails
	 */
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	/**
	 * @param bankDetails the bankDetails to set
	 */
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	/**
	 * @return the busList
	 */
	public List<Bus> getBusList() {
		return busList;
	}
	/**
	 * @param busList the busList to set
	 */
	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}

	

}
