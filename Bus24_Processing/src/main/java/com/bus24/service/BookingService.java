package com.bus24.service;

import java.util.Date;

import org.json.JSONObject;

public interface BookingService {
	public String boardingPoints(String routeId);

	public String searchBookings();

	public String searchBookings(String travelId);

	public String searchBookings(String fromDate, String toDate);

	public String searchBookings(String travelId, String fromDate, String toDate);

	/**
	 * This method return the list of all passenger with passengerId,
	 * name,age,bookingId,seatNo,status of specific routeId
	 * 
	 * 
	 * @return Return jsonPassenger
	 * @author mulayam
	 */
	public String getAllPassenger(Integer routeId);

	/**
	 * This method process ticket booking
	 * 
	 * @param jsonBooking
	 * @return
	 * @author mulayam
	 */
	public String bookTicket(String jsonBooking);

}
