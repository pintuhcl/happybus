/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This class is use to Spring-Boot Servlet Initializer
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * This Method is Use to Builder Application
	 * 
	 * @author Sathish.Bandi
	 * @return SpringApplicationBuilder
	 * 
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CbaBackEndApplication.class);
	}

}
