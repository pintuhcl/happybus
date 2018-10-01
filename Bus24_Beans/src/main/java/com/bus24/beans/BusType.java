/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.beans;

import java.io.Serializable;

/**
 * This class is used to hold BusType information and send across the n.w
 * 
 * @author Mulayam
 * @since 1.0
 */

public class BusType implements Serializable {

	private Integer typeId;
	private String typeName;
	private String model;
	private Integer noOfSeats;
	private String layoutModel;
	private String layoutType;
	private String layoutDescription;
	
	
	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName
	 *            the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the noOfSeats
	 */
	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	/**
	 * @param noOfSeats
	 *            the noOfSeats to set
	 */
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	/**
	 * @return the layoutModel
	 */
	public String getLayoutModel() {
		return layoutModel;
	}

	/**
	 * @param layoutModel
	 *            the layoutModel to set
	 */
	public void setLayoutModel(String layoutModel) {
		this.layoutModel = layoutModel;
	}

	/**
	 * @return the layoutType
	 */
	public String getLayoutType() {
		return layoutType;
	}

	/**
	 * @param layoutType
	 *            the layoutType to set
	 */
	public void setLayoutType(String layoutType) {
		this.layoutType = layoutType;
	}

	/**
	 * @return the layoutDescription
	 */
	public String getLayoutDescription() {
		return layoutDescription;
	}

	/**
	 * @param layoutDescription
	 *            the layoutDescription to set
	 */
	public void setLayoutDescription(String layoutDescription) {
		this.layoutDescription = layoutDescription;
	}

}
