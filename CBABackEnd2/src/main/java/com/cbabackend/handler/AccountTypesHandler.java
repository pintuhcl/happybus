  /*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.handler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
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
 * This class is used to hold accountTypes job Starting data
 * 
 * @author anitha
 * @since CBABE 1.0
 */

@Controller
public class AccountTypesHandler {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	@Qualifier("createAccountTypesJob")
	private Job accountTypesJob;
	
	/**
	 * This Method is use to run the accounttypes job
	 * 
	 * @return ModelAndView
	 * 
	 */
	@RequestMapping(value = "accountTypesJob", method = RequestMethod.GET)
	public ModelAndView runAccountTypesJob() {
		String status = "";
		try {
			jobLauncher.run(accountTypesJob, new JobParameters());
			status = "AccountTypesJob Job Executed Successfully";
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			status = "AccountTypes Job Not Executed Successfully";
		}
		return new ModelAndView("home", "status", status);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
