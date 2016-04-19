package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MemberMain extends JFrame {

	JPanel contentPane;
	public JButton bidListBtn;
	public JButton addBidBtn;
	public JButton memInfoBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		getContentPane().setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		
		bidListBtn = new JButton("내역");
		getContentPane().add(bidListBtn);
		
		addBidBtn = new JButton("등록");
		getContentPane().add(addBidBtn);
		
		memInfoBtn = new JButton("내 정보");
		getContentPane().add(memInfoBtn);
		
	}

}
