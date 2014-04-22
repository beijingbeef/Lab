package com.asd.ccardapplication;

import java.util.Date;

public class SilverAccount extends ACCardAccount {

	public SilverAccount() {
		super();
	}

	public SilverAccount(String ccnumber, Date expDate) {
		super(ccnumber, expDate);
	}

	@Override
	public String getType() {
		return "Silver";
	}

}
