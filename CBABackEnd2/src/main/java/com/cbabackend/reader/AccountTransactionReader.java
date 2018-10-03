
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.AccountTransactions;
import com.cbabackend.beans.Bank;

/**
 * This interface is used to get the Account Transaction Details of Common
 * Wealth Bank from FlatFiles after Banking Bussiness Hours
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface AccountTransactionReader {
	/**
	 * This method is used to get the Account-Transaction Details of Common
	 * Wealth Bank from FlatFiles
	 * 
	 * @return ItemReader<AccountTransactions>
	 */
	public ItemReader<AccountTransactions> getAccountTransactionsDetails();
}
