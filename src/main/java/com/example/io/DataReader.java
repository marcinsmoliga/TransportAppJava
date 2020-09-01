package com.example.io;

import java.util.Scanner;

import com.example.model.Truck;

public class DataReader {
    private final Scanner sc = new Scanner(System.in);

    public Truck createTruck() {
        System.out.print("Enter the brand name: ");
        String brand = sc.nextLine();
        System.out.print("Enter the Vehicle Registration Plate: ");
        String vehicleRegistrationPlate = sc.nextLine();
        System.out.print("Enter the year of registration: ");
        int regYear = sc.nextInt();

        return new Truck(brand, vehicleRegistrationPlate, regYear);

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
