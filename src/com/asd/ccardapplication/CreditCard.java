package com.asd.ccardapplication;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.asd.ccardapplication.gui.CreditGuiFactory;
import com.asd.framework.AddAccountCmd;
import com.asd.framework.Application;
import com.asd.framework.CmdMgr;
import com.asd.framework.Company;
import com.asd.framework.DepositCmd;
import com.asd.framework.IAccount;
import com.asd.framework.ICommand;
import com.asd.framework.ICustomer;
import com.asd.framework.Person;
import com.asd.framework.WithdrawCmd;
import com.asd.framework.gui.GUIFactory;
import com.asd.framework.gui.GuiActionFunctor;
import com.asd.framework.gui.PopDialog;

public class CreditCard extends Application {

	private ICustomer customers = new Company();
	private CmdMgr cmdmgr = new CmdMgr();

	@Override
	public void run() {

		mainframe = this.factory.createMainFrame();

		/**
		 * Add Credit-card account
		 */
		mainframe.setBtnButtonFunctor_1(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				String[] radios = { "Gold", "Silver", "Bronze" };
				String[] textfields = { "Name", "Street", "City", "State",
						"Zip", "Email", "CC Number", "Exp. Date" };
				PopDialog p = CreditGuiFactory.createInstance()
						.creatCustormerForm(mainframe, radios, textfields);
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
				String zip = data.get("Zip").equals("") ? "0" : data.get("Zip");
				String email = data.get("Email");
				String cc_number = data.get("CC Number");
				String exp = data.get("Exp. Date");

				String tmp[] = exp.split("/");
				exp = tmp[0] + "/20" +tmp[1];
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");

				Date expDate = null;
				try {
					expDate = sdf.parse(exp);
				} catch (ParseException e1) {
					System.out.println("Wrong Date Formate " + exp);
				}

				System.out.println("expDate" + expDate);

				ICustomer customer = new Person(name, street, city, state,
						Integer.parseInt(zip), null, email);

				IAccount account = null;
				if (type.equals("Gold")) {
					account = new GoldAccount(cc_number, expDate);
				} else if (type.equals("Silver")) {
					account = new SilverAccount(cc_number, expDate);
				} else if (type.equals("Bronze")) {
					account = new BronzeAccount(cc_number, expDate);
				}

				customers.addCustomer(customer);

				ICommand cmd = new AddAccountCmd(customer, account);
				cmdmgr.submit(cmd);

				mainframe.addTableRowData(mainframe.parseCustomer(customer));
			}
		});
		/**
		 * Generate Monthly bills
		 */
		mainframe.setBtnButtonFunctor_2(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				int size = customers.count();
				for (int i = 0; i < size; i++) {
					sb.append(customers.getCustomer(i).getAccount()
							.generateMonthlyBills());
					sb.append("\n\n");
				}

				BillDialog bf = new BillDialog(mainframe, true, sb.toString());
				bf.showBillDialog();
			}
		});

		/**
		 * deposit
		 */
		mainframe.setBtnButtonFunctor_3(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				PopDialog p = CreditGuiFactory.createInstance()
						.createDepositForm(mainframe);
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

				ICommand cmd = new DepositCmd(customer.getAccount(), Double
						.parseDouble(amount));
				cmdmgr.submit(cmd);

				int index = getCustomerIndex(customer);

				mainframe.updateRowData(index,
						mainframe.parseCustomer(customer));
			}
		});
		/**
		 * charge
		 */
		mainframe.setBtnButtonFunctor_4(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				PopDialog p = CreditGuiFactory.createInstance()
						.createWithdrawForm(mainframe);
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

				ICommand cmd = new WithdrawCmd(customer.getAccount(), Double
						.parseDouble(amount));
				cmdmgr.submit(cmd);

				int index = getCustomerIndex(customer);
				System.out.println(name + "@" + index);

				mainframe.updateRowData(index,
						mainframe.parseCustomer(customer));
			}
		});

		// load test data
		loadTestData();

		// show
		super.run();
	}

	private int getCustomerIndex(ICustomer customer) {
		int index = -1;
		int size = customers.count();
		for (int i = 0; i < size; i++) {
			ICustomer c = customers.getCustomer(i);
			if (c.getName().equals(customer.getName())) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void makeTestData(String type, String name, String street,
			String city, String state, String zip, String email,
			String cc_number, String exp) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
		Date expDate = null;
		try {
			expDate = sdf.parse(exp);
		} catch (ParseException e1) {
			System.out.println("Wrong Date Formate " + exp);
		}
		ICustomer customer = new Person(name, street, city, state,
				Integer.parseInt(zip), null, email);
		IAccount account = null;
		if (type.equals("Gold")) {
			account = new GoldAccount(cc_number, expDate);
		} else if (type.equals("Silver")) {
			account = new SilverAccount(cc_number, expDate);
		} else if (type.equals("Bronze")) {
			account = new BronzeAccount(cc_number, expDate);
		}

		customers.addCustomer(customer);

		ICommand cmd = new AddAccountCmd(customer, account);
		cmdmgr.submit(cmd);

		mainframe.addTableRowData(mainframe.parseCustomer(customer));
	}

	public void loadTestData() {
		makeTestData("Gold", "tom", "1000 N 4th St", "Fairfield", "IA",
				"52557", "tom@mum.edu", "1212 3333", "10/17");
		makeTestData("Gold", "aphiwad", "1000 N 4th St", "Fairfield", "IA",
				"52557", "aphiwad@mum.edu", "1212 4444", "10/15");
		makeTestData("Silver", "hongming", "1000 N 4th St", "Fairfield", "IA",
				"52557", "hongming@mum.edu", "1212 5555", "10/20");
		makeTestData("Bronze", "va", "1000 N 4th St", "Fairfield", "IA",
				"52557", "va@mum.edu", "1212 5555", "10/16");
	}

	public static void main(String[] args) {
		GUIFactory guiFactory = CreditGuiFactory.createInstance();
		CreditCard credit = new CreditCard();
		credit.setGUIFactory(guiFactory);
		credit.run();
	}

}
