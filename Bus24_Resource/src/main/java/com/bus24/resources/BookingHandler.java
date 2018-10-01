package com.bus24.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.bus24.service.BookingService;

@RestController
@RequestMapping(value="booking")
public class BookingHandler {
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "boardingDetails", method = RequestMethod.POST)
	@ResponseBody
	public String boardingDetails(@RequestParam("routeId") String routeId) {
		return bookingService.boardingPoints(routeId);
	}

	
	@RequestMapping(value="searchBookings",method=RequestMethod.POST)
	@ResponseBody
	public String searchBookings(){
		
		String jsonre=bookingService.searchBookings();
		System.out.println("output::::"+jsonre);
		return jsonre;
	} 
	
	
	@RequestMapping(value="searchBookingsByTravelId",method=RequestMethod.POST)
	@ResponseBody
	public String searchBookingsByTravelId(@RequestParam(value="travelId") String travelId){
		System.out.println("travelid-------------------"+travelId);
		return bookingService.searchBookings(travelId);
	}
	
	
	@RequestMapping(value="searchBookingsByFromDateAndToDate",method=RequestMethod.POST)
	@ResponseBody
	public String searchBookingsByFromDateAndToDate(@RequestParam(value="fromDate") String fromDate,@RequestParam(value="toDate") String toDate){
		
		
		return bookingService.searchBookings(fromDate, toDate);
	}
	
		
	
	
	@RequestMapping(value="searchBookingsByTravelIdFromDateAndToDate",method=RequestMethod.POST)
	@ResponseBody
	public String searchBookingsByTravelIdFromDateAndToDate(@RequestParam("travelId") String travelId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate){
		
		return bookingService.searchBookings(travelId, fromDate, toDate);
	}
	

	/**
	 * Call service to get list of All Passenger
	 * 
	 * @param routeId
	 * @return
	 * @author mulayam
	 */
	@GetMapping("getAllPassengers/{routeId}")
	public String getAllPassenger(@PathVariable("routeId") Integer routeId) {
		return bookingService.getAllPassenger(routeId);
	}

	/**
	 * Call service to book ticket
	 * 
	 * @return
	 * @author mulayam
	 */
	@PostMapping("bookTicket")
	public String bookTicket(@RequestBody String jsonBooking) {
		return bookingService.bookTicket(jsonBooking);

	}
}
