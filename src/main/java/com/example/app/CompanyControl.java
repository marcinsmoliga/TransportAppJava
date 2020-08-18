package com.example.app;

import com.example.io.DataReader;
import com.example.model.Car;
import com.example.model.CarDatabase;
import com.example.model.Person;
import com.example.model.PersonDatabase;

public class CompanyControl {
	private final DataReader dataReader = new DataReader();
	private final CarDatabase carDatabase = new CarDatabase();
	private final PersonDatabase personDatabase = new PersonDatabase();

	public void printMenu() {
		Option option;

		do {
			printOptions();
			option = Option.convertToOption(dataReader.getInt());

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
		} while (option != Option.EXIT);
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
		for(Option option : Option.values()) {
			System.out.println(option);
		}
		System.out.print("Choose action: ");
	}


}
