package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Coupon;

public interface CouponDAO {
	public Integer addCoupon(Coupon coupon);
	public List<Coupon> searchCoupon();
	
	public Integer editCoupon(Coupon coupon);

}
