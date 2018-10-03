/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Deposite;

/**
 * This class is used to get the Deposite Details of Common Wealth Deposite from
 * FlatFiles.
 * 
 * @author Prateek.Shukla
 * @since CBABE 1.0
 */
@Service
public class DepositeItemProcessor implements ItemProcessor<Deposite, Deposite> {
	private Logger logger = Logger.getLogger(DepositeItemProcessor.class);

	/**
	 * This method is used to get the Deposite Details of Common Wealth Deposite from
	 * FlatFiles
	 * 
	 * @author Sathish.Bandi
	 * @return {@link Deposite}
	 * 
	 */
	@Override
	public Deposite process(Deposite Deposite) throws Exception {
		Deposite.setDepositeTypeName(Deposite.getDepositeTypeName().toUpperCase());
		logger.info("Deposite Details : " + Deposite.getDepositeTypeName() + " ");
		return Deposite;
	}

}
