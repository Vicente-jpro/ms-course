package com.example.hrworkers.exceptions;

public class WorkerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public WorkerNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
