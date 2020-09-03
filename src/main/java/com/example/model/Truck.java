package com.example.model;

import java.util.Objects;

public class Truck extends Vehicle {
    public static final String TYPE = "Truck";
    private String tachographModel;


    public Truck(String brand, String vehicleRegistrationPlate, int regYear, String tachographModel) {
        super(brand, vehicleRegistrationPlate, regYear);
        this.tachographModel = tachographModel;
    }

    public String getTachographModel() {
        return tachographModel;
    }

    public void setTachographModel(String tachographModel) {
        this.tachographModel = tachographModel;
    }

    @Override
    public String toString() {
       return super.toString() + "Tachograph model: " + tachographModel;
    }

    @Override
    public String toCsv() {
        return TYPE + ";" +
                getBrand() + ";" +
                getVehicleRegistrationPlate() + ";" +
                getRegYear() + ";" +
                tachographModel;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Objects.equals(tachographModel, truck.tachographModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tachographModel);
    }
}
