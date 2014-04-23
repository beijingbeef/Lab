package com.asd.ccardapplication.gui;

import java.awt.Frame;

import com.asd.framework.gui.GUIFactory;
import com.asd.framework.gui.MainFrame;
import com.asd.framework.gui.PopDialog;

public class CreditGuiFactory extends GUIFactory {

	private static CreditGuiFactory instance = null;
	
	public static CreditGuiFactory createInstance(){
		if ( null == instance ){
			instance = new CreditGuiFactory();
		}
		return instance;
	}
	
	private CreditGuiFactory(){
		
	}
	
	@Override
	public MainFrame createMainFrame() {
		CreditMainFrame frame = new CreditMainFrame("Credit-card processing Application","Add Credit-card account","Generate Monthly bills","Deposit","Charge");
		String[] header = {"Name","CC number","Exp. date","Type","Balance"};
		frame.setTableHeader(header);
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
		String[] textfields = {"Name","Amount"};
		p.setTextfield(textfields);
		return p;
	}

	@Override
	public PopDialog createWithdrawForm(Frame owner) {
		PopDialog p = new PopDialog(owner,true);
		p.setTitle("Charge");
		String[] textfields = {"Name","Amount"};
		p.setTextfield(textfields);
		return p;
	}
	
	static public void main(String[] args){
		CreditGuiFactory cgf = new CreditGuiFactory();
		cgf.createMainFrame().setVisible(true);
	}

}
