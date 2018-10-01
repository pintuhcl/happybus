package com.bus24.web.service;

import com.bus24.beans.Agents;

public interface AgentService {
public String searchAgent(String agencyName);

/**this method is used register the Agent 
 * @author pramod
 * @version 1.0
 */
public String registerAgent(Agents agent, Long userId, String token);
public String editAgent(String jsonAgent);

}
