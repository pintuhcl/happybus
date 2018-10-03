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
import org.springframework.context.annotation.Configuration;

import com.cbabackend.beans.Nominee;
import com.cbabackend.processor.NomineeItemProcessor;
import com.cbabackend.reader.NomineeItemReader;
import com.cbabackend.writer.NomineeItemWriter;

/**
 * This class is Use to Nominee Job Configurations
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 * @version 1.0
 */
@Configuration
public class NomineeJobs {

	@Autowired
	private NomineeItemWriter nomineeItemWriter;

	@Autowired
	private NomineeItemProcessor nomineeItemProcessor;

	@Autowired
	private NomineeItemReader nomineeItemReader;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Nominee Step
	 * 
	 * @author Rahul M.
	 * @return {@link Step}
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Bean
	public Step createNomineeStep() {
		return stepBuilderFactory.get("createNomineeStep").chunk(1).reader(nomineeItemReader.getNomineeDetails())
				.processor((ItemProcessor) nomineeItemProcessor).writer(nomineeItemWriter.saveNomineeDetails()).build();
	}// createNomineeStep()

	/**
	 * This Method is Use to Create the Nominee JOB
	 * 
	 * @author Rahul M.
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createBankJob() {
		return jobBuilderFactory.get("createBankJob").incrementer(new RunIdIncrementer()).flow(createNomineeStep())
				.end().build();
	}// createBankJob()
}// class
