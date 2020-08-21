package com.example.model;

import java.io.Serializable;

public class CarDatabase implements Serializable {
	private static final int MAX_CARS = 1000;
	private Car[] cars = new Car[MAX_CARS];
	private int carNumber = 0;

	public void addCar(Car car) {
		if (carNumber > MAX_CARS) {
			System.err.println("Not enough space in the database! Can not add the next car!");
		} else {
			cars[carNumber] = car;
			carNumber++;
		}
	}

	public void printCars() {
		for (int i = 0; i < carNumber; i++) {
			System.out.println(cars[i]);
		}
	}
}
