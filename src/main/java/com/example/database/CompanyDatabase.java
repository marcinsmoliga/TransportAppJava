package com.example.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.example.app.exception.VehicleAlreadyExistsException;
import com.example.model.Employee;
import com.example.model.Vehicle;

public class CompanyDatabase implements Serializable {
	private Map<String,Vehicle> vehicles = new HashMap<>();
	private Map<String,Employee> employees = new HashMap<>();

	public Map<String,Employee> getEmployees() {
		return employees;
	}

	public Map<String,Vehicle> getVehicles() {
		return vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		if (vehicles.containsKey(vehicle.getVehicleRegistrationPlate())) {
			throw new VehicleAlreadyExistsException(
					"The vehicle with such a registration plate is already in the database");
		}
		vehicles.put(vehicle.getVehicleRegistrationPlate(), vehicle);
	}

	public void addEmployee(Employee employee) {
		if (employees.containsKey(employee.getPesel())) {
			throw new VehicleAlreadyExistsException("The employee with such a PESEL number is already in the database");
		}
		employees.put(employee.getPesel(), employee);
	}

	public boolean removeVehicle(Vehicle vehicle) {
		if (vehicles.containsValue(vehicle)) {
			vehicles.remove(vehicle.getVehicleRegistrationPlate());
			return true;
		} else {
		    return false;
        }
	}
}
