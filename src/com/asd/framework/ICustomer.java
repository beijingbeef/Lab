package com.asd.framework;

public interface ICustomer {
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	
	public void addCustomer(ICustomer customer);
	public void removeCustomer(ICustomer customer);
}