package com.example.model;

import java.io.Serializable;

public class Person implements Serializable {
    String firstName;
    String lastName;
    int birthYear;

    public Person(final String firstName, final String lastName, final int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + " Last name: " + lastName + " Year of birth: " + birthYear;
    }
}
