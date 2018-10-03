/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Customer;



/**
 * This interface is used to Writing the Customer Details of Common Wealth Customer from
 * Database
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */
public interface CustomerItemWriter {
	/**
	 * This method is used to save the Customer Details of Common Wealth Customer from
	 * Database
	 * 
	 * @return ItemWriterr<Customer>
	 */
	public ItemWriter<Customer> saveCustomerDetails();
}
