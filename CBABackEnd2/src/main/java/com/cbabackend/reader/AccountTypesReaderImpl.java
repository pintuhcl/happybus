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
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.AccountTypes;
import com.cbabackend.beans.Bank;
import com.cbabackend.beans.AccountTypes;

/**
 * This class is used to get the AccountTypes Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author anitha
 * @since CBABE 1.0
 */
@Repository
public class AccountTypesReaderImpl  implements AccountTypesReader {
	
	/**
	 * This method is used to get the AccountTypes Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<AccountTypes>
	 */

	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.bank.path}")
	String filePath;
	public ItemReader<AccountTypes> getAccountypes() {
		FlatFileItemReader<AccountTypes> itemReader = null;

		try {
	
	/*String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="bank.csv";
	*/
			ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createAccountTypesLineMapper());
		System.out.println(new AccountTypes().getAccountTypeName());
		
		return itemReader;
	}

	private LineMapper<AccountTypes> createAccountTypesLineMapper() {
		DefaultLineMapper<AccountTypes> lineMapper = null;

		// create lineMapper obj
		lineMapper = new DefaultLineMapper<AccountTypes>();

		// access property of lineMapper
		lineMapper.setFieldSetMapper(createFieldSetMapper());
		lineMapper.setLineTokenizer(createLineTokenizer());
		return lineMapper;

	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<AccountTypes>
	 */
	private FieldSetMapper<AccountTypes> createFieldSetMapper() {
		BeanWrapperFieldSetMapper<AccountTypes> fieldSetMapper = null;
		// create fieldSetMapper obj
		fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		// access property of fieldSetMapper
		fieldSetMapper.setTargetType(AccountTypes.class);

		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated AccountTypes 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = null;
		// create lineTokenizer obj
		lineTokenizer = new DelimitedLineTokenizer();
		// access the property of lineTokenizer
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "AccountTypesId", "AccountTypesName","accountDesc", "minBalanceToOpen", "minBalanceToMaintain"});
		return lineTokenizer;
	}
	
	
	
	
	
	
	
	

}
