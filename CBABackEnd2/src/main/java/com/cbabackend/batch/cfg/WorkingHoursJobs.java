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

import com.cbabackend.processor.WorkingHoursItemProcessor;
import com.cbabackend.reader.WorkingHoursItemReader;
import com.cbabackend.writer.WorkingHoursItemWriter;

/**
 * This class is Use to Working-Hours Job Configurations
 * 
 * @author Sathish
 * @since CBABE 1.0
 * @version 1.0
 */
@Configuration
public class WorkingHoursJobs {
	@Autowired
	private WorkingHoursItemWriter workingHoursItemWriter;
	@Autowired
	private WorkingHoursItemReader workingHoursItemReader;
	@Autowired
	private WorkingHoursItemProcessor workingHoursItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Working-Hours Step
	 * 
	 * @author Sathish
	 * @return {@link Step}
	 * 
	 */
	@Bean
	public Step createWorkingHoursStep() {
		return stepBuilderFactory.get("createWorkingHoursStep").chunk(1)
				.reader(workingHoursItemReader.getWorkingHours()).processor((ItemProcessor) workingHoursItemProcessor)
				.writer(workingHoursItemWriter.saveWorkingHours()).build();
	}

	/**
	 * This Method is Use to Create the Working-Hours Job
	 * 
	 * @author Sathish
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createWorkingHoursJob() {
		return jobBuilderFactory.get("createWorkingHoursJob").incrementer(new RunIdIncrementer())
				.flow(createWorkingHoursStep()).end().build();
	}

}
