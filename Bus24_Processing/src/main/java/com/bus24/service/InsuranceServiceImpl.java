package com.bus24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bus24.beans.Insurance;
import com.bus24.beans.Response;
import com.bus24.dao.InsuranceDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;

/**
 * 
 * @author Rakhi
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceDAO insuranceDAO;

	@Override
	public String addNewInsuranceCompany(String jsonInsurance) {

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to process your request! please try again");

		try {
			Insurance insurance = JsonUtil.convertJsonToJava(jsonInsurance, Insurance.class);
			if (insurance != null) {
				Integer count = insuranceDAO.addInsuranceCompany(insurance);
				if (count != null && count > 0) {
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("New Insurance Company Successfully Added");
				}
			}

		} catch (DataAccessException e) {

		} catch (Exception e) {

		}

		return JsonUtil.convertJavaToJson(response);

	}

	@Override
	public String getAllInsuranceCompany() {

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to process your request! please try again");

		try {

			List<Insurance> list = insuranceDAO.getAllInsuranceCompany();
			if (list != null && list.size() > 0) {

				String listJson = JsonUtil.convertJavaToJson(list);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("Company List found");
			}

		} catch (DataAccessException e) {

		} catch (Exception e) {

		}
		return JsonUtil.convertJavaToJson(response);
	}

	@Override
	public String getInsuranceCompanyByTravelId(Integer travelId) {

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to process your request! please try again");

		try {
			Insurance insurance = insuranceDAO.getInsuranceCompanyByTravelId(travelId);
			if (insurance != null) {

				String listJson = JsonUtil.convertJavaToJson(travelId);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("Company found");
			}
		} catch (DataAccessException e) {

		} catch (Exception e) {

		}
		return JsonUtil.convertJavaToJson(response);
	}

}
