/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.service;

import java.util.List;

import com.bus24.beans.Travel;

/**
 * This interface is used to gather Travel Requirements
 * 
 * @author sathish.bandi
 * @since 1.0
 */
public interface TravelService {
	public String registerTravel(String jsonTravel, Long userId, String token);

	/**
	 * this method is used to search for travel
	 * 
	 * @author Eshwar,Abdul
	 * @param travel
	 * @return List<Travel>
	 */
	public String searchTravel(String jsonTravel, Long userId, String token);

	/**
	 * this method is used to get all travel
	 * 
	 * @author Mulayam
	 * @return List<Travel>
	 */
	public String getAllTravel();


/**
 * this method is used to EDIT/UPDATE for travel
 * @author Eshwar,Abdul
 * @param travel
 * @return List<Travel>
 */
public String editTravel(String jsonTravel,Long userId,String token);
}
