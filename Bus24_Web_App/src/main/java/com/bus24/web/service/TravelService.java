
/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.web.service;

import com.bus24.beans.Travel;

/**
 * @author mulayam
 * @version 1.0
 */
public interface TravelService {
	public String getAllTravel();
	
	/**
	 * @author Eshwar
	 * @version 1.0
	 */
	public String searchTravel(Travel travel,Long userId,String token);

	public String addTravel(Travel travel,Object userId,Object token);
	/**
	 * @author Eshwar
	 * @version 1.0
	 */
	public String updateTravel(Travel travel,Long userId,String token);

}
