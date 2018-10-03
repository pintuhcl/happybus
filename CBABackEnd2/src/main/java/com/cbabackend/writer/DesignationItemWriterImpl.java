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

import com.cbabackend.beans.Designation;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Designation Details of Common Wealth Designation from
 * Database
 * 
 * @author Chandni
 * @since CBABE 1.0
 * 
 */
@Repository
public class DesignationItemWriterImpl implements DesignationItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Designation Details of Common Wealth Designation from
	 * Database
	 * 
	 * @return ItemWriter<Designation>
	 */
	public ItemWriter<Designation> saveDesignationDetails() {
		JdbcBatchItemWriter<Designation> itemWriter = new JdbcBatchItemWriter<Designation>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_Designation_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Designation Designation, PreparedStatement pst) -> {
			pst.setInt(1, Designation.getDesignationId());
			pst.setString(2, Designation.getDesignationTitle());
			pst.setString(3, Designation.getDesignationDesc());
		});
		return itemWriter;
	}
}
