package com.bpbproject.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bpbproject.model.ExceptionMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String localizedMessage=ex.getLocalizedMessage();
		
		if (localizedMessage==null) {
			localizedMessage=ex.toString();
		}
		ExceptionMessage exceptionMessage=new ExceptionMessage(new Date(),localizedMessage);
		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value= {StudentServiceException.class, NullPointerException.class})
	public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request){
		
		String localizedMessage=ex.getLocalizedMessage();
		
		if (localizedMessage==null) {
			localizedMessage=ex.toString();
		}
		ExceptionMessage exceptionMessage=new ExceptionMessage(new Date(),localizedMessage);
		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
/*
	@ExceptionHandler(value= {StudentServiceException.class})
	public ResponseEntity<Object> handleStudentServiceException(StudentServiceException ex, WebRequest request){
		
		String localizedMessage=ex.getLocalizedMessage();
		
		if (localizedMessage==null) {
			localizedMessage=ex.toString();
		}
		ExceptionMessage exceptionMessage=new ExceptionMessage(new Date(),localizedMessage);
		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
*/}
