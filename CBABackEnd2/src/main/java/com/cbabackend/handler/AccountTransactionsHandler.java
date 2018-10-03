package com.cbabackend.handler;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.batch.core.Job;
import org.springframework.stereotype.Controller;

@Controller
public class AccountTransactionsHandler {
   @Autowired
   @Qualifier("createAccountTransactionsJob")
	private Job transactionsJob;
    @Autowired
  private JobLauncher jobLauncher;
    @Scheduled(cron="0 0 23 MON-SAT * *")
	public void runAccountTransactionsJob(){
		try {
			jobLauncher.run(transactionsJob,new JobParametersBuilder().addLong("transactionsJob",System.currentTimeMillis()).toJobParameters());
		} catch (JobExecutionAlreadyRunningException e) {
		
			e.printStackTrace();
		} catch (JobRestartException e) {
		
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
		
			e.printStackTrace();
		}
		
	}
}
