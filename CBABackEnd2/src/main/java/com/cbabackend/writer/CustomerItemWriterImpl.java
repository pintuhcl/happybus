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

import com.cbabackend.beans.Address;
import com.cbabackend.beans.Customer;
import com.cbabackend.beans.Customer;
import com.cbabackend.util.SQLConstants;
/**
 * This class is used to Writing the Customer Details of Common Wealth Customer from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class CustomerItemWriterImpl implements CustomerItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Customer Details of Common Wealth Customer from
	 * Database
	 * 
	 * @return ItemWriter<Customer>
	 */


	@Override
	public ItemWriter<Customer> saveCustomerDetails() {
		JdbcBatchItemWriter<Customer> itemWriter = new JdbcBatchItemWriter<Customer>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_CUSTOMER_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Customer customer, PreparedStatement pst) -> {
			pst.setInt(1, customer.getCustomerId());
			pst.setString(2, customer.getFirstName());
			pst.setString(3, customer.getLastName());
			pst.setString(4,customer.getMiddleName());
			pst.setDate(5,(Date) customer.getDateOfBirth());
			pst.setString(6,customer.getGender());
			pst.setString(7,customer.getMaritalStatus());
			pst.setString(8,customer.getOccupation());
			pst.setString(9,customer.getIncomeRange());
			pst.setString(10,customer.getEmail());
			pst.setString(11,customer.getAlternativeEmail());
			pst.setString(12,customer.getMobile());
			pst.setString(13,customer.getAlternativeMobile());
			pst.setString(14,customer.getCitizenship());
			pst.setString(15,customer.getPassportNumber());
			pst.setString(16,customer.getPassportType());
			pst.setString(17,customer.getDrivingLicence());
			pst.setString(18,customer.getDrivingLicenceType());
			pst.setString(19,customer.getOtherIdDesc());
			pst.setString(20,customer.getTaxFileNumber());
			pst.setString(21,customer.getAustralianBusinessNumber());
			pst.setInt(22,customer.getAddressId());
			pst.setByte(23,customer.getImage());
			pst.setByte(24,customer.getSignature());
			pst.setInt(25,customer.getNomineId());
			pst.setString(26,customer.getExistingAccountNumber());
			
			
		});
		return itemWriter;

		
		
		
	}

}
