
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.beans;

import java.io.Serializable;

/**
* This class is used to hold Type of Card_Type information
* 
* @author Mayur R Tibadiya
* @since CBABE 1.0
*/
public class Card_Type implements Serializable {

	private Integer cardTypeId;
	private String cardTypeName;
	private String cardTypeNumber;
	private String cardDistributedName;

	/**
	 * @return the cardTyprId
	 */
	public Integer getCardTyprId() {
		return cardTypeId;
	}

	/**
	 * @param cardTyprId
	 *            the cardTyprId to set
	 */
	public void setCardTyprId(Integer cardTyprId) {
		this.cardTypeId = cardTyprId;
	}

	/**
	 * @return the cardTypeName
	 */
	public String getCardTypeName() {
		return cardTypeName;
	}

	/**
	 * @param cardTypeName
	 *            the cardTypeName to set
	 */
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	/**
	 * @return the cardTypeNumber
	 */
	public String getCardTypeNumber() {
		return cardTypeNumber;
	}

	/**
	 * @param cardTypeNumber
	 *            the cardTypeNumber to set
	 */
	public void setCardTypeNumber(String cardTypeNumber) {
		this.cardTypeNumber = cardTypeNumber;
	}

	/**
	 * @return the cardDistributedName
	 */
	public String getCardDistributedName() {
		return cardDistributedName;
	}

	/**
	 * @param cardDistributedName
	 *            the cardDistributedName to set
	 */
	public void setCardDistributedName(String cardDistributedName) {
		this.cardDistributedName = cardDistributedName;
	}

}
