package com.bus24.service;

import com.bus24.beans.Issue;
public interface IssueService {
	/**
	 * 
	 * @param jsonIssue
	 * @return jsonResponse
	 */
	public String insertIssue(String jsonIssue);
	
	public String selectAllIssue();


}
