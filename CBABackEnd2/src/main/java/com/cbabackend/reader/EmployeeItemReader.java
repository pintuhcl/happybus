
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Employee;

/**
 * This interface is used to get the Employee Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface EmployeeItemReader {
	/**
	 * This method is used to get the Employee Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Employee>
	 */
	public ItemReader<Employee> getEmployeeDetails();
}
