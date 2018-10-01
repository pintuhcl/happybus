package com.bus24.web.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bus24.web.service.BookingService;


/**
 * This class handle the request/response for booking operation
 * 
 * @author mulayam
 *
 */
@Controller
public class BookingController {

	Logger logger = Logger.getLogger(BookingController.class);
	@Autowired
	private BookingService bookingService;

	@GetMapping("/searchBooking")
	public String searchBookingPage() {
		return "searchBookings";
	}

	/**
	 * This method return the list of bookings of all the travels
	 * 
	 * @return jsonBookingList
	 */
	@RequestMapping(value = "searchBookings", method = RequestMethod.POST)
	@ResponseBody
	public String searchBookings() {
		return bookingService.searchBookings();
	}

	/**
	 * This method return the list of bookings for specified travelId
	 * 
	 * @param travelId
	 * @return jsonBookingList
	 */
	@RequestMapping(value = "searchBookingByTravelId", method = RequestMethod.POST)
	@ResponseBody
	public String searchBookings(@RequestParam("travelId") Integer travelId) {
		return bookingService.searchBookings(travelId);
	}

	/**
	 * This method return the list of bookings based on given fromDate and
	 * toDate
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return jsonBookingList
	 */
	@RequestMapping(value = "searchBookingsByDate", method = RequestMethod.POST)
	@ResponseBody
	public String searchBookings(@RequestParam("fromDate") Date fromDate, @RequestParam("toDate") Date toDate) {
		return bookingService.searchBookings(fromDate, toDate);
	}

	/**
	 * This method return the list of bookings based on given travelId,fromDate
	 * and toDate
	 * 
	 * @param travelId
	 * @param fromDate
	 * @param toDate
	 * @return jsonBookingList
	 */
	@RequestMapping(value = "searchBookingByTravelDate", method = RequestMethod.POST)
	@ResponseBody
	public String searchBookings(@RequestParam("travelId") Integer travelId, @RequestParam("fromDate") Date fromDate,
			@RequestParam("toDate") Date toDate) {
		return bookingService.searchBookings(travelId, fromDate, toDate);
	}

	/**
	 * this method handle the request to getAllPassenger of specific routeId
	 * 
	 * @param routeId
	 * @return
	 * @author mulayam
	 * 
	 */
	@GetMapping("/getAllPassengers/{routeId}")
	@ResponseBody
	public String getAllPassenger(@PathVariable("routeId") Integer routeId) {

		return bookingService.getAllPassengers(routeId);
	}

	@PostMapping("/bookTicket")
	@ResponseBody
	public String bookTicket(@RequestBody String jsonBooking) {
		logger.info("Entered in bookTicket:" + jsonBooking);
		String jsonResponse = bookingService.bookTicket(jsonBooking);
		logger.info("Response from booking:" + jsonBooking);
		return jsonResponse;
	}

}
