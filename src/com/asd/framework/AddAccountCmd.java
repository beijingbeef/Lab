package com.asd.framework;

public class AddAccountCmd implements ICommand {
	private ICustomer customer;
	private IAccount account;

	public AddAccountCmd(ICustomer customer, IAccount account) {
		this.customer = customer;
		this.account = account;
	}

	@Override
	public void execute() {
		this.customer.addAccount(account);
	}

}
