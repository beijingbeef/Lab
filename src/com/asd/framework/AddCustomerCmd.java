package com.asd.framework;

public class AddCustomerCmd implements ICommand {
	private Customers customers;
	private ICustomer customer;

	public AddCustomerCmd(Customers cs, ICustomer c) {
		this.customers = cs;
		this.customer = c;
	}

	@Override
	public void execute() {
		this.customers.addCustomer(this.customer);
	}

}
