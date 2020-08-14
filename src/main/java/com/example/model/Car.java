package com.example.model;

public class Car {
    String brand;
    String vehicleRegistrationPlate;

    public Car(final String brand, final String vehicleRegistrationPlate) {
        this.brand = brand;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
    }

    public void printInfo() {
        System.out.println("Brand: " + brand + " Vehicle Registration Plate: " + vehicleRegistrationPlate);
    }
}
