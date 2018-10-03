/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.handler;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class is used to Card_TypeHandler Job Execution  
 * 
 * @author Rashmi
 * @since CBABE 1.0
 * 
 */
@Controller
public class Card_TypeHandler {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	@Qualifier("createCard_TypeJob")
	private Job Card_TypeJob;
	
	/*@Autowired
	@Qualifier("txmgr")
	private PlatformTransactionManager txmgr;*/
	
	/**
	 * This Method is use to run the Card_Type job 
	 * 
	 * @return ModelAndView   
	 * 
	 */
    @RequestMapping(value="Card_TypeJob",method=RequestMethod.GET)
   // @Transactional(value="txmgr",propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public ModelAndView runCard_TypeJob(){
		String status="";
    	try {
			jobLauncher.run(Card_TypeJob,new JobParametersBuilder().addLong("Card_TypeJob",System.currentTimeMillis()).toJobParameters());
		status="Card_Type Job Executed Successfully Completed";
    	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
		status="Card_Type Job Not Executed Successfully";	
		e.printStackTrace();
		}
	return 	new ModelAndView("home","status",status);
	}
}
