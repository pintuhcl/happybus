package com.nit.jobs;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class OtpBeanItemReader implements ItemReader<OtpBean>{

	@Override
	public OtpBean read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	System.out.println("read() ");
		return new OtpBean();
	}

}
