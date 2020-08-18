package com.example.app;

import com.example.io.DataReader;
import com.example.model.Car;
import com.example.model.CarDatabase;
import com.example.model.Person;
import com.example.model.PersonDatabase;

public class CompanyControl {
	private static final int EXIT = 0;
	private static final int ADD_CAR = 1;
	private static final int ADD_PERSON = 2;
	private static final int SHOW_CARS = 3;
	private static final int SHOW_PEOPLE = 4;
	private final DataReader dataReader = new DataReader();
	private final CarDatabase carDatabase = new CarDatabase();
	private final PersonDatabase personDatabase = new PersonDatabase();

	public void printMenu() {
		int option = -1;

		do {
			printOptions();
			option = dataReader.getInt();

			switch (option) {
				case ADD_CAR:
					addNewCar();
					break;
				case ADD_PERSON:
					addNewPerson();
					break;
				case SHOW_CARS:
					showAllCars();
					break;
				case SHOW_PEOPLE:
					showAllPeople();
					break;
				case EXIT:
					exitProgram();
					break;
				default:
					System.err.println("Incorrect input! Please try again.");
			}
		} while (option != EXIT);
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
		System.out.println(ADD_CAR + " - add car");
		System.out.println(ADD_PERSON + " - add person");
		System.out.println(SHOW_CARS + " - show all cars");
		System.out.println(SHOW_PEOPLE + " - show all people");
		System.out.println(EXIT + " - exit the program");
		System.out.print("Choose action: ");
	}


}
