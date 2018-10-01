/* Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.beans;

import java.sql.Time;
import java.util.Date;

/**
 * This class hold the searched buses information for passenger send across the
 * network
 * 
 * @author mulayam
 */
public class SearchedBus {

	private Integer busId;
	private Integer noOfSeats;
	private Integer noOfAvaibleSeats;
	private Integer routeId;
	private String source;
	private String destination;

	private Integer travelId;
	private String travelName;

	private Date departureDate;
	private Date arrivalDate;

	private Time departureTime;
	private Time arrivalTime;

	private Integer distance;
	private String boradingPoints;
	private String dropingPoints;

	private String via;
	private Integer price;
	private String busType;
	private String busModel;
	private String layoutModel;

	private String layoutDescription;

	private Integer totalTime;

	private String layoutType;

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
	 * @return the noOfAvaibleSeats
	 */
	public Integer getNoOfAvaibleSeats() {
		return noOfAvaibleSeats;
	}

	/**
	 * @param noOfAvaibleSeats
	 *            the noOfAvaibleSeats to set
	 */
	public void setNoOfAvaibleSeats(Integer noOfAvaibleSeats) {
		this.noOfAvaibleSeats = noOfAvaibleSeats;
	}

	/**
	 * @return the routeId
	 */
	public Integer getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId
	 *            the routeId to set
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the travelId
	 */
	public Integer getTravelId() {
		return travelId;
	}

	/**
	 * @param travelId
	 *            the travelId to set
	 */
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}

	/**
	 * @return the travelName
	 */
	public String getTravelName() {
		return travelName;
	}

	/**
	 * @param travelName
	 *            the travelName to set
	 */
	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}

	/**
	 * @return the departureTime
	 */
	public Date getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime
	 *            the departureTime to set
	 */

	/**
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * @return the boradingPoints
	 */
	public String getBoradingPoints() {
		return boradingPoints;
	}

	/**
	 * @param boradingPoints
	 *            the boradingPoints to set
	 */
	public void setBoradingPoints(String boradingPoints) {
		this.boradingPoints = boradingPoints;
	}

	/**
	 * @return the dropingPoints
	 */
	public String getDropingPoints() {
		return dropingPoints;
	}

	/**
	 * @param dropingPoints
	 *            the dropingPoints to set
	 */
	public void setDropingPoints(String dropingPoints) {
		this.dropingPoints = dropingPoints;
	}

	/**
	 * @return the via
	 */
	public String getVia() {
		return via;
	}

	/**
	 * @param via
	 *            the via to set
	 */
	public void setVia(String via) {
		this.via = via;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the busType
	 */
	public String getBusType() {
		return busType;
	}

	/**
	 * @param busType
	 *            the busType to set
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}

	/**
	 * @return the busModel
	 */
	public String getBusModel() {
		return busModel;
	}

	/**
	 * @param busModel
	 *            the busModel to set
	 */
	public void setBusModel(String busModel) {
		this.busModel = busModel;
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

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate
	 *            the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the arrivalTime
	 */
	public Time getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime
	 *            the arrivalTime to set
	 */
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @param departureTime
	 *            the departureTime to set
	 */
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the totalTime
	 */
	public Integer getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime
	 *            the totalTime to set
	 */
	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public String getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(String layoutType) {
		this.layoutType = layoutType;
	}
	

}
