/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.batch.cfg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cbabackend.processor.CardItemProcessor;
import com.cbabackend.reader.CardItemReader;
import com.cbabackend.writer.CardItemWriter;

/**
 * This class is Use to Card Job Configurations
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 * @version 1.0
 */

@Configuration
public class CardJobs {

	@Autowired
	private CardItemReader cardItemReader;

	@Autowired
	private CardItemProcessor cardItemProcessor;

	@Autowired
	private CardItemWriter cardItemWriter;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Card Step
	 * 
	 * @author Rahul
	 * @return {@link Step}
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public Step createCardStep(){
		return stepBuilderFactory.get("createCardStep").chunk(1).reader(cardItemReader.getCardDetails()).processor((ItemProcessor) cardItemProcessor).
				writer(cardItemWriter.saveCardDetails()).build();
	}//createCardStep()
	
	public Job createCardJob(){
		return jobBuilderFactory.get("createCardJob").incrementer(new RunIdIncrementer()).flow(createCardStep()).end().build();
	}//createCardJob()
}//class
