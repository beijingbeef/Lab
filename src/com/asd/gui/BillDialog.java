package com.asd.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class BillDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3571477368073596893L;
	private JPanel contentPane;
	private String message = "";
	
	public BillDialog(Frame owner, boolean modal,String message){
		super(owner, modal);
		this.message = message;
	}
	
	/**
	 * Create the frame.
	 */
	public void showBillDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea(message);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_okButton_actionPerformed(e);
			}
		});
		panel.add(okButton);
		
		this.setVisible(true);
	}

	protected void do_okButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
}
