package com.example.io.file;

import com.example.database.CompanyDatabase;

public interface FileManager {
    CompanyDatabase importData();
    void exportData(CompanyDatabase companyDatabase);
}
