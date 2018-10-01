/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.service;
/**
 * This interface is gather agent requirements
 * 
 * @author pramod,damodar,sekhar
 * @since 1.0
 */

public interface AgentService {
	
	
	/**
	 * this method is used to register Agents
	 * @param jsonAgent,userId,token
	 * @return jsonResponse
	 */
	public String registerAgent(String jsonAgent,Long userId,String token);
    public String searchAgent(String agencyName);
    public String editAgent(String jsonAgent);
}
