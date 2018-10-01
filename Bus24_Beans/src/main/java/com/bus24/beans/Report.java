/* Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.*/
package com.bus24.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used to hold Payment/business related Report information
 * @author suchitra
 * @since 1.0
 */
public class Report implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer paymentId;
	private Date paymentTime;
	private Integer transactionId;
	private Integer userId;
	private String payment_by;
	private Integer bank_acc_id;
	private Integer amount;
	private Integer status;
	/**
	 * @return the paymentId
	 */
	public Integer getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the paymentTime
	 */
	public Date getPaymentTime() {
		return paymentTime;
	}
	/**
	 * @param paymentTime the paymentTime to set
	 */
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the payment_by
	 */
	public String getPayment_by() {
		return payment_by;
	}
	/**
	 * @param payment_by the payment_by to set
	 */
	public void setPayment_by(String payment_by) {
		this.payment_by = payment_by;
	}
	/**
	 * @return the bank_acc_id
	 */
	public Integer getBank_acc_id() {
		return bank_acc_id;
	}
	/**
	 * @param bank_acc_id the bank_acc_id to set
	 */
	public void setBank_acc_id(Integer bank_acc_id) {
		this.bank_acc_id = bank_acc_id;
	}
	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
