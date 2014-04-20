package com.asd.gui;

import java.util.GregorianCalendar;

public class Entry implements IEntry {
	private double ammount;
	private GregorianCalendar date;

	public Entry(double ammount, GregorianCalendar date) {
		this.ammount = ammount;
		this.date = date;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

}
