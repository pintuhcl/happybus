/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bus24.beans.Agents;
import com.bus24.beans.BankDetails;
import com.bus24.dao.util.SQLConstants;


/**
 * This class is used to gather Agents information.
 * 
 * @author pramod
 * @since 1.0
 */

@Repository
public class AgentsDAOImpl implements AgentsDAO {
	
	private static Logger logger = Logger.getLogger(AgentsDAOImpl.class);
 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	/**
	 * this method is used to register Agents
	 * 
	 * @param agent
	 * @return agentId
	 */
	public Object registerAgent(Agents agent) {
		logger.info("enter into agentDaoImpl");
		Object agentId = null;

		// create SimpleJdbcCall Obj by passing JdbcTemplet
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
		// set procedure name
		jdbcCall.setProcedureName("register_agent");
		// create Map Obj
		Map<String, Object> inParams = new HashMap<>();
		// set procedure IN param
		inParams.put("bank_acc_id_in", null);
		inParams.put("bank_acc_no_in", agent.getBankDetails().getAccountNumber());
		inParams.put("bank_acc_holder_name_in", agent.getBankDetails().getAccHolderName());
		inParams.put("bank_name_in", agent.getBankDetails().getBankName());
		inParams.put("bank_branch_name_in", agent.getBankDetails().getBankBranch());
		inParams.put("bank_ifsc_in", agent.getBankDetails().getIfscCode());

		inParams.put("user_id_in", null);
		inParams.put("user_name_in", agent.getUser().getUserName());
		inParams.put("user_password_in", agent.getUser().getPassword());
		inParams.put("user_mobile_in", agent.getUser().getMobile());
		inParams.put("user_role_in", agent.getUser().getUserRole());
		inParams.put("user_created_by_in", agent.getUser().getCreatedBy());
		inParams.put("user_status_in", agent.getUser().getStatus());

		inParams.put("agent_id_out", null);
		inParams.put("agent_name_in", agent.getAgencyName());
		inParams.put("agent_phone_number1_in", agent.getPhoneNumber1());
		inParams.put("agent_phone_number2_in", agent.getPhoneNumber2());
		inParams.put("agent_address_line1_in", agent.getAddressLine1());
		inParams.put("agent_address_line2_in", agent.getAddressLine2());
		inParams.put("agent_reg_no_in", agent.getRegNo());
		inParams.put("agent_website_in", agent.getWebsite());
		inParams.put("agent_email_in", agent.getEmail());
		inParams.put("agent_status_in", agent.getStatus());
		inParams.put("agent_state_in", agent.getState());
		inParams.put("agent_city_in", agent.getCity());
		

		jdbcCall.declareParameters(new SqlParameter("bank_acc_id_in", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("bank_acc_no_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("bank_acc_holder_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("bank_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("bank_branch_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("bank_ifsc_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("user_id_in", Types.BIGINT));
		jdbcCall.declareParameters(new SqlParameter("user_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("user_password_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("user_mobile_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("user_role_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("user_created_by_in", Types.BIGINT));
		jdbcCall.declareParameters(new SqlParameter("user_status_in", Types.TINYINT));
		jdbcCall.declareParameters(new SqlOutParameter("agent_id_out", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_phone_number1_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_phone_number2_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_address_line1_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_address_line2_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_reg_no_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_website_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_email_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_status_in", Types.TINYINT));
		jdbcCall.declareParameters(new SqlParameter("agent_state_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("agent_city_in", Types.VARCHAR));
		
		// execute
		Map<String, Object> outParamsMap = jdbcCall.execute(inParams);
		// get agent_id_out param
		if (outParamsMap != null && outParamsMap.size() > 0) {
			agentId = outParamsMap.get("agent_id_out");
			System.out.println("DAO-----"+agentId);
		}

		return agentId;
	}

	/**
	 * this method is used to search Agents
	 * 
	 * @param agencyname
	 * @return agents
	 */

	@Override
	public Agents searchAgent(String agencyname) {
	return 	(Agents)jdbcTemplate.query(SQLConstants.SEARCH_AGENT_SQL,new RowMapper<Agents>(){

			@Override
			public Agents mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Agents agents=new Agents();
				agents.setAgentId(rs.getLong(1));
				agents.setAgencyName(rs.getString(2));
				agents.setRegNo(rs.getString(3));
				agents.setPhoneNumber1(rs.getString(4));
				agents.setPhoneNumber2(rs.getString(5));
				agents.setEmail(rs.getString(6));
				agents.setAddressLine1(rs.getString(7));
				agents.setAddressLine2(rs.getString(8));
				agents.setCity(rs.getString(9));
				agents.setState(rs.getString(10));
				agents.setIdcard(rs.getString(11));
				
				agents.setStatus(rs.getByte(11));
				BankDetails bankDetails=new BankDetails();
				bankDetails.setBankId(rs.getInt(12));
				bankDetails.setAccountNumber(rs.getString(13));
				bankDetails.setAccHolderName(rs.getString(14));
				bankDetails.setIfscCode(rs.getString(15));
				bankDetails.setBankName(rs.getString(16));
				bankDetails.setBankBranch(rs.getString(17));
				agents.setBankDetails(bankDetails);
				return agents;
			}
				
		},agencyname).get(0);
		
	}

	/**
	 * this method is used to edit Agent
	 * 
	 * @param agent
	 * @return int
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.SERIALIZABLE)
	public Integer editAgent(Agents agent) 
	{
		Integer count=0;
	
		count=jdbcTemplate.update(SQLConstants.EDIT_AGENT_SQL,agent.getAgencyName(),agent.getRegNo(),agent.getPhoneNumber1(),agent.getPhoneNumber2(),agent.getEmail(),agent.getAddressLine1(),agent.getAddressLine2(),agent.getCity(),agent.getCity(),agent.getIdcard(),agent.getStatus(),agent.getBankDetails().getBankId());
		count=jdbcTemplate.update(SQLConstants.EDIT_AGENT_BANK_SQL,agent.getBankDetails().getBankId(),agent.getBankDetails().getAccHolderName(),agent.getBankDetails().getIfscCode(),agent.getBankDetails().getBankName(), agent.getBankDetails().getBankBranch());
		if(count>0)
		{
		return count;
		}
		return count;
	}

}
