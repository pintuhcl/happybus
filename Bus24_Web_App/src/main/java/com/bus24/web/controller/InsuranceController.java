package com.bus24.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bus24.beans.Insurance;
import com.bus24.beans.Travel;
import com.bus24.web.service.InsuranceService;

@Controller
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceService;

	@RequestMapping(value = "registerInsurance", method = RequestMethod.GET)
	public String registerInsuranceCompany() {
		return "registerInsuranceCompany";
	}

	/**
	 * this method is used to register Insurance Company
	 * 
	 * @author rakhi
	 * @version 1.0
	 */
	@ResponseBody
	@RequestMapping(value = "registerInsurance", method = RequestMethod.POST)
	public String registerInsurance(@RequestBody String jsonInsurance) {
//System.out.println("Entered into registerInsurace :"+jsonInsurance);
//		return "Hello";
	return insuranceService.addInsuranceCompany(jsonInsurance);
		
	}

	public List<Insurance> getAllInsuranceCompany() {
		return null;
		// method

	}

	/**
	 * this method is used to get all insurance by tavel id
	 * 
	 * @author rakhi
	 * @return List<travel>
	 */
	public Insurance getInsuranceCompanyByTravelId(Integer travelId) {
		return null;
	}

	/**
	 * this method is used to EDIT/UPDATE for insurance
	 * 
	 * @author rakhi
	 * @param insurance
	 * @return Integer
	 */
	public Integer editInsuranceComapny(Insurance insurance) {
		return null;
	}

}
