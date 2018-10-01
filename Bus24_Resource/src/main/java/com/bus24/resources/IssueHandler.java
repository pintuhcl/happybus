package com.bus24.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus24.service.IssueService;
/**
 * @author Jagannath
 *
 */
@RestController
@RequestMapping(value = "issue")
public class IssueHandler {
	@Autowired
	private IssueService issueService;
	
	@RequestMapping(value="addIssue", method=RequestMethod.POST)
	@ResponseBody
	public String addIssue(@RequestBody String jsonIssue)
	{
		String jsonResponse=issueService.insertIssue(jsonIssue);
		return jsonResponse;
		
	}
	
	@RequestMapping(value="listIssue", method=RequestMethod.GET)
	@ResponseBody
	public String selectAllIssue() {
		return issueService.selectAllIssue();
	}

	
}
