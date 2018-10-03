package com.cbabackend.batch.cfg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.adapter.ItemWriterAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cbabackend.processor.AccountTransactionProcessor;
import com.cbabackend.reader.AccountTransactionReader;


@Configuration
public class AccountTransactionsJobs {
	@Autowired
private AccountTransactionReader accountTransactionReader;
  @Autowired
private AccountTransactionProcessor accountTransactionProcessor;
@Autowired
 private StepBuilderFactory stepBuilderFactory;
@Autowired
private JobBuilderFactory jobBuilderFactory;
@Bean
public Step createAccountTransactionsStep(){
	return stepBuilderFactory.get("createAccountTransactionsStep").chunk(1).reader(accountTransactionReader.getAccountTransactionsDetails())
			.processor((ItemProcessor)accountTransactionProcessor ).writer(new ItemWriterAdapter<>()).build();
}
@Bean
public Job createAccountTransactionsJob(){
	return jobBuilderFactory.get("createAccountTransactionsJob").flow(createAccountTransactionsStep()).end().build();
}

}
