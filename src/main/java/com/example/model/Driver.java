package com.example.model;

public class Driver extends Person {
	private String drivingLicenceNumber;

	public Driver(String firstName, String lastName, int birthYear, String drivingLicenceNumber) {
		super(firstName, lastName, birthYear);
		this.drivingLicenceNumber = drivingLicenceNumber;
	}

	public String getDrivingLicenceNumber() {
		return drivingLicenceNumber;
	}

	public void setDrivingLicenceNumber(String drivingLicenceNumber) {
		this.drivingLicenceNumber = drivingLicenceNumber;
	}
}
