package com.asd.framework.impl;

import com.asd.framework.AAccount;
import com.asd.framework.Entry;
import com.asd.framework.IAccount;
import com.asd.framework.TransactionType;

public class CheckingAccount extends AAccount {
	private double interest_rate;

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

}
