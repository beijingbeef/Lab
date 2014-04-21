package com.asd.gui.impl;

import java.awt.Frame;

import com.asd.gui.GUIFactory;
import com.asd.gui.MainFrame;
import com.asd.gui.PopDialog;

public class BankGuiFactory extends GUIFactory {

	@Override
	public MainFrame createMainFrame() {
		MainFrame frame = new BankMainFrame("Bank Application","Add personal account","Add company account","Deposit","Withdraw");
		return frame;
	}

	@Override
	public PopDialog creatCustormerForm(Frame owner,String[] radios, String[] textfields) {
		PopDialog p = new PopDialog(owner,true);
		p.setRadio(radios);
		p.setTextfield(textfields);
		return p;
	}

	@Override
	public PopDialog createDepositForm(Frame owner) {
		PopDialog p = new PopDialog(owner,true);
		p.setTitle("Deposit");
		String[] textfields = {"name","account"};
		p.setTextfield(textfields);
		return p;
	}

	@Override
	public PopDialog createWithdrawForm(Frame owner) {
		PopDialog p = new PopDialog(owner,true);
		p.setTitle("Withdraw");
		String[] textfields = {"name","account"};
		p.setTextfield(textfields);
		return p;
	}
	
	static public void main(String[] args){
		BankGuiFactory bgf = new BankGuiFactory();
		bgf.createMainFrame().setVisible(true);
	}

}
