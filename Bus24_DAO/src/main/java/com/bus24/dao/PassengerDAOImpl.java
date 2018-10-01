package com.bus24.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Passenger;
import com.bus24.dao.util.SQLConstants;

/**
 * This class implements the persistence login of passenger
 * 
 * @author mulayam
 *
 */
@Repository
public class PassengerDAOImpl implements PassengerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int[] addPassengers(List<Passenger> listPassenegrs, Integer newBookingId) {

		// name,gender,age,seat_no,booking_id
		return jdbcTemplate.batchUpdate(SQLConstants.SQL_INSERT_PASSENGERS, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				Passenger passenger = listPassenegrs.get(i);
				System.out.println(passenger);
				ps.setString(1, passenger.getName());
				ps.setString(2, passenger.getGender());
				ps.setInt(3, passenger.getAge());
				ps.setString(4, passenger.getSeatNo());
				ps.setInt(5, newBookingId);

			}

			@Override
			public int getBatchSize() {
				return listPassenegrs.size();
			}
		});

	}

	@Override
	public List<Passenger> getAllPassengers(Integer routeId) {

		// passenger_id,name,gender,age,seat_no,booking_id,status
		return jdbcTemplate.query(SQLConstants.SQL_SELECT_PASSENGER_BY_ROUTE_ID, new RowMapper<Passenger>() {

			@Override
			public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {

				Passenger passenger = new Passenger();
				passenger.setPassengerId(rs.getInt(1));
				passenger.setName(rs.getString(2));
				passenger.setGender(rs.getString(3));
				passenger.setAge(rs.getInt(4));
				passenger.setSeatNo(rs.getString(5));
				passenger.setBookingId(rs.getInt(6));
				passenger.setStatus(rs.getInt(7));

				return passenger;
			}
		}, routeId);
	}
}
