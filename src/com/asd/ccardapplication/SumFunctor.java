package com.asd.ccardapplication;

import com.asd.framework.IEntry;
import com.asd.framework.IFunctor;

public class SumFunctor implements IFunctor {
	double total;

	public SumFunctor() {
		this.total = 0;
	}

	@Override
	public void compute(IEntry e) {
		this.total += e.getAmount();
	}

	@Override
	public double getValue() {
		return this.total;
	}

}
