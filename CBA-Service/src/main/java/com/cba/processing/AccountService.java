package com.cba.processing;

public interface AccountService {
/**
 * this method is used to check the Account Status
 * @param accountNumber
 * @return jsonStr
 */
	String checkAccountStatus(String accountNumber);
	
	/**
	 * this method is used to check the Balance
	 * @param accountNumber
	 * @return jsonResponse
	 */
	String checkBalance(String accountNumber);

}
