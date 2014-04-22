package com.asd.ccardapplication;

import java.util.Date;

public class GoldAccount extends ACCardAccount {

	public GoldAccount() {
		super();
	}

	public GoldAccount(String ccnumber, Date expDate) {
		super(ccnumber, expDate);
	}

	@Override
	public String getType() {
		return "Gold";
	}

}
