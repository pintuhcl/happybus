
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.IdentityCard1;
import com.cbabackend.beans.IdentityCard2;

/**
 * This interface is used to get the IdentityCard1 Details of Common Wealth IdentityCard1 from
 * FlatFiles
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface IdentityCard2ItemReader {
	/**
	 * This method is used to get the IdentityCard1 Details of Common Wealth IdentityCard1 from
	 * FlatFiles
	 * 
	 * @return ItemReader<IdentityCard1>
	 */
	public ItemReader<IdentityCard2> getIdentityCard2Details();
}
