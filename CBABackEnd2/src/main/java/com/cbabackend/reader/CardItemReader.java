/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Bank;
import com.cbabackend.beans.Card;

/**
 * This interface is used to get the Card Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 */
public interface CardItemReader {

	/**
	 * This method is used to get the Card Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Card>
	 */
	public ItemReader<Card> getCardDetails();
}
