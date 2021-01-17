package com.bpbproject.studentservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpbproject.controllers.utilities.Utils;
import com.bpbproject.model.Student;
import com.bpbproject.model.request.StudentRequest;
import com.bpbproject.studentservice.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	Map<String, Student> studentMap;
	
	Utils utils;
	
	public StudentServiceImpl() {}

	@Autowired
	public StudentServiceImpl(Utils utils) {
		this.utils = utils;
	}

	public Student createStudent(StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		
		Student studentResponse = new Student();
		studentResponse.setFirstName(studentRequest.getFirstName());
		studentResponse.setLastName(studentRequest.getLastName());
		studentResponse.setEmail(studentRequest.getEmail());
		
		//String userId=UUID.randomUUID().toString();
		
		String userId=utils.generateUserId();
		studentResponse.setUserId(userId);
		if (studentMap==null) {
			studentMap = new HashMap<String, Student>();
			studentMap.put(userId, studentResponse);
			
		}
		return studentResponse;
	}

}
