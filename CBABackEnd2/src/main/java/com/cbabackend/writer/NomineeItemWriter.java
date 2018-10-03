/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Nominee;

/**
 * This interface is used to Writing the Nominee Details of Common Wealth Bank
 * from Database
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 */
public interface NomineeItemWriter {
	/**
	 * This method is used to save the Nominee Details of Common Wealth Bank
	 * from Database
	 * 
	 * @return ItemWriterr<Nominee>
	 */
	public ItemWriter<Nominee> saveNomineeDetails();
}
