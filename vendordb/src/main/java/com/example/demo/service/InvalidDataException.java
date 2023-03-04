package com.example.demo.service;

public class InvalidDataException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2423997402484948850L;

	public InvalidDataException(String message) {
        super(message);
    }
}

