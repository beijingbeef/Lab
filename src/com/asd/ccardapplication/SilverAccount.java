package com.asd.ccardapplication;

import java.util.Date;

public class SilverAccount extends ACCardAccount {

	public SilverAccount(String ccnumber, Date expDate) {
		super(ccnumber, expDate);
		this.monthly_interest = 0.08;
		this.minimum_payment_rate = 0.12;
	}

	@Override
	public String getInitial() {
		return "Silver";
	}

}
