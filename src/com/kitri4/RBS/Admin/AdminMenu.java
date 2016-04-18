package com.kitri4.RBS.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class AdminMenu extends JFrame {

	JPanel contentPane;
	JButton userManagBtn;
	JButton auctionManagBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 10, 10));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		userManagBtn = new JButton("내역통계");
		contentPane.add(userManagBtn);
		
		auctionManagBtn = new JButton("회원관리");
		contentPane.add(auctionManagBtn);
	}

}
