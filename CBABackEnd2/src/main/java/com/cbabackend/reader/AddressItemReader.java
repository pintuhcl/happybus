
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Address;

/**
 * This interface is used to get the Address Details of Common Wealth Address from
 * FlatFiles
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface AddressItemReader {
	/**
	 * This method is used to get the Address Details of Common Wealth Address from
	 * FlatFiles
	 * 
	 * @return ItemReader<Address>
	 */
	public ItemReader<Address> getAddressDetails();
}
