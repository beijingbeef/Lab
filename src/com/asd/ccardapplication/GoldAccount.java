package com.asd.ccardapplication;

import java.util.Date;

public class GoldAccount extends CCardAccount {

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
