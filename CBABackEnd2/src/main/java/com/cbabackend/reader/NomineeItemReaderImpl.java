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
import com.cbabackend.beans.Nominee;



/**
 * This class is used to get the Nominee Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 */
@Repository
public class NomineeItemReaderImpl implements NomineeItemReader {

	/**
	 * This method is used to get the Bank Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Nominee>
	 */

	@Value("${ftp.url}")
	String ftpUrl;
	@Value("${ftp.host}")
	String ftpHost;
	@Value("${ftp.username}")
	String userName;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.nominee.path}")
	String filePath;

	@Override
	public ItemReader<Nominee> getNomineeDetails() {
		FlatFileItemReader<Nominee> itemReader = new FlatFileItemReader<>();

		ftpUrl = String.format(ftpUrl, userName, password, filePath);

		try {
			itemReader.setResource(new UrlResource(new URL(ftpUrl)));
		} // try

		catch (MalformedURLException e) {
			e.printStackTrace();

		} // catch

		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createNomineeLineMapper());
		System.out.println(new Nominee().getNomineeName());

		return itemReader;
	}// getNominee

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Bank>
	 */

	private LineMapper<Nominee> createNomineeLineMapper() {

		DefaultLineMapper<Nominee> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createNomineeFieldSetMapper());
		lineMapper.setLineTokenizer(createNomineeLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Bank>
	 */
	private FieldSetMapper<Nominee> createNomineeFieldSetMapper() {

		BeanWrapperFieldSetMapper<Nominee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();

		fieldSetMapper.setTargetType(Nominee.class);

		return fieldSetMapper;

	}// createNomineeFieldSetMapper()

	/**
	 * This method is used to Create the LineTokenizer Object And Separated Bank
	 * Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 */

	private LineTokenizer createNomineeLineTokenizer() {

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(
				new String[] { "nomineeId", "nomineeName", "nomineeDOB", "gender", "relationship", "address, nomineeDesc" });

		return lineTokenizer;
	}//
}// class
