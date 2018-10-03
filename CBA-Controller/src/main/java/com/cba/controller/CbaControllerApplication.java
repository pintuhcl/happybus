package com.cba.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages={
	"com.cba.security",
"com.cba.controller",
"com.cba.processing","com.cba.dao","com.cba.advices",
"com.cba.integration"
})
@EnableAspectJAutoProxy
public class CbaControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbaControllerApplication.class, args);
	}
}
