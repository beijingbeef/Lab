package com.asd.test.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.asd.gui.MainFrame;
import com.asd.gui.PopDialog;

public class MyTestFrame extends MainFrame {

	private static final long serialVersionUID = 1410943831161094218L;

	
	public MyTestFrame(String title, String button_1_name,
			String button_2_name, String button_3_name, String button_4_name) {
		super(title, button_1_name, button_2_name, button_3_name, button_4_name);
	}


	@Override
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		String []rowValues = {"7","7","7"};
		addTableRowData(rowValues);
	}


	@Override
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		removeTableRowData(0);
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


	@Override
	public JPanel getDIYComponentPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton btnNewButton = new JButton("Test Pop Dialog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				haha_actionPerformed(e);
			}
		});
		
		panel.add(btnNewButton);
		
		return panel;
	}
	
	public void haha_actionPerformed(ActionEvent e){
		
		PopDialog p = new PopDialog(this,true);
		String[] radios = {"radio1","radio2","radio3"};
		p.setRadio(radios);
		String[] textfields = {"name","city","zip"};
		p.setTextfield(textfields);
		p.showWindow();
		System.out.println(p.getData());
	
	}
	
	
	public static void main(String[] args) {
		MainFrame frame = new MyTestFrame("default","add row","remove first row","change header","update 1st row");
		frame.setVisible(true);
	}
	
	
}
