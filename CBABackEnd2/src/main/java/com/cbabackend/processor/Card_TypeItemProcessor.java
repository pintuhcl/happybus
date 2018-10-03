/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Card_Type;

/**
 * This class is used to get the Card_Type Details of Common Wealth Card_Type from
 * FlatFiles.
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */
@Service
public class Card_TypeItemProcessor implements ItemProcessor<Card_Type, Card_Type> {
	private Logger logger = Logger.getLogger(Card_TypeItemProcessor.class);

	/**
	 * This method is used to get the Card_Type Details of Common Wealth Card_Type from
	 * FlatFiles
	 * 
	 * @author Rashmi
	 * @return {@link Card_Type}
	 * 
	 */
	@Override
	public Card_Type process(Card_Type Card_Type) throws Exception {
		Card_Type.setCardTypeName(Card_Type.getCardTypeName().toUpperCase());
		logger.info("Card_Type Details : " + Card_Type.getCardTypeName() + " ");
		return Card_Type;
	}

}
