/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.AccountTransactions;
import com.cbabackend.util.SQLConstants;



/**
 * This Class is used to get the Account-Transaction Details of Common Wealth
 * Bank from Data-Base
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class AccountTransactionsDAOImpl implements AccountTransactionsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * This method is used to get the Account-Transaction Details of Common
	 * Wealth Bank from Data-Base
	 * 
	 * @return {@link AccountTransactions}
	 */
	@Override
	public AccountTransactions getAccountTransactionsDetails(String accountTransactionId) {
	 return   jdbcTemplate.queryForObject(SQLConstants.SQL_GET_ACCOUNT_TRANSACTIONS,(ResultSet rs,int row)->{
	    AccountTransactions accountTransactions=new AccountTransactions();
	    accountTransactions.setAccountTransactionId(accountTransactionId);
	    accountTransactions.setAccountId(rs.getInt(1));
	    accountTransactions.setTransactionType(rs.getString(2));
	    accountTransactions.setTransactionDate(rs.getDate(3));
	    accountTransactions.setTransactionAmount(rs.getDouble(4));
	    accountTransactions.setTransactionStatus(rs.getString(5));
	    accountTransactions.setTransactionMode(rs.getString(6));
	    accountTransactions.setTransactionDesc(rs.getString(7));
	    accountTransactions.setUpdatedBy(rs.getInt(8));
	    
	    return accountTransactions;
	    },accountTransactionId);
	 
	}

	@Override
	public int updateAccountTransactionDetails(AccountTransactions accountTransactions) {
return jdbcTemplate.update(SQLConstants.SQL_UPDATE_ACCOUNT_TRANSACTIONS,accountTransactions.getTransactionAmount(),accountTransactions.getTransactionDate(),accountTransactions.getTransactionStatus(),accountTransactions.getTransactionMode(),accountTransactions.getTransactionType(),accountTransactions.getAccountTransactionId());
	}

	@Override
	public int saveAccountTransactionDetails(AccountTransactions accountTransactions) {
	return jdbcTemplate.update(SQLConstants.SQL_SAVE_ACCOUNT_TRANSACTIONS,accountTransactions.getAccountTransactionId(),accountTransactions.getAccountId(),accountTransactions.getTransactionAmount(),accountTransactions.getTransactionDate(),accountTransactions.getTransactionMode(),accountTransactions.getTransactionType(),accountTransactions.getTransactionStatus(),accountTransactions.getTransactionDesc(),accountTransactions.getUpdatedBy());
	}

}
