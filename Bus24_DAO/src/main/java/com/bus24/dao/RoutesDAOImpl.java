package com.bus24.dao;
//* Copyright (c) 2017- 2018, HappyBus and/or its affiliates. All rights reserved.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//* HappyBus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Route;
import com.bus24.dao.util.SQLConstants;

/**
 * RoutesDAOImpl is used to perform persistence operations on Routes Table
 * 
 * @author: sahoo
 * @since 1.0
 */
@Repository
public class RoutesDAOImpl implements RoutesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addRoute(Route route) {

		return jdbcTemplate.update(SQLConstants.SQL_ADD_ROUTE,
				new Object[] { route.getBusId(), route.getTravelId(), route.getSource(), route.getDestination(),
						route.getDateOfJourney(), route.getVia(), route.getDistance(), route.getDepartureTime(),
						route.getArrivalTime(), route.getBoardingPoints(), route.getDroppingPoints(), route.getStatus(),
						route.getServiceNo(), route.getPrice()

				});

	}

	@Override
	public Route getRoute(Integer routeId) {
		// bus_id,route_id,travel_id,
		// source,destination,departure_time,arrival_time,
		// boarding_points,dropping_points,price

		return jdbcTemplate.queryForObject(SQLConstants.SQL_SELECT_ROUTE_BY_ROUTE_ID, new RowMapper<Route>() {

			@Override
			public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
				Route route = new Route();
				route.setTravelId(rs.getInt("travel_id"));
				route.setDateOfJourney(rs.getDate("departure_time"));

				return route;
			}
		}, routeId);

	}

	@Override
	public List<String> getSourceList() {

		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_SOURCES, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString(1);
			}
		});

	}

	@Override
	public List<String> getDestinationList() {
		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_DESTINATION, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
	}

	@Override
	public Integer editRoute(Route route) {

		Integer result = jdbcTemplate.update(SQLConstants.SQL_ROUTE_EDIT, route.getBusId(), route.getTravelId(),
				route.getSource(), route.getDestination(), route.getDateOfJourney(), route.getVia(),
				route.getDistance(), route.getDepartureTime(), route.getArrivalTime(), route.getBoardingPoints(),
				route.getDroppingPoints(), route.getStatus(), route.getServiceNo(), route.getPrice(),
				route.getRouteId());

		return result;
	}

	@Override
	public List<Route> searchRouteBySource(Route route) {

		List<Route> routeList = jdbcTemplate.query(SQLConstants.SQL_ROUTE_DETAILS, new Object[] { route.getSource() },
				new ResultSetExtractor<List<Route>>() {

					@Override
					public List<Route> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<Route> routeList = new ArrayList<Route>();
						while (rs.next()) {
							route.setBusId(rs.getInt(1));

							route.setRouteId(rs.getInt(2));
							route.setSource(rs.getString(3));
							route.setDestination(rs.getString(4));
							route.setDistance(rs.getInt(5));
							route.setDepartureTime(rs.getTime(6));
							route.setArrivalTime(rs.getTime(7));
							route.setBoardingPoints(rs.getString(8));
							route.setDroppingPoints(rs.getString(9));
							route.setStatus(rs.getByte(10));
							route.setServiceNo(rs.getInt(11));
							route.setPrice(rs.getDouble(12));
							route.setVia(rs.getString(13));
							route.setTravelId(rs.getInt(14));
							routeList.add(route);
						} // while

						return routeList;
					}// extractData

				}// annonymous inner class
		);// method call

		return routeList;
	}// method

}

/*
 * 
 * 
 * SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate); Map<String,
 * Object> map = new HashMap<>(); map.put("route_source_in", route.getSource());
 * map.put("rotes_destination_in", route.getDestination());
 * map.put("routes_distance_in", route.getDistance());
 * map.put("routes_departureTime_in", route.getDepartureTime());
 * map.put("routes_arrivalTime_in", route.getDepartureTime());
 * map.put("routes_travelduration_in", route.getTravelDuration());
 * 
 * 
 * simpleJdbcCall.declareParameters(new SqlParameter("route_source_in",
 * Types.VARCHAR)); simpleJdbcCall.declareParameters(new
 * SqlParameter("routes_distance_in", Types.INTEGER));
 * simpleJdbcCall.declareParameters(new SqlParameter("rotes_destination_in",
 * Types.VARCHAR)); simpleJdbcCall.declareParameters(new
 * SqlParameter("routes_departureTime_in", Types.VARCHAR));
 * simpleJdbcCall.declareParameters(new SqlParameter("routes_arrivalTime_in",
 * Types.VARCHAR)); simpleJdbcCall.declareParameters(new
 * SqlOutParameter("routes_travelduration_in", Types.INTEGER));
 * simpleJdbcCall.withProcedureName("save_bus"); Map<String, Object>
 * outParamsMap = simpleJdbcCall.execute(map); Object busId =
 * outParamsMap.get("bus_id_out"); return busId; }
 */

/**
 * RoutesDAOimpl is used to perform persistence operations on routes table
 */
