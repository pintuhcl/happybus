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

import com.cbabackend.processor.IdentityCard1ItemProcessor;
import com.cbabackend.reader.IdentityCard1ItemReader;
import com.cbabackend.writer.IdentityCard1ItemWriter;

/**
 * This class is Use to IdentityCard1 Job Configurations
 * 
 * @author Chandni
 * @since CBABE 1.0
 * @version 1.0
 */
@SuppressWarnings("unused")
@Configuration
public class IdentityCard1Jobs {
	@Autowired
	private IdentityCard1ItemWriter IdentityCard1ItemWriter;
	@Autowired
	private IdentityCard1ItemReader IdentityCard1ItemReader;
	@Autowired
	private IdentityCard1ItemProcessor IdentityCard1ItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the IdentityCard1 Step
	 * 
	 * @author Chandni
	 * @return {@link Step}
	 * 
	 */

	@Bean
	public Step createIdentityCard1Step() {
		return stepBuilderFactory.get("createIdentityCard1Step").chunk(1).reader(IdentityCard1ItemReader.getIdentityCard1Details())
				.processor((ItemProcessor)IdentityCard1ItemProcessor).writer(IdentityCard1ItemWriter.saveIdentityCard1Details()).build();
	}

	/**
	 * This Method is Use to Create the IdentityCard1 Job
	 * 
	 * @author Chandni
	 * @return {@link Job}
	 * 
	 */

	@Bean
	public Job createIdentityCard1Job() {
		return jobBuilderFactory.get("createIdentityCard1Job").incrementer(new RunIdIncrementer()).flow(createIdentityCard1Step()).end()
				.build();
	}// method

}// class
