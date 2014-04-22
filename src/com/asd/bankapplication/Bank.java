package com.asd.bankapplication;

import com.asd.bankapplication.gui.BankGuiFactory;
import com.asd.gui.GUIFactory;
import com.asd.gui.MainFrame;

public class Bank {

	public static void main(String[] args) {
		GUIFactory guiFactory = BankGuiFactory.createInstance();
		MainFrame mainframe = guiFactory.createMainFrame();
		mainframe.setVisible(true);
	}

}
