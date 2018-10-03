package com.cba.beans;

import java.io.Serializable;

public class AccountStatus implements Serializable{
	private Integer accountId;
	private Integer branchId;
private String accountNumber;
private String accountHolderName;
private String accountStatus;
private String accountType;
private Double totalBalance;
private String branchName;



/**
 * @return the accountId
 */
public Integer getAccountId() {
	return accountId;
}
/**
 * @param accountId the accountId to set
 */
public void setAccountId(Integer accountId) {
	this.accountId = accountId;
}
/**
 * @return the branchId
 */
public Integer getBranchId() {
	return branchId;
}
/**
 * @param branchId the branchId to set
 */
public void setBranchId(Integer branchId) {
	this.branchId = branchId;
}
/**
 * @return the accountNumber
 */
public String getAccountNumber() {
	return accountNumber;
}
/**
 * @param accountNumber the accountNumber to set
 */
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
/**
 * @return the accountHolderName
 */
public String getAccountHolderName() {
	return accountHolderName;
}
/**
 * @param accountHolderName the accountHolderName to set
 */
public void setAccountHolderName(String accountHolderName) {
	this.accountHolderName = accountHolderName;
}
/**
 * @return the accountStatus
 */
public String getAccountStatus() {
	return accountStatus;
}
/**
 * @param accountStatus the accountStatus to set
 */
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
/**
 * @return the accountType
 */
public String getAccountType() {
	return accountType;
}
/**
 * @param accountType the accountType to set
 */
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
/**
 * @return the totalBalance
 */
public Double getTotalBalance() {
	return totalBalance;
}
/**
 * @param totalBalance the totalBalance to set
 */
public void setTotalBalance(Double totalBalance) {
	this.totalBalance = totalBalance;
}
/**
 * @return the branchName
 */
public String getBranchName() {
	return branchName;
}
/**
 * @param branchName the branchName to set
 */
public void setBranchName(String branchName) {
	this.branchName = branchName;
}


}
