package com.kitri4.GGY.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame {

	public JPanel contentPane;
	public JButton userManagBtn;
	public JButton auctionManagBtn;
	public JButton logoutBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userManagBtn = new JButton("프로그램 통계");
		userManagBtn.setBounds(45, 198, 294, 63);
		contentPane.add(userManagBtn);
		
		auctionManagBtn = new JButton("회원 관리");
		auctionManagBtn.setBounds(45, 288, 294, 63);
		contentPane.add(auctionManagBtn);

		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(45, 374, 294, 63);
		contentPane.add(logoutBtn);
	}
}
