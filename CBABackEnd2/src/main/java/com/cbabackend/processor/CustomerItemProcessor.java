/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Customer;

/**
 * This class is used to get the Customer Details of Common Wealth Customer from
 * FlatFiles.
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */
@Service
public class CustomerItemProcessor implements ItemProcessor<Customer, Customer> {
	private Logger logger = Logger.getLogger(CustomerItemProcessor.class);

	/**
	 * This method is used to get the Customer Details of Common Wealth Customer from
	 * FlatFiles
	 * 
	 * @author Rashmi
	 * @return {@link Customer}
	 * 
	 */
	@Override
	public Customer process(Customer Customer) throws Exception {
		Customer.setCustomerId(Customer.getCustomerId());
		logger.info("Customer Details : " + Customer.getCustomerId() + " ");
		return Customer;
	}

}
