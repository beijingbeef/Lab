package com.asd.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class PopDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4498653702063530648L;

	private final JPanel contentPanel = new JPanel();

	private int height = 20;
	private int radioWidth = 100;
	private int lableWidth = 100;
	private int textfiledWidth = 200;
	private ButtonGroup group = null;
	

	private String[] radios = {};

	private String[] textfields = {};
	
	private Map<String,TextField> mapTextfields = null;
	private Map<String,String> data = null;

	public PopDialog(Frame owner, boolean modal) {
		super(owner, modal);
	}

	/**
	 * Create the dialog.
	 */
	public PopDialog() {

	}

	public void showWindow() {

		mapTextfields = new HashMap<String,TextField>();
		// radio
		Dimension radioPreferredSize = new Dimension();
		radioPreferredSize.setSize(radioWidth, height);

		// lable
		Dimension lablePreferredSize = new Dimension();
		lablePreferredSize.setSize(lableWidth, height);

		// textfield
		Dimension textfieldPreferredSize = new Dimension();
		textfieldPreferredSize.setSize(textfiledWidth, height);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		int fwHeight = (radios.length + textfields.length) * (height + 5) + 65 ;
		fwHeight = 0 == radios.length ?  fwHeight + 10 : fwHeight;
		
		setBounds(100, 100, 330, fwHeight);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanel);

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		group = new ButtonGroup();

		for(int i = 0; i < radios.length; i++){
			JRadioButton rdbtnNewRadioButton = new JRadioButton(radios[i]);
			rdbtnNewRadioButton.setPreferredSize(radioPreferredSize);
			panel.add(rdbtnNewRadioButton);
			group.add(rdbtnNewRadioButton);
		}
			
		

		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		for(int i = 0; i < textfields.length; i++){
				
			Label label = new Label(textfields[i]);
			label.setPreferredSize(lablePreferredSize);
			panel_1.add(label);
				
				
			TextField textField = new TextField();
			textField.setPreferredSize(textfieldPreferredSize);
			panel_1.add(textField);
				
			mapTextfields.put(textfields[i], textField);
		}

		JPanel panel_4 = new JPanel();
		contentPanel.add(panel_4, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_okButton_actionPerformed(e);
			}
		});
		panel_4.add(okButton);

		JButton cancleButton = new JButton("cancle");
		cancleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_cancleButton_actionPerformed(e);
			}
		});
		panel_4.add(cancleButton);
		
		this.setVisible(true);

	}

	public void setRadio(String[] radios) {
		this.radios = radios;
	}

	public void setTextfield(String[] textfields) {
		this.textfields = textfields;
	}

	public Map<String, String> getData() {
		return data;
	}

	protected void do_okButton_actionPerformed(ActionEvent e) {
		
		data = new HashMap<String,String>();
		
		Set<String> keys = mapTextfields.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = mapTextfields.get(key).getText();
			data.put(key, value);
			
		}
		
		Enumeration<AbstractButton> r = group.getElements();
		while(r.hasMoreElements()){
			JRadioButton jrb = (JRadioButton) r.nextElement();
			if(jrb.isSelected()){
				data.put("radio", jrb.getText());
			}
		}
		
		this.dispose();
	}

	protected void do_cancleButton_actionPerformed(ActionEvent e) {
		data = null;
		this.dispose();
	}

}
