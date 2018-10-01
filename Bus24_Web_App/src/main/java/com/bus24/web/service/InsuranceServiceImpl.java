package com.bus24.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bus24.beans.Insurance;
import com.bus24.beans.Response;
import com.bus24.util.JsonUtil;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private RestTemplate restTemplate;
	private static final Logger logger = Logger.getLogger(InsuranceServiceImpl.class);

	public String addInsuranceCompany(String jsonInsurance) {
		// convert java to json
		
		logger.info("Enter into registerInsuranceCompany->" + jsonInsurance);

		String REGISTER_INSURANCE = "http://localhost:8081/Bus24Webservice/insurance/addNew";

		String jsonResponse=restTemplate.postForObject(REGISTER_INSURANCE,jsonInsurance , String.class);
		
		return jsonResponse;
	}

	@Override
	public String editInsuranceComapny(String insurance) {
		
		return null;
	}

	@Override
	public List<Insurance> getAllInsuranceCompany() {
		return null;
	}

	@Override
	public Insurance getInsuranceCompanyByTravelId(Integer travelId) {
		return null;
	}

}
