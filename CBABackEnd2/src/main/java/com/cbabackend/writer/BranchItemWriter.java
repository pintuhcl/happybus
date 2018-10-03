/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Branch;
/**
 * This interface is used to Writing the Branch Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface BranchItemWriter {
	/**
	 * This method is used to save the Branch Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriterr<Branch>
	 */
public ItemWriter<Branch> saveBranchDetails();
}
