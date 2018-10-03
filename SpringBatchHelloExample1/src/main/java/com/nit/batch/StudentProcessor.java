package com.nit.batch;

import org.springframework.batch.item.ItemProcessor;

import com.nit.domain.Student;

public class StudentProcessor 
implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student std) throws Exception {
		return std;
	}

}
