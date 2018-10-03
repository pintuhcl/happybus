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

import com.cbabackend.beans.Region;

/**
 * This class is used to get the Region Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Repository
public class RegionItemReaderImpl implements RegionItemReader {
	/**
	 * This method is used to get the Region Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Region>
	 */
	public ItemReader<Region> getRegionDetails() {
		FlatFileItemReader<Region> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("//ORCL/cba_flat_files/Region.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createRegionLineMapper());
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Region>
	 */

	private LineMapper<Region> createRegionLineMapper() {
		DefaultLineMapper<Region> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createRegionFieldSetMapper());
		lineMapper.setLineTokenizer(createRegionLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Region>
	 */

	private FieldSetMapper<Region> createRegionFieldSetMapper() {
		BeanWrapperFieldSetMapper<Region> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Region.class);
		return fieldSetMapper;
	}

	/**
	 * This method is used to Create the LineTokenizer Object And Separated
	 * Region Data By Using ';' (Semicolon)
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createRegionLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "regionId", "regionCode", "regionName", "regionHeadOffice",
				"regionAddress", "regionDesc", "bankId" });
		return lineTokenizer;
	}
}
