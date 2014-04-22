package com.asd.framework;

public interface ICustomer {
	public void addAccount(IAccount account);

	public ICustomer getCustomer(int index);

	public ICustomer getCustomer(String name);

	public IAccount getAccount();

	public String getName();

	public String getStreet();

	public String getCity();

	public String getState();

	public int getZip();

	public String getEmail();

	public String getType();

	public int getSize();

	public void addCustomer(ICustomer customer);

	public void removeCustomer(ICustomer customer);

	public void sendEmailToCustomer(double amount);
}