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

import com.cbabackend.processor.AddressItemProcessor;
import com.cbabackend.reader.AddressItemReader;
import com.cbabackend.writer.AddressItemWriter;

/**
 * This class is Use to Address Job Configurations
 * 
 * @author Chandni
 * @since CBABE 1.0
 * @version 1.0
 */
@SuppressWarnings("unused")
@Configuration
public class AddressJobs {
	@Autowired
	private AddressItemWriter addressItemWriter;
	@Autowired
	private AddressItemReader addressItemReader;
	@Autowired
	private AddressItemProcessor addressItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Address Step
	 * 
	 * @author Sathish
	 * @return {@link Step}
	 * 
	 */

	@Bean
	public Step createAddressStep() {
		return stepBuilderFactory.get("createAddressStep").chunk(1).reader(addressItemReader.getAddressDetails())
				.processor((ItemProcessor) addressItemProcessor).writer(addressItemWriter.saveAddressDetails()).build();
	}

	/**
	 * This Method is Use to Create the Address Job
	 * 
	 * @author Chandni
	 * @return {@link Job}
	 * 
	 */

	@Bean
	public Job createAddressJob() {
		return jobBuilderFactory.get("createAddressJob").incrementer(new RunIdIncrementer()).flow(createAddressStep()).end()
				.build();
	}// method

}// class
