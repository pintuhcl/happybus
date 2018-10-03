package com.cba.processing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cba.beans.Account;
import com.cba.beans.AccountTransactions;

public class Deposite_Testing {

	/**
	 * @author admin
	 * @category Test case for deposite operation
	 * @param account
	 *            , accountTransactions ,userRole
	 */
	@Test
	public void depositeTest() {
		String  accountNumber="1234"; double transactionAmount=1000;
		
		// create object of OperationsService class
		OperationsServiceImpl operationsServiceImpl = new OperationsServiceImpl();
		// AccountTrancation class   object 
		AccountTransactions accountTransactions = new AccountTransactions();
		  accountTransactions.setTransactionAmount(transactionAmount);
		// Create Account Class object
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		String userRole="admin";
		String deposite = operationsServiceImpl.deposit(account, accountTransactions, userRole);
		//assertEquals(TransactionAmountt, accountTransactions.getTransactionAmount());

		assertEquals(1000.000,transactionAmount);
		assertEquals("1234", account);
	}

}
