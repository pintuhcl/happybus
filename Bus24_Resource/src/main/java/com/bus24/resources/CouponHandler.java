package com.bus24.resources;

import java.awt.PageAttributes.MediaType;

import javax.activation.MimeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.CouponService;
@RestController
@RequestMapping(value = "coupon")
public class CouponHandler {
	
		@Autowired
		private CouponService couponService;

		@ResponseBody
		@RequestMapping(value = "registerCoupon", method = RequestMethod.POST)
		public String registerCoupon(@RequestBody String jsonCoupon) {
			
			String jsonResponse = couponService.saveCoupon(jsonCoupon);
			System.out.println(jsonResponse);
			return jsonResponse;
		
		}
		@ResponseBody
		@RequestMapping(value="searchCoupon",method=RequestMethod.GET)
		public String searchCoupon(){
			String jsonResponse=couponService.searchCouponDetails();
			return jsonResponse;
		}
		
	}



