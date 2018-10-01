package com.bus24.dao;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bus24.dao.util.SQLConstants;

@Repository
public class OtpLogDAOImpl implements OtpLogDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer saveOtp(Integer otp, Long userId) {
		Integer count = jdbcTemplate.update(SQLConstants.SQL_INSERT_OTP, otp, new Date(), userId);
		return count;
	}

	@Override
	public Map<String, Object> validateOtp(Long userId) {
	String GET_OTP="SELECT otp,TIMESTAMPDIFF(MINUTE,generated_time,now()) as minute_diff    from otplog  where user_id=? order by minute_diff asc LIMIT 1";
	Map<String,Object> resultMap
	=jdbcTemplate.queryForMap(GET_OTP,userId);			
		return resultMap;
	}
}







