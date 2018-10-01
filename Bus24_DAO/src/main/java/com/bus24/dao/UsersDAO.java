/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import com.bus24.beans.User;

/**
 * This interface is used to gather Users Requirements
 * 
 * @author 8235165187
 * @since 1.0
 */
public interface UsersDAO {
	/**
	 * this method is used to registerPassenger
	 * 
	 * @author sathish
	 * @param user
	 * @return userId
	 */
	public Object registerPassenger(User user);

	public String getHashPassword(String userName);

	public User getUserDetails(String userName);

	public Integer changePassword(User user);

	public User showMyprofile(String userName);

	public Integer updateMyprofile(User user);

	/**
	 * Pradeep
	 * 
	 * @author 8125925663
	 * @since 1.0
	 */

	public Integer forgotPassword(User user);

	/**
	 * this method return user object of specific userid
	 * 
	 * @author Pavani
	 */

	public User getUserByUserId(Long userId);

	public Integer updateUserStatus(Long userId, Integer status);

	public int updateLogoutStatus(Long userId, int status);

	public boolean checkEmail(String email);

	public boolean checkMobile(String mobile);

}
