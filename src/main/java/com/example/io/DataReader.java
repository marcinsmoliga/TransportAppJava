package com.example.io;

import java.util.Scanner;

import com.example.model.Car;
import com.example.model.Person;

public class DataReader {
	private Scanner sc = new Scanner(System.in);

	public Person createPerson() {
		System.out.print("Enter first name: ");
		String firstName = sc.nextLine();
		System.out.print("Enter last name: ");
		String lastName = sc.nextLine();
		System.out.print("Enter year of birth: ");
		int year = sc.nextInt();

		return new Person(firstName, lastName, year);
	}

	public Car createCar() {
		System.out.print("Enter brand: ");
		String brand = sc.nextLine();
		System.out.print("Enter Vehicle Registration Plate: ");
		String vehicleRegistrationPlate = sc.nextLine();
		System.out.print("Enter the number of wheels: ");
		int wheels = getInt();

		return new Car(brand, vehicleRegistrationPlate, wheels);
	}

	public int getInt() {
		int number = sc.nextInt();
		sc.nextLine();
		return number;
	}

	public void close() {
		sc.close();
	}
}
