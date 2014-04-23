package com.asd.ccardapplication;

import java.util.Date;

public class BronzeAccount extends ACCardAccount {

	public BronzeAccount(String ccnumber, Date expDate) {
		super(ccnumber, expDate);
		this.monthly_interest = 0.10;
		this.minimum_payment_rate = 0.14;
	}

	@Override
	public String getInitial() {
		return "Bronze";
	}

}
