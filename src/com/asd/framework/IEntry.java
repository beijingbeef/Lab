package com.asd.framework;

import java.util.Date;

public interface IEntry {
	
	public TransactionType getTransactionType();
	public void setTransactionType(TransactionType type);
	
	public double getAmount();
	public void setAmount(double amount);
	
	public Date getDate();
	public void setDate(Date date);
	
	

}
