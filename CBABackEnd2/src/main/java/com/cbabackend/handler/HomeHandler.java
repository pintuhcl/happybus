/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is used to Show Home Page Handler
 * 
 * @author Satish
 * @since CBABE 1.0
 */
@Controller
public class HomeHandler {
	/**
	 * This Method is use to Mapping Home Home Page
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/")
	public String showHomePage() {
		return "home";
	}
}
