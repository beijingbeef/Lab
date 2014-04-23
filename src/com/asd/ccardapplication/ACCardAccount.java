package com.asd.ccardapplication;

import java.util.Date;

import com.asd.framework.AAccount;
import com.asd.framework.IAccount;
import com.asd.framework.ICustomer;
import com.asd.framework.IEntry;
import com.asd.framework.TransactionType;

public abstract class ACCardAccount extends AAccount {
	protected double monthly_interest = 0.0;
	protected double minimum_payment_rate = 0.0;
	protected double last_month_balance = 0.0;
	protected Date expire_date;

	public ACCardAccount(String ccnumber, Date expDate) {
		this.accnr = ccnumber;
		this.expire_date = expDate;
	}

	@Override
	public void addEntry(IEntry entry) {
		if (this.expire_date.compareTo(new Date()) > 0) {
			super.addEntry(entry);
		}
	}

	public String getCCnumber() {
		return this.accnr;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public IAccount getAccount(int index) {
		return null;
	}

	@Override
	public void addInterest() {
	}

	@Override
	public double getLastMonthBalance() {
		return this.last_month_balance;
	}

	@Override
	public double getTotalMonthlyCredit() {
		Date now = new Date();
		double total = 0;
		for (IEntry e : this.entries) {
			if (e.getDate().getMonth() == now.getMonth()
					&& e.getTransactionType() == TransactionType.deposit) {
				total += e.getAmount();
			}
		}
		return total;
	}

	@Override
	public double getTotalMonthlyCharge() {
		Date now = new Date();
		double total = 0;
		for (IEntry e : this.entries) {
			if (e.getDate().getMonth() == now.getMonth()
					&& e.getTransactionType() == TransactionType.withdraw) {
				total += e.getAmount();
			}
		}
		return total;
	}

	@Override
	public double getNewMonthlyBalance() {
		double lastBal = getLastMonthBalance();
		double totalCredit = getTotalMonthlyCredit();
		double totalCharge = getTotalMonthlyCharge();
		double newBal = lastBal - totalCredit + totalCharge
				+ (this.monthly_interest * (lastBal - totalCredit));

		return newBal;
	}

	@Override
	public double getMonthlyAmountDue() {
		return this.minimum_payment_rate * getNewMonthlyBalance();
	}

	@Override
	public String generateMonthlyBills() {
		ICustomer c = getCustomer();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(String.format("Name= %s\n", c.getName()));
		strBuilder.append(String.format("Address= %s, %s, %s, %d\n",
				c.getStreet(), c.getCity(), c.getState(), c.getZip()));
		strBuilder.append(String.format("CC number= %s\n", getCCnumber()));
		strBuilder.append(String.format("CC type= %s\n", getType()));
		strBuilder.append(String.format("Previous balance= %.2f\n",
				getLastMonthBalance()));
		strBuilder.append(String.format("Total credits= %.2f\n",
				getTotalMonthlyCredit()));
		strBuilder.append(String.format("Total charges= %.2f\n",
				getTotalMonthlyCharge()));
		strBuilder.append(String.format("New balance= %.2f\n",
				getCurrentBalance()));
		strBuilder.append(String.format("Total amount due= %.2f\n",
				getMonthlyAmountDue()));

		this.last_month_balance = getNewMonthlyBalance();

		return strBuilder.toString();
	}
}
