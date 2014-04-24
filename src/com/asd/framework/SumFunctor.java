package com.asd.framework;

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
