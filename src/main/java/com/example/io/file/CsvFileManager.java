package com.example.io.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.example.app.exception.DataExportException;
import com.example.app.exception.DataImportException;
import com.example.app.exception.InvalidDataException;
import com.example.database.VehicleDatabase;
import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "VehicleDatabase.csv";
    @Override
    public VehicleDatabase importData() {
        VehicleDatabase vehicleDatabase = new VehicleDatabase();

        try (
                Scanner fileReader = new Scanner(new File(FILE_NAME))
                ) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Vehicle vehicle = createObjectFromFile(line);
                vehicleDatabase.addVehicle(vehicle);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + FILE_NAME + " not found.");
        }
        return vehicleDatabase;
    }

    private Vehicle createObjectFromFile(String line) {
        String[] split = line.split(";");
        String type = split[0];
        if(Truck.TYPE.equals(type)) {
           return createTruck(split);
        } else if (Van.TYPE.equals(type)) {
            return createVan(split);
        }
        throw new InvalidDataException("Unknown vehicle type: " + type);
    }

    private Van createVan(String[] split) {
        String brand = split[1];
        String vehicleRegistrationPlate = split[2];
        int regYear = Integer.parseInt(split[3]);
        int euroPalletsNumber = Integer.parseInt(split[4]);
        return new Van(brand, vehicleRegistrationPlate, regYear, euroPalletsNumber);
    }

    private Truck createTruck(String[] split) {
        String brand = split[1];
        String vehicleRegistrationPlate = split[2];
        int regYear = Integer.parseInt(split[3]);
        String tachographModel = split[4];
        return new Truck(brand, vehicleRegistrationPlate, regYear, tachographModel);
    }

    @Override
    public void exportData(VehicleDatabase vehicleDatabase) {
        Vehicle[] vehicles = vehicleDatabase.getVehicles();
        try (
                FileWriter fw = new FileWriter(FILE_NAME);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            for (Vehicle vehicle : vehicles) {
                bw.write(vehicle.toCsv());
            }
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file " + FILE_NAME);
        }
    }
}
