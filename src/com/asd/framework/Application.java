package com.asd.framework;

import com.asd.framework.gui.GUIFactory;
import com.asd.framework.gui.MainFrame;

public class Application {
	
	protected MainFrame mainframe = null;
	protected GUIFactory factory = null;
	
	public void setGUIFactory( GUIFactory factory){
		this.factory = factory;
	}
	
	public void run(){
		mainframe.setVisible(true);
	}
}
