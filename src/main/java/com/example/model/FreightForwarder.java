package com.example.model;

public class FreightForwarder extends Person {
	private String companyIdNumber;

	public FreightForwarder(String firstName, String lastName, int birthYear,
	                        String companyIdNumber) {
		super(firstName, lastName, birthYear);
		this.companyIdNumber = companyIdNumber;
	}

	public String getCompanyIdNumber() {
		return companyIdNumber;
	}

	public void setCompanyIdNumber(String companyIdNumber) {
		this.companyIdNumber = companyIdNumber;
	}
}
