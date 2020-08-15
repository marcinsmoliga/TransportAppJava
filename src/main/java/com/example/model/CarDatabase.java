package com.example.model;

public class CarDatabase {
	private final int maxCars = 1000;
	private Car[] cars = new Car[maxCars];
	private int carNumber = 0;

	public void addCar(Car car) {
		if (carNumber > maxCars) {
			System.err.println("Not enough space in the database! Can not add next car!");
		} else {
			cars[carNumber] = car;
			carNumber++;
		}
	}

	public void printCars() {
		for (int i = 0; i < carNumber; i++) {
			cars[i].printInfo();
		}
	}
}
