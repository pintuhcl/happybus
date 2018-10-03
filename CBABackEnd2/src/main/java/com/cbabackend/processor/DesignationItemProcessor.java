/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Designation;

/**
 * This class is used to get the Designation Details of Common Wealth Designation from
 * FlatFiles.
 * 
 * @author Chandni
 * @since CBABE 1.0
 */
@Service
public class DesignationItemProcessor implements ItemProcessor<Designation, Designation> {
	private Logger logger = Logger.getLogger(DesignationItemProcessor.class);

	/**
	 * This method is used to get the Designation Details of Common Wealth Designation from
	 * FlatFiles
	 * 
	 * @author Chandni
	 * @return {@link Designation}
	 * 
	 */
	@Override
	public Designation process(Designation Designation) throws Exception {
		Designation.setDesignationTitle(Designation.getDesignationTitle().toUpperCase());
		logger.info("Designation Details : " + Designation.getDesignationTitle() + " ");
		return Designation;
	}

}
