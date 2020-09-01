package com.example.app;

import com.example.database.VehicleDatabase;
import com.example.io.DataReader;
import com.example.model.Truck;
import com.example.model.Van;

public class CompanyControl {
    private final DataReader dataReader = new DataReader();
    private final VehicleDatabase vehicleDatabase = new VehicleDatabase();
    private final static int EXIT = 0;
    private final static int ADD_TRUCK = 1;
    private final static int SHOW_ALL_TRUCKS = 2;
    private final static int ADD_VAN = 3;
    private final static int SHOW_ALL_VANS = 4;

    public void startProgram() {
        int option;
        do {
            printMenu();
            option = dataReader.getInt();
            switch (option) {
                case EXIT -> exitProgram();
                case ADD_TRUCK -> addNewTruck();
                case SHOW_ALL_TRUCKS -> showAllTrucks();
                case ADD_VAN -> addNewVan();
                case SHOW_ALL_VANS -> showAllVans();
            }
        } while (option != EXIT);
    }

    private void showAllVans() {
        vehicleDatabase.printVans();
    }

    private void addNewVan() {
        Van van = dataReader.createVan();
        vehicleDatabase.addVan(van);
    }

    private void showAllTrucks() {
        vehicleDatabase.printTrucks();
    }

    private void exitProgram() {
        System.out.println("");
        dataReader.closeReader();

    }

    private void addNewTruck() {
        Truck truck = dataReader.createTruck();
        vehicleDatabase.addTruck(truck);
    }

    private void printMenu() {
        System.out.println("LoadAndGo");
        System.out.println(" " + EXIT + " - exit the program\n " +
                ADD_TRUCK + " - add new truck to the database\n " +
                SHOW_ALL_TRUCKS + " - retrieve all trucks from the database\n " +
                ADD_VAN + " - add new van to the database\n " +
                SHOW_ALL_VANS + " - retrieve all vans from the database");
        System.out.print("Choose option: ");
    }
}
