/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used to hold Coupon information and send across the n.w
 * 
 * @author  Sudheer,Lokesh
 * @since 1.0
 */
public class Coupon implements Serializable {
	private Integer couponId;
	private String couponCode;
	private Date generatedDate;
	private Integer discount;
	private Byte status;
	private User user;
	/**
	 * @return the couponId
	 */
	public Integer getCouponId() {
		return couponId;
	}
	/**
	 * @param couponId the couponId to set
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	/**
	 * @return the couponCode
	 */
	public String getCouponCode() {
		return couponCode;
	}
	/**
	 * @param couponCode the couponCode to set
	 */
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	/**
	 * @return the generatedDate
	 */
	public Date getGeneratedDate() {
		return generatedDate;
	}
	/**
	 * @param generatedDate the generatedDate to set
	 */
	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}
	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
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
	
}