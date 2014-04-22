package com.asd.framework.gui;

import java.awt.Frame;

public abstract class GUIFactory {
	public abstract MainFrame createMainFrame();
	public abstract PopDialog creatCustormerForm(Frame owner,String[] radios,String[] textfields);
	public abstract PopDialog createDepositForm(Frame owner);
	public abstract PopDialog createWithdrawForm(Frame owner);
}
