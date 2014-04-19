package com.asd.gui;

public class Company extends ACustomer implements ICompany {

	public Company(String name, String street, String city, String state,
			int zip, String email) {
		super(name, street, city, state, zip, email);
	}

}
