package com.example.app;

import com.example.database.VehicleDatabase;
import com.example.io.DataReader;
import com.example.model.Truck;
import com.example.model.Van;

public class CompanyControl {
    private final DataReader dataReader = new DataReader();
    private final VehicleDatabase vehicleDatabase = new VehicleDatabase();

    public void startProgram() {
        Option option;
        do {
            printMenu();
            option = Option.getOptionFromInt(dataReader.getInt());
            switch (option) {
                case EXIT -> exitProgram();
                case ADD_TRUCK -> addNewTruck();
                case SHOW_ALL_TRUCKS -> showAllTrucks();
                case ADD_VAN -> addNewVan();
                case SHOW_ALL_VANS -> showAllVans();
            }
        } while (option != Option.EXIT);
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
        for (Option option : Option.values()) {
            System.out.println(option);
        }
        System.out.print("Choose option: ");
    }
}
