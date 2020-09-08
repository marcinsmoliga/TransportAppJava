package com.example.app;

import com.example.app.exception.NoSuchOptionException;

public enum Option {
    ADD_TRUCK(1, "add new truck"),
    ADD_VAN(2, "add new van"),
    ADD_DRIVER(3, "add new driver"),
    SHOW_ALL_TRUCKS(4, "retrieve all trucks"),
    SHOW_ALL_VANS(5, "retrieve all vans"),
    SHOW_ALL_DRIVERS(6, "retrieve all drivers"),
    DELETE_TRUCK(7, "remove a truck"),
    DELETE_VAN(8, "remove a van"),
    EXIT(0, "exit the program");

    private final int actionNumber;
    private final String description;

    Option(int actionNumber, String description) {
        this.actionNumber = actionNumber;
        this.description = description;
    }

    public int getActionNumber() {
        return actionNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return actionNumber + " - " + description;
    }

    public static Option getOptionFromInt(int userInput) throws NoSuchOptionException {
        Option option = null;
        try {
            for (Option element : Option.values()) {
                if (element.getActionNumber() == userInput) {
                    return element;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Incorrect input: " + option + ". Please choose the option again: ");
        }
        return option;
    }
}
