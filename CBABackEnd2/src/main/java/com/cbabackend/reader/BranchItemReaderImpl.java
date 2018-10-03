/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.Branch;

/**
 * This class is used to get the Branch Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Repository
public class BranchItemReaderImpl implements BranchItemReader {
	/**
	 * This method is used to get the Branch Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Branch>
	 */
	public ItemReader<Branch> getBranchDetails() {
		FlatFileItemReader<Branch> itemReader = null;
		// create itemReader obj
		itemReader = new FlatFileItemReader<>();

		// access property of itemReader
		itemReader.setResource(new FileSystemResource("//ORCL/cba_flat_files/Branch.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createLineMapper());
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Branch>
	 */
	private LineMapper<Branch> createLineMapper() {
		DefaultLineMapper<Branch> lineMapper = null;

		// create lineMapper obj
		lineMapper = new DefaultLineMapper<Branch>();

		// access property of lineMapper
		lineMapper.setFieldSetMapper(createFieldSetMapper());
		lineMapper.setLineTokenizer(createLineTokenizer());
		return lineMapper;

	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Branch>
	 */
	private FieldSetMapper<Branch> createFieldSetMapper() {
		BeanWrapperFieldSetMapper<Branch> fieldSetMapper = null;
		// create fieldSetMapper obj
		fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		// access property of fieldSetMapper
		fieldSetMapper.setTargetType(Branch.class);

		return fieldSetMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated Branch 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = null;
		// create lineTokenizer obj
		lineTokenizer = new DelimitedLineTokenizer();
		// access the property of lineTokenizer
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "branchId", "branchName", "branchCode", "phoneNummber1", "phoneNumber2",
				"email", "address", "city", "state", "country", "zipcode", "swiftCode", "workingHoursId", "regionId" });
		return lineTokenizer;
	}
}
