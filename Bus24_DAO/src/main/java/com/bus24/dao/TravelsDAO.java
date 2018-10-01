/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Travel;

/**
 * This interface is used to gather Travel Requirements
 * 
 * @author sathish.bandi
 * @since 1.0
 */
public interface TravelsDAO {
	public Object registerTravel(Travel travel);

	/**
	 * this method is used to search for travel
	 * 
	 * @author Eshwar,Abdul
	 * @param travel
	 * @return List<Travel>
	 */
	public List<Travel> searchTravel(Travel travel);

	/**
	 * this method is used to get all travel
	 * 
	 * @author Mulayam
	 * @return List<Travel>
	 */
	public List<Travel> getAllTravel();


/**
 * this method is used to EDIT/UPDATE for travel
 * @author Eshwar,Abdul
 * @param travel
 * @return Integer
 */

public Object editTravel(Travel travel);
}
