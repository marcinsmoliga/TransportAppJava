package com.example.model;

public class Truck extends Vehicle {
    private String brand;
    private String vehicleRegistrationPlate;
    private int regYear;

    public Truck(String brand, String vehicleRegistrationPlate, int regYear) {
        this.brand = brand;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
        this.regYear = regYear;
    }


    public void printInfo() {
        String info = "Vehicle registration plate: " + getVehicleRegistrationPlate()
                + " Brand: " + getBrand() + " Year of registration: " + getRegYear();

        System.out.println(info);
    }
}
