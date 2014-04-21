package com.asd.framework;

import java.util.Date;

public class Entry implements IEntry {
	private double amount;
	private Date date;
	private TransactionType type;

	public Entry(TransactionType type, double amount) {
		this(type, amount, new Date());
	}

	public Entry(TransactionType type, double amount, Date date) {
		this.type = type;
		this.amount = amount;
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
