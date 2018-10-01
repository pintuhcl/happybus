package com.bus24.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bus24.dao.util.SQLConstants;

@Repository
public class UserAuthenticationDAOImpl 
implements UserAuthenticationDAO{
	@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public Integer saveToken(String token, Long userId) {
	return jdbcTemplate.update(SQLConstants.SQL_SAVE_TOKEN,token,userId,1);
}
	@Override
	public Integer isAuthenticated(Long userId, String token, int status) {
		Integer count=jdbcTemplate.queryForObject(SQLConstants.SQL_IS_AUTHENTICATED,Integer.class,userId,token,status);
		return count;
	}
}





