package com.sakshi.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;

	private String details;

	private String message;

	public ExceptionResponse(Date timeStamp, String details, String message) {
		super();
		this.timeStamp = timeStamp;
		this.details = details;
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
