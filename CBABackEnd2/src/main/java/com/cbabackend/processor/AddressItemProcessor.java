/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Address;

/**
 * This class is used to get the Address Details of Common Wealth Address from
 * FlatFiles.
 * 
 * @author chandni
 * @since CBABE 1.0
 */
@Service
public class AddressItemProcessor implements ItemProcessor<Address, Address> {
	private Logger logger = Logger.getLogger(AddressItemProcessor.class);

	/**
	 * This method is used to get the Address Details of Common Wealth Address from
	 * FlatFiles
	 * 
	 * @author Sathish.Bandi
	 * @return {@link Address}
	 * 
	 */
	@Override
	public Address process(Address address) throws Exception {
		address.setAddressId(address.getAddressId());
		logger.info("Address Details : " + address.getAddressId() + " ");
		address.setPermanentAddress(address.getPermanentAddress());
		logger.info("Address Details : " + address.getPermanentAddress() + " ");
		
		return address;
	}

}
