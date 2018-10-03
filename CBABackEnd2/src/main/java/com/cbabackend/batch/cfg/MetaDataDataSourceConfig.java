/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.batch.cfg;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.SimpleJobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.JdbcExecutionContextDao;
import org.springframework.batch.core.repository.dao.JdbcJobExecutionDao;
import org.springframework.batch.core.repository.dao.JdbcJobInstanceDao;
import org.springframework.batch.core.repository.dao.JdbcStepExecutionDao;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * This class is Use to Meta-Data DataSource Configuration
 * 
 * @author Sathish
 * @since CBABE 1.0
 * @version 1.0
 *
 */
@Configuration
public class MetaDataDataSourceConfig implements BatchConfigurer {
	/**
	 * This Method is Use to Create Meta-Data DataSource
	 * 
	 * @author Sathish
	 * @return {@link DataSourceBuilder}
	 * 
	 */

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.batch.meta-data")
	public DataSource createMetaDatadataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * This Method is Use to Create Data-Source Transaction Manager Object
	 * 
	 * @author Sathish
	 * @return {@link DataSourceTransactionManager}
	 * 
	 */

	@Override
	public PlatformTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(createMetaDatadataSource());
	}// method

	/**
	 * This Method is Use to Create the Job-Explorer to get the pre-Define
	 * JDBC-DAO
	 * 
	 * @author Sathish
	 * @return {@link SimpleJobExplorer}
	 * 
	 */

	@Override
	public JobExplorer getJobExplorer() throws Exception {

		return new SimpleJobExplorer(new JdbcJobInstanceDao(), new JdbcJobExecutionDao(), new JdbcStepExecutionDao(),
				new JdbcExecutionContextDao());
	}

	/**
	 * This Method is Use to Create Job Launcher And Set the Job-Repository
	 * 
	 * @author Sathish
	 * @return {@link JobLauncher}
	 * 
	 */
	@Override
	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLuancher = new SimpleJobLauncher();
		jobLuancher.setJobRepository(getJobRepository());
		jobLuancher.afterPropertiesSet();
		return jobLuancher;
	}

	/**
	 * This Method is Use to Create Job Repository And Set the
	 * Data-Source,Transaction-Manager
	 * 
	 * @author Sathish
	 * @return {@link JobRepository}
	 * 
	 */

	@Override
	public JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean jobFactoryBean = new JobRepositoryFactoryBean();
		jobFactoryBean.setDataSource(createMetaDatadataSource());
		jobFactoryBean.setTransactionManager(getTransactionManager());
		jobFactoryBean.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
		// jobFactoryBean.setValidateTransactionState(false);
		jobFactoryBean.afterPropertiesSet();
		return jobFactoryBean.getObject();
	}// method

}// class
