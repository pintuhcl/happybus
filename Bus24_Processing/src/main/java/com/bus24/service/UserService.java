/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.service;

import com.bus24.beans.User;

/**
 * This interface is gather user module requirements
 * 
 * @author sathish
 * @since 1.0
 */
public interface UserService {
	/**
	 * this method is used to registerPassenger
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 */
	public String registerPassenger(String jsonUser);

	/**
	 * this method is used to login user
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 */
	public String loginUser(String jsonUser);

	/**
	 * this method is used to showMyprofile
	 * 
	 * @param jsonUser
	 * @author abhinav
	 * @return jsonResponse
	 */
	public String showMyprofile(String jsonUser);

	/**
	 * this method is used to UPDATE Myprofile
	 * 
	 * @author abhinav
	 * @param jsonUser
	 * @return jsonResponse
	 */
	public String updateMyprofile(String jsonUser);

	public String validateOtp(String jsonOtp);

	/**
	 * This method is used to resend otp
	 * 
	 * @return jsonResponse
	 */
	public String resendOTP(String jsonUser);
	
	/**
	 * the method contain logic for forgotPassword
	 * 
	 * @param jsonUser
	 * @return jsonResponse
	 * @author Pradeep Srivastav
	 */

	public String forgotPassword(String jsonUser);
	
	
	
	public String changePassword(String jsonUser);

	public String updateLogoutStatus(Long userId);
	
	public String  checkUserAccount(String jsonUser);

}
