package com.asd.framework;

import java.util.ArrayList;

public class Accounts extends AAccount {

	protected ArrayList<IAccount> accounts;

	public Accounts() {
		accounts = new ArrayList<>();
	}

	public void addAccount(IAccount account) {
		accounts.add(account);
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getTotalMonthlyCredit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalMonthlyCharge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getNewMonthlyBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMonthlyAmountDue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInterest(double rate) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAccount getAccount(int index) {
		return this.accounts.get(index);
	}

}
