package com.asd.ccardapplication.gui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.asd.ccardapplication.ACCardAccount;
import com.asd.framework.ICustomer;
import com.asd.framework.gui.MainFrame;

public class CreditMainFrame extends MainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -693371272789329727L;

	public CreditMainFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}

	public String[] parseCustomer(ICustomer customer) {
		String[] result = new String[5];
		ACCardAccount account = (ACCardAccount) customer.getAccount();
		Date date = account.getExpire_date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		result[0] = customer.getName();
		result[1] = account.getCCnumber();

		try {
			result[2] = sdf.format(date);
		} catch (Exception e1) {
			result[2] = "";
		}

		result[3] = account.getType();
		result[4] = String.valueOf(account.getCurrentBalance());
		return result;
	}
}
