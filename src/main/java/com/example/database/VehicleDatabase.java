package com.example.database;

import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class VehicleDatabase {
    private final static int MAX_VEHICLE = 1000;
    private final Vehicle[] vehicles = new Vehicle[MAX_VEHICLE];
    private int vehicleNumber = 0;


    public void addTruck(Truck truck) {
        if (vehicleNumber < MAX_VEHICLE) {
            vehicles[vehicleNumber] = truck;
            vehicleNumber++;
        } else {
            System.out.println("It is not possible to add another vehicle. There is no space in the database.");
        }
    }

    public void printTrucks() {
        int truckNumber = 0;

        for (int i = 0; i < vehicleNumber; i++) {
            if (vehicles[i] instanceof Truck) {
                System.out.println(vehicles[i]);
                truckNumber++;
            }
        }

        if (truckNumber == 0) {
            System.out.println("No trucks in the database.");
        }
        System.out.println();
    }

    public void addVan(Van van) {
        if (vehicleNumber < MAX_VEHICLE) {
            vehicles[vehicleNumber] = van;
            vehicleNumber++;
        } else {
            System.out.println("It is not possible to add another vehicle. There is no space in the database.");
        }
    }

    public void printVans() {
        int vanNumber = 0;

        for (int i = 0; i < vehicleNumber; i++) {
            if (vehicles[i] instanceof Van) {
                System.out.println(vehicles[i]);
                vanNumber++;
            }
        }

        if (vanNumber == 0) {
            System.out.println("No vanes in the database.");
        }
        System.out.println();
    }
}
