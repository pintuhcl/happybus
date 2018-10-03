/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Region;

/**
 * This interface is used to get the Region Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface RegionItemReader {
	/**
	 * This method is used to get the Region Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @return ItemReader<Region>
	 */
	public ItemReader<Region> getRegionDetails();
}
