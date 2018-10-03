/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.batch.cfg;

/**
 * This class is Use to BDeposite Job Configurations
 * 
 * @author Prateek Shukla
 * @since CBABE 1.0
 * @version 1.0
 * 
 */
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cbabackend.processor.DepositeItemProcessor;
import com.cbabackend.reader.DepositeItemReader;
import com.cbabackend.writer.DepositeItemWriter;

@Configuration
public class DepositeJobs {
	@Autowired
	private DepositeItemWriter depositeItemWriter;
	@Autowired
	private DepositeItemReader depositeItemReader;
	@Autowired
	private DepositeItemProcessor depositeItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the BDeposite Step
	 * 
	 * @author Prateek Shukla
	 * @return {@link Step}
	 * 
	 */
	@Bean
	public Step createDepositeStep() {
		return stepBuilderFactory.get("createDepositeStep").chunk(1).reader(depositeItemReader.getDepositeDetails())
				.processor((ItemProcessor)depositeItemProcessor).writer(depositeItemWriter.saveDepositeDetails()).build();
	}

	/**
	 * This Method is Use to Create the Deposite Job
	 * 
	 * @author Sathish
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createBDepositeJob() {
		return jobBuilderFactory.get("createDepositeJob").incrementer(new RunIdIncrementer()).flow(createDepositeStep())
				.end().build();
	}

}
