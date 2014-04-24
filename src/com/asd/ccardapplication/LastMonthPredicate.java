package com.asd.ccardapplication;

import java.util.Date;

import com.asd.framework.IEntry;
import com.asd.framework.IPredicate;

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
