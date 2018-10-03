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

import com.cbabackend.beans.Card;

/**
 * This class is used to get the Card Details of Common Wealth Card from
 * FlatFiles
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 */
@Repository
public class CardItemReaderImpl implements CardItemReader {
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.Card.path}")
	String filePath;

	public ItemReader<Card> getCardDetails() {
		FlatFileItemReader<Card> itemReader = new FlatFileItemReader<>();

		try {
			ftpURL = String.format(ftpURL, username, password, host, filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createCardLineMapper());
		System.out.println(new Card().getCardId());
		System.out.println(new Card().getCardHolderName().toUpperCase());
		System.out.println(new Card().getCardTypeId());
		System.out.println(new Card().getCvv());
		System.out.println(new Card().getExpiryDate());
		System.out.println(new Card().getCardNumber());

		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Card>
	 */
	private LineMapper<Card> createCardLineMapper() {
		DefaultLineMapper<Card> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createCardFieldSetMapper());
		lineMapper.setLineTokenizer(createCardLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Card>
	 */
	private FieldSetMapper<Card> createCardFieldSetMapper() {
		BeanWrapperFieldSetMapper<Card> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Card.class);
		return fieldSetMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated Card
	 * Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createCardLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer
				.setNames(new String[] { "cardId", "cardNumber", "cardHolderName", "expiryDate", "cvv", "cardTypeId" });
		return lineTokenizer;
	}
}//