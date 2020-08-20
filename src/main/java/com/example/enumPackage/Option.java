package com.example.enumPackage;

import com.example.exception.NoSuchOptionException;

public enum Option {
	EXIT (0, "exit the program"),
	ADD_CAR (1, "add car"),
	ADD_PERSON (2, "add person"),
	SHOW_CARS (3, "show all cars"),
	SHOW_PEOPLE (4, "show all people");

	private final int optionNumber;
	private final String description;

	Option(int optionNumber, String description) {
		this.optionNumber = optionNumber;
		this.description = description;
	}

	public static Option convertToOption(int number) throws NoSuchOptionException {
		try {
			return Option.values()[number];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoSuchOptionException("There is no such option as " + number);
		}

	}

	@Override
	public String toString() {
		return optionNumber + " - " + description;
	}
}
