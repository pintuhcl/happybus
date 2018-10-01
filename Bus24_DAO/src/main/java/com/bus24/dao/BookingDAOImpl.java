package com.bus24.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Booking;
import com.bus24.beans.Route;
import com.bus24.beans.SearchedBooking;
import com.bus24.beans.Travel;
import com.bus24.dao.util.SQLConstants;

@Repository
public class BookingDAOImpl implements BookingDAO {
	private static Logger logger = Logger.getLogger(BookingDAOImpl.class);
	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public Route bordingPoints(Integer routeId) {
		final Route route = new Route();
		JdbcTemplate.queryForObject(SQLConstants.SQL_BOOKING_RETRIEVE_BOARDING_DROPPING, new RowMapper<Route>() {
			public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
				route.setBoardingPoints(rs.getString(1));
				route.setDroppingPoints(rs.getString(2));
				route.setPrice(rs.getDouble(3));
				return route;
			}
		}, routeId);

		return route;
	}

	/**
	 * This Method Contain Logic For Getting All Bookings Of All the Travels By
	 * SuperAdmin
	 * 
	 * @return List<searchedBooking>
	 * @author Sindhu
	 */

	@Override
	public List<SearchedBooking> searchBookings() {

		final SearchedBooking searchedBooking = new SearchedBooking();

		return JdbcTemplate.query(SQLConstants.SQL_SEARCH_BOOKINGS_BY_ALL_TRAVELS, new RowMapper<SearchedBooking>() {
			public SearchedBooking mapRow(ResultSet rs, int rowNum) throws SQLException {
				searchedBooking.setBookingId(rs.getInt(1));
				searchedBooking.setBookingDate(rs.getDate(2));
				searchedBooking.setDateOfJourney(rs.getDate(3));
				searchedBooking.setNoOfPassengers(rs.getInt(4));
				searchedBooking.setFinalFare(rs.getDouble(5));
				// travel
				Travel travel = new Travel();
				travel.setTravelId(rs.getInt(6));
				travel.setTravelName(rs.getString(7));
				searchedBooking.setTravel(travel);
				// route
				Route route = new Route();
				route.setRouteId(rs.getInt(8));
				searchedBooking.setRoute(route);
				searchedBooking.setSource(rs.getString(9));

				searchedBooking.setDestination(rs.getString(10));
				searchedBooking.setDistance(rs.getInt(11));

				searchedBooking.setArrivalTime(rs.getDate(12));
				searchedBooking.setDepatureTime(rs.getDate(13));

				System.out.println(searchedBooking);

				return searchedBooking;
			}
		});

	}

	/**
	 * This Method Contains Logic For Getting All Bookings From Specific Travel
	 * 
	 * @param travel_id
	 * @return List<searchedBooking>
	 * @author Sindhu
	 */

	@Override
	public List<SearchedBooking> searchBookings(Integer travelId) {
		final SearchedBooking searchedBooking = new SearchedBooking();
		logger.info("Entered into searchBookingsbytravelid===============>");
		return JdbcTemplate.query(SQLConstants.SQL_SEARCH_BOOKINGS_BY_TRAVEL_ID, new RowMapper<SearchedBooking>() {
			public SearchedBooking mapRow(ResultSet rs, int rowNum) throws SQLException {
				searchedBooking.setBookingId(rs.getInt(1));
				searchedBooking.setBookingDate(rs.getDate(2));
				searchedBooking.setDateOfJourney(rs.getDate(3));
				searchedBooking.setNoOfPassengers(rs.getInt(4));
				searchedBooking.setFinalFare(rs.getDouble(5));
				// travel
				Travel travel = new Travel();
				travel.setTravelId(rs.getInt(6));
				travel.setTravelName(rs.getString(7));
				searchedBooking.setTravel(travel);
				// route
				Route route = new Route();
				route.setRouteId(rs.getInt(8));
				searchedBooking.setRoute(route);
				searchedBooking.setSource(rs.getString(9));

				searchedBooking.setDestination(rs.getString(10));
				searchedBooking.setDistance(rs.getInt(11));

				searchedBooking.setArrivalTime(rs.getDate(12));
				searchedBooking.setDepatureTime(rs.getDate(13));

				System.out.println(searchedBooking);
				return searchedBooking;
			}
		}, travelId);

	}

	/**
	 * This Method Contain Logic For Getting All Bookings By FromDate and ToDate
	 * 
	 * @param fromDate,toDate
	 * @return List<searchedBooking>
	 * @author Sindhu And Pavani
	 */

	@Override
	public List<SearchedBooking> searchBookings(Date from, Date to) {
		final SearchedBooking searchedBooking = new SearchedBooking();

		return JdbcTemplate.query(SQLConstants.SQL_SEARCH_BOOKINGS_BY_USING_FROM_TO_DATE,
				new RowMapper<SearchedBooking>() {
					public SearchedBooking mapRow(ResultSet rs, int rowNum) throws SQLException {
						searchedBooking.setBookingId(rs.getInt(1));
						searchedBooking.setBookingDate(rs.getDate(2));
						searchedBooking.setDateOfJourney(rs.getDate(3));
						searchedBooking.setNoOfPassengers(rs.getInt(4));
						searchedBooking.setFinalFare(rs.getDouble(5));
						// travel
						Travel travel = new Travel();
						travel.setTravelId(rs.getInt(6));
						travel.setTravelName(rs.getString(7));
						searchedBooking.setTravel(travel);
						// route
						Route route = new Route();
						route.setRouteId(rs.getInt(8));
						searchedBooking.setRoute(route);
						searchedBooking.setSource(rs.getString(9));

						searchedBooking.setDestination(rs.getString(10));
						searchedBooking.setDistance(rs.getInt(11));

						searchedBooking.setArrivalTime(rs.getDate(12));
						searchedBooking.setDepatureTime(rs.getDate(13));

						System.out.println(searchedBooking);

						return searchedBooking;
					}
				}, from, to);

	}

	/**
	 * This Method Contain Logic For Getting All Bookings By Specific TravelId
	 * ,FromDate and ToDate
	 * 
	 * @param travelID,fromDate,toDate
	 * @return List<searchedBooking>
	 * @author Sindhu And Pavani
	 */

	@Override
	public List<SearchedBooking> searchBookings(Integer travelId, Date from, Date to) {
		final SearchedBooking searchedBooking = new SearchedBooking();

		return JdbcTemplate.query(SQLConstants.SQL_SEARCH_BOOKINGS_BY_USING_TRAVEL_ID_FROM_AND_TO_DATE,
				new RowMapper<SearchedBooking>() {
					public SearchedBooking mapRow(ResultSet rs, int rowNum) throws SQLException {
						searchedBooking.setBookingId(rs.getInt(1));
						searchedBooking.setBookingDate(rs.getDate(2));
						searchedBooking.setDateOfJourney(rs.getDate(3));
						searchedBooking.setNoOfPassengers(rs.getInt(4));
						searchedBooking.setFinalFare(rs.getDouble(5));
						// travel obj
						Travel travel = new Travel();
						travel.setTravelId(rs.getInt(6));
						travel.setTravelName(rs.getString(7));
						searchedBooking.setTravel(travel);
						// route obj
						Route route = new Route();
						route.setRouteId(rs.getInt(8));
						searchedBooking.setRoute(route);
						searchedBooking.setSource(rs.getString(9));

						searchedBooking.setDestination(rs.getString(10));
						searchedBooking.setDistance(rs.getInt(11));

						searchedBooking.setArrivalTime(rs.getDate(12));
						searchedBooking.setDepatureTime(rs.getDate(13));

						System.out.println(searchedBooking);

						return searchedBooking;
					}
				}, travelId, from, to);

	}

	/**
	 * Persist Booking Data Into Bookings table
	 * 
	 * @author mulayam
	 */
	@Override
	public Integer saveBooking(Booking booking) {

		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

		JdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// user_id,route_id,travel_id,,"
				// date_of_journey," +
				// "boarding_point,dropping_point,ticket_no,"
				// "number_of_passengers,final_fare"

				PreparedStatement ps = con.prepareStatement(SQLConstants.SQL_INSERT_BOOKING,
						Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, booking.getUser().getUserId());
				ps.setInt(2, booking.getRouteId());
				ps.setInt(3, booking.getTravelId());
				ps.setDate(4, new java.sql.Date(booking.getDateOfJourney().getTime()));
				ps.setString(5, booking.getBoardingPoint());
				ps.setString(6, booking.getDroppingPoint());

				ps.setString(7, booking.getTicketNo());
				ps.setInt(8, booking.getNoOfPassenger());
				ps.setDouble(9, booking.getFinalFare());

				return ps;
			}
		}, generatedKeyHolder);

		return generatedKeyHolder.getKey().intValue();
	}

}
