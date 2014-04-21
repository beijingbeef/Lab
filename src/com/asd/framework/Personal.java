package com.asd.framework;

public class Personal extends ACustomer implements IPersonal {
	private String dob;

	public Personal(String name, String street, String city, String state,
			int zip, String dob, String email) {
		super(name, street, city, state, zip, email);
		this.dob = dob;
	}

	@Override
	public void addCustomer(ICustomer customer) {
	}

	@Override
	public void removeCustomer(ICustomer customer) {
	}

}
