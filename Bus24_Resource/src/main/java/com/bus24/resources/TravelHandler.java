package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.TravelService;

@RestController
@RequestMapping(value = "travels")
public class TravelHandler {
	@Autowired
	private TravelService travelService;

	@ResponseBody
	@RequestMapping(value = "registerTravel", method = RequestMethod.POST)
	public String registerTravel(@RequestBody String jsonTravel, @RequestParam("userId") Long userId,
			@RequestParam("token") String token) {
		String jsonResponse = travelService.registerTravel(jsonTravel, userId, token);
		return jsonResponse;
	}

	/**
	 * this method is used to search for travel
	 * 
	 * @author Eshwar,Abdul
	 */
	@ResponseBody
	@RequestMapping(value = "searchTravel", method = RequestMethod.POST)
	public String searchTravel(@RequestBody String jsonTravel, @RequestParam("userId") Long userId,
			@RequestParam("token") String token) {
		String jsonResponse = travelService.searchTravel(jsonTravel, userId, token);
		return jsonResponse;
	}// method

	/**
	 * this method is used to EDIT/UPDATE for travel
	 * 
	 * @author Eshwar,Abdul
	 */
	@ResponseBody
	@RequestMapping(value = "editTravel", method = RequestMethod.POST)
	public String editTravel(@RequestBody String jsonTravel, @RequestParam("userId") Long userId,
			@RequestParam("token") String token) {
		String jsonResponse = travelService.editTravel(jsonTravel, userId, token);
		return jsonResponse;
	}// method

	/**
	 * this method is used to get all travel
	 * 
	 * @author Mulayam
	 * @return jsonTravel
	 */
	@ResponseBody
	@GetMapping("getAllTravel")
	public String getAllTravel() {
		return travelService.getAllTravel();
	}

}
