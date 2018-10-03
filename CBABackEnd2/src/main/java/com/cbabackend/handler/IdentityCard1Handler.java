/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.handler;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class is used to IdentityCard1Handler Job Execution  
 * 
 * @author Chandni
 * @since CBABE 1.0
 * 
 */
@Controller
public class IdentityCard1Handler {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	@Qualifier("createIdentityCard1Job")
	private Job IdentityCard1Job;
	
	/*@Autowired
	@Qualifier("txmgr")
	private PlatformTransactionManager txmgr;*/
	
	/**
	 * This Method is use to run the IdentityCard1 job 
	 * 
	 * @return ModelAndView   
	 * 
	 */
    @RequestMapping(value="IdentityCard1Job",method=RequestMethod.GET)
   // @Transactional(value="txmgr",propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public ModelAndView runIdentityCard1Job(){
		String status="";
    	try {
			jobLauncher.run(IdentityCard1Job,new JobParametersBuilder().addLong("IdentityCard1Job",System.currentTimeMillis()).toJobParameters());
		status="IdentityCard1 Job Executed Successfully Completed";
    	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
		status="IdentityCard1 Job Not Executed Successfully";	
		e.printStackTrace();
		}
	return 	new ModelAndView("home","status",status);
	}
}
