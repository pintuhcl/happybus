package com.bus24.jobs;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.bus24.beans.OtpBean;

public class OtpBeanItemReader implements ItemReader<OtpBean>{

	@Override
	public OtpBean read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	System.out.println("read() ");
		return new OtpBean();
	}

}
