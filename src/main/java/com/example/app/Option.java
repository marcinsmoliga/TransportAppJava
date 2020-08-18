package com.example.app;

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

	public static Option convertToOption(int number) {
		Option[] values = Option.values();
		return values[number];
	}

	@Override
	public String toString() {
		return optionNumber + " - " + description;
	}
}
