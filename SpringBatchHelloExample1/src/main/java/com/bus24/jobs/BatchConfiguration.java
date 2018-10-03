package com.bus24.jobs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.batch.operations.JobRestartException;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.MethodInvoker;

import com.bus24.beans.OtpBean;
import com.bus24.dao.util.SQLConstants;

@Configuration
public class BatchConfiguration {

@Bean
	public  ItemWriter<OtpBean> otpItemWriter(DataSource dataSource){
JdbcBatchItemWriter<OtpBean> batchItemWriter=new
JdbcBatchItemWriter<>();
  try{
   batchItemWriter.setDataSource(dataSource);
    batchItemWriter.setSql(SQLConstants.SQL_DELETE_OTP);
   batchItemWriter.setItemPreparedStatementSetter
   (new ItemPreparedStatementSetter<OtpBean>(){

	@Override
	public void setValues(OtpBean bean, PreparedStatement pst) throws SQLException {
	pst.setInt(1,2);
		}
   });
  }catch(EmptyResultDataAccessException de){
	 System.out.println("Rows Not Found"); 
  }
    return batchItemWriter;
	}
	
	 @Bean
	 
	   public static Step createOtpStep(ItemWriter<?> itemWriter,
	                              StepBuilderFactory stepBuilderFactory) {
		 
		Step s=  stepBuilderFactory.get("createOtpStep").<OtpBean,OtpBean>chunk(1).reader(new OtpBeanItemReader()).processor(new OtpBeanItemProcessor()).writer((ItemWriter<? super OtpBean>) itemWriter).build();
	  
	 return s;
	 }
	   
	   @Bean
	   public static Job createOtpJob(JobBuilderFactory factory,Step step){
		    
		  return factory.get("createOtpJob").flow(step).end().build();
	   }
	  @Scheduled(cron="*/59*/35*/19* * *")   //seconds
	 //  @Scheduled(fixedDelay=65000)
	   void launchOtpJob(Job job,JobLauncher jobLauncher) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, org.springframework.batch.core.repository.JobRestartException {
	       System.out.println("Starting otp job ");
     
	        jobLauncher.run(job, newExecution());
            
	    }
	    private JobParameters newExecution() {
	        Map<String, JobParameter> parameters = new HashMap<>();

	        JobParameter parameter = new JobParameter(new Date());
	        parameters.put("currentTime", parameter);

	        return new JobParameters(parameters);
	    }
}
