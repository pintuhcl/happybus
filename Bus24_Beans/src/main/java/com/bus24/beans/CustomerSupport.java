package com.bus24.beans;

public class CustomerSupport {
	private User user;
	private Integer queryId;
	private String query;
	private String querySoluttion;
	private Integer queryStatus;
	private Integer queryType;
	private String querDescription;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getQueryId() {
		return queryId;
	}
	
	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQuerySoluttion() {
		return querySoluttion;
	}
	public void setQuerySoluttion(String querySoluttion) {
		this.querySoluttion = querySoluttion;
	}
	public Integer getQueryStatus() {
		return queryStatus;
	}
	public void setQueryStatus(Integer queryStatus) {
		this.queryStatus = queryStatus;
	}
	public Integer getQueryType() {
		return queryType;
	}
	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}
	public String getQuerDescription() {
		return querDescription;
	}
	public void setQuerDescription(String querDescription) {
		this.querDescription = querDescription;
	}
	
	@Override
	public String toString() {
		return "CustomerSupport [user=" + user + ", queryId=" + queryId + ", query=" + query + ", querySoluttion="
				+ querySoluttion + ", queryStatus=" + queryStatus + ", queryType=" + queryType + ", querDescription="
				+ querDescription + "]";
	}
}
