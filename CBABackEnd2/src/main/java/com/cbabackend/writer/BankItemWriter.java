/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Bank;

/**
 * This interface is used to Writing the Bank Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface BankItemWriter {
	/**
	 * This method is used to save the Bank Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriterr<Bank>
	 */
	public ItemWriter<Bank> saveBankDetails();
}
