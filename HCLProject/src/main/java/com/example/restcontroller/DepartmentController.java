package com.example.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Department;
import com.example.dao.DepartmentDao;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	
	@PostMapping("/savedept")
	public ResponseEntity<?> saveDepartment(@Valid @RequestBody Department depart,Errors error)
	{
		
		if(error.hasErrors())
		{
			return ResponseEntity.badRequest().body(error.getAllErrors());
		}
		
		else	{
		
		Department departmented=departmentDao.save(depart);
				return ResponseEntity.ok("After saving the department the id is "+departmented.getDepartmentId());
	}
		
	
	
	

		
	
	}
}
