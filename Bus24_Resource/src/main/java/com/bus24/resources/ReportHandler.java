package com.bus24.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.ReportService;

/**
 * @author: suchitra
 * @version:1.0
 *
 */
@RestController
@RequestMapping("report")
public class ReportHandler {
	@Autowired
	ReportService reportService=null;

	@GetMapping("/listAllReportBetween")
	@ResponseBody
	public String getReport(@PathVariable("from") Date from,@PathVariable("to") Date to)
	{
		return reportService.getReport(from, to);
		
	}
	
	@GetMapping("/listAllReportMonthly")
	@ResponseBody
	public String getReport(@PathVariable("month") Integer month)
	{
		return reportService.getReport(month);
		
	}
	
}
