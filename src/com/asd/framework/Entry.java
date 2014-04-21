package com.asd.framework;

import java.util.Date;

public class Entry implements IEntry {
	private double amount;
	private Date date;
	private TransactionType type;

	public Entry(double amount) {
		this(amount, new Date());
	}

	public Entry(double ammount, Date date) {
		this.amount = ammount;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public TransactionType getTransactionType() {
		
		return type;
	}

	@Override
	public void setTransactionType(TransactionType type) {
		this.type = type;
		
	}

	@Override
	public double getAmount() {
		
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
		
	}

}
