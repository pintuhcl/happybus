/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cba.dao;

import java.util.Map;

import com.cba.beans.Account;
import com.cba.beans.AccountStatus;
import com.cba.beans.AccountTransactions;
import com.cba.beans.BalanceEnquiry;;
/**
 * This class is used to implement Persistence on Account Table
 * 
 * @author Sathish
 * @since CBA 1.0
 */
public interface AccountDAO {

	Map<String,Object> updateBalance(Account account, AccountTransactions accountTransactions);

	AccountStatus checkAccountStatus(String accountNumber);
	
	BalanceEnquiry checkBalance(String accountNumber);

}
