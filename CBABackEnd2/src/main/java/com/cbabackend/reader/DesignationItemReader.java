
/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Designation;

/**
 * This interface is used to get the Designation Details of Common Wealth Designation from
 * FlatFiles
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
public interface DesignationItemReader {
	/**
	 * This method is used to get the Designation Details of Common Wealth Designation from
	 * FlatFiles
	 * 
	 * @return ItemReader<Designation>
	 */
	public ItemReader<Designation> getDesignationDetails();
}
