/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Amenity;
import com.bus24.beans.Bus;
import com.bus24.beans.BusType;
import com.bus24.beans.SearchedBus;
import com.bus24.beans.Travel;
import com.bus24.dao.util.SQLConstants;

/**
 * This class is the implementation class of BusDAO, implement the persistence
 * logic on Bus Entity
 * 
 * @author Mulayam
 * @since 1.0
 */
@Repository
public class BusDAOImpl implements BusDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	/**
	 * This method used to get all amenities of specified busId
	 * 
	 * @author mulayam
	 * @since 1.0
	 * @param busID
	 */

	@Override
	public int saveBus(Bus bus, Long userId) {

		BusStoredProcedure busStoredProcedure = new BusStoredProcedure();
		busStoredProcedure.setDataSource(dataSource);
		busStoredProcedure.setSql("regiseter_bus");
		busStoredProcedure.declareParameter(new SqlParameter("bus_reg_num_in", Types.VARCHAR));
		busStoredProcedure.declareParameter(new SqlParameter("bus_type_id_in", Types.INTEGER));
		busStoredProcedure.declareParameter(new SqlParameter("amenitiesList_in", Types.VARCHAR));
		busStoredProcedure.declareParameter(new SqlParameter("created_by_in", Types.BIGINT));
		busStoredProcedure.declareParameter(new SqlParameter("travel_id_in", Types.INTEGER));
		busStoredProcedure.declareParameter(new SqlParameter("bus_status_in", Types.BIT));
		busStoredProcedure.declareParameter(new SqlOutParameter("bus_id_out", Types.INTEGER));

		List<Amenity> amenities = bus.getListAmenities();
		String amenitiesNames = "";
		for (Amenity item : amenities) {
			amenitiesNames = amenitiesNames + item.getAmenityName() + ',';
		}
		if (amenitiesNames.isEmpty()) {
			amenitiesNames = "";
		} else
			amenitiesNames = amenitiesNames.substring(0, amenitiesNames.lastIndexOf(','));
		System.out.println(amenitiesNames);
		Map<String, Object> inParamMap = new HashMap<>();
		inParamMap.put("bus_reg_num_in", bus.getRegNo());
		inParamMap.put("bus_type_id_in", bus.getBusType().getTypeId());
		inParamMap.put("amenitiesList_in", amenitiesNames);
		inParamMap.put("created_by_in", userId);
		System.out.println("UserId convert into intvalue: " + userId.intValue());
		inParamMap.put("travel_id_in", userId.intValue());
		inParamMap.put("bus_status_in", (byte) 1);

		Map<String, Object> outParamsMap = busStoredProcedure.execute(inParamMap);
		Object busId = outParamsMap.get("bus_id_out");

		return (int) busId;
	}

	@Override
	public List<Amenity> getBusAmenities(Integer busId) {

		// amenity_id,amenity_name

		return jdbcTemplate.query(SQLConstants.SQL_SELECT_AMENITY_BY_BUSID, new RowMapper<Amenity>() {
			@Override
			public Amenity mapRow(ResultSet rs, int arg1) throws SQLException {
				Amenity amenity = new Amenity();
				amenity.setAmenityId(rs.getInt(1));
				amenity.setAmenityName(rs.getString(2));
				return amenity;
			}
		}, busId);
	}

	/**
	 * 
	 * Get The list of busses of specific travelId
	 * 
	 * @author mulayam
	 * @param travelId
	 * @return return list of busses
	 * @since 1.0
	 */
	@Override
	public List<Bus> searchBusesByTravelId(Integer travelId) {

		return jdbcTemplate.query(SQLConstants.SQL_SELECT_BUS_FOR_ADMIN_BY_TRAVELID, new RowMapper<Bus>() {

			/*
			 * bus_id,travel_id,reg_no, status, bus_type_name, bus_model,
			 * layout_model,no_of_seats,layout_type,layout_desc
			 */

			@Override
			public Bus mapRow(ResultSet rs, int arg1) throws SQLException {

				Bus bus = new Bus();
				bus.setBusId(rs.getInt(1));

				Travel travel = new Travel();
				travel.setTravelId(rs.getInt(2));
				travel.setTravelName(rs.getString(3));
				bus.setTravelId(travel);

				bus.setRegNo(rs.getString(4));

				bus.setStatus(rs.getByte(5));

				BusType busType = new BusType();
				busType.setTypeName(rs.getString(6));
				busType.setModel(rs.getString(7));
				busType.setLayoutModel(rs.getString(8));
				busType.setNoOfSeats(rs.getInt(9));
				busType.setLayoutType(rs.getString(10));
				busType.setLayoutDescription(rs.getString(11));

				bus.setBusType(busType);
				return bus;
			}
		}, travelId);
	}

	/**
	 * This method is used to search busses for passenger
	 * 
	 * @param source
	 * @param destination
	 * @param date
	 * @return {@link List<SearchedBus>}
	 * @author mulayam
	 */
	@Override
	public List<SearchedBus> searchBusesForPassenger(String source, String destination, String date) {

		System.out.println(source);
		System.out.println(destination);

		//
		// travel_id
		// travel_name
		// bus_id
		// no_of_seats
		// no_of_avaible_seats
		// route_id
		// source
		// destination
		// departure_time
		// arrival_time
		// boarding_points
		// dropping_points
		// distance
		// price
		// via
		// bus_type_name
		// bus_model
		// layout_model
		// layout_desc
		// layout_type
		// date=? source =? destination=? departure_time=?
		//
		return jdbcTemplate.query(SQLConstants.SQL_SELECT_BUS_FOR_PASSENGER, new RowMapper<SearchedBus>() {
			@Override
			public SearchedBus mapRow(ResultSet rs, int arg1) throws SQLException {

				SearchedBus bus = new SearchedBus();
				bus.setTravelId(rs.getInt(1));
				bus.setTravelName(rs.getString(2));
				bus.setBusId(rs.getInt(3));
				bus.setNoOfSeats(rs.getInt(4));
				bus.setNoOfAvaibleSeats(rs.getInt(5));
				bus.setRouteId(rs.getInt(6));
				bus.setSource(rs.getString(7));
				bus.setDestination(rs.getString(8));

				bus.setDepartureTime(rs.getTime(9));

				// bus.setDepartureDate(rs.getDate(9));
				bus.setArrivalTime(rs.getTime(10));

				// bus.setArrivalDate(rs.getDate(10));
				//

				bus.setBoradingPoints(rs.getString(11));
				bus.setDropingPoints(rs.getString(12));
				bus.setDistance(rs.getInt(13));
				bus.setPrice(rs.getInt(14));
				bus.setVia(rs.getString(15));

				bus.setBusType(rs.getString(16));
				bus.setBusModel(rs.getString(17));
				bus.setLayoutModel(rs.getString(18));
				bus.setLayoutDescription(rs.getString(19));
				bus.setLayoutType(rs.getString(20));
				bus.setTotalTime(rs.getInt(21));

				return bus;
			}
		}, date, source, destination, date);
	}

}
