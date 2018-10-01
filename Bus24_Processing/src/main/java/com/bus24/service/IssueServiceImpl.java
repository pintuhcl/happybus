package com.bus24.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bus24.beans.Amenity;
import com.bus24.beans.Issue;
import com.bus24.beans.Response;
import com.bus24.dao.IssueDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;
@Service
public class IssueServiceImpl implements IssueService{

	private static Logger logger=Logger.getLogger(IssueServiceImpl.class);
	
	@Autowired
	private IssueDAO issueDAO;
	@Override
	public String insertIssue(String jsonIssue) {
		logger.info("Enter into insertIssue method");
		Response response=new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Issue Not added, please try again");
		Issue issue=null;
		Integer count;
		try
		{
			logger.info("JsonIssue:::"+jsonIssue);
			issue=JsonUtil.convertJsonToJava(jsonIssue,Issue.class);
			if(issue !=null)
			{
				count=issueDAO.insertIssue(issue);
				if(count !=null && count>0){
					response.setStatus(StatusUtil.STATUS_SUCCESS);
					response.setMessage("Issue Added Successfully");
					logger.info("Successfully Saved");
				}
				else{
					response.setMessage("Unable to process your request! Pleaes try again");
					logger.error("data Not Saved");
					
				}
			}
			else{
				response.setMessage("Invalid Data! Pleaes try again");
				logger.error("Invalid Data");
			}
		}catch (DataAccessException de) {
			logger.info("Exception Occured while Fetching adding issue Details : " + de.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);

		} catch (Exception e) {
			logger.info("Exception Occured while Fetching adding issue Details: " + e.getMessage());

			response.setMessage("Unable to Process Your Request!Please Try Again.");
			response.setStatus(StatusUtil.STATUS_FAILURE);
		}
		String jsonResposne = JsonUtil.convertJavaToJson(response);
		return jsonResposne;
	}
	
	
	
	@Override
	public String selectAllIssue() {
		
		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Not retrived ! Please try again");
		try {
			List<Issue> issues = issueDAO.selectAllIssue();
			if (issues != null && issues.size() > 0) {
				logger.info(issues);
				String jsonStr = JsonUtil.convertJavaToJson(issues);
				response.setData(jsonStr);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("issue found");
			} else {
				response.setMessage("Data Not Found");
			}
		} catch (DataAccessException e) {
			logger.error("DataAcessEx", e);
			response.setMessage("Unable to process your request please try again");
		} catch (Exception e) {
			logger.error("Ex:", e);
			response.setMessage("Unable to process your request please try again");
		}

		String jsonResponse = JsonUtil.convertJavaToJson(response);

		return jsonResponse;
	}
}
