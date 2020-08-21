package com.example.io.file;

import com.example.model.CarDatabase;
import com.example.model.PersonDatabase;

public interface FileManager {
	CarDatabase importCarDatabase();
	PersonDatabase importPersonDatabase();
	void exportCarData(CarDatabase carDatabase);
	void exportPersonData(PersonDatabase personDatabase);
}
