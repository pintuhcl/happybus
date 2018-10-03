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

import com.cbabackend.beans.Bank;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Bank Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class BankItemWriterImpl implements BankItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Bank Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriter<Bank>
	 */
	public ItemWriter<Bank> saveBankDetails() {
		JdbcBatchItemWriter<Bank> itemWriter = new JdbcBatchItemWriter<Bank>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_BANK_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Bank bank, PreparedStatement pst) -> {
			pst.setInt(1, bank.getBankId());
			pst.setString(2, bank.getBankName());
			pst.setString(3, bank.getBankDesc());
		});
		return itemWriter;
	}
}
