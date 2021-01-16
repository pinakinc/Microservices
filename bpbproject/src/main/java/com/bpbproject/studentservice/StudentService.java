package com.bpbproject.studentservice;

import com.bpbproject.model.Student;
import com.bpbproject.model.request.StudentRequest;

public interface StudentService {
	Student createStudent(StudentRequest studentRequest);

}
