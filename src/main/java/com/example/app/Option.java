package com.example.app;

import com.example.app.exception.NoSuchOptionException;

public enum Option {
    EXIT(0,"exit the program"),
    ADD_TRUCK(1,"add new truck to the database"),
    SHOW_ALL_TRUCKS(3,"retrieve all trucks from the database"),
    ADD_VAN(2,"add new van to the database"),
    SHOW_ALL_VANS(4,"retrieve all vans from the database"),
    DELETE_TRUCK(5, "remove a truck from the database"),
    DELETE_VAN(6, "remove a van from the database");

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
