/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import org.springframework.batch.item.ItemWriter;

import com.cbabackend.beans.WorkingHours;

/**
 * This interface is used to Writing the WorkingHours Details of Common Wealth
 * Bank from Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 */
public interface WorkingHoursItemWriter {
	/**
	 * This method is used to save the WorkingHours Details of Common Wealth
	 * Bank from Database
	 * 
	 * @return ItemWriterr<WorkingHours>
	 */
	public ItemWriter<WorkingHours> saveWorkingHours();
}
