package com.asd.bankapplication.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.asd.framework.CmdMgr;
import com.asd.framework.Company;
import com.asd.framework.Customers;
import com.asd.framework.DepositCmd;
import com.asd.framework.Entry;
import com.asd.framework.IAccount;
import com.asd.framework.ICommand;
import com.asd.framework.ICustomer;
import com.asd.framework.IEntry;
import com.asd.framework.Personal;
import com.asd.framework.TransactionType;
import com.asd.framework.WithdrawCmd;
import com.asd.framework.impl.CheckingAccount;
import com.asd.framework.impl.SavingAccount;
import com.asd.gui.MainFrame;
import com.asd.gui.PopDialog;

public class BankMainFrame extends MainFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -693371272789329727L;

	/**
	 * need to remove from here;
	 */
	private ICustomer customers = new Customers();
	private CmdMgr cmdmgr = new CmdMgr();

	public BankMainFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}
	
	@Override
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
		String[] radios = {"chekings","savings"};
		String[] textfields = {"Name","Street","City","State","Zip","Birthday","Email"};
		PopDialog p =BankGuiFactory.createInstance().creatCustormerForm(this, radios, textfields);
		p.showWindow();
		Map<String,String> data = p.getData();
		if( null == data ){
			return;
		}
		System.out.println(data);
		
		String type = data.get("radio");
		String name = data.get("Name");
		String street = data.get("Street");
		String city = data.get("City");
		String state = data.get("State");
		String zip = data.get("Zip");
		String birthdaty = data.get("Birthday");
		String email = data.get("Email");
		
		ICustomer customer = new Personal(name, street, city, state, Integer.parseInt(zip), birthdaty, email) ;
		IAccount account = null;
		if("chekings".equals(type)){
			account  = new CheckingAccount();
		}else{
			account  = new SavingAccount();
		}
		customer.addAccount(account);
		
		customers.addCustomer(customer);
		
		String []rowValues = {customer.getName(),customer.getStreet(),customer.getCity(),customer.getState(),String.valueOf(customer.getZip()),customer.getType(),account.getType(),String.valueOf(account.getCurrentBalance())};
		addTableRowData(rowValues);
	}


	@Override
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		
		String[] radios = {"chekings","savings"};
		String[] textfields = {"Name","Street","City","State","Zip","NOE","Email"};
		PopDialog p =BankGuiFactory.createInstance().creatCustormerForm(this, radios, textfields);
		p.showWindow();
		Map<String,String> data = p.getData();
		if( null == data ){
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
		
		ICustomer customer = new Company(name, street, city, state, Integer.parseInt(zip), Integer.parseInt(NOE), email) ;
		IAccount account = null;
		if("chekings".equals(type)){
			account  = new CheckingAccount();
		}else{
			account  = new SavingAccount();
		}
		customer.addAccount(account);
		
		customers.addCustomer(customer);
		
		String []rowValues = {customer.getName(),customer.getStreet(),customer.getCity(),customer.getState(),String.valueOf(customer.getZip()),customer.getType(),account.getType(),String.valueOf(account.getCurrentBalance())};
		addTableRowData(rowValues);
	}

	/**
	 * deposit
	 */
	@Override
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		PopDialog p =BankGuiFactory.createInstance().createDepositForm(this);
		p.showWindow();
		Map<String,String> data = p.getData();
		if( null == data ){
			return;
		}
		String name = data.get("Name");
		String amount = data.get("Amount");
		ICustomer customer = customers.getCustomer(name);
		System.out.println(data);
		if( null == customer ){
			System.out.println(name + " not exits!");
			return;
		}
		
		ICommand cmd = new DepositCmd(customer.getAccount(), Double.parseDouble(amount));
		cmdmgr.submit(cmd);
		
		int index = getCustomerIndex(customer);
		System.out.println(name + "@" + index);
		
		updateRowData(index,parseCustomer(customer));
		
	}

	/**
	 * withdraw
	 */
	@Override
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		
		
		
		PopDialog p =BankGuiFactory.createInstance().createWithdrawForm(this);
		p.showWindow();
		Map<String,String> data = p.getData();
		if( null == data ){
			return;
		}
		String name = data.get("Name");
		String amount = data.get("Amount");
		ICustomer customer = customers.getCustomer(name);
		System.out.println(data);
		if( null == customer ){
			System.out.println(name + " not exits!");
			return;
		}
		
		ICommand cmd = new WithdrawCmd(customer.getAccount(), Double.parseDouble(amount));
		cmdmgr.submit(cmd);
		
		int index = getCustomerIndex(customer);
		System.out.println(name + "@" + index);
		
		updateRowData(index,parseCustomer(customer));
	}
	
	@Override
	public JPanel getDIYComponentPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton btnNewButton = new JButton("Add Interest");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInterest_actionPerformed(e);
			}
		});
		
		panel.add(btnNewButton);
		
		return panel;
	}
	
	public void addInterest_actionPerformed(ActionEvent e){
		int size = customers.getSize();
		for(int i = 0 ; i < size; i++){
			ICustomer customer = customers.getCustomer(i);
			customer.getAccount().addInterest();
			updateRowData(i, parseCustomer(customer));
		}
	}

	
	public String[] parseCustomer( ICustomer customer ){
		String[] result = new String[8];
		IAccount account = customer.getAccount();
		result[0] = customer.getName();
		result[1] = customer.getStreet();
		result[2] = customer.getCity();
		result[3] = customer.getState();
		result[4] = String.valueOf(customer.getZip());
		result[5] = customer.getType();
		result[6] = account.getType();
		result[7] =  String.valueOf(account.getCurrentBalance());
		return result;
	}
	
	private int getCustomerIndex(ICustomer customer){
		int index = -1;
		int size = customers.getSize();
		for(int i = 0 ; i < size; i++){
			ICustomer c = customers.getCustomer(i);
			if(c.getName().equals(customer.getName())){
				index = i;
				break;
			}
		}
		return index;
	}
}
