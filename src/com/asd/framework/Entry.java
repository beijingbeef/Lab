package com.asd.framework;

import java.util.Date;

public class Entry implements IEntry {
	private double amount;
	private Date date;

	public Entry(double amount) {
		this(amount, new Date());
	}

	public Entry(double ammount, Date date) {
		this.amount = ammount;
		this.date = date;
	}

	public double getAmmount() {
		return amount;
	}

	public void setAmmount(double ammount) {
		this.amount = ammount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
