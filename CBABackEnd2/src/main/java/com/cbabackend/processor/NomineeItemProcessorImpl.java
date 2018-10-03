/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.processor;

import org.jboss.logging.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Nominee;

/**
 * This class is used to get the Nominee Details of Common Wealth Bank from
 * FlatFiles.
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 */
@Service
public class NomineeItemProcessorImpl implements ItemProcessor<Nominee, Nominee> {

	Logger logger = Logger.getLogger(NomineeItemProcessorImpl.class);

	/**
	 * This method is used to get the Bank Details of Common Wealth Bank from
	 * FlatFiles
	 * 
	 * @author Rahul Malgujar
	 * @return {@link Bank}
	 * 
	 */
	@Override
	public Nominee process(Nominee nominee) throws Exception {

		nominee.setNomineeId(nominee.getNomineeId());
		nominee.setNomineeName(nominee.getNomineeName().toUpperCase());
		nominee.setNomineeDOB(nominee.getNomineeDOB());
		nominee.setGender(nominee.getGender().toUpperCase());
		nominee.setRelationship(nominee.getRelationship().toUpperCase());
		nominee.setAddress(nominee.getAddress().toUpperCase());
		nominee.setCreateDate(nominee.getCreateDate());
		nominee.setCreatedBy(nominee.getCreatedBy());
		nominee.setLastModifiedDate(nominee.getLastModifiedDate());
		nominee.setLastModifiedBy(nominee.getLastModifiedBy());

		logger.info("Nominee Details:: " + nominee.getClass());
		return nominee;

	}// process(-)
}// class
