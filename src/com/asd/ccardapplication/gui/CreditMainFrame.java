package com.asd.ccardapplication.gui;

import java.awt.event.ActionEvent;
import java.util.Map;

import com.asd.bankapplication.gui.BankGuiFactory;
import com.asd.framework.AAccount;
import com.asd.framework.Customer;
import com.asd.framework.IAccount;
import com.asd.framework.ICustomer;
import com.asd.framework.Person;
import com.asd.gui.BillFrame;
import com.asd.gui.MainFrame;
import com.asd.gui.PopDialog;

public class CreditMainFrame extends MainFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -693371272789329727L;


	public CreditMainFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}
	
	/**
	 * Add Credit-card account
	 */
	@Override
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
		String[] radios = { "Gold", "Silver", "Broze" };
		String[] textfields = { "Name", "Street", "City", "State", "Zip",
				 "Email", "CC Number", "Exp. Date"};
		PopDialog p = BankGuiFactory.createInstance().creatCustormerForm(this,
				radios, textfields);
		p.showWindow();
		Map<String, String> data = p.getData();
		if (null == data) {
			return;
		}
		System.out.println(data);

		String type = data.get("radio");
		String name = data.get("Name");
		String street = data.get("Street");
		String city = data.get("City");
		String state = data.get("State");
		String zip = data.get("Zip");
		String email = data.get("Email");
		String cc_number = data.get("CC Number");
		String exp = data.get("Exp. Date");
		
		ICustomer customer =  new Customer(name, street, city, state, Integer.parseInt(zip), email);
		IAccount account = null;
		//account = new AAccount();
		String []rowValues = {"7","7","7"};
		addTableRowData(rowValues);
	}


	/**
	 * Generate Monthly bills
	 */
	@Override
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		BillFrame bf = new BillFrame("message bills");
		bf.setVisible(true);
	}


	@Override
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		String []rowValues = {"0","0","0"};
		setTableHeader(rowValues);
	}


	@Override
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		String []rowValues = {"9","9","9"};
		updateRowData(0,rowValues);
	}

}
