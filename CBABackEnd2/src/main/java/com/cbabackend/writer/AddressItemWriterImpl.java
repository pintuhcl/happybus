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

import com.cbabackend.beans.Address;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Address Details of Common Wealth Address from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class AddressItemWriterImpl implements AddressItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Address Details of Common Wealth Address from
	 * Database
	 * 
	 * @return ItemWriter<Address>
	 */
	public ItemWriter<Address> saveAddressDetails() {
		JdbcBatchItemWriter<Address> itemWriter = new JdbcBatchItemWriter<Address>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_ADDRESS_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Address address, PreparedStatement pst) -> {
			pst.setInt(1, address.getAddressId());
			pst.setString(2, address.getResidenceType());
			pst.setString(3, address.getPresentAddress());
			pst.setString(4, address.getPresentCity());
			pst.setString(5, address.getPresentState());
			pst.setString(6, address.getPresentCountry());
			pst.setString(7, address.getPresentZipcode());
			pst.setString(8, address.getPermanentAddress());
			pst.setString(9, address.getPermanentCity());
			pst.setString(10, address.getPermanentState());
			pst.setString(11, address.getPermanentCountry());
			pst.setString(12, address.getPermanentZipcode());
		});
		return itemWriter;
	}
}
