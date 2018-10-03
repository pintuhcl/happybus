package com.nit.cfg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Scheduled;

import com.nit.batch.StudentProcessor;
import com.nit.batch.StudentWriter;
import com.nit.domain.Student;
import com.thoughtworks.xstream.core.util.Pool.Factory;

@Configuration
public class MyBeans {
	
	
   @Bean(name="itemReader")
	public ItemReader<Student> readStudentFromCSVFile(){
		FlatFileItemReader<Student> fileItemReader=new
				FlatFileItemReader<>();
		fileItemReader.setResource(new FileSystemResource("E://sathish/project6pm/files/student.csv"));
	   fileItemReader.setLinesToSkip(1);
	   
	   fileItemReader.setLineMapper(createLineMapper());
	   return fileItemReader;
   }
   public LineMapper<Student> createLineMapper(){
	DefaultLineMapper<Student> lineMapper=new
			DefaultLineMapper<>();
     lineMapper.setLineTokenizer(createLineTokenizer());
    lineMapper.setFieldSetMapper(createStudentInfoMapper());	
	return lineMapper;
   }
   public LineTokenizer createLineTokenizer(){
	   DelimitedLineTokenizer studentLineTokenizer 
	   = new DelimitedLineTokenizer();
       studentLineTokenizer.setDelimiter(";");
       studentLineTokenizer.setNames(new String[]{"name", "email", "course"});
       return studentLineTokenizer;
   }
   
   public FieldSetMapper<Student> createStudentInfoMapper(){
	   BeanWrapperFieldSetMapper<Student> studentInformationMapper = new BeanWrapperFieldSetMapper<>();
       studentInformationMapper.setTargetType(Student.class);
       return studentInformationMapper;
   }
   
   
   @Bean
  public ItemProcessor<Student,Student> fileItemProcessor() {
       return new  StudentProcessor();
   }
   @Bean
   ItemWriter<Student> fileItemWriter() {
       return new StudentWriter();
   }
   @Bean
   public static Step createStep(ItemReader<Student> itemReader,
                              ItemProcessor itemProcessor,
                              ItemWriter itemWriter,
                              StepBuilderFactory stepBuilderFactory) {
	return   stepBuilderFactory.get("createStep").chunk(1).reader(itemReader).processor(itemProcessor).writer(itemWriter).build();
   }
   
   @Bean
   public static Job createJob(JobBuilderFactory factory,Step step){
	   
	  return factory.get("createJob").incrementer(new RunIdIncrementer()).
			  
			  flow(step).end().build();
   }
   
}





