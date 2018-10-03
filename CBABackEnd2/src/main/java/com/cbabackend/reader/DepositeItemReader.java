package com.cbabackend.reader;

import org.springframework.batch.item.ItemReader;

import com.cbabackend.beans.Bank;
import com.cbabackend.beans.Deposite;
import com.cbabackend.beans.Person;

/**
 * This interface is used to get the Deposite Details of Common Wealth Bank from
 * FlatFiles
 * 
 * @author Prateek.Shukla
 * @since CBABE 1.0
 */

public interface DepositeItemReader {
	
	public ItemReader<Deposite> getDepositeDetails();

}
