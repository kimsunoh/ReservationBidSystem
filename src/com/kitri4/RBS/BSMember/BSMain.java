package com.kitri4.RBS.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BSMain extends JFrame {

	public JPanel contentPane;
	public JButton bidListBtn;
	public JButton storeMenuBtn;
	public JButton InfoBtn;
	public JButton logoutBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSMain frame = new BSMain();
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
	public BSMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		
		bidListBtn = new JButton("내역");
		getContentPane().add(bidListBtn);
		
		storeMenuBtn = new JButton("메뉴");
		getContentPane().add(storeMenuBtn);
		
		InfoBtn = new JButton("내 정보");
		getContentPane().add(InfoBtn);
		
		logoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		contentPane.add(logoutBtn, BorderLayout.NORTH);
		
	}

}
