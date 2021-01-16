package com.bpbproject.model.request;

import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentRequest {
	
	
	@NotNull(message="firstName cannot be null")
	@Size(min=2,message="password must be greater than 2 characters")
	private String firstName;
	
	@NotNull(message="lastName cannot be null")
	@Size(min=2,message="password must be greater than 2 characters")
    private String lastName;
	
	@NotNull(message="email cannot be null")
	@Email(message="email must be valid")
	private String email;
	
	@NotNull(message="userid cannot be null")
	@Size(min=8,max=16,message="password must be greater than 8 and less than 16 characters")
	private String password;
	
	public StudentRequest(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public StudentRequest() {
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}

}
