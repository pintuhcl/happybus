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

import com.cbabackend.beans.Nominee;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Nominee Details of Common Wealth Nominee
 * from Database
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 * 
 */
@Repository
public class NomineeItemWriterImpl implements NomineeItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Nominee Details of Common Wealth Nominee
	 * from Database
	 * 
	 * @return ItemWriter<Nominee>
	 */
	public ItemWriter<Nominee> saveNomineeDetails() {
		JdbcBatchItemWriter<Nominee> itemWriter = new JdbcBatchItemWriter<Nominee>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_NOMINEE_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Nominee nominee, PreparedStatement pst) -> {
			pst.setInt(1, nominee.getNomineeId());
			pst.setString(2, nominee.getNomineeName());
			pst.setDate(3, nominee.getNomineeDOB());
			pst.setString(4, nominee.getGender());
			pst.setString(5, nominee.getRelationship());
			pst.setString(6, nominee.getAddress());
			pst.setInt(7, nominee.getCreatedBy());
			pst.setDate(8, nominee.getCreateDate());
			pst.setInt(9, nominee.getLastModifiedBy());
			pst.setDate(10, nominee.getLastModifiedDate());
		});
		return itemWriter;
	}// saveNomineeDetails()
}// class
