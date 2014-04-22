package com.asd.framework;

public interface IAccount {

	public void addAccount(IAccount account);

	public void addEntry(IEntry entry);

	public void notifyCustomer();

	public void addInterest();

	public String getType();

	public IAccount getAccount(int index);

	public void setCustomer(ICustomer c);

	public ICustomer getCustomer();

	public double getCurrentBalance();

	public double getLastMonthBalance();

	public double getTotalMonthlyCredit();

	public double getTotalMonthlyCharge();

	public double getNewMonthlyBalance();

	public double getMonthlyAmountDue();

	public void setInterest(double rate);

	public double getInterest();

	public String generateMonthlyBills();
}
