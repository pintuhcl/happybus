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

import com.cbabackend.beans.IdentityCard1;

/**
 * This class is used to get the IdentityCard1 Details of Common Wealth IdentityCard1 from
 * FlatFiles
 * @author Chandni
 * @since CBABE 1.0
 */
@Repository
public class IdentityCard1ItemReaderImpl implements IdentityCard1ItemReader {
	/**
	 * This method is used to get the IdentityCard1 Details of Common Wealth IdentityCard1 from
	 * FlatFiles
	 * 
	 * @return ItemReader<IdentityCard1>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.IdentityCard1.path}")
	String filePath;
	public ItemReader<IdentityCard1> getIdentityCard1Details() {
		FlatFileItemReader<IdentityCard1> itemReader = new FlatFileItemReader<>();

		try {
	
	/*String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="IdentityCard1.csv";
	*/

	ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createIdentityCard1LineMapper());
		System.out.println(new IdentityCard1().getIdCardNumber());
		
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<IdentityCard1>
	 */
	private LineMapper<IdentityCard1> createIdentityCard1LineMapper() {
		DefaultLineMapper<IdentityCard1> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createIdentityCard1FieldSetMapper());
		lineMapper.setLineTokenizer(createIdentityCard1LineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<IdentityCard1>
	 */
	private FieldSetMapper<IdentityCard1> createIdentityCard1FieldSetMapper() {
		BeanWrapperFieldSetMapper<IdentityCard1> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(IdentityCard1.class);
		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated IdentityCard1 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createIdentityCard1LineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "IdCard1Id", "IdCard1Number", "IdentityCard1Type","IdCard1HolderName","IdCard1IssuedOn","IdCard1IssuedBy","IdCard1expDate","IdCard1addressId" });
		return lineTokenizer;
	}
}//