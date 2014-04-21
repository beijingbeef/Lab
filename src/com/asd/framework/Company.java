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

	@Override
	public String getDob() {
		return null;
	}

	@Override
	public int getNumberOfEmployee() {
		return this.nr_of_employee;
	}

	@Override
	public String getType() {
		return "C";
	}

	@Override
	public ICustomer getCustomer(int index) {
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public ICustomer getCustomer(String name) {
		if (this.name.equals(name)) {
			return this;
		}
		return null;
	}

}
