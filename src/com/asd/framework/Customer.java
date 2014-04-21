package com.asd.framework;

public class Customer extends ACustomer {

	public Customer(String name, String street, String city, String state,
			int zip, String email) {
		super(name, street, city, state, zip, email);
	}

	@Override
	public void addCustomer(ICustomer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCustomer(ICustomer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDob() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfEmployee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
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
	public IAccount getAccount() {
		return null;
	}

}
