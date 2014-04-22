package com.asd.ccardapplication;

import com.asd.ccardapplication.gui.CreditGuiFactory;
import com.asd.gui.GUIFactory;
import com.asd.gui.MainFrame;

public class Credit {

	public static void main(String[] args) {
		GUIFactory guiFactory = CreditGuiFactory.createInstance();
		MainFrame mainframe = guiFactory.createMainFrame();
		mainframe.setVisible(true);
	}

}
