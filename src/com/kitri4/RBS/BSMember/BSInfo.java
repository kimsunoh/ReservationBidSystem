package com.kitri4.RBS.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class BSInfo extends JFrame {

	public JPanel contentPane;
	public JButton bidListBtn;
	public JButton storeMenuBtn;
	public JButton infoBtn;
	//
	public JButton renameBtn;
	public JButton secessionBtn;
	
	public JTextField pwTf;
	public JTextField pwCheckTf;
	public JTextField idTf;
	public JTextField phoneNumTf;
	public JTextField busseNumTf;
	public JTextField storeName;
	public JTabbedPane tabbedPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSInfo frame = new BSInfo();
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
	public BSInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelMain = new JPanel();
		tabbedPane.addTab("=", null, panelMain, null);
		panelMain.setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panelMain.add(panel_1);
		
		bidListBtn = new JButton("내역");
		panelMain.add(bidListBtn);
		
		storeMenuBtn = new JButton("메뉴");
		panelMain.add(storeMenuBtn);
		
		infoBtn = new JButton("내 정보");
		panelMain.add(infoBtn);
		

		JPanel panel = new JPanel();
		tabbedPane.add(panel, BorderLayout.CENTER);
		tabbedPane.setTitleAt(1, "내 정보");
		panel.setLayout(new GridLayout(7, 1, 10, 10));
		
		JPanel panel_0 = new JPanel();
		panel.add(panel_0);
		panel_0.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(new Rectangle(0, 0, 100, 0));
		panel_0.add(lblNewLabel, BorderLayout.NORTH);
		
		idTf = new JTextField();
		panel_0.add(idTf, BorderLayout.CENTER);
		idTf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		pwTf = new JTextField();
		panel_2.add(pwTf, BorderLayout.CENTER);
		pwTf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 (\uD655\uC778)");
		panel_3.add(lblNewLabel_2, BorderLayout.NORTH);
		
		pwCheckTf = new JTextField();
		panel_3.add(pwCheckTf, BorderLayout.CENTER);
		pwCheckTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\uAC00\uAC8C \uC804\uD654\uBC88\uD638");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		phoneNumTf = new JTextField();
		panel_4.add(phoneNumTf, BorderLayout.CENTER);
		phoneNumTf.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("\uC0AC\uC5C5\uC790\uBC88\uD638");
		panel_6.add(lblNewLabel_5, BorderLayout.NORTH);
		
		busseNumTf = new JTextField();
		panel_6.add(busseNumTf, BorderLayout.CENTER);
		busseNumTf.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("\uC0C1\uD638\uBA85");
		panel_7.add(lblNewLabel_6, BorderLayout.NORTH);
		
		storeName = new JTextField();
		panel_7.add(storeName, BorderLayout.CENTER);
		storeName.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 5, 5));
		
		renameBtn = new JButton("수정");
		panel_8.add(renameBtn);
		
		secessionBtn = new JButton("탈퇴");
		panel_8.add(secessionBtn);
	}

}
