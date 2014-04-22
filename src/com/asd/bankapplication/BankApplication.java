package com.asd.bankapplication;

import com.asd.bankapplication.gui.BankGuiFactory;
import com.asd.framework.Application;
import com.asd.framework.gui.GUIFactory;

public class BankApplication extends Application{

	public static void main(String[] args) {
		
		GUIFactory guiFactory = BankGuiFactory.createInstance();
		BankApplication bank = new BankApplication();
		bank.setGUIFactory(guiFactory);
		bank.run();
		
	}

}
