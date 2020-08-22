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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleRegistrationPlate() {
        return vehicleRegistrationPlate;
    }

    public void setVehicleRegistrationPlate(String vehicleRegistrationPlate) {
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public abstract String toCSV();
    @Override
    public String toString() {
        return "Brand: " + brand + " Vehicle Registration Number: " + vehicleRegistrationPlate
                + " Number of wheels: " + wheels;
    }
}