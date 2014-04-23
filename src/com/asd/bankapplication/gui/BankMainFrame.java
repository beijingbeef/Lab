package com.asd.bankapplication.gui;

import com.asd.framework.IAccount;
import com.asd.framework.ICustomer;
import com.asd.framework.gui.MainFrame;

public class BankMainFrame extends MainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -693371272789329727L;

	/**
	 * need to remove from here;
	 */
	public BankMainFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}

	public String[] parseCustomer(ICustomer customer) {
		String[] result = new String[8];
		IAccount account = customer.getAccount();
		result[0] = customer.getName();
		result[1] = customer.getStreet();
		result[2] = customer.getCity();
		result[3] = customer.getState();
		result[4] = String.valueOf(customer.getZip());
		result[5] = customer.getInitial();
		result[6] = account.getInitial();
		result[7] = String.valueOf(account.getCurrentBalance());
		return result;
	}
}
