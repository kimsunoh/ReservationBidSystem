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

public class MemberInfo extends JFrame {

	JPanel contentPane;
	JTextField pwTf;
	JTextField pwCheckTf;
	JTextField phoneNumTf;
	JTextField emailTF;
	JTextField idTf;

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
		contentPane.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(new Rectangle(0, 0, 100, 0));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		idTf = new JTextField();
		panel_1.add(idTf, BorderLayout.CENTER);
		idTf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		pwTf = new JTextField();
		panel_2.add(pwTf, BorderLayout.CENTER);
		pwTf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD (check) : ");
		panel_3.add(lblNewLabel_2, BorderLayout.NORTH);
		
		pwCheckTf = new JTextField();
		panel_3.add(pwCheckTf, BorderLayout.CENTER);
		pwCheckTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("PHONE (123-4567-7890)");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		phoneNumTf = new JTextField();
		panel_4.add(phoneNumTf, BorderLayout.CENTER);
		phoneNumTf.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("EMAIL : ");
		panel_5.add(lblNewLabel_4, BorderLayout.NORTH);
		
		emailTF = new JTextField();
		panel_5.add(emailTF, BorderLayout.CENTER);
		emailTF.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		

		JButton renameBtn = new JButton("¼öÁ¤");
		panel.add(renameBtn);
		
		JButton sesesionBtn = new JButton("Å»Åð");
		panel.add(sesesionBtn);
	}

}
