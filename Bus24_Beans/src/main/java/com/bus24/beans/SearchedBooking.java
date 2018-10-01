/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used to hold SearchBooking information and send across the network
 * 
 * @author Sindhu & pavani
 * @since 1.0
 */
public class SearchedBooking implements Serializable {

	private Integer bookingId;
	private Date bookingDate;
    private Travel travel;
	private Integer noOfPassengers;
	private String source;
	private String destination;
	private Integer distance;
	private Date arrivalTime;
	private Date depatureTime;
	private Date travelDuration;
	private Date dateOfJourney;
	private Double finalFare;
	private Route route;
	/**
	 * 
	 * @return bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}
	/**
	 * 
	 * @param bookingId the bookinId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * 
	 * @return bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}
	/**
	 * 
	 * @param bookingDate the bookingId to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * 
	 * @return travel
	 */
		public Travel getTravel() {
		return travel;
	}
		/**
		 * 
		 * @param travel the travel to set
		 */
	public void setTravel(Travel travel) {
		this.travel = travel;
	}
		/**
	 * 
	 * @return noOfPassengers
	 */
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	/**
	 * 
	 * @param noOfPassengers the no OfPassengers to set
	 */
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	/**
	 * 
	 * @return source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 
	 * @param sourec the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 
	 * @return destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * 
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * 
	 * @return distance
	 */
	public Integer getDistance() {
		return distance;
	}
	/**
	 * 
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	/**
	 * 
	 * @return arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * 
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * 
	 * @return depatureTime
	 */
	public Date getDepatureTime() {
		return depatureTime;
	}
	/**
	 * 
	 * @param depatureTime the depatureTime to set
	 */
	public void setDepatureTime(Date depatureTime) {
		this.depatureTime = depatureTime;
	}
	/**
	 * 
	 * @return duration
	 */
	public Date getTravelDuration() {
		return travelDuration;
	}
	/**
	 * 
	 * @param travelDuration the travelDuration 
	 */
	public void setTravelDuration(Date travelDuration) {
		this.travelDuration = travelDuration;
	}
	/**
	 * 
	 * @return dateOfJourney
	 */
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	/**
	 * 
	 * @param dateOfJourney the dateOfJourney
	 */
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	/**
	 * 
	 * @return finalFare
	 */
	public Double getFinalFare() {
		return finalFare;
	}
	/**
	 * 
	 * @param finalFare the finalFare to set
	 */
	public void setFinalFare(Double finalFare) {
		this.finalFare = finalFare;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route=route;
		
	}
	
	
	}
