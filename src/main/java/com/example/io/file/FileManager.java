package com.example.io.file;

import com.example.database.VehicleDatabase;

public interface FileManager {
    VehicleDatabase importData();
    void exportData(VehicleDatabase vehicleDatabase);
}
