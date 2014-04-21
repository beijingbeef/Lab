package com.asd.framework;

public class AddInterestCmd implements ICommand {
	private IAccount account;

	public AddInterestCmd(IAccount c) {
		this.account = c;
	}

	@Override
	public void execute() {
		this.account.addInterest();
	}

}
