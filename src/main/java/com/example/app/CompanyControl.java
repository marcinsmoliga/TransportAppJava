package com.example.app;

import com.example.io.DataReader;
import com.example.model.Car;
import com.example.model.CarDatabase;
import com.example.model.Person;
import com.example.model.PersonDatabase;

public class CompanyControl {
	private final int exit = 0;
	private final int addCar = 1;
	private final int addPerson = 2;
	private final int showCars = 3;
	private final int showPeople = 4;
	private final DataReader dataReader = new DataReader();
	private final CarDatabase carDatabase = new CarDatabase();
	private final PersonDatabase personDatabase = new PersonDatabase();

	public void printMenu() {
		int option = -1;

		do {
			printOptions();
			option = dataReader.getInt();

			switch (option) {
				case addCar:
					addNewCar();
					break;
				case addPerson:
					addNewPerson();
					break;
				case showCars:
					showAllCars();
					break;
				case showPeople:
					showAllPeople();
					break;
				case exit:
					exitProgram();
					break;
				default:
					System.err.println("Incorrect input! Please try again.");
			}
		} while (option != exit);
	}

	private void showAllPeople() {
		personDatabase.printPeople();
	}

	private void showAllCars() {
		carDatabase.printCars();
	}

	private void addNewPerson() {
		Person person = dataReader.createPerson();
		personDatabase.addPerson(person);
	}

	private void addNewCar() {
		Car car = dataReader.createCar();
		carDatabase.addCar(car);
	}

	private void exitProgram() {
		dataReader.close();
		System.out.println("Quitting the program. The program has closed correctly.");


	}

	private void printOptions() {
		System.out.println(addCar + " - add car");
		System.out.println(addPerson + " - add person");
		System.out.println(showCars + " - show all cars");
		System.out.println(showPeople + " - show all people");
		System.out.println(exit + " - exit the program");
		System.out.print("Choose action: ");
	}


}
