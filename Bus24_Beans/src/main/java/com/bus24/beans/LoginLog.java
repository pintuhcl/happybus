package com.bus24.beans;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{
private Integer loginLogId;
private String userAgent,sessionId,ipAddress;
private Date loginTime;
private Long userId;
private Byte logoutStatus;
/**
 * @return the loginLogId
 */
public Integer getLoginLogId() {
	return loginLogId;
}
/**
 * @param loginLogId the loginLogId to set
 */
public void setLoginLogId(Integer loginLogId) {
	this.loginLogId = loginLogId;
}
/**
 * @return the userAgent
 */
public String getUserAgent() {
	return userAgent;
}
/**
 * @param userAgent the userAgent to set
 */
public void setUserAgent(String userAgent) {
	this.userAgent = userAgent;
}
/**
 * @return the sessionId
 */
public String getSessionId() {
	return sessionId;
}
/**
 * @param sessionId the sessionId to set
 */
public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}
/**
 * @return the ipAddress
 */
public String getIpAddress() {
	return ipAddress;
}
/**
 * @param ipAddress the ipAddress to set
 */
public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
}
/**
 * @return the loginTime
 */
public Date getLoginTime() {
	return loginTime;
}
/**
 * @param loginTime the loginTime to set
 */
public void setLoginTime(Date loginTime) {
	this.loginTime = loginTime;
}
/**
 * @return the userId
 */
public Long getUserId() {
	return userId;
}
/**
 * @param userId the userId to set
 */
public void setUserId(Long userId) {
	this.userId = userId;
}
/**
 * @return the logoutStatus
 */
public Byte getLogoutStatus() {
	return logoutStatus;
}
/**
 * @param logoutStatus the logoutStatus to set
 */
public void setLogoutStatus(Byte logoutStatus) {
	this.logoutStatus = logoutStatus;
}

}
