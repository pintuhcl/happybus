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

import com.cbabackend.beans.IdentityCard2;

/**
 * This class is used to get the IdentityCard2 Details of Common Wealth IdentityCard2 from
 * FlatFiles
 * @author Chandni
 * @since CBABE 1.0
 */
@Repository
public class IdentityCard2ItemReaderImpl implements IdentityCard2ItemReader {
	/**
	 * This method is used to get the IdentityCard2 Details of Common Wealth IdentityCard2 from
	 * FlatFiles
	 * 
	 * @return ItemReader<IdentityCard2>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.IdentityCard2.path}")
	String filePath;
	public ItemReader<IdentityCard2> getIdentityCard2Details() {
		FlatFileItemReader<IdentityCard2> itemReader = new FlatFileItemReader<>();

		try {
	
	/*String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="IdentityCard2.csv";
	*/

	ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createIdentityCard2LineMapper());
		System.out.println(new IdentityCard2().getIdCardNumber());
		
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<IdentityCard2>
	 */
	private LineMapper<IdentityCard2> createIdentityCard2LineMapper() {
		DefaultLineMapper<IdentityCard2> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createIdentityCard2FieldSetMapper());
		lineMapper.setLineTokenizer(createIdentityCard2LineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<IdentityCard2>
	 */
	private FieldSetMapper<IdentityCard2> createIdentityCard2FieldSetMapper() {
		BeanWrapperFieldSetMapper<IdentityCard2> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(IdentityCard2.class);
		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated IdentityCard2 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createIdentityCard2LineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "IdCard2Id", "IdCard2Number", "IdCard2Type","IdCard2HolderName","IdCard2IssuedOn","IdCard2IssuedBy","IdCard2expDate","IdCard2addressId" });
		return lineTokenizer;
	}
}//