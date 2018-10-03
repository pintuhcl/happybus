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

import com.cbabackend.beans.AccountTransactions;

/**
 * This class is used to get the Account-Transaction Details of Common Wealth
 * Bank from FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Repository
public class AccountTransactionsReaderImpl implements AccountTransactionReader {
	
	
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.accountTransactions.path}")
	String filePath;
	
	
	/**
	 * This method is used to get the Account-Transaction Details of Common
	 * Wealth Bank from FlatFiles
	 * 
	 * @return {@link ItemReader<AccountTransactions>}
	 */
	@Override
	public ItemReader<AccountTransactions> getAccountTransactionsDetails() {
		FlatFileItemReader<AccountTransactions> itemReader = new FlatFileItemReader<>();

		try {
			ftpURL = String.format(ftpURL, username, password, host, filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createAccountTransactionsLineMapper());

		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object Of Account
	 * Transaction
	 * 
	 * @return LineMapper<AccountTransactions>
	 * 
	 */
	private LineMapper<AccountTransactions> createAccountTransactionsLineMapper() {
		DefaultLineMapper<AccountTransactions> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createAccountTransactionsFieldSetMapper());
		lineMapper.setLineTokenizer(createAccountTransactionsLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated
	 * Account-Transaction Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 * 
	 */

	private LineTokenizer createAccountTransactionsLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer
				.setNames(new String[] { "accountTransactionId", "accountId", "transactionType", "transactionStatus",
						"transactionDate", "transactionMode", "transactionAmount", "transactionDesc", "updatedBy" });
		return lineTokenizer;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object Of Account
	 * Transaction
	 * 
	 * @return FieldSetMapper<AccountTransactions>
	 */
	private FieldSetMapper<AccountTransactions> createAccountTransactionsFieldSetMapper() {
		BeanWrapperFieldSetMapper<AccountTransactions> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(AccountTransactions.class);
		return fieldSetMapper;
	}

}
