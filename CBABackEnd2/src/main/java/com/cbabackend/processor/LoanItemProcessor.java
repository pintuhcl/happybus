/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cbabackend.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.cbabackend.beans.Branch;
import com.cbabackend.beans.Loan;

/**
 * This class is used to get the Loan Details of Common Wealth Bank from
 * FlatFiles.
 * 
 * @author Anitha
 * @since CBABE 1.0
 */
@Service
public class LoanItemProcessor  implements ItemProcessor<Loan, Loan>  {

	/**
	 * This method is used to get the Loan Details of Common Wealth Bank from
	 * FlatFiles.
	 * 
	 * @author Anitha
	 * @return {@link Loan}
	 * 
	 */
	@Override
	public Loan process(Loan loan) throws Exception {
		loan.setLoan_Id(loan.getLoan_Id());
		loan.setintrest_rate(loan.getintrest_rate());
		loan.setStart_Date(loan.getStart_Date());
		loan.setLoan_type_Id(loan.getLoan_type_Id());
		return loan;
	}

}
