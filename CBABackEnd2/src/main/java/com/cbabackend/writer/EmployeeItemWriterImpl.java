/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import com.cbabackend.beans.Employee;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Employee Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class EmployeeItemWriterImpl implements EmployeeItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Employee Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriter<Employee>
	 */
	@SuppressWarnings("deprecation")
	public ItemWriter<Employee> saveEmployeeDetails() {
		JdbcBatchItemWriter<Employee> itemWriter = new JdbcBatchItemWriter<Employee>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_EMPLOYEE_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Employee employee, PreparedStatement pst) -> {
			pst.setInt(1, employee.getEmployeeId());
			pst.setInt(2,employee.getBranchId());
			//System.out.println(Date.valueOf((employee.getDateOfJoin()).toString()));
			System.out.println(new java.sql.Date(employee.getDob().getTime()));
			//pst.setDate(3,Date.valueOf((employee.getDateOfJoin()).toString()));
			pst.setDate(3,(new java.sql.Date(employee.getDateOfJoin().getTime())));
			pst.setDouble(4,employee.getSalary());
			pst.setString(5, employee.getFirst_name());
			pst.setString(6, employee.getLast_name());
			pst.setString(7, employee.getMiddle_name());
			pst.setInt(8, employee.getAddress1());
			pst.setInt(9, employee.getAddress2());
			pst.setString(10, employee.getEmail());
			pst.setString(11, employee.getPhone());
			pst.setString(12, employee.getMobile());
			pst.setString(13, employee.getGender());
			pst.setDate(14, (new java.sql.Date(employee.getDateOfJoin().getDate())));
			System.out.println(new java.sql.Date(employee.getDob().getTime()));
			pst.setDate(15, (new java.sql.Date(employee.getCreated_date().getDate())));
			pst.setInt(16, employee.getCreated_by());
			pst.setString(17, employee.getJob_title());
			pst.setString(18, employee.getJob_description());
			
		});
		return itemWriter;
	}
}
