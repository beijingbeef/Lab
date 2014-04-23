package com.asd.framework;

import java.util.ArrayList;

public class Accounts extends AAccount {
	protected ArrayList<IAccount> accounts = new ArrayList<>();

	@Override
	public void addAccount(IAccount account) {
		this.accounts.add(account);
	}

	@Override
	public void removeAccount(IAccount account) {
		this.accounts.remove(account);
	}

	@Override
	public void addInterest() {
		for (IAccount a : this.accounts) {
			a.addInterest();
		}
	}

	@Override
	public String getInitial() {
		return null;
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
	public String generateMonthlyBills() {
		return null;
	}
}
