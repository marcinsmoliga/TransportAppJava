package com.example.model;

public class Truck extends Car {
	public static final String TYPE = "Truck";

	public Truck(String brand, String vehicleRegistrationPlate, int wheels) {
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
