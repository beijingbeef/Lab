package com.asd.framework;

public interface ICustomer {

	// transparent getter and setter
	public String getName();

	public void setName(String name);

	public String getStreet();

	public void setStreet(String street);

	public String getCity();

	public void setCity(String city);

	public String getState();

	public void setState(String state);

	public int getZip();

	public void setZip(int zip);

	public String getEmail();

	public void setEmail(String email);

	// ------------------------------------------

	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public IAccount getAccount();

	public int count();

	public ICustomer getCustomer(int index);

	public ICustomer getCustomer(String name);

	// transparent method for composite
	public void addCustomer(ICustomer customer);

	// transparent method for composite
	public void removeCustomer(ICustomer customer);

	public void sendEmailToCustomer();

	public String getInitial();
}