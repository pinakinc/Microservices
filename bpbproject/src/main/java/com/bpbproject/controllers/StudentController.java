package com.bpbproject.controllers;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bpbproject.exceptions.StudentServiceException;
import com.bpbproject.model.Student;
import com.bpbproject.model.request.StudentRequest;
import com.bpbproject.model.request.UpdateStudentRequest;
import com.bpbproject.studentservice.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	Map<String, Student> studentMap;
	
	@Autowired
    StudentService studentService;

	private static final String PATH = "/hello";

	@GetMapping
	public String getStudents(@RequestParam(value="page",defaultValue="1") int page, @RequestParam(value="limit",defaultValue="50") int limit,@RequestParam(value="sort",required=false) String sort) {
		return "get all students was called for page "+ page + " with limit "+limit+ " is sorted "+sort;
	}

	@GetMapping(path="/{userId}", produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Student> getStudent(@PathVariable String userId) {
		
//		String firstName=null;
		
//		@SuppressWarnings("unused")
//		int firstNameLength = firstName.length();
		
		if (true) throw new StudentServiceException("A student service exception was thrown");
		
		if (studentMap.containsKey(userId)) {
			return new ResponseEntity<>(studentMap.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
		
	}

	@PutMapping(path="/{userId}", consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Student updateStudent(@PathVariable String userId, @Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student fetchStudent=studentMap.get(userId);
		fetchStudent.setFirstName(updateStudentRequest.getFirstName());
		fetchStudent.setLastName(updateStudentRequest.getLastName());
		studentMap.put(userId, fetchStudent);
		return fetchStudent;
	}

	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
		
		Student studentResponse = studentService.createStudent(studentRequest);
		
		return new ResponseEntity<Student>(studentResponse, HttpStatus.OK);

		
	}

	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		studentMap.remove(userId);
		return ResponseEntity.noContent().build();
	}

}