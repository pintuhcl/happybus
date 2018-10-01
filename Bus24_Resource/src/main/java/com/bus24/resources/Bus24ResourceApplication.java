package com.bus24.resources;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={
	"com.bus24.resources","com.bus24.jobs","com.bus24.service","com.bus24.dao","com.bus24.integration","com.bus24.integration.cfg"	
})
@EnableBatchProcessing
public class Bus24ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bus24ResourceApplication.class, args);
	}
}
