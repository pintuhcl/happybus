package com.cba.beans;

import java.io.Serializable;

public class BalanceEnquiry implements Serializable {
	
/*	Account Number	Account Holder's Name	Account Status	Account Balance
*/
	private String accountNumber;
	private String accountHoldername;
	private String accountStatus;
	private Double totalBalance;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHoldername() {
		return accountHoldername;
	}
	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

}
