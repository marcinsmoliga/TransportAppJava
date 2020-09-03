package com.example.io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.example.app.exception.DataExportException;
import com.example.app.exception.DataImportException;
import com.example.database.VehicleDatabase;

public class SerializableFileManager implements FileManager {
    private final static String FILE_NAME = "VehicleDatabase.obj";

    @Override
    public VehicleDatabase importData() {
        try (
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (VehicleDatabase) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + FILE_NAME + " not found!");
        } catch (IOException e) {
            throw new DataImportException("Error reading  data from the file " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Incompatible data type in the file " + FILE_NAME);
        }
    }

    @Override
    public void exportData(VehicleDatabase vehicleDatabase) {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(vehicleDatabase);
        } catch (FileNotFoundException e) {
            throw new DataExportException("File " + FILE_NAME + " not found!");
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file " + FILE_NAME);
        }
    }
}
