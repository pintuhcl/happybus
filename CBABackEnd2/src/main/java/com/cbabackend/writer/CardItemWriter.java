/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Card;

/**
 * This interface is used to Write the Card Details of Common Wealth Bank from
 * Database m.
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 */

public interface CardItemWriter {

	/**
	 * This method is used to save the Bank Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriterr<Bank>
	 */

	public ItemWriter<Card> saveCardDetails();

}// class
