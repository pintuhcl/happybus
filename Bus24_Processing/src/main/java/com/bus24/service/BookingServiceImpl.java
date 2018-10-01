package com.bus24.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus24.beans.Booking;
import com.bus24.beans.Passenger;
import com.bus24.beans.Response;
import com.bus24.beans.Route;

import com.bus24.beans.SearchedBooking;
import com.bus24.beans.Travel;
import com.bus24.beans.User;
import com.bus24.dao.BookingDAO;
import com.bus24.dao.PassengerDAO;
import com.bus24.dao.RoutesDAO;
import com.bus24.dao.UsersDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;

@Service
public class BookingServiceImpl implements BookingService {
	private static Logger logger = Logger.getLogger(BookingServiceImpl.class);
	@Autowired
	private BookingDAO bookingDAO;

	@Autowired
	private RoutesDAO routeDAO;
	@Autowired
	private PassengerDAO passengerDAO;

	@Autowired
	private UsersDAO usersDAO;

	public String boardingPoints(String jsonRouteId) {
		String jsonResponse = "";
		logger.info("Entered into Showmyprofile : " + jsonRouteId);

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Registration is Failure!Please Try Again");

		try {// handle exceptions
			Route route = JsonUtil.convertJsonToJava(jsonRouteId, Route.class);
			Integer routeId = route.getRouteId();
			route = bookingDAO.bordingPoints(routeId);
			if (route != null) {
				jsonResponse = JsonUtil.convertJavaToJson(route);
				response.setMessage("Boarding points sent");
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setData(jsonResponse);
				return jsonResponse;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process!Please Try Again");
			logger.error("Exception Occured while User Login ::" + e.getMessage());

		}

		catch (Exception e) {
			e.printStackTrace();
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to process!Please Try Again");
			logger.error("Exception Occured while User Login ::" + e.getMessage());

		}

		return jsonResponse;

	}

	@Override
	public String searchBookings() {
		String jsonResponse = "";

		Response response = new Response();
		response.setMessage("Could not Fetch Booking Details!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {
			List<SearchedBooking> list = bookingDAO.searchBookings();

			if (list != null && list.size() > 0) {
				jsonResponse = JsonUtil.convertJavaToJson(list);
				if (jsonResponse != null) {

					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Bookings List Fetched");
					response.setData(jsonResponse);

				} else {
					logger.error("bookings list conversion from list to json failed");
				}
			} // if
			else {
				response.setMessage("Bookings Details Not Found");
				response.setStatus(StatusUtil.STATUS_FAILURE);
			}

		} // try
		catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Booking Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Booking Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}

		logger.info(jsonResponse);
		return jsonResponse;
	}

	@Override
	public String searchBookings(String jsontravelId) {
		// System.out.println(jsontravelId);

		String jsonResponse = "";
		Response response = new Response();
		response.setMessage("Could not Fetch Booking Details!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {

			logger.info("Entered into try=======>");
			// Travel travel=JsonUtil.convertJsonToJava(jsontravelId,
			// Travel.class);
			// Integer travelId = travel.getTravelId();

			Integer travelId = Integer.parseInt(jsontravelId);

			List<SearchedBooking> list = bookingDAO.searchBookings(travelId);
			if (list != null && list.size() > 0) {
				logger.info("Entered into if=======>");
				jsonResponse = JsonUtil.convertJavaToJson(list);
				if (jsonResponse != null) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Bookings List Fetched");
					response.setData(jsonResponse);

				} // if closed
				else {
					logger.error("bookings list conversion from list to json failed");
				} // else closed
			} // First if
			else {
				response.setMessage("Bookings Details Not Found");
				response.setStatus(StatusUtil.STATUS_FAILURE);
			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Booking Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Booking Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}

		return jsonResponse;
	}

	@Override
	public String searchBookings(String jsonFromDate, String jsonToDate) {
		String jsonResponse = "";
		logger.info("enter into searchBooking:" + jsonFromDate + "----" + jsonToDate);
		Response response = new Response();
		response.setMessage("Could not Fetch Booking Details!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {
			logger.info("Enter in searchBooking try");
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date fDate = df.parse(jsonFromDate);
			Date tDate = df.parse(jsonToDate);

			List<SearchedBooking> list = bookingDAO.searchBookings(fDate, tDate);
			for (SearchedBooking searchedBooking : list) {
				System.out.println(searchedBooking);
			}
			if (list != null && list.size() > 0) {
				jsonResponse = JsonUtil.convertJavaToJson(list);
				if (jsonResponse != null) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Bookings List Fetched");
					response.setData(jsonResponse);

				} // if closed
				else {
					logger.error("bookings list conversion from list to json failed");
				} // else closed
			} // First if
			else {
				response.setMessage("Bookings Details Not Found");
				response.setStatus(StatusUtil.STATUS_FAILURE);
			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Booking Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Booking Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}

		return jsonResponse;

	}

	@Override
	public String searchBookings(String jsonTravelId, String jsonFromDate, String jsonToDate) {
		String jsonResponse = "";
		logger.info("in try========================" + jsonFromDate + "====" + jsonToDate + "====" + jsonTravelId);
		Response response = new Response();
		response.setMessage("Could not Fetch Booking Details!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {

			logger.info("Entered into try=======>");
			Integer travelId = Integer.parseInt(jsonTravelId);

			/*
			 * Travel travel=JsonUtil.convertJsonToJava(jsonTravelId,
			 * Travel.class); Integer travelId = travel.getTravelId();
			 */
			logger.info("convertion in try========================" + travelId);
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date fDate = df.parse(jsonFromDate);
			Date tDate = df.parse(jsonToDate);
			logger.info("convertion in try========================" + fDate + "====" + tDate);

			List<SearchedBooking> list = bookingDAO.searchBookings(travelId, fDate, tDate);
			if (list != null && list.size() > 0) {
				jsonResponse = JsonUtil.convertJavaToJson(list);
				if (jsonResponse != null) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Bookings List Fetched");
					response.setData(jsonResponse);

				} // if closed
				else {
					logger.error("bookings list conversion from list to json failed");
				} // else closed
			} // First if
			else {
				response.setMessage("Bookings Details Not Found");
				response.setStatus(StatusUtil.STATUS_FAILURE);
			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Booking Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Booking Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}

		return jsonResponse;

	}

	@Transactional(noRollbackFor = { DataAccessException.class })
	@Override
	public String bookTicket(String jsonBooking) {

		logger.info("Entered into bookTicket : " + jsonBooking);

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Booking Ticket is Failure!Please Try Again");
		// convert jsonUser into java object
		Booking booking = JsonUtil.convertJsonToJava(jsonBooking, Booking.class);
		try {
			if (booking != null) {
				logger.info("Booking jsonConverted Into Java Object : " + booking);
				List<Passenger> listPassenegrs = booking.getPassengers();
				logger.info("passenger: " + listPassenegrs);

				User user = booking.getUser();
				logger.info("User " + user);
				if (user != null) {
					// get user id from db

					User u = usersDAO.getUserDetails(user.getEmail());
					booking.getUser().setUserId(u.getUserId());
					logger.info("User Details fetched: " + user);
					// get route info of specific routeId
					Route route = routeDAO.getRoute(booking.getRouteId());

					logger.info("Route Details fetched: " + route);

					String ticketNo = user.getUserId() + "" + Calendar.getInstance().getTimeInMillis();

					booking.setTravelId(route.getTravelId());
					booking.setDateOfJourney(route.getDateOfJourney());

					Date date = new Date();
					// SimpleDateFormat format = new
					// SimpleDateFormat("yyyy-MM-dd
					// HH:mm:ss.SSS");

					booking.setBookingDate(date);

					booking.setTicketNo(ticketNo);
					booking.setPaymentId(0);
					booking.setCouponId(0);
					booking.setNoOfPassenger(listPassenegrs.size());
					booking.setStatus((byte) 0);

					// save booking details into bookings table

					logger.info("Booking details prepared and saving: ");
					Integer newBookingId = bookingDAO.saveBooking(booking);
					logger.info("New BookingId:" + newBookingId);

					if (newBookingId != null && newBookingId > 0) {
						logger.info("Booking details saved and newBookingId created ,now saveing passengers list");

						int rows[] = passengerDAO.addPassengers(listPassenegrs, newBookingId);

						// check passenger details successfully saved
						int count = Arrays.stream(rows).sum();

						if (count == listPassenegrs.size()) {
							logger.error("Passenger Details saved");
							response.setMessage("Congratulation ! Your ticket Successfully Booked.");

							String jsonPassengers = JsonUtil.convertJavaToJson(listPassenegrs);
							response.setData(jsonPassengers);

							response.setDataList(
									new String[] { booking.getTicketNo(), booking.getDateOfJourney().toString(),
											booking.getBoardingPoint(), booking.getDroppingPoint() });
							response.setStatus(StatusUtil.STATUS_SUCCESS);

						}
					}
				} else {
					logger.error("User Not Exists");
					response.setMessage("User Not Exists");
					response.setStatus(StatusUtil.STATUS_FAILURE);
				}

				// save passengers details in passengers table

			}
		} catch (DataAccessException de) {
			logger.info("DataAccessException Occured while Booking Ticket : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Booking Ticket: " + e);

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		String jsonResponse = JsonUtil.convertJavaToJson(response);
		return jsonResponse;
	}

	@Override
	public String getAllPassenger(Integer routeId) {
		Response response = new Response();
		response.setMessage("Could not Fetch Passenger Details!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		try {

			if (routeId != null) {
				List<Passenger> list = passengerDAO.getAllPassengers(routeId);
				if (list != null && list.size() > 0) {
					String jsonList = JsonUtil.convertJavaToJson(list);
					if (jsonList != null) {
						response.setStatus(StatusUtil.STATUS_SUCCESS);
						response.setMessage("Passengers List Fetched");
						response.setData(jsonList);
					} else {
						logger.error("Passenger list conversion from list to json failed");
					}
				} else {
					response.setMessage("Passenger Details Not Found");
					response.setStatus(StatusUtil.STATUS_FAILURE);
				}
			}
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching Passenger Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching Passenger Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		return JsonUtil.convertJavaToJson(response);
	}

}
