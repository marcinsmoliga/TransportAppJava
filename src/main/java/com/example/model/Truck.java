package com.example.model;

public class Truck extends Vehicle {
    private String tachographModel;


    public Truck(String brand, String vehicleRegistrationPlate, int regYear, String tachographModel) {
        this.setBrand(brand);
        this.setVehicleRegistrationPlate(vehicleRegistrationPlate);
        this.setRegYear(regYear);
        this.tachographModel = tachographModel;
    }

    public String getTachographModel() {
        return tachographModel;
    }

    public void setTachographModel(String tachographModel) {
        this.tachographModel = tachographModel;
    }

    public void printInfo() {
        String info = "Vehicle registration plate: " + getVehicleRegistrationPlate()
                + " Brand: " + getBrand() + " Year of registration: " + getRegYear()
                + " Tachograph model: " + tachographModel;

        System.out.println(info);
    }
}
