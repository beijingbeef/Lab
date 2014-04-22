package com.asd.ccardapplication.gui;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.asd.bankapplication.gui.BankGuiFactory;
import com.asd.ccardapplication.ACCardAccount;
import com.asd.ccardapplication.BronzeAccount;
import com.asd.ccardapplication.GoldAccount;
import com.asd.ccardapplication.SilverAccount;
import com.asd.framework.AddAccountCmd;
import com.asd.framework.AddCustomerCmd;
import com.asd.framework.CmdMgr;
import com.asd.framework.Customer;
import com.asd.framework.Customers;
import com.asd.framework.DepositCmd;
import com.asd.framework.IAccount;
import com.asd.framework.ICommand;
import com.asd.framework.ICustomer;
import com.asd.framework.WithdrawCmd;
import com.asd.gui.BillDialog;
import com.asd.gui.MainFrame;
import com.asd.gui.PopDialog;

public class CreditMainFrame extends MainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -693371272789329727L;
	private ICustomer customers = new Customers();
	private CmdMgr cmdmgr = new CmdMgr();

	public CreditMainFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}

	/**
	 * Add Credit-card account
	 */
	@Override
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {

		String[] radios = { "Gold", "Silver", "Bronze" };
		String[] textfields = { "Name", "Street", "City", "State", "Zip",
				"Email", "CC Number", "Exp. Date" };
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

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		Date expDate = null;
		try {
			expDate = sdf.parse(exp);
		} catch (ParseException e1) {
			System.out.println("Wrong Date Formate " + exp);
		}

		ICustomer customer = new Customer(name, street, city, state,
				Integer.parseInt(zip), email);
		
		IAccount account = null;
		if (type.equals("Gold")) {
			account = new GoldAccount(cc_number, expDate);
		} else if (type.equals("Silver")) {
			account = new SilverAccount(cc_number, expDate);
		} else if (type.equals("Bronze")) {
			account = new BronzeAccount(cc_number, expDate);
		}
		
		ICommand cmd = new AddCustomerCmd(customers, customer);
		cmdmgr.submit(cmd);
		
		cmd = new AddAccountCmd(customer, account);
		cmdmgr.submit(cmd);

		addTableRowData(parseCustomer(customer));
	}

	/**
	 * Generate Monthly bills
	 */
	@Override
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {

		StringBuilder sb = new StringBuilder();
		int size = customers.getSize();
		for (int i = 0; i < size; i++) {
			sb.append(customers.getCustomer(i).getAccount()
					.generateMonthlyBills());
			sb.append("\n\n");
		}

		BillDialog bf = new BillDialog(this,true,sb.toString());
		bf.showBillDialog();
	}

	/**
	 * deposit
	 * 
	 * @param e
	 */
	@Override
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {

		PopDialog p = BankGuiFactory.createInstance().createDepositForm(this);
		p.showWindow();
		Map<String, String> data = p.getData();
		if (null == data) {
			return;
		}
		String name = data.get("Name");
		String amount = data.get("Amount");
		ICustomer customer = customers.getCustomer(name);
		System.out.println(data);
		if (null == customer) {
			System.out.println(name + " not exits!");
			return;
		}

		ICommand cmd = new DepositCmd(customer.getAccount(),
				Double.parseDouble(amount));
		cmdmgr.submit(cmd);

		int index = getCustomerIndex(customer);
		System.out.println(name + "@" + index);

		updateRowData(index, parseCustomer(customer));
	}

	/**
	 * withdraw
	 * 
	 * @param e
	 */
	@Override
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		PopDialog p = BankGuiFactory.createInstance().createWithdrawForm(this);
		p.showWindow();
		Map<String, String> data = p.getData();
		if (null == data) {
			return;
		}
		String name = data.get("Name");
		String amount = data.get("Amount");
		ICustomer customer = customers.getCustomer(name);
		System.out.println(data);
		if (null == customer) {
			System.out.println(name + " not exits!");
			return;
		}

		ICommand cmd = new WithdrawCmd(customer.getAccount(),
				Double.parseDouble(amount));
		cmdmgr.submit(cmd);

		int index = getCustomerIndex(customer);
		System.out.println(name + "@" + index);

		updateRowData(index, parseCustomer(customer));
	}

	public String[] parseCustomer(ICustomer customer) {
		String[] result = new String[5];
		ACCardAccount account = (ACCardAccount) customer.getAccount();
		Date date = account.getExpire_date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		result[0] = customer.getName();
		result[1] = account.getCCnumber();
		result[2] = sdf.format(date);
		result[3] = account.getType();
		result[4] = String.valueOf(account.getCurrentBalance());
		return result;
	}

	private int getCustomerIndex(ICustomer customer) {
		int index = -1;
		int size = customers.getSize();
		for (int i = 0; i < size; i++) {
			ICustomer c = customers.getCustomer(i);
			if (c.getName().equals(customer.getName())) {
				index = i;
				break;
			}
		}
		return index;
	}

}
