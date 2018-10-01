package com.bus24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus24.beans.Coupon;
import com.bus24.beans.Response;
import com.bus24.dao.CouponDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.Roles;
import com.bus24.util.StatusUtil;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDAO dao;
	@Override
	public String saveCoupon(String json) {
	Response response=new Response();
	//Coupon coupon1=new Coupon();
	String jsonCoupon="";
	response.setStatus(StatusUtil.STATUS_FAILURE);
	response.setMessage("failure");
	try
	{
		Coupon coupon=JsonUtil.convertJsonToJava(json,Coupon.class);
		
		//if(coupon.getUser().getUserRole()!=null || coupon.getUser().getUserRole().equals(Roles.ROLE_SUPER_ADMIN)){

		if (coupon != null ) {
			System.out.println("lokesh");
			//String userrole=dao.getRole(165);
			//System.out.println(userrole);
		

					
				System.out.println("service");
				//coupon.setCouponCode(CouponGenerator.generateCoupon(10,100));
				int count=dao.addCoupon(coupon);
				System.out.println(count);
				System.out.println(coupon);
			response.setStatus(StatusUtil.STATUS_SUCCESS);
			response.setMessage("coupon inserted  Successfully");
			
			// convert user into json
			System.out.println("service");
			
			jsonCoupon = JsonUtil.convertJavaToJson(coupon);
			System.out.println(jsonCoupon);
			response.setData(jsonCoupon);
			}
		//}
	
		
	}catch(Exception e)
	{
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("failure");	
		//System.out.println("failure");
	}
		return jsonCoupon;
	}
	
	public String searchCouponDetails(){
		Response response=new Response();
		String jsonResponse="";
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("failure");
		
		List<Coupon> list=dao.searchCoupon();
		try{
			jsonResponse=JsonUtil.convertJavaToJson(list);
			response.setStatus(StatusUtil.STATUS_SUCCESS);
			response.setMessage("sucess");
			response.setData(jsonResponse);
		}
		catch(Exception e)
		{
			response.setStatus(StatusUtil.STATUS_FAILURE);
			response.setMessage("failure");
				
		}
		return jsonResponse;
	}
}


