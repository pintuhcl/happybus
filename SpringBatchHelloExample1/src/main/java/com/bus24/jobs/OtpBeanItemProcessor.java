package com.bus24.jobs;

import org.springframework.batch.item.ItemProcessor;

import com.bus24.beans.OtpBean;

public class OtpBeanItemProcessor implements 
ItemProcessor<OtpBean,OtpBean>{

	@Override
	public OtpBean process(OtpBean otpBean) throws Exception {
		System.out.println("process() ");
		return otpBean;
	}

}
