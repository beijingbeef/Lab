package com.asd.ccardapplication;

import com.asd.ccardapplication.gui.CreditGuiFactory;
import com.asd.framework.Application;
import com.asd.framework.gui.GUIFactory;

public class CCardApplication  extends Application{

	public static void main(String[] args) {
		
		GUIFactory guiFactory = CreditGuiFactory.createInstance();
		
		CCardApplication credit = new CCardApplication();
		credit.setGUIFactory(guiFactory);
		credit.run();
	}

}
