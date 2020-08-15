package com.example.model;

public class PersonDatabase {
	private final int maxPeople = 1000;
	private Person[] people = new Person[maxPeople];
	private int personNumber = 0;

	public void addPerson(Person person) {
		if (personNumber < maxPeople) {
			people[personNumber] = person;
			personNumber++;
		} else {
			System.err.println("Not enough space in the database! Can not add the next person!");
		}
	}

	public void printPeople() {
		for(int i = 0; i < personNumber; i++) {
			people[1].printInfo();
		}
	}
}
