package com.asd.framework;

import java.util.ArrayList;

public class Customers extends ACustomer {

	protected ArrayList<ICustomer> customers;

	public Customers() {
	}

	public Customers(String name, String street, String city, String state,
			int zip, String email) {
		super(name, street, city, state, zip, email);

		this.customers = new ArrayList<>();
	}

	@Override
	public void addCustomer(ICustomer customer) {
		customers.add(customer);
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
		return 0;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public ICustomer getCustomer(int index) {
		return this.customers.get(index);
	}

	@Override
	public int getSize() {
		return this.customers.size();
	}

}
