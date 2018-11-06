package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentDao {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department save(Department dept)
	{
		return departmentRepository.save(dept);
		
	}
	

}
