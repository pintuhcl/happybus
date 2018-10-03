/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Bank;

/**
 * This class is used to get the Bank Details of Common Wealth Bank from
 * FlatFiles.
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Service
public class BankItemProcessor implements ItemProcessor<Bank, Bank> {
	private Logger logger = Logger.getLogger(BankItemProcessor.class);

	/**
	 * This method is used to get the Bank Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @author Sathish.Bandi
	 * @return {@link Bank}
	 * 
	 */
	@Override
	public Bank process(Bank bank) throws Exception {
		bank.setBankName(bank.getBankName().toUpperCase());
		logger.info("Bank Details : " + bank.getBankName() + " ");
		return bank;
	}

}
