/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.Employee;

/**
 * This class is used to get the Employee Details of Common Wealth Bank from
 * FlatFiles
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Repository
public class EmployeeItemReaderImpl implements EmployeeItemReader {
	/**
	 * This method is used to get the Employee Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Employee>
	 */
	@Value("${ftp.url}")
	String ftpURL;
	@Value("${ftp.host}")
	String host;
	@Value("${ftp.username}")
	String username;
	@Value("${ftp.password}")
	String password;
	@Value("${ftp.employee.path}")
	String filePath;
	public ItemReader<Employee> getEmployeeDetails() {
		FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<>();

		try {
	
	String ftpURL="ftp://%s:%s@%s/%s";
	String host="ORCL";
	String username="nareshit";
	String password="sathish";
	String filePath="employee.csv";
	

	ftpURL=String.format(ftpURL,username,password,host,filePath);
			itemReader.setResource(new UrlResource(new URL(ftpURL)));
	
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		//itemReader.setResource(new FileSystemResource("D:/WorkSpace/FinalNitWithTeam/cba_flat_files/employee.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createEmployeeLineMapper());
		System.out.println(new Employee().getEmployeeId());
		
		return itemReader;
	}

	/**
	 * This method is used to Create the LineMapper Object
	 * 
	 * @return LineMapper<Employee>
	 */
	private LineMapper<Employee> createEmployeeLineMapper() {
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(createEmployeeFieldSetMapper());
		lineMapper.setLineTokenizer(createEmployeeLineTokenizer());
		return lineMapper;
	}

	/**
	 * This method is used to Create the FieldSetMapper Object
	 * 
	 * @return FieldSetMapper<Employee>
	 */
	private FieldSetMapper<Employee> createEmployeeFieldSetMapper() {
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Employee.class);
		return fieldSetMapper;
	}
	/**
	 * This method is used to Create the LineTokenizer Object And Separated Employee 
	 * Data By Using ';' (Semicolon)   
	 * 
	 * @return LineTokenizer
	 */
	private LineTokenizer createEmployeeLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "employee_id","branch_id","date_of_joining","salary","first_name","last_name","middle_name","address1","address2","email","phone","mobile","gender","dob","created_date","created_by","job_title","job_description" });
		return lineTokenizer;
	}
}//