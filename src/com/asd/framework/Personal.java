package com.asd.framework;

public class Personal extends ACustomer implements IPersonal {

	public Personal(String name, String street, String city, String state,
			int zip, String email) {
		super(name, street, city, state, zip, email);
	}

}
