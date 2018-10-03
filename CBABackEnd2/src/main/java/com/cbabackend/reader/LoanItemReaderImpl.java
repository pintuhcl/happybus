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

import com.cbabackend.beans.Loan;


/**
 * This class is used to get the Account-Transaction Details of Common Wealth
 * Bank from FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Repository
public class LoanItemReaderImpl implements  LoanItemReader{
	
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.Loan.path}")
	String filePath;
	
	/**
	 * This method is used to get the Account-Transaction Details of Common
	 * Wealth Bank from FlatFiles
	 * 
	 * @return {@link ItemReader<Loan>}
	 */

	@Override
	public ItemReader<Loan> getLoanDetails() {
		FlatFileItemReader<Loan> itemReader = new FlatFileItemReader<>();

		try {
			ftpURL = String.format(ftpURL, username, password, host, filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createLoanLineMapper());
		return itemReader;
	}
	/**
	 * This method is used to Create the LineMapper Object Of Account
	 * Transaction
	 * 
	 * @return LineMapper<Loan>
	 * 
	 */
	private LineMapper<Loan> createLoanLineMapper() {
		DefaultLineMapper<Loan> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createLoanFieldSetMapper());
		lineMapper.setLineTokenizer(createLoanLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated
	 * Account-Transaction Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 * 
	 */
	
	private LineTokenizer createLoanLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] {"loan_id","interest_rate","start_date","loan_type_id" });
		return lineTokenizer;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object Of Account
	 * Transaction
	 * 
	 * @return FieldSetMapper<Loan>
	 */
	private FieldSetMapper<Loan> createLoanFieldSetMapper() {
		BeanWrapperFieldSetMapper<Loan> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Loan.class);
		return fieldSetMapper;
	}



}
