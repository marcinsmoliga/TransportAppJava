package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		Driver driver = (Driver) o;
		return Objects.equals(drivingLicenceNumber, driver.drivingLicenceNumber) &&
				Objects.equals(driverVehicles, driver.driverVehicles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), drivingLicenceNumber, driverVehicles);
	}

	@Override
	public String toCsv() {
		return getFirstName() + ";" + getLastName() + ";" + getPesel() + ";" + drivingLicenceNumber;
	}
}
