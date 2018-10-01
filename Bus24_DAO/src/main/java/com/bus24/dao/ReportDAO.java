package com.bus24.dao;

import java.util.Date;
import java.util.List;

import com.bus24.beans.Agents;
import com.bus24.beans.Report;
import com.bus24.beans.Travel;

/**
* This interface is used to generate Report for BUS24.
*@author  suchitra
* @since   1.0
*/
public interface ReportDAO {
	
	

	
	/**
	 * Get Report between two Date
	 * @param from
	 * @param to
	 * @return List<Report>
	 * @author suchi
	 */
	public List<Report> getReport(Date from,Date to);
	
	/**
	 * Get report between two date for specific travel
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	
	public List<Report> getReport(Travel travel,Date from,Date to);

	/**
	 * Get report between two date for specific agent
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public List<Report> getReport(Agents agent,Date from,Date to);
	
	

	/**
	 * Get report monthly  wise specific of all travel
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public List<Report> getReport(Integer month);
	/**
	 * Get report monthly  wise for specific travel 
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public List<Report> getReport(Travel travel,Integer month);
	/**
	 * Get report monthly  wise for specific agent 
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public List<Report> getReport(Agents agent,Integer month);
	
	
	
	
	
	
}
