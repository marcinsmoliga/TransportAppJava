package com.example.io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.example.exception.DataExportException;
import com.example.exception.DataImportException;
import com.example.model.CarDatabase;
import com.example.model.PersonDatabase;

public class SerializableFileManager implements FileManager {
	private static final String CAR_DATABASE = "cardatabase.o";
	private static final String PERSON_DATABASE = "persondatabase.o";

	@Override
	public CarDatabase importCarDatabase() {
		try (
				FileInputStream fis = new FileInputStream(CAR_DATABASE);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			return (CarDatabase) ois.readObject();
		} catch (FileNotFoundException e) {
			throw new DataImportException(CAR_DATABASE + " file not found!");
		} catch (ClassNotFoundException e) {
			throw new DataImportException("Error reading data from the file " + CAR_DATABASE);
		} catch (IOException e) {
			throw new DataExportException("Incompatible data type in the file " + CAR_DATABASE);
		}

	}

	@Override
	public PersonDatabase importPersonDatabase() {
		try (
				FileInputStream fis = new FileInputStream(PERSON_DATABASE);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			return (PersonDatabase) ois.readObject();
		} catch (FileNotFoundException e) {
			throw new DataImportException(PERSON_DATABASE + " file not found!");
		} catch (ClassNotFoundException e) {
			throw new DataImportException("Error reading data from the file " + PERSON_DATABASE);
		} catch (IOException e) {
			throw new DataExportException("Incompatible data type in the file " + PERSON_DATABASE);
		}
	}

	@Override
	public void exportCarData(CarDatabase carDatabase) {
		try (
				FileOutputStream fos = new FileOutputStream(CAR_DATABASE);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(carDatabase);
		} catch (FileNotFoundException e) {
			throw new DataExportException(CAR_DATABASE + " file not found!");
		} catch (IOException e) {
			throw new DataExportException("Error writing data to the file " + CAR_DATABASE);
		}
	}

	@Override
	public void exportPersonData(PersonDatabase personDatabase) {
		try (
				FileOutputStream fos = new FileOutputStream(PERSON_DATABASE);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(personDatabase);
		} catch (FileNotFoundException e) {
			throw new DataExportException(CAR_DATABASE + " file not found!");
		} catch (IOException e) {
			throw new DataExportException("Error writing data to the file " + CAR_DATABASE);
		}
	}
}
