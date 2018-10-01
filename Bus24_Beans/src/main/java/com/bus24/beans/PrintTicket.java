package com.bus24.beans;
import java.io.Serializable;
import java.util.Date;

/**
 * This class is used to hold Printticket  information and send across the n.w
 * 
 * @author srinivas
 * @since 1.0
 */

public class PrintTicket {
	
	Integer serviceNo;
	Integer reportingTime;
	Integer departureTime;
	Integer seatNo;
	String boardingPoint;
	Integer ticketNo;
	Integer totalFare;
	public Integer getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(Integer serviceNo) {
		this.serviceNo = serviceNo;
	}
	public Integer getReportingTime() {
		return reportingTime;
	}
	public void setReportingTime(Integer reportingTime) {
		this.reportingTime = reportingTime;
	}
	public Integer getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Integer departureTime) {
		this.departureTime = departureTime;
	}
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	public Integer getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(Integer ticketNo) {
		this.ticketNo = ticketNo;
	}
	public Integer getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}
	
	

}
