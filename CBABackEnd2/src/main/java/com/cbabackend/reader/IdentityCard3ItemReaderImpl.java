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

import com.cbabackend.beans.IdentityCard3;

/**
 * This class is used to get the IdentityCard3 Details of Common Wealth IdentityCard3 from
 * FlatFiles
 * @author Chandni
 * @since CBABE 1.0
 */
@Repository
public class IdentityCard3ItemReaderImpl implements IdentityCard3ItemReader {
	/**
	 * This method is used to get the IdentityCard3 Details of Common Wealth IdentityCard3 from
	 * FlatFiles
	 * 
	 * @return ItemReader<IdentityCard3>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.IdentityCard3.path}")
	String filePath;
	public ItemReader<IdentityCard3> getIdentityCard3Details() {
		FlatFileItemReader<IdentityCard3> itemReader = new FlatFileItemReader<>();

		try {
	
	/*String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="IdentityCard3.csv";
	*/

	ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createIdentityCard3LineMapper());
		System.out.println(new IdentityCard3().getIdCardNumber());
		
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<IdentityCard3>
	 */
	private LineMapper<IdentityCard3> createIdentityCard3LineMapper() {
		DefaultLineMapper<IdentityCard3> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createIdentityCard3FieldSetMapper());
		lineMapper.setLineTokenizer(createIdentityCard3LineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<IdentityCard3>
	 */
	private FieldSetMapper<IdentityCard3> createIdentityCard3FieldSetMapper() {
		BeanWrapperFieldSetMapper<IdentityCard3> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(IdentityCard3.class);
		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated IdentityCard3 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createIdentityCard3LineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "IdCard1Id", "IdCard1Number", "IdCard3Type","IdCard3HolderName","IdCard3IssuedOn","IdCard3IssuedBy","IdCard3expDate","IdCard3addressId" });
		return lineTokenizer;
	}
}//