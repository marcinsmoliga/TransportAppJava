package com.example.io.file;

import com.example.exception.NoSuchFileTypeException;
import com.example.io.ConsolePrinter;
import com.example.io.DataReader;

public class FileManagerBuilder {
	ConsolePrinter consolePrinter;
	DataReader dataReader;

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
				throw new NoSuchFileTypeException("Invalid data type!");
			}
		}
	}

	private FileType getFileType() {
		boolean correctType = false;
		FileType fileType = null;

		do {
			printTypes();
			consolePrinter.printLine("Choose data type: ");
			String type = dataReader.getString().toUpperCase();
			try {
				fileType = FileType.valueOf(type);
				correctType = true;
			} catch (IllegalArgumentException e) {
				consolePrinter.printNextLine("Invalid data type: " + type + ". Re-enter the data.");
			}
		} while (!correctType);

		return fileType;
	}

	private void printTypes() {
		for (FileType fileType : FileType.values()) {
			consolePrinter.printNextLine(fileType.name());
		}
	}
}
