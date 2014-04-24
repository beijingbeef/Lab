package com.asd.framework;

public abstract class AAccount implements IAccount {
	protected String accnr;
	protected double current_balance;
	protected ICustomer customer;
	protected Entries entries = new Entries();

	@Override
	public double getCurrentBalance() {
		return this.current_balance;
	}

	@Override
	public abstract void addAccount(IAccount account);

	@Override
	public abstract void removeAccount(IAccount account);

	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	@Override
	public void addEntry(IEntry entry) {
		this.entries.add(entry);
		this.current_balance += entry.getAmount();
	}

	@Override
	public void notifyCustomer() {
		this.customer.sendEmailToCustomer();
	}

	@Override
	public abstract void addInterest();

	@Override
	public abstract String getInitial();

	@Override
	public abstract double getLastMonthBalance();

	@Override
	public abstract double getTotalMonthlyCredit();

	@Override
	public abstract double getTotalMonthlyCharge();

	@Override
	public abstract double getNewMonthlyBalance();

	@Override
	public abstract double getMonthlyAmountDue();

	@Override
	public abstract String generateMonthlyBills();

}
