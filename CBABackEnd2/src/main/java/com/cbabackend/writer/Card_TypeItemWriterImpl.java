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

import com.cbabackend.beans.Card_Type;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Card_Type Details of Common Wealth Card_Type from
 * Database
 * 
 * @author Rashmi
 * @since CBABE 1.0
 * 
 */
@Repository
public class Card_TypeItemWriterImpl implements Card_TypeItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Card_Type Details of Common Wealth Card_Type from
	 * Database
	 * 
	 * @return ItemWriter<Card_Type>
	 */
	public ItemWriter<Card_Type> saveCard_TypeDetails() {
		JdbcBatchItemWriter<Card_Type> itemWriter = new JdbcBatchItemWriter<Card_Type>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_Card_Type_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Card_Type card_Type, PreparedStatement pst) -> {
			pst.setInt(1, card_Type.getCardTyprId());
			pst.setString(2, card_Type.getCardTypeName());
			pst.setString(3, card_Type.getCardTypeNumber());
			pst.setString(4, card_Type.getCardDistributedName());
		});
		return itemWriter;
	}
}
