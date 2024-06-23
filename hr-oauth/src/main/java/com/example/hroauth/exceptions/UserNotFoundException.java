package com.example.hroauth.exceptions;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private int status;
	
	public UserNotFoundException(String errorMessage, int status) {
		super(errorMessage);
		this.status = status;
	}

}
