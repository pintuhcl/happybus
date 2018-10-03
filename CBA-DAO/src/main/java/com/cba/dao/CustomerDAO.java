/*
* Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.dao;

import java.util.Map;

import com.cba.beans.Account;
import com.cba.beans.Customer;


/**
 * This class is used to implement Persistence on Account Table
 * 
 * @author Sathish
 * @since CBA 1.0
 */

public interface CustomerDAO {

	public Customer getCustomerDetails(Account account);

	public Map<String, Object> getEmailandMobile(String accountNumber);
}
