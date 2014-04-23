package com.asd.framework;

public abstract class ACustomer implements ICustomer {
	protected IAccount account;

	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected int zip;
	protected String email;

	public ACustomer(String name, String street, String city, String state,
			int zip, String email) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int getZip() {
		return zip;
	}

	@Override
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void addAccount(IAccount account) {
		IAccount acc = getAccount();
		acc.addAccount(account);
		this.account = acc;
		account.setCustomer(this);
	}
	
	@Override
	public void removeAccount(IAccount account) {
		IAccount acc = getAccount();
		acc.removeAccount(account);
		this.account = acc;
	}

	@Override
	public IAccount getAccount() {
		return this.account;
	}

	@Override
	public abstract int count();

	@Override
	public abstract ICustomer getCustomer(int index);

	@Override
	public abstract ICustomer getCustomer(String name);

	@Override
	public abstract void addCustomer(ICustomer customer);

	@Override
	public abstract void removeCustomer(ICustomer customer);

	@Override
	public abstract void sendEmailToCustomer();
	
	@Override
	public abstract String getInitial();
}
