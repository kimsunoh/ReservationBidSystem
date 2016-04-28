package com.kitri4.GGY.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri4.GGY.Main.Login;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class BSMain extends JFrame {

	public JPanel contentPane;
	public JButton bidListBtn;
	public JButton storeMenuBtn;
	public JButton InfoBtn;
	public JButton logoutBtn;
	private JLabel lblNewLabel;

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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(5, 10, 374, 108);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/kitri4/GGY/Img/a.png")));
		lblNewLabel.setBounds(107, 10, 170, 88);
		panel_6.add(lblNewLabel);
		
		bidListBtn = new JButton("내역");
		bidListBtn.setBounds(55, 155, 270, 70);
		getContentPane().add(bidListBtn);
		
		storeMenuBtn = new JButton("메뉴");
		storeMenuBtn.setBounds(55, 255, 270, 70);
		getContentPane().add(storeMenuBtn);
		
		InfoBtn = new JButton("내 정보");
		InfoBtn.setBounds(55, 355, 270, 70);
		getContentPane().add(InfoBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(55, 455, 270, 70);
		contentPane.add(logoutBtn);
		
	}

}
