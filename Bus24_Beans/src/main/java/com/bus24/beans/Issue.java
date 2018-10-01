package com.bus24.beans;

import java.io.Serializable;
import java.util.List;

public class Issue implements Serializable{
	
	private Integer issueId;
	private String issueName;
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueName=" + issueName + "]";
	}
	
	
	
}
