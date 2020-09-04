package com.example.database;

import java.io.Serializable;
import java.util.Arrays;

import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class VehicleDatabase implements Serializable {
    private final static int INITIAL_SIZE = 1;
    private Vehicle[] vehicles = new Vehicle[INITIAL_SIZE];
    private int vehicleNumber = 0;

    public Vehicle[] getVehicles() {
        Vehicle[] result = new Vehicle[vehicleNumber];

        for (int i = 0; i < vehicleNumber; i++) {
            result[i] = vehicles[i];
        }
        return result;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicleNumber == vehicles.length) {
            vehicles = Arrays.copyOf(vehicles, vehicles.length * 2);
        }
        vehicles[vehicleNumber] = vehicle;
        vehicleNumber++;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        final int notFound = -1;
        int found = notFound;
        int i = 0;
        while (i < vehicles.length && found == notFound) {
            if (vehicle.equals(vehicles[i])) {
                found = i;
            } else {
                i++;
            }
        }

        if (found != notFound) {
            System.arraycopy(vehicles, found + 1, vehicles, found, vehicles.length - found - 1);
            vehicleNumber--;
            vehicles[vehicleNumber] = null;
        }
        return found != notFound;
    }
}
