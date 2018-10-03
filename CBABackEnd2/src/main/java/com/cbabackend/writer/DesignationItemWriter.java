/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Designation;

/**
 * This interface is used to Writing the Designation Details of Common Wealth Designation from
 * Database
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface DesignationItemWriter {
	/**
	 * This method is used to save the Designation Details of Common Wealth Designation from
	 * Database
	 * 
	 * @return ItemWriterr<Designation>
	 */
	public ItemWriter<Designation> saveDesignationDetails();
}
