package com.bus24.dao;

import java.util.Date;

import java.util.List;

import com.bus24.beans.Booking;
import com.bus24.beans.Route;
import com.bus24.beans.SearchedBooking;

/**
 * 
 * @author Pavani & Sindhu
 *
 */
public interface BookingDAO {

	public Route bordingPoints(Integer routeId);

	/**
	 * Get All Bookings
	 * 
	 * @return List<SearhedBooking>
	 * @since 1.0
	 */
	public List<SearchedBooking> searchBookings();

	/**
	 * Get All booking list of specified travelId
	 * 
	 * @param travelId
	 * @return List<SearchedBooking>
	 * @since 1.0
	 */

	public List<SearchedBooking> searchBookings(Integer travelId);

	/**
	 * Get All booking list of specified from date and to date
	 * 
	 * @param from
	 *            date and to date
	 * @return List<SearchedBooking>
	 * @since 1.0
	 */
	public List<SearchedBooking> searchBookings(Date from, Date to);

	/**
	 * Get All booking list of specified travelId, from date and to date
	 * 
	 * @param travelId,from
	 *            date and to date
	 * @return List<SearchedBooking>
	 * @since 1.0
	 */

	public List<SearchedBooking> searchBookings(Integer travelId, Date from, Date to);

	/**
	 * This method persist Booking object into database
	 * 
	 * @param booking
	 * @return
	 * @author mulayam
	 */
	public Integer saveBooking(Booking booking);

}
