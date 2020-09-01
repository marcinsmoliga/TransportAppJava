package com.example.io;

import com.example.database.VehicleDatabase;
import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class ConsolePrinter {

    public void printTrucks(Vehicle[] vehicles) {
        int truckNumber = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                printNextLine(vehicle.toString());
                truckNumber++;
            }
        }

        if (truckNumber == 0) {
            printNextLine("No trucks in the database.");
        }
        printNextLine("");
    }

    public void printVans(Vehicle[] vehicles) {
        int vanNumber = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Van) {
                printNextLine(vehicle.toString());
                vanNumber++;
            }
        }

        if (vanNumber == 0) {
            printNextLine("No vanes in the database.");
        }
        printNextLine("");
    }

    public void printLine(String text) {
        System.out.print(text);
    }

    public void printNextLine(String text) {
        System.out.println(text);
    }
}
