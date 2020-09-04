package com.example.model.comparator;

import java.util.Comparator;

import com.example.model.Vehicle;

public class RegistrationPlateComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getVehicleRegistrationPlate().compareToIgnoreCase(v2.getVehicleRegistrationPlate());
    }
}
