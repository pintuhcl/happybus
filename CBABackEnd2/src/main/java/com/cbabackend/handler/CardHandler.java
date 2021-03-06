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
 * This class is used to NomineHandler Job Execution
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 * 
 */
@Controller
public class CardHandler {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("createCardJob")
	private Job CardJob;

	/**
	 * This Method is use to run the Card job
	 * 
	 * @return ModelAndView
	 * 
	 */
	@RequestMapping(value = "CardJob", method = RequestMethod.GET)

	public ModelAndView runCardJob() {
		String status = "";

		try {
			jobLauncher.run(CardJob,
					new JobParametersBuilder().addLong("CardJob", System.currentTimeMillis()).toJobParameters());
			status = "Card Job Executed Successfully Completed";
		} // try

		catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			status = "Card Job Not Executed Successfully";
			e.printStackTrace();
		} // catch

		return new ModelAndView("home", "status", status);
	}// runCardJob()
}//class
