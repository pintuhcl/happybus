/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.bus24.beans.Agents;
import com.bus24.beans.Response;
import com.bus24.beans.User;
import com.bus24.dao.AgentsDAO;
import com.bus24.dao.AgentsDAOImpl;
import com.bus24.exceptions.UserNotAuthenticatedException;
import com.bus24.integration.UserSmsServiceClient;
import com.bus24.util.JsonUtil;
import com.bus24.util.PasswordGenerator;
import com.bus24.util.SmsTemplates;
import com.bus24.util.StatusUtil;
import com.bus24.util.ValidationUtil;

/**
 * This interface is gather agent requirements
 * 
 * @author pramod
 * @since 1.0
 */
@Service
public class AgentServiceImpl implements AgentService {
	private static Logger logger = Logger.getLogger(AgentServiceImpl.class);
	@Autowired
	private AgentsDAO agentDAO;
	@Autowired
	private UserAuthenticationService userAuthenticationService;
	@Autowired
	private UserSmsServiceClient smsServiceClient;

	/**
	 * this method is used to register Agents
	 * 
	 * @param jsonAgent,userId,token
	 * @return jsonResponse
	 */
	public String registerAgent(String jsonAgent, Long userId, String token) {
		System.out.println("enter into webservice");
		Response response = new Response();
		String jsonResponse = " ";
		response.setMessage("Agent Registration Failure!Please Try Again.");
		response.setStatus(StatusUtil.STATUS_FAILURE);

		try {
			logger.info("enter into try of registerAgent()");
			
			
			
				// convert json to java
				Agents agent = JsonUtil.convertJsonToJava(jsonAgent, Agents.class);

				// check user is authenticated or not
				if (agent != null) {

						User user = agent.getUser();
						user.setUserName(agent.getEmail());
						user.setEmail(agent.getEmail());
						String password = PasswordGenerator.generatePassword();

						// encript the password
						user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
						agent.setUser(user);
						System.out.println(agent.getEmail());

						// if user is authenticated then DAO's
						String agentId = (String) agentDAO.registerAgent(agent);
						System.out.println(agentId);

						if (agentId != null) {
							response.setMessage("Agent " + agent.getAgencyName() + " registration is successful");
							response.setStatus(StatusUtil.STATUS_SUCCESS);
						} // if
							// send sms
						String sms = "Dear Agent Use this UserName= " + agent.getUser().getUserName()
								+ " and Password= " + password + " for Login - Thank you Bus24.com";
						String smsStatus = smsServiceClient.sendSms(agent.getUser().getMobile(), sms,
								SmsTemplates.SMS_TEMP_ID_OTP);
						logger.info("Sms Status : " + smsStatus);

						// send email
					} // if
				if (userAuthenticationService.isAuthenticated(userId, token)) {

			
			} // if
		} catch (UserNotAuthenticatedException e) {
			logger.info("Exception Occured while Authenticating of User : " + e.getMessage());
			response.setMessage(e.getMessage());
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} catch (DataAccessException de) {
			logger.info("Exception Occured while Registering the Agent1 : " + de.getMessage());
			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		} catch (Exception e) {
			logger.info("Exception Occured while Registering the Agent2 : " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		jsonResponse = JsonUtil.convertJavaToJson(response);
		logger.info("Response from Register Agent : " + jsonResponse);
		return jsonResponse;
	}

	/**
	 * This interface is gather agent requirements
	 * 
	 * @author damodar,sekhar
	 * @since 1.0
	 */
	@Override
	public String searchAgent(String agencyName) {
		logger.info("Entered into search agent method" + agencyName);
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Please enter input");
		if (agencyName != null) {
			try {
				Agents agents = agentDAO.searchAgent(agencyName);
				if (agents != null) {
					return JsonUtil.convertJavaToJson(agents);
				} else {
					response.setStatus(StatusUtil.STATUS_FAILURE);
					response.setMessage("Please enter valid enter agency name");
				}
			} catch (Exception e) {
				logger.error("exception occured while callind dao:" + e);
				response.setStatus(StatusUtil.STATUS_FAILURE);
				response.setMessage("Unable To Process Your Request");
			}
		}
		return JsonUtil.convertJavaToJson(response);

	}

	@Override
	public String editAgent(String jsonAgent) {
		
		Response response = new Response();
		logger.info("Entered into editAgent method  :"+jsonAgent);
		response.setMessage(" Sorry  Unable to process your request");
		response.setStatus(StatusUtil.STATUS_FAILURE);
		
		if (jsonAgent != null) {
			Agents agent = JsonUtil.convertJsonToJava(jsonAgent, Agents.class);
			if(agent!=null)
			{
				try
				{
			  Integer	count=agentDAO.editAgent(agent);
				if (count==null) {
					response.setStatus(StatusUtil.STATUS_FAILURE);
					response.setMessage("invalid data entered");
				}
				else if(count>0 && count!=null)
				{
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Agent Updated Successfully");
				}
				}
				catch (DataAccessException de) {
					logger.error("Exception occured while Updating Agent:"+de);
					response.setStatus(StatusUtil.STATUS_FAILURE);
					response.setMessage("unable to process your request!please try again");

				} catch (Exception e) {
					logger.error("Exception occured while calling dao:"+e);
					response.setStatus(StatusUtil.STATUS_FAILURE);
					response.setMessage("Unable to process!Please Try Again");
				}
			}

		}
     return JsonUtil.convertJavaToJson(response);
  }
}
			
	
