package com.bus24.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bus24.beans.Coupon;
import com.bus24.beans.Response;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;
@Service
public class CouponServiceImpl implements CouponService {
	RestTemplate restTemplate=null;
	

	@Override
	public String addCoupon(Coupon coupon) {
		//logger.info("Entered into loginUser :: " + user.getUserName() + " " + user.getPassword());

		Response response = new Response();
		String jsonResponse="";
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Unable to Process your Request !Please Try Again.");
		try {
			String jsonUser = JsonUtil.convertJavaToJson(coupon);
			System.out.println(jsonUser);
			System.out.println("sudheer");
			String REST_add_coupon = "http://localhost:8081/Bus24Webservice/coupon/registerCoupon";
			 jsonResponse = restTemplate.postForObject(REST_add_coupon,jsonUser, String.class);
			//logger.info("response of loginUser :: " + jsonResponse);
			 System.out.println(jsonUser);
			 System.out.println(jsonResponse);
		} catch (RestClientException re) {
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("Unable to Process your Request !Please Try Again.");
			//logger.error("Exception occured while login :: " + re.getMessage());
		}
		return jsonResponse;
	}


}
