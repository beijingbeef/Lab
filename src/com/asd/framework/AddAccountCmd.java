package com.asd.framework;

public class AddAccountCmd implements ICommand {
	private Accounts accounts;
	private IAccount account;

	public AddAccountCmd(Accounts cs, IAccount c) {
		this.accounts = cs;
		this.account = c;
	}

	@Override
	public void execute() {
		this.accounts.addCustomer(this.account);
	}

}
