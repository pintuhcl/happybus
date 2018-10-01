/*Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Insurance;
import com.bus24.beans.Travel;
import com.bus24.dao.util.SQLConstants;

/**
 * This class is used to implement Persistence Logic on insurance Entity
 * 
 * @author rakhi
 * @since 1.0
 */

@Repository
public class InsuranceDAOImpl implements InsuranceDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer addInsuranceCompany(Insurance insurance) {
		return jdbcTemplate.update(SQLConstants.SQL_INSERT_INSURANCE_COMPANY, insurance.getCompanyName(),
				insurance.getTravel().getTravelId(), insurance.getAmount());
	}

	@Override
	public List<Insurance> getAllInsuranceCompany() {

		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_INSURANCE_COMPANY, new RowMapper<Insurance>() {

			// company_id,company_name,amount,t.travel_id,travel_name
			@Override
			public Insurance mapRow(ResultSet rs, int rowNum) throws SQLException {

				Insurance insurance = new Insurance();
				insurance.setComapnyId(rs.getInt(1));
				insurance.setCompanyName(rs.getString(2));
				insurance.setAmount(rs.getFloat(3));

				Travel travel = new Travel();
				travel.setTravelId(rs.getInt(4));
				travel.setTravelName(rs.getString(5));

				insurance.setTravel(travel);
				return insurance;
			}

		});

	}

	@Override
	public Insurance getInsuranceCompanyByTravelId(Integer travelId) {

		jdbcTemplate.queryForObject(SQLConstants.SQL_SELECT_INSURANCE_COMPANY_BY_TRAVELID, new RowMapper<Insurance>() {

			@Override
			public Insurance mapRow(ResultSet rs, int rowNum) throws SQLException {

				Insurance insurance = new Insurance();
				insurance.setComapnyId(rs.getInt(1));
				insurance.setCompanyName(rs.getString(2));
				insurance.setAmount(rs.getFloat(3));

				Travel travel = new Travel();
				travel.setTravelId(rs.getInt(4));
				travel.setTravelName(rs.getString(5));
				insurance.setTravel(travel);
				return insurance;
			}
		}, travelId);

		return null;
	}

	@Override
	public Integer editInsuranceComapny(Insurance insurance) {
		// TODO Auto-generated method stub
		return null;
	}

}
