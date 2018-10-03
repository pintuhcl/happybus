/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Branch;

/**
 * This class is used to get the Branch Details of Common Wealth Bank from
 * FlatFiles.
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Service
public class BranchItemProcessor implements ItemProcessor<Branch, Branch> {

	/**
	 * This method is used to get the Branch Details of Common Wealth Bank from
	 * FlatFiles.
	 * 
	 * @author Sathish.Bandi
	 * @return {@link Branch}
	 * 
	 */
	@Override
	public Branch process(Branch branch) throws Exception {
		branch.setBranchName(branch.getBranchName().toUpperCase());
		branch.setCity(branch.getCity().toUpperCase());
		branch.setCountry(branch.getCountry().toUpperCase());
		branch.setState(branch.getState().toUpperCase());
		return branch;
	}
}
