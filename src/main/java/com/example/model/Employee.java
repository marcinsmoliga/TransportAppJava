package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Employee implements Serializable, CsvConvertible {
	private String firstName;
	private String lastName;
	private String pesel;

	public Employee(String firstName, String lastName, String pesel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(firstName, employee.firstName) &&
				Objects.equals(lastName, employee.lastName) &&
				Objects.equals(pesel, employee.pesel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, pesel);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " PESEL: " + pesel;
	}
}
