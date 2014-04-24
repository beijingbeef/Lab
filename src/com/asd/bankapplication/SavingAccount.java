package com.asd.bankapplication;

import com.asd.framework.AAccount;
import com.asd.framework.Entry;
import com.asd.framework.IAccount;
import com.asd.framework.IEntry;
import com.asd.framework.TransactionType;

public class SavingAccount extends AAccount {
	private double interest_rate = 0.10;

	@Override
	public void addInterest() {
		double interest = getCurrentBalance() * this.interest_rate;
		addEntry(new Entry(TransactionType.interest, interest));
	}

	@Override
	public void addAccount(IAccount account) {
	}

	@Override
	public void removeAccount(IAccount account) {
	}

	@Override
	public void addEntry(IEntry entry) {
		if (entry.getAmount() > 0
				|| (entry.getAmount() < 0 && (entry.getAmount() * -1) <= this.current_balance)) {
			super.addEntry(entry);
		}
	}

	@Override
	public String getInitial() {
		return "S";
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
