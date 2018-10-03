package com.nit;

import java.util.Date;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
public class HelloExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloExampleApplication.class, args);
	}
	
}
