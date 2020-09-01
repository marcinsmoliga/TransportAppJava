package com.example.database;

import com.example.model.Truck;

public class VehicleDatabase {
    private final static int MAX_VEHICLE = 1000;
    private Truck[] trucks = new Truck[MAX_VEHICLE];
    private int truckNumber = 0;

    public void addTruck(Truck truck) {
        if (truckNumber < MAX_VEHICLE) {
            trucks[truckNumber] = truck;
            truckNumber++;
        } else {
            System.out.println("It is not possible to add another vehicle. There is no space in the database.");
        }
    }

    public void printTrucks() {
        if (truckNumber == 0) {
            System.out.println("The database is empty.");
        } else {
            for (int i = 0; i < truckNumber; i++) {
                trucks[i].printInfo();
            }
        }
        System.out.println();

    }
}
