package com.asd.framework;

public class Person extends ACustomer implements IPerson {
	private String dob;

	public Person(String name, String street, String city, String state,
			int zip, String dob, String email) {
		super(name, street, city, state, zip, email);
		this.dob = dob;
	}

	@Override
	public String getDob() {
		return this.dob;
	}

	@Override
	public int count() {
		return 1;
	}

	@Override
	public ICustomer getCustomer(int index) {
		return null;
	}

	@Override
	public ICustomer getCustomer(String name) {
		if (this.name.equals(name)) {
			return this;
		}
		return null;
	}

	@Override
	public void addCustomer(ICustomer customer) {
	}

	@Override
	public void removeCustomer(ICustomer customer) {
	}

	@Override
	public void sendEmailToCustomer() {
		System.out.println(String.format("Email to %s", this.getName()));
	}

	@Override
	public String getInitial() {
		return "P";
	}
}
