package com.example.model;

public class Truck {
    private String brand;
    private String vehicleRegistrationPlate;
    private int regYear;

    public Truck(String brand, String vehicleRegistrationNumber, int regYear) {
        this(brand, vehicleRegistrationNumber);
        this.regYear = regYear;
    }

    public Truck(String brand, String vehicleRegistrationPlate) {
        this.brand = brand;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
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

    public void printInfo() {
        String info = "Vehicle registration plate: " + vehicleRegistrationPlate
                + " Brand: " + brand;

        if (regYear != 0) {
            info +=" Year of registration: " + regYear;
        }
        System.out.println(info);
    }
}
