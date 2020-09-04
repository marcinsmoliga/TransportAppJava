package com.example.app;

import com.example.app.exception.NoSuchOptionException;

public enum Option {
    EXIT(0,"exit the program"),
    ADD_TRUCK(1,"add new truck"),
    ADD_VAN(2,"add new van"),
    SHOW_ALL_TRUCKS(3,"retrieve all trucks"),
    SHOW_ALL_VANS(4,"retrieve all vans"),
    DELETE_TRUCK(5, "remove a truck"),
    DELETE_VAN(6, "remove a van");

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

    public static Option getOptionFromInt(int option) throws NoSuchOptionException {
        try {
        return Option.values()[option];
    } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Incorrect input: " + option + ". Please choose the option again: " );
        }
    }
}
