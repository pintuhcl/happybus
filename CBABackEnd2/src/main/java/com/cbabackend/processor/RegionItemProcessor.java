/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Branch;
import com.cbabackend.beans.Region;

/**
 * This class is used to get the Region Details of Common Wealth Bank from
 * FlatFiles.
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Service
public class RegionItemProcessor implements ItemProcessor<Region, Region> {

	/**
	 * This method is used to get the Region Details of Common Wealth Bank from
	 * FlatFiles.
	 * 
	 * @author Sathish.Bandi
	 * @return {@link Region}
	 * 
	 */
	@Override
	public Region process(Region region) throws Exception {
		region.setRegionName(region.getRegionName().toUpperCase());
		region.setRegionHeadOffice(region.getRegionHeadOffice().toUpperCase());
		return region;
	}

}
