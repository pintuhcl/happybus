
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Card_Type;



/**
 * This interface is used to get the Card_Type Details of Common Wealth Card_Type from
 * FlatFiles
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */
public interface Card_TypeItemReader {
	/**
	 * This method is used to get the Card_Type Details of Common Wealth Card_Type from
	 * FlatFiles
	 * 
	 * @return ItemReader<Card_Type>
	 */
	public ItemReader<Card_Type> getCard_TypeDetails();
}
