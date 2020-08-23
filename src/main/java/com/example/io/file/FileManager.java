package com.example.io.file;

import com.example.model.CarDatabase;

public interface FileManager {
	CarDatabase importCarDatabase();
	void exportCarData(CarDatabase carDatabase);
}
