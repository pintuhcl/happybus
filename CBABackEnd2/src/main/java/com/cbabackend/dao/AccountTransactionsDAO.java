/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.dao;

import com.cbabackend.beans.AccountTransactions;

/**
 * This interface is used to get the Account-Transaction Details of Common
 * Wealth Bank from Data-Base
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface AccountTransactionsDAO {
	/**
	 * This method is used to get the Account-Transaction Details of Common
	 * Wealth Bank from Data-Base
	 * 
	 * @return {@link AccountTransactions}
	 */
	public AccountTransactions getAccountTransactionsDetails(String accountTransactionId);

	public int updateAccountTransactionDetails(AccountTransactions accountTransactions);

	public int saveAccountTransactionDetails(AccountTransactions accountTransactions);
}
