package com.example.model;

public class Van extends Vehicle {
    private int euroPalletsNumber;

    public Van(String brand, String vehicleRegistrationPlate, int regYear, int euroPalletsNumber) {
        this.setBrand(brand);
        this.setVehicleRegistrationPlate(vehicleRegistrationPlate);
        this.setRegYear(regYear);
        this.euroPalletsNumber = euroPalletsNumber;
    }

    public int getEuroPalletsNumber() {
        return euroPalletsNumber;
    }

    public void setEuroPalletsNumber(int euroPalletsNumber) {
        this.euroPalletsNumber = euroPalletsNumber;
    }

    public void printInfo() {
        String info = "Vehicle registration plate: " + getVehicleRegistrationPlate()
                + " Brand: " + getBrand() + " Year of registration: " + getRegYear()
                + " Number of Euro pallets: " + euroPalletsNumber;

        System.out.println(info);
    }
}
