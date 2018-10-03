package com.cbabackend.exceptions;

public class AccountTransactionsNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountTransactionsNotFoundException(  final String accountTransactionsNotFoundException){
		
		super(accountTransactionsNotFoundException);
	}
	
	

}
