package com.bpbproject.model;

import java.util.Date;

public class ExceptionMessage {
	private Date timeStamp;
	private String message;
	public Date getTimeStamp() {
		return timeStamp;
	}
	public ExceptionMessage(Date timeStamp, String message) {
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public ExceptionMessage() {
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
