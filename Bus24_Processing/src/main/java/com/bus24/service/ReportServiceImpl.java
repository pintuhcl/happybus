package com.bus24.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bus24.beans.Agents;
import com.bus24.beans.Report;
import com.bus24.beans.Response;
import com.bus24.beans.Travel;
import com.bus24.dao.AmenityDAO;
import com.bus24.dao.ReportDAO;
import com.bus24.util.JsonUtil;
import com.bus24.util.StatusUtil;

/**
 * 
 * @author suchitra
 * @version 1.0
 */
@Service
public class ReportServiceImpl implements ReportService {
	private static Logger logger = Logger.getLogger(ReportServiceImpl.class);

	@Autowired
	private ReportDAO reportDAO;

	@Override
	public String getReport(Date from, Date to) {
		logger.info("Entering to getReport(Date from, Date to) method");

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Could Not Fetch Records! Please try again");
		try {
			List<Report> reportList = reportDAO.getReport(from, to);

			if (reportList != null && reportList.size() > 0) {
				logger.info(reportList);

				String jsonReport = JsonUtil.convertJavaToJson(reportList);

				response.setData(jsonReport);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("ReportList  found");
			} // if
			else {
				response.setMessage("Data Not Found In Database");
			}//else

		} // try
		catch (DataAccessException e) {
			logger.error("DataAcessEx", e);
			response.setMessage("Unable to process your request please try again");
		} catch (Exception e) {
			logger.error("Ex:", e);
			response.setMessage("Unable to process your request please try again");
		}
		String jsonResponse = JsonUtil.convertJavaToJson(response);

		return jsonResponse;
	}

	@Override
	public String getReport(Travel travel, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReport(Agents agent, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReport(Integer month) {
		logger.info("Entering to getReport(Integer month) method");

		Response response = new Response();
		response.setStatus(StatusUtil.STATUS_FAILURE);
		response.setMessage("Could Not Fetch Records! Please try again");
		try {
			List<Report> reportList = reportDAO.getReport(month);

			if (reportList != null && reportList.size() > 0) {
				logger.info(reportList);

				String jsonReport = JsonUtil.convertJavaToJson(reportList);

				response.setData(jsonReport);
				response.setStatus(StatusUtil.STATUS_SUCCESS);
				response.setMessage("ReportList  found");
			} // if
			else {
				response.setMessage("Data Not Found In Database");
			}//else

		} // try
		catch (DataAccessException e) {
			logger.error("DataAcessEx", e);
			response.setMessage("Unable to process your request please try again");
		} catch (Exception e) {
			logger.error("Ex:", e);
			response.setMessage("Unable to process your request please try again");
		}
		String jsonResponse = JsonUtil.convertJavaToJson(response);

		return jsonResponse;
	}

	@Override
	public String getReport(Travel travel, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReport(Agents agent, Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

}
