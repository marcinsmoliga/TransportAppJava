package com.example.model;

import java.util.Objects;

public class Van extends Vehicle {
    public static final String TYPE = "Van";
    private int euroPalletsNumber;

    public Van(String brand, String vehicleRegistrationPlate, int regYear, int euroPalletsNumber) {
        super(brand, vehicleRegistrationPlate, regYear);
        this.euroPalletsNumber = euroPalletsNumber;
    }

    public int getEuroPalletsNumber() {
        return euroPalletsNumber;
    }

    public void setEuroPalletsNumber(int euroPalletsNumber) {
        this.euroPalletsNumber = euroPalletsNumber;
    }
    @Override
    public String toString() {
        return super.toString() + "Number of Euro Pallets: " + euroPalletsNumber;
    }

    @Override
    public String toCsv() {
        return TYPE + ";" +
                getBrand() + ";" +
                getVehicleRegistrationPlate() + ";" +
                getRegYear() + ";" +
                euroPalletsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Van van = (Van) o;
        return euroPalletsNumber == van.euroPalletsNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(euroPalletsNumber);
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return getVehicleRegistrationPlate().compareToIgnoreCase(vehicle.getVehicleRegistrationPlate());
    }
}
