package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Driver extends Employee {
	private final String drivingLicenceNumber;
	private List<Vehicle> driverVehicles = new ArrayList<>();


	public Driver(String firstName, String lastName, String pesel, String drivingLicenceNumber) {
		super(firstName, lastName, pesel);
		this.drivingLicenceNumber = drivingLicenceNumber;
	}

	public void addVehicle(Vehicle vehicle) {
		driverVehicles.add(vehicle);
	}
}
