package com.example.model.comparator;

import java.util.Comparator;

import com.example.model.Vehicle;

public class BrandComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getBrand().compareToIgnoreCase(v2.getBrand());
    }
}
