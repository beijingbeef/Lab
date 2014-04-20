package com.asd.gui;

public interface IAccount {
	public void addEntry(IEntry entry);

	public void notifyCustomer();

	public void addInterest();

	public double getCurrentBalance();

	public double getLastMonthBalance();

	public double getTotalMonthlyCredit();

	public double getTotalMonthlyCharge();

	public double getNewMonthlyBalance();

	public double getMonthlyAmountDue();
}
