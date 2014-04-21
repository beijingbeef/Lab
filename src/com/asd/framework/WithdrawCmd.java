package com.asd.framework;

public class WithdrawCmd implements ICommand {
	private IAccount account;
	private double amount;

	public WithdrawCmd(IAccount c, double amount) {
		this.account = c;
		this.amount = amount;
	}

	@Override
	public void execute() {
		this.account.addEntry(new Entry(this.amount * -1));
	}

}
