/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Branch;
import com.cbabackend.beans.WorkingHours;

/**
 * This class is used to get the Working-Hours Details of Common Wealth Bank
 * from FlatFiles.
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
@Service
public class WorkingHoursItemProcessor implements ItemProcessor<WorkingHours, WorkingHours> {
	/**
	 * This method is used to get the Working-Hours Details of Common Wealth
	 * Bank from FlatFiles.
	 * 
	 * @author Sathish.Bandi
	 * @return {@link WorkingHours}
	 * 
	 */
	@Override
	public WorkingHours process(WorkingHours workingHours) throws Exception {

		return workingHours;
	}
}
