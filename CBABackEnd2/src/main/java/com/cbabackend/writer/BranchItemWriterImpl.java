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
import com.cbabackend.beans.Branch;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Branch Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class BranchItemWriterImpl implements BranchItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Branch Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriter<Branch>
	 */
	@Override
	public ItemWriter<Branch> saveBranchDetails() {
		JdbcBatchItemWriter<Branch> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_BRANCH_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Branch branch, PreparedStatement pst) -> {
			pst.setInt(1, branch.getBranchId());
			pst.setString(2, branch.getBranchName());
			pst.setString(3, branch.getBranchCode());
			pst.setString(4, branch.getPhoneNumber1());
			pst.setString(5, branch.getPhoneNumber2());
			pst.setString(6, branch.getEmail());
			pst.setString(7, branch.getSwiftCode());
			pst.setInt(8, branch.getWorkingHoursId());
			pst.setString(9, branch.getAddress());
			pst.setString(10, branch.getCity());
			pst.setString(11, branch.getState());
			pst.setString(12, branch.getCountry());
			pst.setString(13, branch.getZipcode());
			pst.setInt(14, branch.getRegionId());
		});
		return itemWriter;
	}
}
