package com.example.io.file;

import com.example.app.exception.NoSuchFileTypeException;
import com.example.io.ConsolePrinter;
import com.example.io.DataReader;

public class FileManagerBuilder {
    private final ConsolePrinter consolePrinter;
    private final DataReader dataReader;

    public FileManagerBuilder(ConsolePrinter consolePrinter, DataReader dataReader) {
        this.consolePrinter = consolePrinter;
        this.dataReader = dataReader;
    }

    public FileManager build() {
        FileType fileType = getFileType();
        switch (fileType) {
            case SERIAL -> {
                return new SerializableFileManager();
            }
            case CSV -> {
                return new CsvFileManager();
            }
            default -> {
                throw new NoSuchFileTypeException("Unsupported file type.");
            }
        }

    }

    private FileType getFileType() {
        boolean isFileTypeCorrect = false;
        FileType result = null;

        do {
            printFileTypes();
            consolePrinter.printLine("Select a data format: ");
            String fileType = dataReader.getString().toUpperCase();
            try {
                result = FileType.valueOf(fileType);
                isFileTypeCorrect = true;
            } catch (IllegalArgumentException e) {
                consolePrinter.printNextLine("Unsupported data type. Please choose again.");
            }
        } while (!isFileTypeCorrect);
        return result;
    }

    private void printFileTypes() {
        for (FileType fileType : FileType.values()) {
            consolePrinter.printNextLine(fileType.name());
        }
    }
}
