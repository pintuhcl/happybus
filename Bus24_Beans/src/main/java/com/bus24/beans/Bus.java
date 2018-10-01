/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.beans;

import java.io.Serializable;
/**
 * This class is used to hold Bus information and send across the n.w
 *@author  vicky,Mulayam
 * @since   1.0
 */
import java.util.Date;
import java.util.List;

/**
 * Holds the details of bus
 * 
 * @author mulayam
 * @version 1.0
 */
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer busId;
	private String regNo;
	private Byte status;
	private Integer busTypeId;

	private Travel travelId;
	private Long createdBy;

	private Date createdDate;
	private Long lastModifiedBy;
	private Date lastModifiedDate;
	private Long lastUpdatedBy;
	private Date lastUpdatedDate;
	// private String busRegNo;
	private List<Amenity> listAmenities;

	private BusType busType;

	/**
	 * @return the busId
	 */
	public Integer getBusId() {
		return busId;
	}

	/**
	 * @param busId
	 *            the busId to set
	 */
	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * @param regNo
	 *            the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	/**
	 * @return the status
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @return the busTypeId
	 */
	public Integer getBusTypeId() {
		return busTypeId;
	}

	/**
	 * @param busTypeId
	 *            the busTypeId to set
	 */
	public void setBusTypeId(Integer busTypeId) {
		this.busTypeId = busTypeId;
	}

	/**
	 * @return the travelId
	 */
	public Travel getTravelId() {
		return travelId;
	}

	/**
	 * @param travelId
	 *            the travelId to set
	 */
	public void setTravelId(Travel travelId) {
		this.travelId = travelId;
	}

	/**
	 * @return the listAmenities
	 */
	public List<Amenity> getListAmenities() {
		return listAmenities;
	}

	/**
	 * @param listAmenities
	 *            the listAmenities to set
	 */
	public void setListAmenities(List<Amenity> listAmenities) {
		this.listAmenities = listAmenities;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate
	 *            the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the busType
	 */
	public BusType getBusType() {
		return busType;
	}

	/**
	 * @param busType
	 *            the busType to set
	 */
	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", regNo=" + regNo + ", status=" + status + ", busTypeId=" + busTypeId
				+ ", travelId=" + travelId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", listAmenities=" + listAmenities
				+ ", busType=" + busType + "]";
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
