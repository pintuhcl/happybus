package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Coupon;
import com.bus24.dao.util.SQLConstants;
@Repository
public class CouponDAOImpl implements CouponDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public Integer addCoupon(Coupon coupon) {
	int count=0;
	count=jdbcTemplate.update(SQLConstants.SQL_INSERT_COUPON,new Object[] {coupon.getCouponCode(),coupon.getDiscount(),coupon.getStatus(),coupon.getUser().getUserId()});
	System.out.println(count);	
	return count;
	}

	@Override
	public List<Coupon> searchCoupon() {
		List<Coupon> list=null;
		list=jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_COUPONS,new ResultSetExtractor<List<Coupon>>(){

			@Override
			public List<Coupon> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Coupon> list=new ArrayList();
				while(rs.next())
				{
				Coupon coupon=new Coupon();
				coupon.setCouponId(rs.getInt(1));
				coupon.setCouponCode(rs.getString(2));
				coupon.setDiscount(rs.getInt(3));
				coupon.setGeneratedDate(rs.getDate(4));
				coupon.setStatus(rs.getByte(5));
				list.add(coupon);
				}
				return list;
			}
		});
		
			
		return list;	
		}
		

	@Override
	public Integer editCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}


	/*public String getRole(int userId) {
		String userrole=jdbcTemplate.queryForObject(SQLConstants.SQL_SELECT_ROLE,new Object[] {userId},String.class);
		return userrole;
	}*/

}
