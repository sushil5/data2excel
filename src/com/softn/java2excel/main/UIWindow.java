package com.softn.java2excel.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UIWindow implements ActionListener {
	JMenuBar mb;    
	JMenu file,edit,help; 
	JMenuItem cut,copy,paste,resets;    
	
	JTextField t1 = null;
	JTextField t2 = null;
	JTextField t3 = null;
	JTextField t4 = null;
	JTextField t5 = null;
	JTextField t6 = null;
	JTextField t7 = null;
	JLabel l1 = null;
	JLabel l2 = null;
	JLabel l3 = null;
	JLabel l4 = null;
	JLabel l5 = null;
	JLabel l6 = null;
	JLabel l7 = null;
	static int index=1;
	UserInfo uinfo=new UserInfo();
	String buttonName=null;

	UIWindow() {
		JFrame f = new JFrame("Java2Excel");

		cut=new JMenuItem("cut");    
		copy=new JMenuItem("copy");    
		paste=new JMenuItem("paste");    
		resets=new JMenuItem("reset");    
		cut.addActionListener(this);    
		copy.addActionListener(this);    
		paste.addActionListener(this);    
		resets.addActionListener(this);    
		mb=new JMenuBar();    
		file=new JMenu("File");    
		edit=new JMenu("Edit");    
		help=new JMenu("Help");     
		edit.add(cut);edit.add(copy);edit.add(paste);edit.add(resets);    
		mb.add(file);mb.add(edit);mb.add(help);    
		    
		f.setJMenuBar(mb);  

		l1 = new JLabel("BANK NAME");
		t1 = new JTextField();

		l2 = new JLabel("LOAN TYPE");
		t2 = new JTextField();

		l3 = new JLabel("FILE NO ");
		t3 = new JTextField();

		l4 = new JLabel("SURVEYOR NAME");
		t4 = new JTextField();

		l5 = new JLabel("APPLICANT'S NAME");
		t5 = new JTextField();

		l6 = new JLabel("TYPE OF LOCALITY");
		t6 = new JTextField();

		l7 = new JLabel("ADDR OF PROPERTY");
		t7 = new JTextField();

		JButton save = new JButton("Save");
		JButton reset = new JButton("Reset");
		JButton add = new JButton("Add");

		l1.setBounds(50, 100, 95, 30);
		t1.setBounds(200, 100, 200, 30);

		l2.setBounds(50, 150, 95, 30);
		t2.setBounds(200, 150, 200, 30);

		l3.setBounds(50, 200, 95, 30);
		t3.setBounds(200, 200, 200, 30);

		l4.setBounds(50, 250, 150, 30);
		t4.setBounds(200, 250, 200, 30);

		l5.setBounds(50, 300, 150, 30);
		t5.setBounds(200, 300, 200, 30);

		l6.setBounds(50, 350, 150, 30);
		t6.setBounds(200, 350, 200, 30);

		l7.setBounds(50, 400, 150, 30);
		t7.setBounds(200, 400, 200, 30);

		add.setBounds(100, 480, 80, 30);
		save.setBounds(200, 480, 80, 30);
		reset.setBounds(300, 480, 80, 30);
		
		add.addActionListener(this);
		save.addActionListener(this);
		reset.addActionListener(this);
		
		f.add(l1);
		f.add(t1);

		f.add(l2);
		f.add(t2);

		f.add(l3);
		f.add(t3);

		f.add(l4);
		f.add(t4);

		f.add(l5);
		f.add(t5);

		f.add(l6);
		f.add(t6);

		f.add(l7);
		f.add(t7);
		f.add(add);
		f.add(save);
		f.add(reset);

		f.setSize(500, 600);
		f.setLayout(null);
		f.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
      buttonName=e.getActionCommand();
      
      if(e.getSource()==resets) {
    	  t1.setText("");
    		t2.setText("");
    		t3.setText("");
    		t4.setText("");
    		t5.setText("");
    		t6.setText("");
    		t7.setText("");
      }
if(buttonName.equals("Add")) {
    uinfo.add();
	
}
else if(buttonName.equals("Save")) {

	try {
		uinfo.save();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
}
else {
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	t7.setText("");

}
		
	}

}
