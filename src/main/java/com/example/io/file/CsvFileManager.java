package com.example.io.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.example.exception.DataExportException;
import com.example.exception.DataImportException;
import com.example.exception.InvalidDataException;
import com.example.model.Car;
import com.example.model.CarDatabase;
import com.example.model.PersonDatabase;
import com.example.model.Truck;
import com.example.model.Van;

public class CsvFileManager implements FileManager {
	private static final String FILE_NAME = "cardatabase.csv";

	@Override
	public CarDatabase importCarDatabase() {
		CarDatabase carDatabase = new CarDatabase();
		try (
				Scanner sc = new Scanner(new File(FILE_NAME));
		) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				Car car = createObjectFromString(line);
				carDatabase.addCar(car);
			}

		} catch (FileNotFoundException e) {
			throw new DataImportException("File " + FILE_NAME + " not found.");
		}
		return carDatabase;
	}

	private Car createObjectFromString(String line) {
		String[] elements = line.split(";");
		String type = elements[0];

		if (type.equals(Truck.TYPE)) {
			return createTruck(elements);
		} else if (type.equals(Van.TYPE)) {
			return createVan(elements);
		}
		throw new InvalidDataException("Unknown data type " + type);
	}

	private Van createVan(String[] elements) {
		String brand = elements[1];
		String vehicleRegistrationPlate = elements[2];
		int wheels = Integer.parseInt(elements[3]);
		return new Van(brand, vehicleRegistrationPlate, wheels);
	}

	private Truck createTruck(String[] elements) {
		String brand = elements[1];
		String vehicleRegistrationPlate = elements[2];
		int wheels = Integer.parseInt(elements[3]);
		return new Truck(brand, vehicleRegistrationPlate, wheels);
	}

	@Override
	public PersonDatabase importPersonDatabase() {
		return null;
	}

	@Override
	public void exportCarData(CarDatabase carDatabase) {
		Car[] cars = carDatabase.getCars();
		try (
				FileWriter fw = new FileWriter(FILE_NAME);
				BufferedWriter bw = new BufferedWriter(fw);
		) {
			for (Car car : cars) {
				bw.write(car.toCSV());
				bw.newLine();
			}
		} catch (IOException e) {
			throw new DataExportException("Error writing data to the file " + FILE_NAME);
		}
	}

	@Override
	public void exportPersonData(PersonDatabase personDatabase) {

	}
}
