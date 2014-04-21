package com.asd.framework;

public class Company extends ACustomer implements ICompany {
	private int nr_of_employee;

	public Company(String name, String street, String city, String state,
			int zip, int noe, String email) {
		super(name, street, city, state, zip, email);
		this.nr_of_employee = noe;
	}

	@Override
	public void addCustomer(ICustomer customer) {
	}

	@Override
	public void removeCustomer(ICustomer customer) {
	}

}
