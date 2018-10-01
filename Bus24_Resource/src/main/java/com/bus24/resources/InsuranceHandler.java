package com.bus24.resources;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.InsuranceService;

/**
 * 
 * @author Rakhi
 *
 */
@RestController
@RequestMapping("/insurance")
public class InsuranceHandler {

	@Autowired
	private InsuranceService insuranceService;

	@PostMapping("/addNew")
	public String addNewInsuranceCompany(String jsonInsurance) {

		return insuranceService.addNewInsuranceCompany(jsonInsurance);

	}

	@GetMapping("/getAllCompany")
	public String getAllInsuranceCompany() {

		return insuranceService.getAllInsuranceCompany();

	}

	@GetMapping("/getAllCompany/{travelId}")
	public String getInsuranceCompanyByTravelId(@PathParam("travelId") Integer travelId) {
		return insuranceService.getInsuranceCompanyByTravelId(travelId);
	}

}
