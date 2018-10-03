/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.IdentityCard1;

/**
 * This class is used to get the IdentityCard1 Details of Common Wealth IdentityCard1 from
 * FlatFiles.
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
@Service
public class IdentityCard1ItemProcessor implements ItemProcessor<IdentityCard1, IdentityCard1> {
	private Logger logger = Logger.getLogger(IdentityCard1ItemProcessor.class);

	/**
	 * This method is used to get the IdentityCard1 Details of Common Wealth IdentityCard1 from
	 * FlatFiles
	 * 
	 * @author Chandni
	 * @return {@link IdentityCard1}
	 * 
	 */
	@Override
	public IdentityCard1 process(IdentityCard1 IdentityCard1) throws Exception {
		IdentityCard1.setIdCardNumber(IdentityCard1.getIdCardNumber().toUpperCase());
		logger.info("IdentityCard1 Details : " + IdentityCard1.getIdCardNumber() + " ");
		return IdentityCard1;
	}

}
