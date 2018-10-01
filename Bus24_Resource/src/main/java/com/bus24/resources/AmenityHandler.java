
package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.AmenityService;

/**
 * @author mulayam
 *
 */
@RestController
@RequestMapping("amenity")
public class AmenityHandler {

	@Autowired
	AmenityService amenityService;

	@PostMapping("/add")
	@ResponseBody
	public String addAmenity(@RequestBody String jsonAmenity) {

		return amenityService.addAmenity(jsonAmenity);

	}

	@GetMapping("/list")
	@ResponseBody
	public String getAllAmenities() {
		return amenityService.getAllAmenities();
	}

	@PostMapping("/update")
	@ResponseBody
	public String update(@RequestBody String jsonAmenity) {
		return amenityService.updateAmenity(jsonAmenity);
	}
}
