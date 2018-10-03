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

import com.cbabackend.beans.WorkingHours;

/**
 * This class is used to get the Business Hour Details of Common Wealth Bank
 * from FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Repository
public class WorkingHoursItemReaderImpl implements WorkingHoursItemReader {
	/**
	 * This method is used to get the Business hour Details of Common Wealth
	 * Bank from FlatFiles
	 * 
	 * @return ItemReader<WorkingHours>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.workingHour.path}")
	String filePath;
	public ItemReader<WorkingHours> getWorkingHours() {
		FlatFileItemReader<WorkingHours> itemReader = new FlatFileItemReader<>();
		ftpURL=String.format(ftpURL,username,password,host,filePath);
		try {
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createWorkingHoursLineMapper());
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<WorkingHours>
	 */

	private LineMapper<WorkingHours> createWorkingHoursLineMapper() {
		DefaultLineMapper<WorkingHours> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createWorkingHoursFieldSetMapper());
		lineMapper.setLineTokenizer(createWorkingHoursLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<WorkingHours>
	 */
	private FieldSetMapper<WorkingHours> createWorkingHoursFieldSetMapper() {
		BeanWrapperFieldSetMapper<WorkingHours> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(WorkingHours.class);
		//fieldSetMapper.mapFieldSet(fs)
		return fieldSetMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated
	 * WorkingHours Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createWorkingHoursLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "id", "openingHours", "closingHours" });
		return lineTokenizer;
	}

}
