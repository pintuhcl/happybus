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

import com.cbabackend.beans.IdentityCard2;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the IdentityCard2 Details of Common Wealth IdentityCard2 from
 * Database
 * 
 * @author C
 * @since CBABE 1.0
 * 
 */
@Repository
public class IdentityCard2ItemWriterImpl implements IdentityCard2ItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the IdentityCard2 Details of Common Wealth IdentityCard2 from
	 * Database
	 * 
	 * @return ItemWriter<IdentityCard2>
	 */
	public ItemWriter<IdentityCard2> saveIdentityCard2Details() {
		JdbcBatchItemWriter<IdentityCard2> itemWriter = new JdbcBatchItemWriter<IdentityCard2>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_IdentityCard2_DETAILS);
		itemWriter.setItemPreparedStatementSetter((IdentityCard2 IdentityCard2, PreparedStatement pst) -> {
			pst.setInt(1, IdentityCard2.getIdCardId());
			pst.setString(2, IdentityCard2.getIdCardNumber());
			pst.setString(3, IdentityCard2.getIdCardType());
			pst.setString(4, IdentityCard2.getIdCardHolderName());
			pst.setDate(5, (Date) IdentityCard2.getIssuedOn());
			pst.setString(6, IdentityCard2.getIssuedBy());
			pst.setDate(7, (Date) IdentityCard2.getExpDate());
			pst.setInt(8, IdentityCard2.getAddressId());
		});
		return itemWriter;
	}
}
