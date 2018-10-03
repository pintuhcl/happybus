/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Employee;

/**
 * This class is used to get the Employee Details of Common Wealth Employee from
 * FlatFiles.
 * 
 * @author Nitin
 * @since CBABE 1.0
 */
@Service
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {
	private Logger logger = Logger.getLogger(EmployeeItemProcessor.class);

	/**
	 * This method is used to get the Employee Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @author Sathish.Bandi
	 * @return {@link Employee}
	 * 
	 */
	@Override
	public Employee process(Employee employee) throws Exception {
		employee.setFirst_name(employee.getFirst_name().toUpperCase());
		employee.setLast_name(employee.getLast_name().toUpperCase());
		employee.setMiddle_name(employee.getMiddle_name().toUpperCase());
		logger.info("Employee Details : " + employee.getFirst_name() + " ");
		return employee;
	}

}
