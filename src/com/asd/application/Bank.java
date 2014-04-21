package com.asd.application;

import com.asd.gui.GUIFactory;
import com.asd.gui.MainFrame;
import com.asd.gui.impl.BankGuiFactory;

public class Bank {

	public static void main(String[] args) {
		GUIFactory guiFactory = BankGuiFactory.createInstance();
		MainFrame mainframe = guiFactory.createMainFrame();
		mainframe.setVisible(true);
	}

}
