
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.AccountTransactions;
import com.cbabackend.dao.AccountTransactionsDAO;
import com.cbabackend.exceptions.AccountTransactionsNotFoundException;

/**
 * This class is used to get the Account Transaction Details of Common
 * Wealth Bank from FlatFiles after Banking Bussiness Hours
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Service
public class AccountTransactionProcessor implements ItemProcessor<AccountTransactions, AccountTransactions> {
	private static Logger logger=Logger.getLogger(AccountTransactionProcessor.class);
	@Autowired
	private AccountTransactionsDAO accountTransactionsDAO;

	/**
	 * This method is used to get the Account Transaction Table
	 * 
	 * @author Sathish.Bandi
	 * @return {@link AccountTransactions}
	 * 
	 */
	@Override
public AccountTransactions process(AccountTransactions accountTransactions) throws Exception {
		// get the data from Account_Transactions Table
try{
logger.info("Entered into process () :"+accountTransactions.getAccountTransactionId());	
AccountTransactions accountTransactions2 = 
accountTransactionsDAO.getAccountTransactionsDetails(accountTransactions.getAccountTransactionId());
 boolean flag=accountTransactions.equals(accountTransactions2);
  if(flag==false){
	  logger.info("Updating AccountTransaction Details  :"+accountTransactions.getAccountTransactionId());	
	  
  //update record in db (transactionDate,transactionAmt,transactionStatus,transactionMode,transatcionType)
  int count=accountTransactionsDAO.updateAccountTransactionDetails(accountTransactions);
  }
}catch(EmptyResultDataAccessException | AccountTransactionsNotFoundException e){
	  logger.warn("Account Transaction Record Not Found : "+accountTransactions.getAccountTransactionId());	
     logger.info("Saving Account Transaction Details into db :"+accountTransactions.getAccountTransactionId());
	//insert new record into db
	int count=accountTransactionsDAO.saveAccountTransactionDetails(accountTransactions);
}
		
		// return obj's
		return accountTransactions;
	}
}




