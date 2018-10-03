/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Deposite;

/**
 * This interface is used to Writing the Deposite Details of Common Wealth Deposite from
 * Database
 * 
 * @author Prateek.Shukla
 * @since CBABE 1.0
 */
public interface DepositeItemWriter {
	/**
	 * This method is used to save the Deposite Details of Common Wealth Deposite from
	 * Database
	 * 
	 * @return ItemWriterr<Deposite>
	 */
	public ItemWriter<Deposite> saveDepositeDetails();
}
