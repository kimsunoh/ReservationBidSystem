package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;

public class MemberInfo extends JFrame {

	public JPanel contentPane;
	public JTextField pwTf;
	public JTextField pwCheckTf;
	public JTextField phoneNumTf;
	public JTextField emailTF;
	public JTextField idTf;
	
	public JTabbedPane tabbedPane;
	public JButton bidListBtn;
	public JButton addBidBtn;
	public JButton memInfoBtn;
	public JPanel myPn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInfo frame = new MemberInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("=", null, panel_6, null);
		panel_6.setLayout(new GridLayout(5, 1, 10, 10));
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_6.add(lblNewLabel_5);
		
		bidListBtn = new JButton("\uB0B4\uC5ED");
		panel_6.add(bidListBtn);
		
		addBidBtn = new JButton("\uB4F1\uB85D");
		panel_6.add(addBidBtn);
		
		memInfoBtn = new JButton("\uB0B4 \uC815\uBCF4");
		panel_6.add(memInfoBtn);
		
		myPn = new JPanel();
		tabbedPane.addTab("\uB0B4 \uC815\uBCF4", null, myPn, null);
		myPn.setLayout(new GridLayout(6, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		myPn.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(new Rectangle(0, 0, 100, 0));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		idTf = new JTextField();
		panel_1.add(idTf);
		idTf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		myPn.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		pwTf = new JTextField();
		panel_2.add(pwTf, BorderLayout.CENTER);
		pwTf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		myPn.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD (check) : ");
		panel_3.add(lblNewLabel_2, BorderLayout.NORTH);
		
		pwCheckTf = new JTextField();
		panel_3.add(pwCheckTf, BorderLayout.CENTER);
		pwCheckTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		myPn.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("PHONE (123-4567-7890)");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		phoneNumTf = new JTextField();
		panel_4.add(phoneNumTf, BorderLayout.CENTER);
		phoneNumTf.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		myPn.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("EMAIL : ");
		panel_5.add(lblNewLabel_4, BorderLayout.NORTH);
		
		emailTF = new JTextField();
		panel_5.add(emailTF, BorderLayout.CENTER);
		emailTF.setColumns(10);
		
		JPanel panel = new JPanel();
		myPn.add(panel);
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		

		JButton renameBtn = new JButton("¼öÁ¤");
		panel.add(renameBtn);
		
		JButton sesesionBtn = new JButton("Å»Åð");
		panel.add(sesesionBtn);
	}

}
