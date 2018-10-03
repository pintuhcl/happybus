
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.reader;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import com.cbabackend.beans.Customer;
import com.cbabackend.beans.Customer;

/**
 * This class is used to get the Customer Details of Common Wealth Customer from
 * FlatFiles
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */

public class CustomerItemReaderImpl implements CustomerItemReader {
	/**
	 * This method is used to get the Customer Details of Common Wealth Customer
	 * from FlatFiles
	 * 
	 * @return ItemReader<Customer>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.Customer.path}")
	String filePath;

	@Override
	public ItemReader<Customer> getCustomerDetails() {
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();

		ftpURL = String.format(ftpURL, username, password, host, filePath);
		try {
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		itemReader.setResource(new FileSystemResource("D:/CustomeringProject/cba_flat_files/customer.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createCustomerLineMapper());
		System.out.println(new Customer().getCustomerId());

		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Customer>
	 */

	private LineMapper<Customer> createCustomerLineMapper() {
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createCustomerFieldSetMapper());
		lineMapper.setLineTokenizer(createCustomerLineTokenizer());
		return lineMapper;

	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Customer>
	 */
	private FieldSetMapper<Customer> createCustomerFieldSetMapper() {
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class);
		return fieldSetMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated
	 * Customer Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createCustomerLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "customerId", "firstName", "lastName", "middleName", "dateOfBirth",
				"gender", "maritalStatus", "occupation", "incomeRange", "email", "alternativeEmail", "mobile",
				"alternativeMobile", "citizenship", "passportNumber", "passportType", "drivingLicence",
				"drivingLicenceType", "otherIdDesc", "taxFileNumber", "australianBusinessNumber", "addressId", "image",
				"signature", "nomineId", "existingAccountNumber" });
		return lineTokenizer;
	}

}
