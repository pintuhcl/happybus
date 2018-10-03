/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 * This class is used to hold Type of Card information Of Comman Wealth Bank
 * 
 * @author Mayur R Tibadiya
 * @since CBABE 1.0
 */
public class Card implements Serializable {

	private Integer cardId;
	private String cardNumber;
	private String cardHolderName;
	private Date expiryDate;
	private Integer cvv;
	private Integer cardTypeId;// FK Card_Type Id

	/**
	 * @return the cardId
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId
	 *            the cardId to set
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * @param cardHolderName
	 *            the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the cvv
	 */
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * @param cvv
	 *            the cvv to set
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return the cardTypeId
	 */
	public Integer getCardTypeId() {
		return cardTypeId;
	}

	/**
	 * @param cardTypeId
	 *            the cardTypeId to set
	 */
	public void setCardTypeId(Integer cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

}
