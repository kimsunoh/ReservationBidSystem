package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class MemberInfo extends JPanel {

	public JPanel contentPane;
	public JButton homebutton;
	public JLabel lblNewLabel;
	public JLabel idLabel;
	public JTextField idTf;
	public JLabel pwLabel;
	public JTextField pwTf;
	public JLabel pwcLabel;
	public JTextField pwCheckTf;
	public JLabel phoneLabel;
	public JTextField phoneNumTf;
	public JLabel emailLabel;
	public JTextField emailTF;
	public JButton renameBtn;
	public JButton sesesionBtn;

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
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 662);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("³» Á¤º¸", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("  \uD68C\uC6D0\uAC00\uC785 \uC815\uBCF4");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 379, 41);
		panel.add(lblNewLabel);
		
		idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		idLabel.setBounds(10, 51, 357, 25);
		panel.add(idLabel);
		
		idTf = new JTextField();
		idTf.setBounds(12, 86, 355, 25);
		panel.add(idTf);
		idTf.setColumns(10);
		
		pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pwLabel.setBounds(10, 123, 357, 25);
		panel.add(pwLabel);
		
		pwTf = new JTextField();
		pwTf.setColumns(10);
		pwTf.setBounds(12, 160, 355, 25);
		panel.add(pwTf);
		
		pwcLabel = new JLabel("\uBE44\uBC00\uBC88\uD638(\uD655\uC778)");
		pwcLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwcLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pwcLabel.setBounds(10, 195, 357, 25);
		panel.add(pwcLabel);
		
		pwCheckTf = new JTextField();
		pwCheckTf.setColumns(10);
		pwCheckTf.setBounds(10, 232, 357, 25);
		panel.add(pwCheckTf);
		
		phoneLabel = new JLabel("\uC5F0\uB77D\uCC98(000-0000-000)");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		phoneLabel.setBounds(12, 267, 355, 25);
		panel.add(phoneLabel);
		
		phoneNumTf = new JTextField();
		phoneNumTf.setColumns(10);
		phoneNumTf.setBounds(10, 302, 357, 25);
		panel.add(phoneNumTf);
		
		emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		emailLabel.setBounds(12, 337, 355, 25);
		panel.add(emailLabel);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(10, 372, 357, 25);
		panel.add(emailTF);
		
		renameBtn = new JButton("\uC218\uC815");
		renameBtn.setBounds(12, 555, 161, 41);
		panel.add(renameBtn);
		
		sesesionBtn = new JButton("\uD0C8\uD1F4");
		sesesionBtn.setBounds(206, 555, 161, 41);
		panel.add(sesesionBtn);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}

}
