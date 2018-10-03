package com.nit.cfg;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.batch.operations.JobRestartException;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class JobLancherCfg {
	private Job job;
	private JobLauncher jobLauncher;
   @Autowired
	public JobLancherCfg(Job job,JobLauncher jobLauncher) {
		this.job=job;
		this.jobLauncher=jobLauncher;
	}
	
    @Scheduled(fixedRate=30)   //milliseconds
    void launchJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, org.springframework.batch.core.repository.JobRestartException {
       System.out.println("Starting csvFile Reading job");

        jobLauncher.run(job, newExecution());

    }
    private JobParameters newExecution() {
        Map<String, JobParameter> parameters = new HashMap<>();

        JobParameter parameter = new JobParameter(new Date());
        parameters.put("currentTime", parameter);

        return new JobParameters(parameters);
    }

}
