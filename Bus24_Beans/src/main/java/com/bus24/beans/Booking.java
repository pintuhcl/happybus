package com.bus24.beans;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author mulayam
 *
 */
public class Booking {

	private Integer bookingId;
	private String ticketNo;
	private Date bookingDate;
	private Integer noOfPassenger;
	private Integer userId;

	private Integer routeId;

	private Integer travelId;
	private Integer paymentId;
	private Integer couponId;

	private Double finalFare;
	private Byte status;

	private Date dateOfJourney;
	private String boardingPoint;
	private String droppingPoint;

	private List<Passenger> passengers;
	private User user;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(Integer noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Double getFinalFare() {
		return finalFare;
	}

	public void setFinalFare(Double finalFare) {
		this.finalFare = finalFare;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", ticketNo=" + ticketNo + ", bookingDate=" + bookingDate
				+ ", noOfPassenger=" + noOfPassenger + ", userId=" + userId + ", routeId=" + routeId + ", travelId="
				+ travelId + ", paymentId=" + paymentId + ", couponId=" + couponId + ", finalFare=" + finalFare
				+ ", status=" + status + ", dateOfJourney=" + dateOfJourney + ", boardingPoint=" + boardingPoint
				+ ", droppingPoint=" + droppingPoint + ", passengers=" + passengers + ", user=" + user
				+ ", getBookingId()=" + getBookingId() + ", getBookingDate()=" + getBookingDate()
				+ ", getNoOfPassenger()=" + getNoOfPassenger() + ", getUserId()=" + getUserId() + ", getRouteId()="
				+ getRouteId() + ", getTravelId()=" + getTravelId() + ", getPaymentId()=" + getPaymentId()
				+ ", getCouponId()=" + getCouponId() + ", getFinalFare()=" + getFinalFare() + ", getStatus()="
				+ getStatus() + ", getDateOfJourney()=" + getDateOfJourney() + ", getBoardingPoint()="
				+ getBoardingPoint() + ", getDroppingPoint()=" + getDroppingPoint() + ", getPassengers()="
				+ getPassengers() + ", getUser()=" + getUser() + ", getTicketNo()=" + getTicketNo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
