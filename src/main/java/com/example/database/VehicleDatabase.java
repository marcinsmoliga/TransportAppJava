package com.example.database;

import com.example.model.Truck;
import com.example.model.Van;

public class VehicleDatabase {
    private final static int MAX_VEHICLE = 1000;
    private final Truck[] trucks = new Truck[MAX_VEHICLE];
    private final Van[] vans = new Van[MAX_VEHICLE];
    private int truckNumber = 0;
    private int vanNumber = 0;

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

    public void addVan(Van van) {
        if (vanNumber < MAX_VEHICLE) {
            vans[vanNumber] = van;
            vanNumber++;
        } else {
            System.out.println("It is not possible to add another vehicle. There is no space in the database.");
        }
    }

    public void printVans() {
        if (vanNumber == 0) {
            System.out.println("The database is empty.");
        } else {
            for (int i = 0; i < vanNumber; i++) {
                vans[i].printInfo();
            }
        }
        System.out.println();

    }
}
