package com.example.app;

import com.example.database.VehicleDatabase;
import com.example.io.DataReader;
import com.example.model.Truck;

public class CompanyControl {
    private final DataReader dataReader = new DataReader();
    private final VehicleDatabase vehicleDatabase = new VehicleDatabase();
    private final static int EXIT = 0;
    private final static int ADD_TRUCK = 1;
    private final static int SHOW_ALL_TRUCKS = 2;

    public void startProgram() {
        int option;
        do {
            printMenu();
            option = dataReader.getInt();
            switch (option) {
                case EXIT -> exitProgram();
                case ADD_TRUCK -> addNewTruck();
                case SHOW_ALL_TRUCKS -> showAllTrucks();
            }
        } while (option != EXIT);
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
                ADD_TRUCK + " - add truck to the database\n " +
                SHOW_ALL_TRUCKS + " - show all trucks from the database");
        System.out.print("Choose option: ");
    }
}
