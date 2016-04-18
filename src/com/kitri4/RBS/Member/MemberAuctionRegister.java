package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MemberAuctionRegister extends JFrame {

	JPanel contentPane;
	JTextArea needsomeTA;
	JButton bidResitBtn;
	JComboBox peoplNumComb;
	JComboBox foodCategoComd;
	JComboBox locationComb;
	JComboBox dongComb;
	JTextField priceTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAuctionRegister frame = new MemberAuctionRegister();
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
	public MemberAuctionRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("=", null, panel_1, null);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JButton bidListBtn = new JButton("내역");
		panel_1.add(bidListBtn);
		
		JButton addBidBtn = new JButton("등록");
		panel_1.add(addBidBtn);
		
		JButton memInfoBtn = new JButton("내정보");
		panel_1.add(memInfoBtn);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("등록", null, panel_4, null);
		panel_4.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 1, 10, 10));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("인원 : ");
		panel_5.add(lblNewLabel_1, BorderLayout.NORTH);
		
		peoplNumComb = new JComboBox();
		panel_5.add(peoplNumComb, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("카테고리 :");
		panel_7.add(lblNewLabel_2, BorderLayout.NORTH);
		
		foodCategoComd = new JComboBox();
		panel_7.add(foodCategoComd, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("지역 : ");
		panel_8.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(1, 2, 10, 10));
		
		locationComb = new JComboBox();
		panel_9.add(locationComb);
		
		dongComb = new JComboBox();
		panel_9.add(dongComb);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("최대가격 (단위:만원) :");
		panel_3.add(lblNewLabel_4, BorderLayout.NORTH);
		
		priceTf = new JTextField();
		panel_3.add(priceTf, BorderLayout.CENTER);
		priceTf.setColumns(10);
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setLayout(new BorderLayout(10, 10));
		
		bidResitBtn = new JButton("등록");
		panel.add(bidResitBtn, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("비고 (고려사항) :");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		needsomeTA = new JTextArea();
		panel.add(needsomeTA, BorderLayout.CENTER);
		
	}

}
