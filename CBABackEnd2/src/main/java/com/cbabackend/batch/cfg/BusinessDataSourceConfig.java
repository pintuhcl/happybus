/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.batch.cfg;

/**
 * This class is Use to Get The Business Data Source Configuration
 * 
 * @author Sathish
 * @since CBABE 1.0
 * @version 1.0
 * 
 */
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

public class BusinessDataSourceConfig {

	/**
	 * This Method is Use to Create Data Source
	 * 
	 * @author Sathish
	 * @return {@link DataSource}
	 * 
	 */
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.ds")
	public DataSource createDataSource() {
		return DataSourceBuilder.create().build();
	}// method
}// class
