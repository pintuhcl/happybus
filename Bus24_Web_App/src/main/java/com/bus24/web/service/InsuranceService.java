package com.bus24.web.service;

import java.util.List;

import com.bus24.beans.Insurance;

/**
 * @author rakhi
 * @version 1.0
 */

public interface InsuranceService {
	public String addInsuranceCompany(String insurance);	
	public String editInsuranceComapny(String insurance);
	public List<Insurance> getAllInsuranceCompany();
	public Insurance getInsuranceCompanyByTravelId(Integer travelId);

}
