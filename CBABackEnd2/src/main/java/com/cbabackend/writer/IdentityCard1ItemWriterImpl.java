/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import java.sql.Date;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.IdentityCard1;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the IdentityCard1 Details of Common Wealth IdentityCard1 from
 * Database
 * 
 * @author C
 * @since CBABE 1.0
 * 
 */
@Repository
public class IdentityCard1ItemWriterImpl implements IdentityCard1ItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the IdentityCard1 Details of Common Wealth IdentityCard1 from
	 * Database
	 * 
	 * @return ItemWriter<IdentityCard1>
	 */
	public ItemWriter<IdentityCard1> saveIdentityCard1Details() {
		JdbcBatchItemWriter<IdentityCard1> itemWriter = new JdbcBatchItemWriter<IdentityCard1>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_IdentityCard1_DETAILS);
		itemWriter.setItemPreparedStatementSetter((IdentityCard1 IdentityCard1, PreparedStatement pst) -> {
			pst.setInt(1, IdentityCard1.getIdCardId());
			pst.setString(2, IdentityCard1.getIdCardNumber());
			pst.setString(3, IdentityCard1.getIdCardType());
			pst.setString(4, IdentityCard1.getIdCardHolderName());
			pst.setDate(5, (Date) IdentityCard1.getIssuedOn());
			pst.setString(6, IdentityCard1.getIssuedBy());
			pst.setDate(7, (Date) IdentityCard1.getExpDate());
			pst.setInt(8, IdentityCard1.getAddressId());
		});
		return itemWriter;
	}
}
