
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.AccountTypes;

/**
* This interface is used to Writing the AccountTypes Details of Common Wealth Bank from
* Database
* 
* @author anitha
* @since CBABE 1.0
*/

public interface AccountTypesItemWriter {
	/**
	 * This method is used to save the AccountTypes Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriterr<AccountTypes>
	 */
	public ItemWriter<AccountTypes> saveAccountTypesDetails();
}
