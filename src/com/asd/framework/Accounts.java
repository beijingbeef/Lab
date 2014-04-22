package com.asd.framework;

import java.util.ArrayList;

public class Accounts extends AAccount {

	protected ArrayList<IAccount> accounts = new ArrayList<>();

	@Override
	public void addAccount(IAccount account) {
		accounts.add(account);
	}

	@Override
	public void addInterest() {
	}

	@Override
	public double getLastMonthBalance() {
		return 0;
	}

	@Override
	public double getTotalMonthlyCredit() {
		return 0;
	}

	@Override
	public double getTotalMonthlyCharge() {
		return 0;
	}

	@Override
	public double getNewMonthlyBalance() {
		return 0;
	}

	@Override
	public double getMonthlyAmountDue() {
		return 0;
	}

	@Override
	public double getInterest() {
		return 0;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public IAccount getAccount(int index) {
		return this.accounts.get(index);
	}

}
