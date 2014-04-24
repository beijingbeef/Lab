package com.asd.framework;

import java.util.Date;

public class LastMonthPredicate implements IPredicate {

	@Override
	public boolean check(IEntry e) {
		Date now = new Date();
		if (e.getDate().getMonth() == now.getMonth() - 1) {
			return true;
		}
		return false;
	}

}
