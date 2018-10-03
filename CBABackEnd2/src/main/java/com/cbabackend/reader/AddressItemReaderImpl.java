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
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.Address;

/**
 * This class is used to get the Address Details of Common Wealth Address from
 * FlatFiles
 * @author Chandni
 * @since CBABE 1.0
 */
@Repository
public class AddressItemReaderImpl implements AddressItemReader {
	/**
	 * This method is used to get the Address Details of Common Wealth Address from
	 * FlatFiles
	 * 
	 * @return ItemReader<Address>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.Address.path}")
	String filePath;
	public ItemReader<Address> getAddressDetails() {
		FlatFileItemReader<Address> itemReader = new FlatFileItemReader<>();

		try {
	
	/*String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="Address.csv";
	*/

	ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createAddressLineMapper());
		System.out.println(new Address().getAddressId());
		
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Address>
	 */
	private LineMapper<Address> createAddressLineMapper() {
		DefaultLineMapper<Address> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createAddressFieldSetMapper());
		lineMapper.setLineTokenizer(createAddressLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Address>
	 */
	private FieldSetMapper<Address> createAddressFieldSetMapper() {
		BeanWrapperFieldSetMapper<Address> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Address.class);
		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated Address 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createAddressLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "AddressId","residenseType", "presentAddress", "presentCity","presentState","presentCountry","presentZipcode","permanentAddress", "permanentCity","permanentState","permanentCountry","permanentZipcode" });
		return lineTokenizer;
	}
}//