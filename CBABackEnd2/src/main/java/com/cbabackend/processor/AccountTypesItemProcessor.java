
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.AccountTypes;




/**
 * This class is used to get the AccountTypes Details of Common Wealth Bank from
 * FlatFiles.
 * 
 * @author anitha
 * @since CBABE 1.0
 */
@Service
public class AccountTypesItemProcessor implements ItemProcessor<AccountTypes, AccountTypes>{
	/**
	 * This method is used to get the AccountTypes Details of Common Wealth Bank from
	 * FlatFiles.
	 * 
	 * @author anitha
	 * @return {@link AccountTypes}
	 * 
	 */
	

	@Override
	public AccountTypes process(AccountTypes accountTypes) throws Exception {
		accountTypes.setAccountTypeName(accountTypes.getAccountTypeName().toUpperCase());
		accountTypes.setAccountTypeId(accountTypes.getAccountTypeId());
		accountTypes.setAccountDesc(accountTypes.getAccountDesc().toUpperCase());
		accountTypes.setMinBalanceToOpen(accountTypes.getMinBalanceToOpen());
		accountTypes.setMinBalanceToMaintain(accountTypes.getMinBalanceToMaintain().toUpperCase());
	    return accountTypes;
	}

	

}
