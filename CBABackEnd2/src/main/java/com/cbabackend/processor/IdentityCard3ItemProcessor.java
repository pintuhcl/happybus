/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.IdentityCard2;

/**
 * This class is used to get the IdentityCard2 Details of Common Wealth IdentityCard2 from
 * FlatFiles.
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
@Service
public class IdentityCard3ItemProcessor implements ItemProcessor<IdentityCard2, IdentityCard2> {
	private Logger logger = Logger.getLogger(IdentityCard3ItemProcessor.class);

	/**
	 * This method is used to get the IdentityCard2 Details of Common Wealth IdentityCard2 from
	 * FlatFiles
	 * 
	 * @author Chandni
	 * @return {@link IdentityCard2}
	 * 
	 */
	@Override
	public IdentityCard2 process(IdentityCard2 IdentityCard2) throws Exception {
		IdentityCard2.setIdCardNumber(IdentityCard2.getIdCardNumber().toUpperCase());
		logger.info("IdentityCard2 Details : " + IdentityCard2.getIdCardNumber() + " ");
		return IdentityCard2;
	}

}
