/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.writer;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.AccountTypes;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the AccountTypes Details of Common Wealth Bank from
 * Database
 * 
 * @author anitha
 * @since CBABE 1.0
 * 
 */
@Repository

public class AccountTypesItemWriterImpl {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the AccountTypes Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriter<AccountTypes>
	 */


	public ItemWriter<AccountTypes> saveAccountTypesDetails() {
		JdbcBatchItemWriter<AccountTypes> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_AccountTypes_DETAILS);
		itemWriter.setItemPreparedStatementSetter((AccountTypes AccountTypes, PreparedStatement pst) -> {
			pst.setInt(1, AccountTypes.getAccountTypeId());
			pst.setString(2, AccountTypes.getAccountTypeName());
			pst.setString(3, AccountTypes.getAccountDesc());
			pst.setString(4, AccountTypes.getMinBalanceToOpen());
			pst.setString(5, AccountTypes.getMinBalanceToMaintain());
			
			;
		});
		return itemWriter;
	}
}
