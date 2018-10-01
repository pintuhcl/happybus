package com.bus24.beans;

import java.io.Serializable;

public class OtpBean implements Serializable {
private Long userId;
private Integer otp;
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
 * @return the otp
 */
public Integer getOtp() {
	return otp;
}
/**
 * @param otp the otp to set
 */
public void setOtp(Integer otp) {
	this.otp = otp;
}

}
