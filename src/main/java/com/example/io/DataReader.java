package com.example.io;

import java.util.Scanner;

import com.example.model.Car;
import com.example.model.Person;
import com.example.model.Truck;
import com.example.model.Van;

public class DataReader {
	private ConsolePrinter consolePrinter;
	private Scanner sc = new Scanner(System.in);

	public DataReader(ConsolePrinter consolePrinter) {
		this.consolePrinter = consolePrinter;
	}

	public Person createPerson() {
		consolePrinter.printNextLine("Enter first name: ");
		String firstName = sc.nextLine();
		consolePrinter.printNextLine("Enter last name: ");
		String lastName = sc.nextLine();
		consolePrinter.printNextLine("Enter year of birth: ");
		int year = sc.nextInt();

		return new Person(firstName, lastName, year);
	}

	public Truck createTruck() {
		consolePrinter.printNextLine("Enter brand: ");
		String brand = sc.nextLine();
		consolePrinter.printNextLine("Enter Vehicle Registration Plate: ");
		String vehicleRegistrationPlate = sc.nextLine();
		consolePrinter.printNextLine("Enter the number of wheels: ");
		int wheels = getInt();

		return new Truck(brand, vehicleRegistrationPlate, wheels);
	}

	public Van createVan() {
		consolePrinter.printNextLine("Enter brand: ");
		String brand = sc.nextLine();
		consolePrinter.printNextLine("Enter Vehicle Registration Plate: ");
		String vehicleRegistrationPlate = sc.nextLine();
		consolePrinter.printNextLine("Enter the number of wheels: ");
		int wheels = getInt();

		return new Van(brand, vehicleRegistrationPlate, wheels);
	}

	public int getInt() {
		try {
			return sc.nextInt();
		} finally {
			clearBuffer();
		}

	}

	public void close() {
		sc.close();
	}

	public void clearBuffer() {
		sc.nextLine();
	}
}
