/*
* Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cba.beans.Account;
import com.cba.beans.Customer;


/**
 * This class is used to implement Persistence on Account Table
 * 
 * @author Sathish
 * @since CBA 1.0
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Customer getCustomerDetails(Account account) {
		
	
		return null;
	}
	@Override
	public Map<String, Object> 
	getEmailandMobile(String accountNumber) {
String sql="select email,mobile from customer "
+ " where customer_id=(select customer_id from account where account_Number=?)";	
   return jdbcTemplate.queryForMap(sql,accountNumber);	
}

}
