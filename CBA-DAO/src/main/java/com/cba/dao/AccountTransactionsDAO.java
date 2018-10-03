/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.dao;
/**
 * This class is used to implement Persistence on AccountTransactions Table
 * 
 * @author Sathish
 * @since CBA 1.0
 */
public interface AccountTransactionsDAO {
	/**
	 * this method is used to get the Balance from db
	 * @param accNumber
	 * @return totalBalance
	 */
public double getTotalBalance(String accNumber);
/**
 * this method is used to update the Balance into the db
 * @param accNumber
 * @return totalBalance
 */
public int updateTotalBalance(String accNumber,double totalBalance);
}



