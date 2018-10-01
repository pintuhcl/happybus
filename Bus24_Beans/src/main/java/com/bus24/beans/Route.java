/* Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.beans;

import java.io.Serializable;
import java.util.Date;
/**
* This class is used to hold Agents information and send across the n.w
*@author  sahoo
* @since   1.0
*/
public class Route implements Serializable{

	

	private Integer routeId;
	private Integer travelId;
	private Long userId;
	private Bus bus;
	private Integer busId;
	
	
	private String source;
	private String destination;
	private String via;
	private Integer distance;
	private Date departureTime;
	private Date arrivalTime;
	private Date travelDuration;
	private String boardingPoints;	
	private String droppingPoints;
	private Date dateOfJourney;
	private Date dateOfReturn;
	private Byte status;
	private Integer serviceNo;
	private Double price;
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getTravelId() {
		return travelId;
	}
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(Date travelDuration) {
		this.travelDuration = travelDuration;
	}
	public String getBoardingPoints() {
		return boardingPoints;
	}
	public void setBoardingPoints(String boardingPoints) {
		this.boardingPoints = boardingPoints;
	}
	public String getDroppingPoints() {
		return droppingPoints;
	}
	public void setDroppingPoints(String droppingPoints) {
		this.droppingPoints = droppingPoints;
	}
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	/**
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}
	/**
	 * @param bus the bus to set
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Date getDateOfReturn() {
		return dateOfReturn;
	}
	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	public Byte getStatus() {
		return status;
	}

	public Integer getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(Integer serviceNo) {
		this.serviceNo = serviceNo;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
}
