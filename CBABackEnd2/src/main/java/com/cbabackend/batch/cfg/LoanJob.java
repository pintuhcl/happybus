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
import org.springframework.batch.item.adapter.ItemWriterAdapter;
import org.springframework.batch.item.support.ListItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cbabackend.processor.LoanItemProcessor;
import com.cbabackend.reader.LoanItemReader;

/**
 * This class is Use to Loan Job Configurations
 * 
 * @author Anitha
 * @since CBABE 1.0
 * @version 1.0
 * 
 */
@Configuration
public class LoanJob {
	@Autowired
	private ListItemWriter loanItemWriter;
	@Autowired
	private LoanItemReader loanItemReader;
	@Autowired
	private LoanItemProcessor loanItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Loan Step
	 * 
	 * @author Anitha
	 * @return {@link Step}
	 * 
	 */
	@Bean
	public Step createLoanStep() {
		return stepBuilderFactory.get("createLoanStep").chunk(1).reader(loanItemReader.getLoanDetails())
				.processor((ItemProcessor) loanItemProcessor).writer(new ItemWriterAdapter<>()).build();
	}

	/**
	 * This Method is Use to Create the Loan Job
	 * 
	 * @author Anitha
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createLoanJob() {
		return jobBuilderFactory.get("createLoanJob").incrementer(new RunIdIncrementer()).flow(createLoanStep())
				.end().build();
	}


}
