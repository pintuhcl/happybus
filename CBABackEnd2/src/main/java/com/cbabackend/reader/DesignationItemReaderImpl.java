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

import com.cbabackend.beans.Designation;

/**
 * This class is used to get the Designation Details of Common Wealth Designation from
 * FlatFiles
 * @author Chandni
 * @since CBABE 1.0
 */
@Repository
public class DesignationItemReaderImpl implements DesignationItemReader {
	/**
	 * This method is used to get the Designation Details of Common Wealth Designation from
	 * FlatFiles
	 * 
	 * @return ItemReader<Designation>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.Designation.path}")
	String filePath;
	public ItemReader<Designation> getDesignationDetails() {
		FlatFileItemReader<Designation> itemReader = new FlatFileItemReader<>();

		try {
	
	/*String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="Designation.csv";
	*/

	ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createDesignationLineMapper());
		System.out.println(new Designation().getDesignationId());
		
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Designation>
	 */
	private LineMapper<Designation> createDesignationLineMapper() {
		DefaultLineMapper<Designation> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createDesignationFieldSetMapper());
		lineMapper.setLineTokenizer(createDesignationLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Designation>
	 */
	private FieldSetMapper<Designation> createDesignationFieldSetMapper() {
		BeanWrapperFieldSetMapper<Designation> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Designation.class);
		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated Designation 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createDesignationLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "Designation_Id", "Designation_Title", "Designation_Desc" });
		return lineTokenizer;
	}
}//