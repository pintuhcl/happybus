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

import com.cbabackend.processor.RegionItemProcessor;
import com.cbabackend.reader.RegionItemReader;
import com.cbabackend.writer.RegionItemWriter;

/**
 * This class is Use to Region Job Configurations
 * 
 * @author Sathish
 * @since CBABE 1.0
 * @version 1.0
 */
@Configuration
public class RegionJobs {
	@Autowired
	private RegionItemWriter regionItemWriter;
	@Autowired
	private RegionItemReader regionItemReader;
	@Autowired
	private RegionItemProcessor regionItemProcessor;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * This Method is Use to Create the Region Step
	 * 
	 * @author Sathish
	 * @return {@link Step}
	 * 
	 */
	@Bean
	public Step createRegionStep() {
		return stepBuilderFactory.get("createRegionStep").chunk(1).reader(regionItemReader.getRegionDetails())
				.processor((ItemProcessor) regionItemProcessor).writer(regionItemWriter.saveRegionDetails()).build();
	}

	/**
	 * This Method is Use to Create the Region Job
	 * 
	 * @author Sathish
	 * @return {@link Job}
	 * 
	 */
	@Bean
	public Job createRegionJob() {
		return jobBuilderFactory.get("createRegionJob").incrementer(new RunIdIncrementer()).flow(createRegionStep())
				.end().build();
	}

}
