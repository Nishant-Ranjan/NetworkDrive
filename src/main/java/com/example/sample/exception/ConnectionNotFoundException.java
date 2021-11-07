package com.example.sample.exception;

public class ConnectionNotFoundException extends RuntimeException {
	
	public ConnectionNotFoundException(String message) {
		super(message);
	}
}
