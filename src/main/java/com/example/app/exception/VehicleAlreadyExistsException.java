package com.example.app.exception;

public class VehicleAlreadyExistsException extends RuntimeException {
	public VehicleAlreadyExistsException(String message) {
		super(message);
	}
}
