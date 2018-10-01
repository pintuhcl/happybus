package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Issue;

public interface IssueDAO {
	
	public Integer insertIssue(Issue issue);
	
	public List<Issue> selectAllIssue();
	

}
