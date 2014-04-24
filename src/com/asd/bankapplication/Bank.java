package com.asd.bankapplication;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.asd.bankapplication.gui.BankGuiFactory;
import com.asd.framework.AddAccountCmd;
import com.asd.framework.AddInterestCmd;
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

public class Bank extends Application {

	private ICustomer customers = new Company();
	private CmdMgr cmdmgr = new CmdMgr();

	@Override
	public void run() {

		mainframe = this.factory.createMainFrame();

		mainframe.setBtnButtonFunctor_1(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				String[] radios = { "chekings", "savings" };
				String[] textfields = { "Name", "Street", "City", "State",
						"Zip", "Birthday", "Email" };
				PopDialog p = BankGuiFactory.createInstance()
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
				String zip = data.get("Zip");
				String birthday = data.get("Birthday");
				String email = data.get("Email");

				ICustomer customer = new Person(name, street, city, state,
						Integer.parseInt(zip), birthday, email);

				IAccount account = null;
				if ("chekings".equals(type)) {
					account = new CheckingAccount();
				} else {
					account = new SavingAccount();
				}

				customers.addCustomer(customer);

				ICommand cmd = new AddAccountCmd(customer, account);
				cmdmgr.submit(cmd);

				mainframe.addTableRowData(mainframe.parseCustomer(customer));
			}
		});

		mainframe.setBtnButtonFunctor_2(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				String[] radios = { "chekings", "savings" };
				String[] textfields = { "Name", "Street", "City", "State",
						"Zip", "NOE", "Email" };
				PopDialog p = BankGuiFactory.createInstance()
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
				String zip = data.get("Zip");
				String NOE = data.get("NOE");
				String email = data.get("Email");

				ICustomer customer = new Company(name, street, city, state,
						Integer.parseInt(zip), Integer.parseInt(NOE), email);

				IAccount account = null;
				if ("chekings".equals(type)) {
					account = new CheckingAccount();
				} else {
					account = new SavingAccount();
				}

				customers.addCustomer(customer);

				ICommand cmd = new AddAccountCmd(customer, account);
				cmdmgr.submit(cmd);

				mainframe.addTableRowData(mainframe.parseCustomer(customer));
			}
		});

		mainframe.setBtnButtonFunctor_3(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				PopDialog p = BankGuiFactory.createInstance()
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

		mainframe.setBtnButtonFunctor_4(new GuiActionFunctor() {
			public void actionPerformed(ActionEvent e) {
				PopDialog p = BankGuiFactory.createInstance()
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

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JButton addInterestButton = new JButton("Add Interest");
		addInterestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInterest_actionPerformed(e);
			}
		});
		panel.add(addInterestButton);
		mainframe.setDIYComponentPanel(panel);

		// load test data
		loadTestData();

		// show
		super.run();
	}

	public void addInterest_actionPerformed(ActionEvent e) {
		int size = customers.count();
		for (int i = 0; i < size; i++) {
			ICustomer customer = customers.getCustomer(i);
			ICommand cmd = new AddInterestCmd(customer.getAccount());
			cmdmgr.submit(cmd);
			mainframe.updateRowData(i, mainframe.parseCustomer(customer));
		}
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

	public void makePersonalTestData(String type, String name, String street,
			String city, String state, String zip, String email, String birthday) {
		ICustomer customer = new Person(name, street, city, state,
				Integer.parseInt(zip), birthday, email);

		IAccount account = null;
		if ("chekings".equals(type)) {
			account = new CheckingAccount();
		} else {
			account = new SavingAccount();
		}

		customers.addCustomer(customer);

		ICommand cmd = new AddAccountCmd(customer, account);
		cmdmgr.submit(cmd);

		mainframe.addTableRowData(mainframe.parseCustomer(customer));
	}

	public void makeCompanyTestData(String type, String name, String street,
			String city, String state, String zip, String email, String NOE) {
		ICustomer customer = new Company(name, street, city, state,
				Integer.parseInt(zip), Integer.parseInt(NOE), email);

		IAccount account = null;
		if ("chekings".equals(type)) {
			account = new CheckingAccount();
		} else {
			account = new SavingAccount();
		}

		customers.addCustomer(customer);

		ICommand cmd = new AddAccountCmd(customer, account);
		cmdmgr.submit(cmd);

		mainframe.addTableRowData(mainframe.parseCustomer(customer));
	}

	public void loadTestData() {
		makePersonalTestData("checkings", "hongming", "1000 N 4th St",
				"Fairfield", "IA", "52557", "hongming@mum.edu", "01/01/1988");
		makePersonalTestData("savings", "va", "1000 N 4th St", "Fairfield",
				"IA", "52557", "aphiwad@mum.edu", "01/01/1988");
		makePersonalTestData("checkings", "aphiwad", "1000 N 4th St",
				"Fairfield", "IA", "52557", "va@mum.edu", "01/01/1988");

//		makeCompanyTestData("checkings", "google", "1000 N 4th St",
//				"Fairfield", "IA", "52557", "google@mum.edu", "10");
//		makeCompanyTestData("checkings", "facebook", "1000 N 4th St",
//				"Fairfield", "IA", "52557", "facebook@mum.edu", "10");
	}

	public static void main(String[] args) {

		GUIFactory guiFactory = BankGuiFactory.createInstance();
		
		Bank bank = new Bank();
		bank.setGUIFactory(guiFactory);
		bank.run();

	}

}
