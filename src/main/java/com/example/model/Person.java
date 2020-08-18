package com.example.model;

public class Person {
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
