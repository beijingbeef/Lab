package com.asd.framework;

import java.util.Date;

public class MonthlyCreditPredicate implements IPredicate {

	@Override
	public boolean check(IEntry e) {
		Date now = new Date();
		if (e.getDate().getMonth() == now.getMonth()
				&& e.getTransactionType() == TransactionType.DEPOSIT) {
			return true;
		}
		return false;
	}

}
