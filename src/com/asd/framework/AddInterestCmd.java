package com.asd.framework;

public class AddInterestCmd implements ICommand {
	private IAccount account;

	public AddInterestCmd(IAccount c) {
		this.account = c;
	}

	@Override
	public void execute() {
		double interest = this.account.getCurrentBalance()
				* this.account.getInterest();
		this.account.addEntry(new Entry(interest));
	}

}
