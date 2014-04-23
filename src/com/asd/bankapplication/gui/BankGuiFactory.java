package com.asd.bankapplication.gui;

import java.awt.Frame;

import com.asd.framework.gui.GUIFactory;
import com.asd.framework.gui.MainFrame;
import com.asd.framework.gui.PopDialog;

public class BankGuiFactory extends GUIFactory {

	private static BankGuiFactory instance = null;
	
	public static BankGuiFactory createInstance(){
		if( null == instance ){
			instance = new BankGuiFactory();
		}
		return instance;
	}
	
	private BankGuiFactory() {
		super();
	}

	@Override
	public MainFrame createMainFrame() {
		MainFrame frame = new BankMainFrame("Bank Application","Add personal account","Add company account","Deposit","Withdraw");
		String[] header = {"Name","Street","City","State","Zip","P/C","Ch/S","Amount"};
		frame.setTableHeader(header);
		return frame;
	}

	@Override
	public PopDialog creatCustormerForm(Frame owner,String[] radios, String[] textfields) {
		PopDialog p = new PopDialog(owner,true);
		if(null != radios){
			p.setRadio(radios);
		}
		p.setTextfield(textfields);
		return p;
	}

	@Override
	public PopDialog createDepositForm(Frame owner) {
		PopDialog p = new PopDialog(owner,true);
		p.setTitle("Deposit");
		String[] textfields = {"Name","Amount"};
		p.setTextfield(textfields);
		return p;
	}

	@Override
	public PopDialog createWithdrawForm(Frame owner) {
		PopDialog p = new PopDialog(owner,true);
		p.setTitle("Withdraw");
		String[] textfields = {"Name","Amount"};
		p.setTextfield(textfields);
		return p;
	}

}
