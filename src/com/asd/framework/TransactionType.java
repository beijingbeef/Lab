package com.asd.framework;

public enum TransactionType {
	DEPOSIT("DEPOSIT"),
	WITHDRAW("WITHDRAW"),
	INTEREST("INTEREST"),
	TAX("TAX");
	
	private final String desc;
	
	TransactionType(String desc)
	{
		this.desc = desc;
	}

	@Override
	public String toString() {
		return desc;
	}
	
	
	
}
