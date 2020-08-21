package com.example.model;

import java.io.Serializable;

public abstract class Car implements Serializable {
    private String brand;
    private String vehicleRegistrationPlate;
    private int wheels;

    public Car(String brand, String vehicleRegistrationPlate, int wheels) {
        this.brand = brand;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + " Vehicle Registration Number: " + vehicleRegistrationPlate
                + " Number of wheels: " + wheels;
    }
}