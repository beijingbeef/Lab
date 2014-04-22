package com.asd.ccardapplication;

import java.util.Date;

public class BronzeAccount extends CCardAccount {

	public BronzeAccount() {
		super();
	}

	public BronzeAccount(String ccnumber, Date expDate) {
		super(ccnumber, expDate);
	}

	@Override
	public String getType() {
		return "Bronze";
	}

}
