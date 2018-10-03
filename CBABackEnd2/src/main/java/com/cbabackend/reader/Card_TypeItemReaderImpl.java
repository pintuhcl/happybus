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

import com.cbabackend.beans.Card_Type;

/**
 * This class is used to get the Card_Type Details of Common Wealth Card_Type
 * from FlatFiles
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */
@Repository
public class Card_TypeItemReaderImpl implements Card_TypeItemReader {
	/**
	 * This method is used to get the Card_Type Details of Common Wealth
	 * Card_Type from FlatFiles
	 * 
	 * @return ItemReader<Card_Type>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.Card_Type.path}")
	String filePath;

	public ItemReader<Card_Type> getCard_TypeDetails() {
		FlatFileItemReader<Card_Type> itemReader = new FlatFileItemReader<>();

		ftpURL = String.format(ftpURL, username, password, host, filePath);
		try {
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		//itemReader.setResource(new FileSystemResource("D:/Card_TypeingProject/cba_flat_files/Card_Type.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createCard_TypeLineMapper());
		System.out.println(new Card_Type().getCardTypeName());

		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Card_Type>
	 */
	private LineMapper<Card_Type> createCard_TypeLineMapper() {
		DefaultLineMapper<Card_Type> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createCard_TypeFieldSetMapper());
		lineMapper.setLineTokenizer(createCard_TypeLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Card_Type>
	 */
	private FieldSetMapper<Card_Type> createCard_TypeFieldSetMapper() {
		BeanWrapperFieldSetMapper<Card_Type> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Card_Type.class);
		return fieldSetMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated
	 * Card_Type Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createCard_TypeLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "cardTypeId", "cardTypeName", "cardTypeNumber","cardDistributedName" });
		return lineTokenizer;
	}
}//