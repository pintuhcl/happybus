package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Agents;
import com.bus24.beans.Amenity;
import com.bus24.beans.Report;
import com.bus24.beans.Travel;
import com.bus24.dao.util.SQLConstants;

/**
 * This interface is used to generate Report for BUS24.
 * 
 * @author suchitra
 * @since 1.0
 */
@Repository
public class ReportDAOImpl implements ReportDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	// select
	// payment_id,payment_time,transaction_id,user_id,payment_by,bank_acc_id,amount,status
	// from payment where Date_format(payment_time,'%Y-%m-%d') between
	// '2017-06-28' and '2017-07-06'

	@Override
	public List<Report> getReport(Date from,Date to) {
		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_FOR_SUPERADMIN_FROM_N_TO, new RowMapper<Report>() {
			@Override
			public Report mapRow(ResultSet rs, int arg1) throws SQLException {
				Report report = new Report();
				report.setPaymentId(rs.getInt(1));
				//change the date format
				report.setPaymentTime(rs.getDate(2));
				report.setTransactionId(rs.getInt(3));
				report.setUserId(rs.getInt(5));
				report.setPayment_by(rs.getString(6));
				report.setBank_acc_id(rs.getInt(8));
				report.setAmount(rs.getInt(9));
				report.setStatus(rs.getInt(10));
				return report;
			}
		}, from, to);
	}

	@Override
	public List<Report> getReport(Travel travel, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReport(Agents agent, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReport(Integer month) {
		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_FOR_SUPERADMIN_MONTHLY, new RowMapper<Report>() {
			@Override
			public Report mapRow(ResultSet rs, int arg1) throws SQLException {
				Report report = new Report();
				report.setPaymentId(rs.getInt(1));
				//change the date format
				report.setPaymentTime(rs.getDate(2));
				report.setTransactionId(rs.getInt(3));
				report.setUserId(rs.getInt(5));
				report.setPayment_by(rs.getString(6));
				report.setBank_acc_id(rs.getInt(8));
				report.setAmount(rs.getInt(9));
				report.setStatus(rs.getInt(10));
				return report;
			}
		},month);
	}

	@Override
	public List<Report> getReport(Travel travel, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReport(Agents agent, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
