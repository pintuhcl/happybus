/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.batch.cfg;

/**
 * This class is Use to Branch Job Configurations
 * 
 * @author Sathish
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

import com.cbabackend.processor.BranchItemProcessor;
import com.cbabackend.reader.BranchItemReader;
import com.cbabackend.writer.BranchItemWriter;

@Configuration
public class BranchJobs {
	@Autowired
	private BranchItemWriter branchItemWriter;
	@Autowired
	private BranchItemReader branchItemReader;
	@Autowired
	private BranchItemProcessor branchItemProcessor;
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
	public Step createBranchStep() {
		return stepBuilderFactory.get("createBranchStep").chunk(1).reader(branchItemReader.getBranchDetails())
				.processor((ItemProcessor) branchItemProcessor).writer(branchItemWriter.saveBranchDetails()).build();
	}

	/**
	 * This Method is Use to Create the Branch Job
	 * 
	 * @author Sathish
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createBranchJob() {
		return jobBuilderFactory.get("createBranchJob").incrementer(new RunIdIncrementer()).flow(createBranchStep())
				.end().build();
	}

}
