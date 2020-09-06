package com.example.io.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import com.example.app.exception.DataExportException;
import com.example.app.exception.DataImportException;
import com.example.app.exception.InvalidDataException;
import com.example.database.CompanyDatabase;
import com.example.model.Driver;
import com.example.model.Employee;
import com.example.model.Truck;
import com.example.model.Van;
import com.example.model.Vehicle;

public class CsvFileManager implements FileManager {
    private static final String FILE_VEHICLES = "VehicleDatabase.csv";
    private static final String FILE_EMPLOYEES = "EmployeesDatabase.csv";
    @Override
    public CompanyDatabase importData() {
        CompanyDatabase companyDatabase = new CompanyDatabase();
        importVehicles(companyDatabase);
        importEmployees(companyDatabase);

        return companyDatabase;
    }

    private void importEmployees(CompanyDatabase companyDatabase) {
        try (
                Scanner fileReader = new Scanner(new File(FILE_EMPLOYEES))
        ) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Employee employee = createEmployeeFromFile(line);
                companyDatabase.addEmployee(employee);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + FILE_EMPLOYEES + " not found.");
        }
    }

    //TODO expand to Employee
    private Driver createEmployeeFromFile(String line) {
        String[] splitLine = line.split(";");
        String firstName = splitLine[0];
        String lastName = splitLine[1];
        String pesel = splitLine[2];
        String drivingLicenceNo = splitLine[3];
        return new Driver(firstName, lastName, pesel, drivingLicenceNo);
    }

    private void importVehicles(CompanyDatabase companyDatabase) {
        try (
                Scanner fileReader = new Scanner(new File(FILE_VEHICLES))
        ) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Vehicle vehicle = createVehicleFromFile(line);
                companyDatabase.addVehicle(vehicle);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + FILE_VEHICLES + " not found.");
        }
    }

    private Vehicle createVehicleFromFile(String line) {
        String[] splitLine = line.split(";");
        String type = splitLine[0];
        if(Truck.TYPE.equals(type)) {
           return createTruck(splitLine);
        } else if (Van.TYPE.equals(type)) {
            return createVan(splitLine);
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
    public void exportData(CompanyDatabase companyDatabase) {
        exportVehicles(companyDatabase);
        exportEmployees(companyDatabase);

    }

    private void exportEmployees(CompanyDatabase companyDatabase) {
        Collection<Employee> employees = companyDatabase.getEmployees().values();
        try (
                FileWriter fw = new FileWriter(FILE_EMPLOYEES);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            for (Employee employee : employees) {
                bw.write(employee.toCsv());
            }
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file " + FILE_EMPLOYEES);
        }
    }

    private void exportVehicles(CompanyDatabase companyDatabase) {
        Collection<Vehicle> vehicles = companyDatabase.getVehicles().values();
        try (
                FileWriter fw = new FileWriter(FILE_VEHICLES);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            for (Vehicle vehicle : vehicles) {
                bw.write(vehicle.toCsv());
            }
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file " + FILE_VEHICLES);
        }
    }
}
