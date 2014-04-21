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

	@Override
	public String getDob() {
		return this.dob;
	}

	@Override
	public int getNumberOfEmployee() {
		return 0;
	}

	@Override
	public String getType() {
		return "P";
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
