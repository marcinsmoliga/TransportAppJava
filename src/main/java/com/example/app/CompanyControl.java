package com.example.app;

import java.util.InputMismatchException;

import com.example.app.exception.NoSuchOptionException;
import com.example.database.VehicleDatabase;
import com.example.io.ConsolePrinter;
import com.example.io.DataReader;
import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class CompanyControl {
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(consolePrinter);
    private final VehicleDatabase vehicleDatabase = new VehicleDatabase();

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
        vehicleDatabase.addVan(van);
    }

    private void showAllTrucks() {
        Vehicle[] vehicles = vehicleDatabase.getVehicles();
        consolePrinter.printTrucks(vehicles);
    }

    private void exitProgram() {
        System.out.println("");
        dataReader.closeReader();

    }

    private void addNewTruck() {
        try {
            Truck truck = dataReader.createTruck();
            vehicleDatabase.addTruck(truck);
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
