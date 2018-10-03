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

import com.cbabackend.processor.IdentityCard3ItemProcessor;
import com.cbabackend.reader.IdentityCard3ItemReader;
import com.cbabackend.writer.IdentityCard3ItemWriter;

/**
 * This class is Use to IdentityCard3 Job Configurations
 * 
 * @author Chandni
 * @since CBABE 1.0
 * @version 1.0
 */
@SuppressWarnings("unused")
@Configuration
public class IdentityCard3Jobs {
	@Autowired
	private IdentityCard3ItemWriter identityCard3ItemWriter;
	@Autowired
	private IdentityCard3ItemReader identityCard3ItemReader;
	@Autowired
	private IdentityCard3ItemProcessor identityCard3ItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the IdentityCard3 Step
	 * 
	 * @author Chandni
	 * @return {@link Step}
	 * 
	 */

	@Bean
	public Step createIdentityCard3Step() {
		return stepBuilderFactory.get("createIdentityCard3Step").chunk(1).reader(identityCard3ItemReader.getIdentityCard3Details())
				.processor((ItemProcessor) identityCard3ItemProcessor).writer(identityCard3ItemWriter.saveIdentityCard2Details()).build();
	}

	/**
	 * This Method is Use to Create the IdentityCard3 Job
	 * 
	 * @author Chandni
	 * @return {@link Job}
	 * 
	 */

	@Bean
	public Job createIdentityCard3Job() {
		return jobBuilderFactory.get("createIdentityCard3Job").incrementer(new RunIdIncrementer()).flow(createIdentityCard3Step()).end()
				.build();
	}// method

}// class
