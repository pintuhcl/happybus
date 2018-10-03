package com.nit.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.nit.domain.Student;

public class StudentWriter implements ItemWriter<Student> {

	@Override
	public void write(List<? extends Student> list) throws Exception {
	
		for(Student std:list){
	System.out.println(std.getName()+" "+std.getCourse()+" "+std.getEmail());		
		}
	}

}
