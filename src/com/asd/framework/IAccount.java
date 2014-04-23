package com.asd.framework;

public interface IAccount {

	public double getCurrentBalance();

	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public ICustomer getCustomer();

	public void setCustomer(ICustomer c);

	public void addEntry(IEntry entry);

	public void notifyCustomer();

	public void addInterest();

	public String getInitial();

	public double getLastMonthBalance();

	public double getTotalMonthlyCredit();

	public double getTotalMonthlyCharge();

	public double getNewMonthlyBalance();

	public double getMonthlyAmountDue();

	public String generateMonthlyBills();
}
