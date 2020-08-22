package com.example.model;

public class Van extends Car {
	public static final String TYPE = "Van";
	public Van(String brand, String vehicleRegistrationPlate, int wheels) {
		super(brand, vehicleRegistrationPlate, wheels);
	}

	@Override
	public String toCSV() {
		return TYPE + ";" +
				getBrand() + ";" +
				getVehicleRegistrationPlate() + ";" +
				getWheels();
	}
}
