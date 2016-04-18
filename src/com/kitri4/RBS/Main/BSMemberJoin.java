package com.kitri4.RBS.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class BSMemberJoin extends JFrame {

	JPanel contentPane;
	JTextField idTf;
	JTextField pwTf;
	JTextField phoneNumTf;
	JTextField pwCheckTf;
	JTextField emailTF;
	JTextField busseNumTf;
	JTextField storeName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSMemberJoin frame = new BSMemberJoin();
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
	public BSMemberJoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		
		JButton bsJoinBtn = new JButton("업주회원가입");
		contentPane.add(bsJoinBtn, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(new Rectangle(0, 0, 100, 0));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		idTf = new JTextField();
		panel_1.add(idTf, BorderLayout.CENTER);
		idTf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		pwTf = new JTextField();
		panel_2.add(pwTf, BorderLayout.CENTER);
		pwTf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD (check) : ");
		panel_3.add(lblNewLabel_2, BorderLayout.NORTH);
		
		pwCheckTf = new JTextField();
		panel_3.add(pwCheckTf, BorderLayout.CENTER);
		pwCheckTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("PHONE (123-4567-7890)");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		phoneNumTf = new JTextField();
		panel_4.add(phoneNumTf, BorderLayout.CENTER);
		phoneNumTf.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("EMAIL : ");
		panel_5.add(lblNewLabel_4, BorderLayout.NORTH);
		
		emailTF = new JTextField();
		panel_5.add(emailTF, BorderLayout.CENTER);
		emailTF.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("사업자번호 :");
		panel_6.add(lblNewLabel_5, BorderLayout.NORTH);
		
		busseNumTf = new JTextField();
		panel_6.add(busseNumTf, BorderLayout.CENTER);
		busseNumTf.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("상호명 : ");
		panel_7.add(lblNewLabel_6, BorderLayout.NORTH);
		
		storeName = new JTextField();
		panel_7.add(storeName, BorderLayout.CENTER);
		storeName.setColumns(10);
	}

}
