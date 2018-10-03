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


import com.cbabackend.beans.Loan;
import com.cbabackend.util.SQLConstants;
/**
 * This class is used to Writing the loan Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class LoanItemWriterImpl implements LoanItemWriter{
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the loan Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriter<loan>
	 */
	
	@Override
	public ItemWriter<Loan> saveLoanDetails() {
		JdbcBatchItemWriter<Loan> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_LOAN_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Loan loan, PreparedStatement pst) -> {
			pst.setInt(1, loan.getLoan_Id());
			pst.setFloat(2, loan.getintrest_rate());
			pst.setDate(3, (Date) loan.getStart_Date());
			pst.setInt(4, loan.getLoan_type_Id());
			
		});
		return itemWriter;
	}

}
