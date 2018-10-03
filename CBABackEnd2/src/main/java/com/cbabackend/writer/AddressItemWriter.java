/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.Address;

/**
 * This interface is used to Writing the Address Details of Common Wealth Address from
 * Database
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface AddressItemWriter {
	/**
	 * This method is used to save the Address Details of Common Wealth Address from
	 * Database
	 * 
	 * @return ItemWriterr<Address>
	 */
	public ItemWriter<Address> saveAddressDetails();
}