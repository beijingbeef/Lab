package com.asd.framework;

public interface ICustomer {
	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public String getName();

	public String getStreet();

	public String getCity();

	public String getState();

	public int getZip();

	public String getEmail();

	public String getDob();

	public int getNumberOfEmployee();

	public String getType();

	public void addCustomer(ICustomer customer);

	public void removeCustomer(ICustomer customer);
}