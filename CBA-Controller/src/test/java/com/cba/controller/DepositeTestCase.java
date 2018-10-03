package com.cba.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cba.beans.Account;
import com.cba.beans.AccountTransactions;
import com.cba.dao.AccountDAO;

public class DepositeTestCase {
	private static AnnotationConfigApplicationContext context;
	private static AccountDAO accountDAO;
	private Account account;
	private AccountTransactions accountTransactions;
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.cba");
		context.refresh();
		accountDAO=(AccountDAO) context.getBean("accountDAO");
		
		
	}
	@Test
	public void testDeposit(){
		accountTransactions=new AccountTransactions();
		
		Map<String, Object> map = new HashMap<>();
		map.put("ACCOUNT_NUM_IN", account.getAccountNumber());
		map.put("TOTAL_BALANCE_IN", account.getBalance());
		map.put("TX_STATUS_IN", accountTransactions.getTransactionStatus());
		map.put("TX_MODE_IN", accountTransactions.getTransactionMode());
		map.put("TX_TYPE_IN", accountTransactions.getTransactionType());
		map.put("TX_AMOUNT_IN", accountTransactions.getTransactionAmount());
		map.put("TX_DESC_IN", accountTransactions.getTransactionDesc());
		map.put("UPDATED_BY_IN", accountTransactions.getUpdatedBy());
		map.put("DDORCHEQUE_NUMBER_IN", accountTransactions.getDdORChequeNumber());
		map.put("ISSUED_BY_IN", accountTransactions.getIssuedBy());
		map.put("ISSUED_DATE_IN", accountTransactions.getIssuedDate());
		map.put("ISSUED_BRANCH_IN", accountTransactions.getIssuedBranch());

		//Map<String, Object> outParams = jdbcCall.execute(map);

	 assertEquals("record inserted sucess fully sucessfully ", true,accountDAO.updateBalance(account, accountTransactions));
	 
	}
	

}
