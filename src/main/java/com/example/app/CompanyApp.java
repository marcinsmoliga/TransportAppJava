package com.example.app;

import com.example.io.DataReader;
import com.example.model.Truck;

public class CompanyApp {

	public static void main(String[] args) {
		DataReader dataReader = new DataReader();

		Truck truck = dataReader.createTruck();
		dataReader.closeReader();
		trucks[0]= truck;

		trucks[0].printInfo();
	}
}
