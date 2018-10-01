/*
 * Copyright (c) 2017, 2018, Bus24 and/or its affiliates. All rights reserved.
 * Bus24 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bus24.beans.BankDetails;
import com.bus24.beans.Travel;
import com.bus24.dao.util.SQLConstants;

/**
 * This class is used to implement Persistence Logic on Travel Entity
 * 
 * @author sathish.bandi
 * @since 1.0
 */
@Repository
public class TravelsDAOImpl implements TravelsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Object registerTravel(Travel travel) {
		Object travelId = null;
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
		jdbcCall.setProcedureName("register_travel");
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("bank_acc_id_in", null);
		inParams.put("bank_acc_no_in", travel.getBankDetails().getAccountNumber());
		inParams.put("bank_acc_holder_name_in", travel.getBankDetails().getAccHolderName());
		inParams.put("bank_name_in", travel.getBankDetails().getBankName());
		inParams.put("branch_name_in", travel.getBankDetails().getBankBranch());
		inParams.put("ifsc_code_in", travel.getBankDetails().getIfscCode());

		inParams.put("user_id_in", null);
		inParams.put("user_name_in", travel.getUser().getUserName());
		inParams.put("password_in", travel.getUser().getPassword());
		inParams.put("userrole_in", travel.getUser().getUserRole());
		inParams.put("created_by_in", travel.getUser().getCreatedBy());
		inParams.put("status_in", travel.getUser().getStatus());

		inParams.put("travel_id_in", null);
		inParams.put("travel_name_in", travel.getUser().getUserName());
		inParams.put("travel_reg_num_in", travel.getTravelRegNumber());
		inParams.put("travel_email_in", travel.getUser().getEmail());
		inParams.put("travel_website_in", travel.getWebsite());
		inParams.put("travel_mobile_in", travel.getUser().getMobile());
		inParams.put("travel_ph1_in", travel.getPhoneNumber1());
		inParams.put("travel_ph2_in", travel.getPhoneNumber2());
		inParams.put("travel_address_line1_in", travel.getAddressLine1());
		inParams.put("travel_address_line2_in", travel.getAddressLine2());
		inParams.put("travel_city_in", travel.getCity());
		inParams.put("travel_state_in", travel.getState());
		inParams.put("travel_zipcode_in", travel.getZipcode());

		jdbcCall.declareParameters(new SqlParameter("bank_acc_id_in", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("bank_acc_no_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("bank_acc_holder_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("bank_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("branch_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("ifsc_code_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("user_id_in", Types.BIGINT));
		jdbcCall.declareParameters(new SqlParameter("user_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("password_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("userrole_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("created_by_in", Types.BIGINT));
		jdbcCall.declareParameters(new SqlOutParameter("travel_id_out", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("travel_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_website_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_reg_num_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_email_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_ph1_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_ph2_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_city_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_state_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_zipcode_in", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("travel_address_line1_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_address_line2_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("travel_mobile_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("status_in", Types.TINYINT));
		Map<String, Object> outParamsMap = jdbcCall.execute(inParams);
		if (outParamsMap != null && outParamsMap.size() > 0) {
			travelId = outParamsMap.get("travel_id_out");
		}
		return travelId;
	}

	/**
	 * this method is used to search for travel
	 * 
	 * @author Eshwar ,Abdul
	 * @param travel
	 * @return List<Travel>
	 */

	@Override
	public List<Travel> searchTravel(Travel travel) {

		List<Travel> listTravels = null;
		listTravels = jdbcTemplate.query(SQLConstants.SEARCH_TRAVELS_DETAILS, new TravelExtractor(),
				travel.getTravelName() + "%", travel.getCity() + "%");
		return listTravels;
	}

	private static final class TravelExtractor implements ResultSetExtractor<List<Travel>> {
		@Override
		public List<Travel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Travel travel = null;
			List<Travel> listTravels = null;
			listTravels = new ArrayList<Travel>();
			while (rs.next()) {
				travel = new Travel();
				BankDetails b = new BankDetails();

				travel.setTravelId(rs.getInt(1));
				travel.setTravelName(rs.getString(2));
				travel.setTravelRegNumber(rs.getString(3));
				travel.setWebsite(rs.getString(4));
				travel.setCity(rs.getString(5));
				travel.setState(rs.getString(6));
				travel.setZipcode(rs.getInt(7));
				travel.setStatus(rs.getByte(8));
				travel.setPhoneNumber1(rs.getString(9));
				travel.setPhoneNumber2(rs.getString(10));
				travel.setAddressLine1(rs.getString(11));
				travel.setAddressLine2(rs.getString(12));
				b.setBankId(rs.getInt(13));
				b.setAccountNumber(rs.getString(14));
				b.setIfscCode(rs.getString(15));
				b.setBankName(rs.getString(16));
				b.setBankBranch(rs.getString(17));
				b.setAccHolderName(rs.getString(18));
				travel.setBankDetails(b);
				listTravels.add(travel);
			} // while
			return listTravels;
		}// method

	}// innerclass

	/**
	 * this method is used to get all travel
	 * 
	 * @author Mulayam
	 * @return List<Travel>
	 */
	@Override
	public List<Travel> getAllTravel() {
		/**
		 * travel_id,travel_name,travel_reg_num,
		 * website,city,state,zipcode,phonenumber1,
		 * phonenumber2,addressline1,addressline2
		 */

		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_TRAVEL, new RowMapper<Travel>() {

			@Override
			public Travel mapRow(ResultSet rs, int arg1) throws SQLException {

				Travel travel = new Travel();
				travel.setTravelId(rs.getInt(1));
				travel.setTravelName(rs.getString(2));
				travel.setTravelRegNumber(rs.getString(3));
				travel.setWebsite(rs.getString(4));
				travel.setCity(rs.getString(5));
				travel.setState(rs.getString(6));
				travel.setZipcode(rs.getInt(7));
				travel.setPhoneNumber1(rs.getString(8));
				travel.setPhoneNumber2(rs.getString(9));

				travel.setAddressLine1(rs.getString(10));
				travel.setAddressLine2(rs.getString(11));

				return travel;
			}
		});

	}

	/**
	 * this method is used to EDIT/UPDATE for travel
	 * 
	 * @author Eshwar ,Abdul
	 * @param travel
	 * @return Object
	 */
	@Override
	public Object editTravel(Travel travel) {
		Object id = null;
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
		jdbcCall.setProcedureName("update_travel");
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("Ttravel_id_in", travel.getTravelId());
		inParams.put("Ttravel_name_in", travel.getTravelName());
		inParams.put("Ttravel_reg_num_in", travel.getTravelRegNumber());
		inParams.put("Twebsite_in", travel.getWebsite());
		inParams.put("Tphonenumber1_in", travel.getPhoneNumber1());
		inParams.put("Tphonenumber2_in", travel.getPhoneNumber2());
		inParams.put("TaddressLine1_in", travel.getAddressLine1());
		inParams.put("TaddressLine2_in", travel.getAddressLine2());
		inParams.put("Tcity_in", travel.getCity());
		inParams.put("Tstate_in", travel.getState());
		inParams.put("Tstatus_in", travel.getStatus());
		inParams.put("Tzipcode_in", travel.getZipcode());

		inParams.put("Bbank_id_in", travel.getBankDetails().getBankId());
		inParams.put("Bbank_acc_no_in", travel.getBankDetails().getAccountNumber());
		inParams.put("Bacc_holder_name_in", travel.getBankDetails().getAccHolderName());
		inParams.put("Bifsc_code_in", travel.getBankDetails().getIfscCode());
		inParams.put("Bbank_name_in", travel.getBankDetails().getBankName());
		inParams.put("Bbranch_name_in", travel.getBankDetails().getBankBranch());
		inParams.put("bank_acc_id_out", null);

		jdbcCall.declareParameters(new SqlParameter("Ttravel_id_in", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("Ttravel_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Ttravel_reg_num_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Twebsite_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Tphonenumber1_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Tphonenumber2_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("TaddressLine1_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("TaddressLine2_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Tcity_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Tstate_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Tstatus_in", Types.TINYINT));
		jdbcCall.declareParameters(new SqlParameter("Tzipcode_in", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("Bbank_id_in", Types.INTEGER));
		jdbcCall.declareParameters(new SqlParameter("Bbank_acc_no_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Bacc_holder_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Bifsc_code_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Bbank_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlParameter("Bbranch_name_in", Types.VARCHAR));
		jdbcCall.declareParameters(new SqlOutParameter("bank_acc_id_out", Types.INTEGER));
		Map<String, Object> outParamsMap = jdbcCall.execute(inParams);
		if (outParamsMap != null && outParamsMap.size() > 0) {
			id = outParamsMap.get("bank_acc_id_out");
		}
		return id;
	}// method

}// class
