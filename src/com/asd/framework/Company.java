package com.asd.framework;

import java.util.ArrayList;

public class Company extends ACustomer implements ICompany {
	private int nr_of_employee;

	protected ArrayList<ICustomer> customers = new ArrayList<>();

	public Company() {
		this(0);
	}

	public Company(int noe) {
		this("", "", "", "", 0, noe, "");
	}

	public Company(String name, String street, String city, String state,
			int zip, int noe, String email) {
		super(name, street, city, state, zip, email);
	}

	@Override
	public int getNumberOfEmployee() {
		return this.nr_of_employee;
	}

	@Override
	public int count() {
		return nr_of_employee;
	}

	@Override
	public ICustomer getCustomer(int index) {
		return null;
	}

	@Override
	public ICustomer getCustomer(String name) {
		if (this.name.equals(name)) {
			return this;
		} else {
			for (ICustomer c : this.customers) {
				if (c.getCustomer(name) != null) {
					return c;
				}
			}
		}
		return null;
	}

	@Override
	public void addCustomer(ICustomer customer) {
		this.customers.add(customer);
	}

	@Override
	public void removeCustomer(ICustomer customer) {
		this.customers.remove(customer);
	}

	@Override
	public void sendEmailToCustomer() {
		for (ICustomer c : this.customers) {
			c.sendEmailToCustomer();
		}
	}

	@Override
	public String getInitial() {
		return "C";
	}
}
