/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.IdentityCard1;

/**
 * This interface is used to Writing the IdentityCard1 Details of Common Wealth IdentityCard1 from
 * Database
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface IdentityCard1ItemWriter {
	/**
	 * This method is used to save the IdentityCard1 Details of Common Wealth IdentityCard1 from
	 * Database
	 * 
	 * @return ItemWriterr<IdentityCard1>
	 */
	public ItemWriter<IdentityCard1> saveIdentityCard1Details();
}
