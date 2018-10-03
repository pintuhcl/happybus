package com.nit.jobs;

import org.springframework.batch.item.ItemProcessor;


public class OtpBeanItemProcessor implements 
ItemProcessor<OtpBean,OtpBean>{

	@Override
	public OtpBean process(OtpBean otpBean) throws Exception {
		System.out.println("process() ");
		return otpBean;
	}

}
