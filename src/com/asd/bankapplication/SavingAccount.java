package com.asd.bankapplication;

import com.asd.framework.AAccount;
import com.asd.framework.Entry;
import com.asd.framework.IAccount;
import com.asd.framework.TransactionType;

public class SavingAccount extends AAccount {
	private double interest_rate = 0;

	@Override
	public void addAccount(IAccount account) {
	}

	@Override
	public void setInterest(double rate) {
		this.interest_rate = rate;
	}

	@Override
	public double getInterest() {
		return this.interest_rate;
	}

	@Override
	public void addInterest() {
		double interest = getCurrentBalance() * getInterest();
		addEntry(new Entry(TransactionType.interest, interest));
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
	public String getType() {
		return "S";
	}

	@Override
	public IAccount getAccount(int index) {
		return null;
	}

}
