/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.reader;
/**
 * This interface is used to get the Nominee Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Rahul M
 * @since CBABE 1.0
 */

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Nominee;

/**
 * This method is used to get the Nominee Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @return ItemReader<Nominee>
 */

public interface NomineeItemReader {

	public ItemReader<Nominee> getNomineeDetails();

}
