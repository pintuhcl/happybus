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
import com.cbabackend.beans.IdentityCard3;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the IdentityCard3 Details of Common Wealth IdentityCard3 from
 * Database
 * 
 * @author C
 * @since CBABE 1.0
 * 
 */
@Repository
public class IdentityCard3ItemWriterImpl implements IdentityCard3ItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the IdentityCard3 Details of Common Wealth IdentityCard3 from
	 * Database
	 * 
	 * @return ItemWriter<IdentityCard3>
	 */
	public ItemWriter<IdentityCard3> saveIdentityCard3Details() {
		JdbcBatchItemWriter<IdentityCard3> itemWriter = new JdbcBatchItemWriter<IdentityCard3>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_IdentityCard3_DETAILS);
		itemWriter.setItemPreparedStatementSetter((IdentityCard3 IdentityCard3, PreparedStatement pst) -> {
			pst.setInt(1, IdentityCard3.getIdCardId());
			pst.setString(2, IdentityCard3.getIdCardNumber());
			pst.setString(3, IdentityCard3.getIdCardType());
			pst.setString(4, IdentityCard3.getIdCardHolderName());
			pst.setDate(5, (Date) IdentityCard3.getIssuedOn());
			pst.setString(6, IdentityCard3.getIssuedBy());
			pst.setDate(7, (Date) IdentityCard3.getExpDate());
			pst.setInt(8, IdentityCard3.getAddressId());
		});
		return itemWriter;
	}

	@Override
	public ItemWriter<IdentityCard2> saveIdentityCard2Details() {
		// TODO Auto-generated method stub
		return null;
	}
}
