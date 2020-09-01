package com.example.model;

public class Vehicle {
    private String brand;
    private String vehicleRegistrationPlate;
    private int regYear;

    public Vehicle(String brand, String vehicleRegistrationPlate, int regYear) {
        this.brand = brand;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
        this.regYear = regYear;
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

    public int getRegYear() {
        return regYear;
    }

    public void setRegYear(int regYear) {
        this.regYear = regYear;
    }

    @Override
    public String toString() {
        return "Vehicle registration plate: " + getVehicleRegistrationPlate()
                + " Brand: " + getBrand() + " Year of registration: " + getRegYear() + " ";
    }
}
