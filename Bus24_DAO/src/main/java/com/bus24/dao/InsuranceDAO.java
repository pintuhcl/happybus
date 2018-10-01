/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.dao;

import java.util.List;

import com.bus24.beans.Insurance;
import com.bus24.beans.Travel;

/**
 * This interface is used to gather insurance Requirements
 * 
 * @author rakhi
 * @since 1.0
 */
public interface InsuranceDAO {

	public Integer addInsuranceCompany(Insurance insurance);

	/**
	 * this method is used to get all insurance
	 * 
	 * @author rakhi
	 * @return List<Insurance>
	 */
	public List<Insurance> getAllInsuranceCompany();

	/**
	 * this method is used to get all insurance by tavel id
	 * 
	 * @author rakhi
	 * @return List<travel>
	 */
	public Insurance getInsuranceCompanyByTravelId(Integer travelId);

	/**
	 * this method is used to EDIT/UPDATE for insurance
	 * 
	 * @author rakhi
	 * @param insurance
	 * @return Integer
	 */
	public Integer editInsuranceComapny(Insurance insurance);

}
