package com.example.enumPackage;

import com.example.exception.NoSuchOptionException;

public enum CarType {
	TRUCK(1, "add Truck"),
	VAN(2, "add Van");

	private final int carNumber;
	private final String description;

	CarType(int carNumber, String description) {
		this.carNumber = carNumber;
		this.description = description;
	}

	public static CarType convertToCarType(int number) throws NoSuchOptionException {
		try {
			return CarType.values()[number - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoSuchOptionException("There is no such option as " + number);
		}
	}

	@Override
	public String toString() {
		return "(" + carNumber + ")" + " - " + description;
	}
}
