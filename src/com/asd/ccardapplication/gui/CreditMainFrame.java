package com.asd.ccardapplication.gui;

import java.awt.event.ActionEvent;

import com.asd.gui.BillFrame;
import com.asd.gui.MainFrame;

public class CreditMainFrame extends MainFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -693371272789329727L;


	public CreditMainFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}
	
	/**
	 * Add Credit-card account
	 */
	@Override
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		String []rowValues = {"7","7","7"};
		addTableRowData(rowValues);
	}


	/**
	 * Generate Monthly bills
	 */
	@Override
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		BillFrame bf = new BillFrame("message bills");
		bf.setVisible(true);
	}


	@Override
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		String []rowValues = {"0","0","0"};
		setTableHeader(rowValues);
	}


	@Override
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		String []rowValues = {"9","9","9"};
		updateRowData(0,rowValues);
	}

}
