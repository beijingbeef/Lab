package com.asd.ccardapplication;

import java.util.Date;

public class GoldAccount extends ACCardAccount {

	public GoldAccount(String ccnumber, Date expDate) {
		super(ccnumber, expDate);
		this.monthly_interest = 0.06;
		this.minimum_payment_rate = 0.10;
	}

	@Override
	public String getInitial() {
		return "Gold";
	}

}
