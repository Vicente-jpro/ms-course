package com.example.hrpayment.exceptions;

public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PaymentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
