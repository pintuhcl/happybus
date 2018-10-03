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
import org.springframework.context.annotation.Bean;

import com.cbabackend.beans.AccountTypes;
import com.cbabackend.processor.AccountTypesItemProcessor;
import com.cbabackend.reader.AccountTransactionReader;



/**
 * This class is Use to Branch Job Configurations
 * 
 * @author Anitha
 * @since CBABE 1.0
 * @version 1.0
 * 
 */

public class AccountTypesJob {
	@Autowired
	private AccountTypes accountTypesItemWriter;
	@Autowired
	private AccountTransactionReader accountTypesReader;
	@Autowired
	private AccountTypesItemProcessor accountTypesItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	/**
	 * This Method is Use to Create the Branch Step
	 * 
	 * @author Sathish
	 * @return {@link Step}
	 * 
	 */
	@Bean
	public Step createAccounTypesStep() {
		return stepBuilderFactory.get("createAccountTypesStep").chunk(1).reader(accountTypesReader.getAccountypes())
				.processor((ItemProcessor) accountTypesItemProcessor).writer(accountTypesItemWriter.saveAccountTypesDetails()).build();
	}
	/**
	 * This Method is Use to Create the Branch Job
	 * 
	 * @author Sathish
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createAccountTypesJob() {
		return jobBuilderFactory.get("createAccountTypesJob").incrementer(new RunIdIncrementer()).flow(createAccounTypesStep())
				.end().build();
	}

}
