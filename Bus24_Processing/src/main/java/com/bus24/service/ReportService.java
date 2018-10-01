package com.bus24.service;

import java.util.Date;
import java.util.List;

import com.bus24.beans.Agents;
import com.bus24.beans.Report;
import com.bus24.beans.Travel;

/**
 * This interface is gather agent requirements
 * 
 * @author suchitra
 * @since 1.0
 */
public interface ReportService {
	
	/**
	 * Get Report between two Date
	 * @param from
	 * @param to
	 * @return List<Report>
	 * @author suchi
	 */
	public String getReport(Date from,Date to);
	
	/**
	 * Get report between two date for specific travel
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	
	public String getReport(Travel travel,Date from,Date to);

	/**
	 * Get report between two date for specific agent
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public String getReport(Agents agent,Date from,Date to);
	
	

	/**
	 * Get report monthly  wise specific of all travel
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public String getReport(Integer month);
	/**
	 * Get report monthly  wise for specific travel 
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public String getReport(Travel travel,Integer month);
	/**
	 * Get report monthly  wise for specific agent 
	 * @param travel
	 * @param from
	 * @param to
	 * @return
	 * @author suchi
	 */
	
	public String getReport(Agents agent,Integer month);
	
	
	
	
	
	

}
