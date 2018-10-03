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

import com.cbabackend.beans.Deposite;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Deposite Details of Common Wealth Deposite from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class DepositeItemWriterImpl implements DepositeItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Deposit Details of Common Wealth Deposite from
	 * Database
	 * 
	 * @return ItemWriter<Deposite>
	 */
	public ItemWriter<Deposite> saveDepositeDetails() {
		JdbcBatchItemWriter<Deposite> itemWriter = new JdbcBatchItemWriter<Deposite>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_DEPOSITE_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Deposite Deposite, PreparedStatement pst) -> {
			pst.setInt(1, Deposite.getDepositeId());
			pst.setString(2, Deposite.getDepositeTypeName());
			pst.setInt(3, Deposite.getRateOfInterest());
			pst.setInt(4, Deposite.getAccountNumber());
		});
		return itemWriter;
	}
}
