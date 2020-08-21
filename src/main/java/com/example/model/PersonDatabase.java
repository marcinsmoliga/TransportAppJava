package com.example.model;

import java.io.Serializable;

public class PersonDatabase implements Serializable {
	private static final int MAX_PEOPLE = 1000;
	private Person[] people = new Person[MAX_PEOPLE];
	private int personNumber = 0;

	public void addPerson(Person person) {
		if (personNumber < MAX_PEOPLE) {
			people[personNumber] = person;
			personNumber++;
		} else {
			System.err.println("Not enough space in the database! Can not add the next person!");
		}
	}

	public void printPeople() {
		for(int i = 0; i < personNumber; i++) {
			System.out.println(people[i]);
		}
	}
}
