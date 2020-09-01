package com.example.io;

import java.util.Scanner;

import com.example.model.Truck;
import com.example.model.Van;

public class DataReader {
    private final Scanner sc = new Scanner(System.in);

    public Truck createTruck() {
        System.out.print("Enter the brand name: ");
        String brand = sc.nextLine();
        System.out.print("Enter the Vehicle Registration Plate: ");
        String vehicleRegistrationPlate = sc.nextLine();
        System.out.print("Enter the year of registration: ");
        int regYear = getInt();
        System.out.print("Enter the tachograph model version: ");
        String tachographModel = sc.nextLine();

        return new Truck(brand, vehicleRegistrationPlate, regYear, tachographModel);
    }

    public Van createVan() {
        System.out.print("Enter the brand name: ");
        String brand = sc.nextLine();
        System.out.print("Enter the Vehicle Registration Plate: ");
        String vehicleRegistrationPlate = sc.nextLine();
        System.out.print("Enter the year of registration: ");
        int regYear = getInt();
        System.out.print("Enter the max number of Euro pallets that can be loaded: ");
        int euroPalletsNumber = getInt();

        return new Van(brand, vehicleRegistrationPlate, regYear, euroPalletsNumber);
    }

    public void closeReader() {
        sc.close();
    }

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }


}
