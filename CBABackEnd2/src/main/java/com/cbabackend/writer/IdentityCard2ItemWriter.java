/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.IdentityCard2;

/**
 * This interface is used to Writing the IdentityCard2 Details of Common Wealth IdentityCard2 from
 * Database
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface IdentityCard2ItemWriter {
	/**
	 * This method is used to save the IdentityCard2 Details of Common Wealth IdentityCard2 from
	 * Database
	 * 
	 * @return ItemWriterr<IdentityCard2>
	 */
	public ItemWriter<IdentityCard2> saveIdentityCard2Details();
}
