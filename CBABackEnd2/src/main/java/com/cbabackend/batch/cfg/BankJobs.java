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

import com.cbabackend.processor.BankItemProcessor;
import com.cbabackend.reader.BankItemReader;
import com.cbabackend.writer.BankItemWriter;

/**
 * This class is Use to Bank Job Configurations
 * 
 * @author Sathish
 * @since CBABE 1.0
 * @version 1.0
 */
@SuppressWarnings("unused")
@Configuration
public class BankJobs {
	@Autowired
	private BankItemWriter bankItemWriter;
	@Autowired
	private BankItemReader bankItemReader;
	@Autowired
	private BankItemProcessor bankItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Bank Step
	 * 
	 * @author Sathish
	 * @return {@link Step}
	 * 
	 */

	@Bean
	public Step createBankStep() {
		return stepBuilderFactory.get("createBankStep").chunk(1).reader(bankItemReader.getBankDetails())
				.processor((ItemProcessor) bankItemProcessor).writer(bankItemWriter.saveBankDetails()).build();
	}

	/**
	 * This Method is Use to Create the Bank Job
	 * 
	 * @author Sathish
	 * @return {@link Job}
	 * 
	 */

	@Bean
	public Job createBankJob() {
		return jobBuilderFactory.get("createBankJob").incrementer(new RunIdIncrementer()).flow(createBankStep()).end()
				.build();
	}// method

}// class
