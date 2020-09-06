package com.example.io;

import java.util.Scanner;

import com.example.model.Driver;
import com.example.model.Truck;
import com.example.model.Van;

public class DataReader {
    ConsolePrinter consolePrinter;
    private final Scanner sc = new Scanner(System.in);

    public DataReader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Truck createTruck() {
        consolePrinter.printLine("Enter the brand name: ");
        String brand = getString();
        consolePrinter.printLine("Enter the Vehicle Registration Plate: ");
        String vehicleRegistrationPlate = getString();
        consolePrinter.printLine("Enter the year of registration: ");
        int regYear = getInt();
        consolePrinter.printLine("Enter the tachograph model version: ");
        String tachographModel = getString();

        return new Truck(brand, vehicleRegistrationPlate, regYear, tachographModel);
    }

    public Van createVan() {
        consolePrinter.printLine("Enter the brand name: ");
        String brand = getString();
        consolePrinter.printLine("Enter the Vehicle Registration Plate: ");
        String vehicleRegistrationPlate = getString();
        consolePrinter.printLine("Enter the year of registration: ");
        int regYear = getInt();
        consolePrinter.printLine("Enter the max number of Euro pallets that can be loaded: ");
        int euroPalletsNumber = getInt();

        return new Van(brand, vehicleRegistrationPlate, regYear, euroPalletsNumber);
    }
    
    public Driver createDriver() {
        consolePrinter.printLine("First name: ");
        String firstName = getString();
        consolePrinter.printLine("Last name: ");
        String lastName = getString();
        consolePrinter.printLine("PESEL: ");
        String pesel = getString();
        consolePrinter.printLine("Driving Licence No: ");
        String drivingLicenceNo = getString();
        return new Driver(firstName, lastName, pesel, drivingLicenceNo);
    }

    public void closeReader() {
        sc.close();
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            getString();
        }
    }

    public String getString() {
        return sc.nextLine();
    }
}
