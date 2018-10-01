package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.RoutesService;

//import com.happybus.processing.service.RoutesService;

/**
 * This class is acting as Resource class . It accessed over the N.w
 * 
 * @author sahoo
 */
@RestController
@RequestMapping(value = "Routes")
public class RoutesHandler {

	@Autowired
	private RoutesService routesService;

	@RequestMapping(value = "addRoutes", method = RequestMethod.GET)
	@ResponseBody
	public String addRoute(@RequestBody String json, @RequestParam("userRole") String userRole,
			@RequestParam("userId") Long userId, @RequestParam("token") String token) {
		return routesService.addRoute(json, userRole, userId, token);
	}
	@GetMapping("sourceList")
	public String getSource() {
		return routesService.getSourceList();
	}

	@GetMapping("destinationList")
	public String getDestination() {
		return routesService.getDestinationList();
	}

	/**
	 * this method is used to search for route
	 * 
	 * @author shankar
	 */
	@ResponseBody
	@RequestMapping(value = "searchRoute", method = RequestMethod.POST)
	public String searchTravel(@RequestBody String jsonRoute, @RequestParam("userId") Long userId,
			@RequestParam("token") String token) {
		String jsonResponse=routesService.searchRoute(jsonRoute, userId, token);
		
		
		
		return jsonResponse;
	}// method

	/**
	 * this method is used to EDIT/UPDATE for route
	 * 
	 * @author shankar
	 */
	@ResponseBody
	@RequestMapping(value = "editRoute", method = RequestMethod.POST)
	public String editTravel(@RequestBody String jsonRoute) {
		String jsonResponse = routesService.editRoute(jsonRoute);
		return jsonResponse;
	}// method

}