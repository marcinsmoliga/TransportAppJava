package com.example.app;

import java.util.InputMismatchException;

import com.example.app.exception.DataExportException;
import com.example.app.exception.DataImportException;
import com.example.app.exception.InvalidDataException;
import com.example.app.exception.NoSuchOptionException;
import com.example.database.VehicleDatabase;
import com.example.io.ConsolePrinter;
import com.example.io.DataReader;
import com.example.io.file.FileManager;
import com.example.io.file.FileManagerBuilder;
import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class CompanyControl {
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(consolePrinter);
    private final FileManager fileManager;
    private VehicleDatabase vehicleDatabase;

    public CompanyControl() {
        fileManager = new FileManagerBuilder(consolePrinter, dataReader).build();
        try {
            vehicleDatabase = fileManager.importData();
            consolePrinter.printNextLine("Successfully retrieved data from the database.");
        } catch (DataImportException | InvalidDataException e) {
            consolePrinter.printNextLine(e.getMessage());
            consolePrinter.printNextLine("A new database has been created.");
            vehicleDatabase = new VehicleDatabase();
        }
    }

    public void startProgram() {
        Option option;
        do {
            printMenu();
            option = getOption();
            switch (option) {
                case EXIT -> exitProgram();
                case ADD_TRUCK -> addNewTruck();
                case SHOW_ALL_TRUCKS -> showAllTrucks();
                case ADD_VAN -> addNewVan();
                case SHOW_ALL_VANS -> showAllVans();
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        Option option = null;
        boolean isOptionCorrect = false;
        while (!isOptionCorrect) {
            try {
                option = Option.getOptionFromInt(dataReader.getInt());
                isOptionCorrect = true;
            } catch (NoSuchOptionException e) {
                consolePrinter.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                consolePrinter.printLine("Incorrect option inserted. Please choose the option again: ");
            }
        }
        return option;
    }

    private void showAllVans() {
        Vehicle[] vehicles = vehicleDatabase.getVehicles();
        consolePrinter.printVans(vehicles);
    }

    private void addNewVan() {
        Van van = dataReader.createVan();
        vehicleDatabase.addVehicle(van);
    }

    private void showAllTrucks() {
        Vehicle[] vehicles = vehicleDatabase.getVehicles();
        consolePrinter.printTrucks(vehicles);
    }

    private void exitProgram() {
        consolePrinter.printNextLine("Saving data to the database.");
        try {
            fileManager.exportData(vehicleDatabase);
            consolePrinter.printNextLine("Data saved successfully.");
        } catch (DataExportException e) {
            consolePrinter.printNextLine(e.getMessage());
        }
        dataReader.closeReader();
        consolePrinter.printNextLine("Closing the program.");


    }

    private void addNewTruck() {
        try {
            Truck truck = dataReader.createTruck();
            vehicleDatabase.addVehicle(truck);
        } catch (InputMismatchException e) {
            consolePrinter.printNextLine("The vehicle can not be added to the database " +
                    " the year of registration must be a number. Please try again.");
        } catch (ArrayIndexOutOfBoundsException e) {
            consolePrinter.printNextLine(e.getMessage());
        }
    }

    private void printMenu() {
        System.out.println("LoadAndGo");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
        System.out.print("Choose option: ");
    }
}
