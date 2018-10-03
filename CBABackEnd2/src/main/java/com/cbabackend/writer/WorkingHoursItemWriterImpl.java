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

import com.cbabackend.beans.WorkingHours;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the WorkingHours Details of Common Wealth Bank
 * from Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class WorkingHoursItemWriterImpl implements WorkingHoursItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the WorkingHours Details of Common Wealth
	 * Bank from Database
	 * 
	 * @return ItemWriter<WorkingHours>
	 */
	public ItemWriter<WorkingHours> saveWorkingHours() {
		JdbcBatchItemWriter<WorkingHours> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_WORKING_HOURS);
		/*
		 * itemWriter.setItemPreparedStatementSetter(new
		 * ItemPreparedStatementSetter<WorkingHours>() { public void
		 * setValues(WorkingHours workingHours, PreparedStatement pst) throws
		 * SQLException { pst.setInt(1, workingHours.getId()); pst.setString(2,
		 * workingHours.getOpeningHours().toString()); pst.setString(3,
		 * workingHours.getClosingHours().toString());
		 * 
		 * } });
		 */

		// lambda expression
		itemWriter.setItemPreparedStatementSetter((WorkingHours workingHours, PreparedStatement pst) -> {

			pst.setInt(1, workingHours.getId());
			pst.setString(2, workingHours.getOpeningHours().toString());
			pst.setString(3, workingHours.getClosingHours().toString());

		});
		return itemWriter;
	}
}
