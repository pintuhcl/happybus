/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import com.bus24.beans.Agents;


/**
 * This interface is used to gather Agents information.
 *@author  pramod
 * @since   1.0
 */
public interface AgentsDAO {
	/**
	 * this method is used to register Agents
	 * @param agent
	 * @return agentId
	 */
	public Object registerAgent(Agents agent);
	/**
	 * this method is used to search Agents
	 * @param agencyname
	 * @return Agents
	 */
	public Agents searchAgent(String agencyname);
	
	/**
	 * this method is used to edit Agent
	 * @param agent
	 * @return int
	 */
	public Integer editAgent(Agents agent);
	
}
