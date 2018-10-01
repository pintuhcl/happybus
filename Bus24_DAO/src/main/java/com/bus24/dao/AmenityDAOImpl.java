/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Amenity;
import com.bus24.dao.util.SQLConstants;

/**
 * This class is the implementation class of AmenityDAO(I), implement the
 * persistence logic on Amenity Entity
 * 
 * @author Mulayam
 * @since 1.0
 */

@Repository
public class AmenityDAOImpl implements AmenityDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer addAmenity(Amenity amenity) {
		// amenity_id,amenity_name
		return jdbcTemplate.update(SQLConstants.SQL_INSERT_AMENITY, amenity.getAmenityId(), amenity.getAmenityName());
	}

	@Override
	public List<Amenity> getAllAmenities() {

		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_AMENITY, new RowMapper<Amenity>() {
			@Override
			public Amenity mapRow(ResultSet rs, int arg1) throws SQLException {
				Amenity amenity = new Amenity();
				amenity.setAmenityId(rs.getInt(1));
				amenity.setAmenityName(rs.getString(2));
				return amenity;
			}
		});
	}

	@Override
	public Integer updateAmenity(Amenity amenity) {
		return jdbcTemplate.update(SQLConstants.SQL_UPDATE_AMENITY, amenity.getAmenityName(), amenity.getAmenityId());
	}
}
