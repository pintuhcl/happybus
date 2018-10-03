package com.nit.jobs;

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
import org.springframework.batch.core.JobParametersBuilder;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.MethodInvoker;



@Configuration
public class BatchConfiguration {
    @Autowired
	private Job job;
     @Autowired
    private JobLauncher jobLauncher;
     /*@Autowired
     private StepBuilderFactory stepBuilderFactory;*/
    @Autowired
     private DataSource dataSource;
     
@Bean
	public  ItemWriter<OtpBean> otpItemWriter(DataSource dataSource){
JdbcBatchItemWriter<OtpBean> batchItemWriter=new
JdbcBatchItemWriter<>();
  
   //batchItemWriter.setDataSource(dataSource);
  NamedParameterJdbcOperations jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
 batchItemWriter.setJdbcTemplate(jdbcTemplate);
 String SQL_DELETE_OTP = "delete from otplog where generated_time<=(sysdate-?)";
  batchItemWriter.setSql(SQL_DELETE_OTP);
   batchItemWriter.setItemPreparedStatementSetter
   (new ItemPreparedStatementSetter<OtpBean>(){

	@Override
	public void setValues(OtpBean bean, PreparedStatement pst) throws SQLException {
	pst.setInt(1,2);
	System.out.println("after values setting to pst ");
		}
   });
  
    return batchItemWriter;
	}
	
	 @Bean
	 
	   public  Step createOtpStep(StepBuilderFactory stepBuilderFactory) {
		 
		Step s=  stepBuilderFactory.get("createOtpStep").<OtpBean,OtpBean>chunk(1).reader(new OtpBeanItemReader()).processor(new OtpBeanItemProcessor()).writer((ItemWriter<? super OtpBean>) otpItemWriter(dataSource)).build();
	  
	 return s;
	 }
	   
	   @Bean
	   public  Job createOtpJob(JobBuilderFactory factory,Step step){
		    
		  return factory.get("createOtpJob").incrementer(new RunIdIncrementer()).flow(step).end().build();
	   }
	 @Scheduled(cron="0 30 18 * * *")   //seconds
	 //  @Scheduled(fixedDelay=600000)
	   void launchOtpJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, org.springframework.batch.core.repository.JobRestartException {
	       System.out.println("Starting otp job ");
	     /*  JobParametersBuilder builder = new JobParametersBuilder();
	       builder.addDate("date", new Date());*/
	      
	       jobLauncher.run(job, new JobParameters());
            
	    }
	  /*  private JobParameters newExecution() {
	        Map<String, JobParameter> parameters = new HashMap<>();

	        JobParameter parameter = new JobParameter(new Date());
	        parameters.put("currentTime", parameter);

	        return new JobParameters(parameters);
	    }*/
}
