package com.example.app;

import java.util.InputMismatchException;

import com.example.exception.DataExportException;
import com.example.exception.DataImportException;
import com.example.exception.InvalidDataException;
import com.example.exception.NoSuchOptionException;
import com.example.io.ConsolePrinter;
import com.example.io.DataReader;
import com.example.io.file.FileManager;
import com.example.io.file.FileManagerBuilder;
import com.example.model.CarDatabase;
import com.example.model.Truck;
import com.example.model.Van;

class CompanyControl {
	private final ConsolePrinter consolePrinter = new ConsolePrinter();
	private final DataReader dataReader = new DataReader(consolePrinter);
	private CarDatabase carDatabase;
	private final FileManager fileManager;

	public CompanyControl() {
		fileManager = new FileManagerBuilder(consolePrinter, dataReader).build();
		try {
			carDatabase = fileManager.importCarDatabase();
			consolePrinter.printNextLine("Successfully data imported");
		} catch (DataImportException | InvalidDataException e) {
			consolePrinter.printNextLine(e.getMessage());
			consolePrinter.printNextLine("A new database has been created");
			carDatabase = new CarDatabase();
		}
	}

	void printMenu() {
		Option option;

		do {
			printOptions();
			option = getOption();

			switch (option) {
				case ADD_CAR -> {
					printCarType();
					CarType carType = getCarType();
					addNewCar(carType);
				}
				case SHOW_CARS -> showAllCars();
				case EXIT -> exitProgram();
				default -> System.err.println("Incorrect input! Please try again.");
			}
		} while (option != Option.EXIT);
	}

	private Option getOption() {
		boolean correctOption = false;
		Option option = null;

		while (!correctOption) {
			try {
				option = Option.convertToOption(dataReader.getInt());
				correctOption = true;
			} catch (NoSuchOptionException e) {
				consolePrinter.printNextLine(e.getMessage());
			} catch (InputMismatchException e) {
				consolePrinter.printNextLine("Input is not a number! Please try again.");
			}
		}
		return option;
	}


	private void showAllCars() {
		carDatabase.printCars();
	}


	private void addNewCar(CarType carType) {
		switch (carType) {
			case TRUCK -> {
				Truck truck = dataReader.createTruck();
				carDatabase.addCar(truck);
			}
			case VAN -> {
				Van van = dataReader.createVan();
				carDatabase.addCar(van);
			}
		}
	}

	private void exitProgram() {
		try {
			fileManager.exportCarData(carDatabase);
			consolePrinter.printNextLine("Successful data write.");
		} catch (DataExportException e) {
			consolePrinter.printNextLine(e.getMessage());
			//TODO ask the user if he wants to try saving the data again
		}
		dataReader.close();
		consolePrinter.printNextLine("Quitting the program. The program has closed correctly.");


	}

	private void printOptions() {
		for (Option option : Option.values()) {
			consolePrinter.printNextLine(option.toString());
		}
		consolePrinter.printLine("Choose action: ");
	}

	private void printCarType() {
		for (CarType carType : CarType.values()) {
			consolePrinter.printNextLine(carType.toString());
		}
		consolePrinter.printLine("Choose car type: ");

	}

	private CarType getCarType() {
		boolean carNumber = false;
		CarType carType = null;

		while (!carNumber) {
			try {
				carType = CarType.convertToCarType(dataReader.getInt());
				carNumber = true;
			} catch (NoSuchOptionException e) {
				consolePrinter.printNextLine(e.getMessage());
			} catch (InputMismatchException e) {
				consolePrinter.printNextLine("Input is not a number! Please try again.");
			}
		}
		return carType;
	}

	public enum Option {
		EXIT(0, "exit the program"),
		ADD_CAR(1, "add car"),
		SHOW_CARS(2, "show all cars");

		private final int optionNumber;
		private final String description;

		Option(int optionNumber, String description) {
			this.optionNumber = optionNumber;
			this.description = description;
		}

		public static Option convertToOption(int number) throws NoSuchOptionException {
			try {
				return Option.values()[number];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchOptionException("There is no such option as " + number);
			}

		}

		@Override
		public String toString() {
			return optionNumber + " - " + description;
		}
	}

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


}
