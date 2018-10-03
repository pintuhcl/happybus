/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.cbabackend.batch.cfg.BusinessDataSourceConfig;
import com.cbabackend.batch.cfg.MetaDataDataSourceConfig;

/**
 * This class is Main Method Class it can be use Run the Spring Application
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * @version 1.0
 */

@ComponentScan(basePackages = { "com.cbabackend.handler", "com.cbabackend.processor", "com.cbabackend.reader",
		"com.cbabackend.writer", "com.cbabackend.batch.cfg" ,"com.cbabackend.dao"})
@SpringBootApplication
@Import({ MetaDataDataSourceConfig.class, BusinessDataSourceConfig.class })
@EnableBatchProcessing
public class CbaBackEndApplication {

	/**
	 * This Main method is use Run the Spring Application
	 * 
	 * @author Sathish.Bandi
	 * @return Void 
	 */
	public static void main(String[] args) {
		SpringApplication.run(CbaBackEndApplication.class, args);

	}
}
