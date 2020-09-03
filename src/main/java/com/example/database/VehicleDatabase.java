package com.example.database;

import java.io.Serializable;

import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class VehicleDatabase implements Serializable {
    private final static int MAX_VEHICLE = 1000;
    private final Vehicle[] vehicles = new Vehicle[MAX_VEHICLE];
    private int vehicleNumber = 0;

    public Vehicle[] getVehicles() {
        Vehicle[] result = new Vehicle[vehicleNumber];

        for (int i = 0; i < vehicleNumber; i++) {
            result[i] = vehicles[i];
        }
        return result;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicleNumber >= MAX_VEHICLE) {
            throw new ArrayIndexOutOfBoundsException("Vehicle cannot be added. There is no free space in the database");
        }
        vehicles[vehicleNumber] = vehicle;
        vehicleNumber++;
    }
}
