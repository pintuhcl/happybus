/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.batch.cfg;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.SimpleJobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.JdbcExecutionContextDao;
import org.springframework.batch.core.repository.dao.JdbcJobExecutionDao;
import org.springframework.batch.core.repository.dao.JdbcJobInstanceDao;
import org.springframework.batch.core.repository.dao.JdbcStepExecutionDao;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.PlatformTransactionManager;

import com.cbabackend.processor.DesignationItemProcessor;
import com.cbabackend.reader.DesignationItemReader;
import com.cbabackend.writer.DesignationItemWriter;

/**
 * This class is Use to Designation Job Configurations
 * 
 * @author Chandni
 * @since CBABE 1.0
 * @version 1.0
 */
@SuppressWarnings("unused")
@Configuration
public class DesignationJobs {
	@Autowired
	private DesignationItemWriter DesignationItemWriter;
	@Autowired
	private DesignationItemReader DesignationItemReader;
	@Autowired
	private DesignationItemProcessor DesignationItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Designation Step
	 * 
	 * @author Chandni
	 * @return {@link Step}
	 * 
	 */

	@Bean
	public Step createDesignationStep() {
		return stepBuilderFactory.get("createDesignationStep").chunk(1).reader(DesignationItemReader.getDesignationDetails())
				.processor((ItemProcessor) DesignationItemProcessor).writer(DesignationItemWriter.saveDesignationDetails()).build();
	}

	/**
	 * This Method is Use to Create the Designation Job
	 * 
	 * @author Chandni
	 * @return {@link Job}
	 * 
	 */

	@Bean
	public Job createDesignationJob() {
		return jobBuilderFactory.get("createDesignationJob").incrementer(new RunIdIncrementer()).flow(createDesignationStep()).end()
				.build();
	}// method

}// class
