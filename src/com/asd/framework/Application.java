package com.asd.framework;

import com.asd.framework.gui.GUIFactory;
import com.asd.framework.gui.MainFrame;

public class Application {
	
	protected GUIFactory factory = null;
	
	public void setGUIFactory( GUIFactory factory){
		this.factory = factory;
	}
	
	public void run(){
		MainFrame mainframe = this.factory.createMainFrame();
		mainframe.setVisible(true);
	}
}
