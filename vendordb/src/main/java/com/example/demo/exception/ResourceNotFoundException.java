package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2437474697516521871L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

//	public ResourceNotFoundException(String message, String string, String vendorCode) {
//		// TODO Auto-generated constructor stub
//		super(message);
//	}
}