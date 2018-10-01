package com.bus24.web.service;

import java.util.Date;

public interface BookingService {

	
	
	/**
	 * This method return Bookings of all the travels
	 * 
	 * @return jsonResonpse
	 */
	public String searchBookings();
	
	/**
	 * This method return Bookings of Specific travel 
	 * @param travelId
	 * @return jsonREsponse
	 */
	public String searchBookings(Integer travelId);
	
	/**
	 * This method return Bookings of All the travels by specific Date
	 * @param fromDate
	 * @param toDate
	 * @return jsonresponse
	 */
	public String searchBookings(Date fromDate,Date toDate);
	
	/**
	 * This method return Bookings of  Specific travel by specific Date
	 * @param travelId
	 * @param fromDate
	 * @param toDate
	 * @return jsonresponse
	 */
	
	public String searchBookings(Integer travelId,Date fromDate,Date toDate);
	
	/**
	 * This method return the list of all passenger with passengerId,
	 * name,age,bookingId,seatNo,status of specific routeId
	 * 
	 * 
	 * @return Return jsonPassenger
	 * @author mulayam
	 */
	public String getAllPassengers(Integer routeId);

	/**
	 * This method process ticket booking
	 * 
	 * @param jsonBooking
	 * @return
	 * @author mulayam
	 */
	public String bookTicket(String jsonBooking);

}
