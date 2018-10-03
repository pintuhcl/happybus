package com.cba.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cba.beans.Account;
import com.cba.sql.SQLConstants;

@Repository
public class AccountTransactionsDAOImpl
implements AccountTransactionsDAO{
	@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public double getTotalBalance(String accNumber) {
    return jdbcTemplate.queryForObject(SQLConstants.SQL_GET_TOTAL_BALANCE,Double.class,accNumber);
	}

	@Override
	public int updateTotalBalance(String accNumber, double totalBalance) {
   return jdbcTemplate.update(SQLConstants.SQL_UPDATE_TOTAL_BALANCE,totalBalance,accNumber);		
	}

}
