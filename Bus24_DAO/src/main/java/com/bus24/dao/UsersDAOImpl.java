/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
*/
package com.bus24.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bus24.beans.User;
import com.bus24.dao.util.SQLConstants;

/**
 * This class is the implementation class of UsersDao,implement the persistence
 * login on User Entity
 * 
 * @author mulayam
 * @since 1.0
 */
@Repository
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * this method is used to registerPassenger
	 * 
	 * @author sathish
	 * @param user
	 * @return userId
	 */
	public Object registerPassenger(User user) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		Map<String, Object> map = new HashMap<>();
		map.put("user_name_in", user.getUserName());
		map.put("password_in", user.getPassword());
		map.put("user_role_in", user.getUserRole());
		map.put("email_in", user.getEmail());
		map.put("mobile_in", user.getMobile());
		map.put("status_in", user.getStatus());
		simpleJdbcCall.declareParameters(new SqlParameter("user_name_in", Types.VARCHAR));
		simpleJdbcCall.declareParameters(new SqlParameter("password_in", Types.VARCHAR));
		simpleJdbcCall.declareParameters(new SqlParameter("user_role_in", Types.VARCHAR));
		simpleJdbcCall.declareParameters(new SqlParameter("email_in", Types.VARCHAR));
		simpleJdbcCall.declareParameters(new SqlParameter("mobile_in", Types.VARCHAR));
		simpleJdbcCall.declareParameters(new SqlParameter("status_in", Types.INTEGER));
		simpleJdbcCall.declareParameters(new SqlOutParameter("user_id_out", Types.BIGINT));
		simpleJdbcCall.withProcedureName("register_passenger");
		Map<String, Object> outParamsMap = simpleJdbcCall.execute(map);
		Object user_id = outParamsMap.get("user_id_out");
		return user_id;
	}

	@Override
	public String getHashPassword(String userName) {
		String password = jdbcTemplate.queryForObject(SQLConstants.SQL_GET_PASSWORD, String.class, userName);
		return password;
	}

	@Override
	public User getUserDetails(String userName) {
		final User user = new User();
		// get userId,role,mobile where userName=?
		jdbcTemplate.queryForObject(SQLConstants.SQL_GET_USER_DETAILS, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				user.setUserId(rs.getLong(1));
				user.setUserRole(rs.getString(2));
				user.setMobile(rs.getString(3));
				user.setUserName(userName);
				user.setStatus(rs.getByte(4));
				return user;
			}
		}, userName);
		return user;
	}

	/**
	 * This method contain logic for Getting show myprofile
	 * 
	 * @param userName
	 * @return jsonResponse
	 * @author ABHINAV
	 */

	@Override
	public User showMyprofile(String userName) {

		final User user = new User();

		jdbcTemplate.queryForObject(SQLConstants.SQL_GET_SHOW_MYPROFILE, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				user.setUserName(rs.getString(1));
				user.setUserRole(rs.getString(2));
				user.setMobile(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setZipCode(rs.getInt(7));
				user.setUserId(rs.getLong(8));
				user.setEmail(rs.getString(9));
				user.setStatus(rs.getByte(10));

				return user;
			}
		}, userName);
		return user;
	}

	/**
	 * This method contain logic for update myprofile
	 * 
	 * @param user
	 * @return jsonResponse
	 * @author Abhinav
	 */
	@Override
	public Integer updateMyprofile(User user) {
		Integer count = jdbcTemplate.update(SQLConstants.SQL_GET_UPDATE_MYPROFILE, (PreparedStatement ps) -> {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getZipCode());
			ps.setLong(5, user.getUserId());

		});
		return count;
	}

	/**
	 * @author Sheeresha
	 */
	@Override
	public User getUserByUserId(Long userId) {
	return null;
	}
		/*User user = new User();
		return jdbcTemplate.queryForObject(SQLConstants.SELECT_USER_SQL, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {

				user.setMobile(rs.getString(1));
				return user;
			}
		}, userId);
	}
*/

	@Override
	public Integer updateUserStatus(Long userId,Integer status) {
 Integer count =jdbcTemplate.update(SQLConstants.SQL_UPDATE_USER_STATUS,status,userId);		
		return count;
	}
	/**
	 * the method contain logic for forgotpassword
	 * 
	 * @param user
	 * @return user
	 * @author Pradeep
	 */

	@Override
	public Integer forgotPassword(User user) {
		
			User fp=new User();
			jdbcTemplate.queryForObject(SQLConstants.SQL_FORGOT_VERIFY, (ResultSet rs, int rowNum) -> {
				fp.setUserId(rs.getLong(1));
				fp.setStatus(rs.getByte(2));
				fp.setMobile(rs.getString(3));
				fp.setEmail(rs.getString(4));
				return fp;
			},user.getEmail(),user.getMobile());
			
		return 0;
	}

	@Override
	public Integer changePassword(User user) {
		
		Integer	count=0;
			jdbcTemplate.update(SQLConstants.SQL_CHANGE_PASSWORD, (PreparedStatement ps) -> {
			ps.setString(1, user.getNewpassword());
			ps.setString(2, user.getUserName());
		});
		return count;
			}

	@Override
	public int updateLogoutStatus(Long userId, int status) {
	return jdbcTemplate.update(SQLConstants.SQL_UPDATE_LOGOUT_STATUS,status,userId);
	}

	@Override
	public boolean checkEmail(String email) {
      boolean flag=false;
 Integer count=jdbcTemplate.queryForObject(SQLConstants.SQL_CHECK_EMAIL,Integer.class,email);
 if(count!=null && count>0){		
	  flag=true;
 }
 return flag;
	}

	@Override
	public boolean checkMobile(String mobile) {
	    boolean flag=false;
	     Integer count=jdbcTemplate.queryForObject(SQLConstants.SQL_CHECK_MOBILE,Integer.class,mobile);
	   if(count!=null && count>0){		
	  	  flag=true;
	   }
	   return flag;
	}
			
}



