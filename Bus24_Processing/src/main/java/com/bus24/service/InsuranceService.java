package com.bus24.service;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Rakhi
 *
 */
@Service
public interface InsuranceService {

	public String addNewInsuranceCompany(String jsonInsurance);

	public String getAllInsuranceCompany();

	public String getInsuranceCompanyByTravelId(Integer travelId);

}
