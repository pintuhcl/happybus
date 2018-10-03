/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Card_Type;

/**
 * This interface is used to Writing the Card_Type Details of Common Wealth Card_Type from
 * Database
 * 
 * @author Rashmi
 * @since CBABE 1.0
 */
public interface Card_TypeItemWriter {
	/**
	 * This method is used to save the Card_Type Details of Common Wealth Card_Type from
	 * Database
	 * 
	 * @return ItemWriterr<Card_Type>
	 */
	public ItemWriter<Card_Type> saveCard_TypeDetails();
}
