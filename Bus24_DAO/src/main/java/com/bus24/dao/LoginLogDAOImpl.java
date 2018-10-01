package com.bus24.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bus24.beans.LoginLog;
import com.bus24.dao.util.SQLConstants;
@Repository
public class LoginLogDAOImpl  implements LoginLogDAO{
	@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public Integer saveLoginLogDetails(LoginLog loginLog, Long userId) {
	return jdbcTemplate.update(SQLConstants.SQL_INSERT_LOGINLOG,userId,new Date(),loginLog.getUserAgent(),loginLog.getIpAddress(),0,loginLog.getSessionId());

	}
}