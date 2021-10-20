package com.example.customer.error;

import java.util.Date;
import java.util.Map;

public class ApiError {
	
	int status;
	String message;
	long timestamp;
	String path;
	
	Map<String, String> validationErrors;

	public ApiError(int status, String message, String path) {
		super();
		this.timestamp = new Date().getTime();
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public void setValidationErrors(Map<String, String> validationErrors2) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
