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

	public JPanel contentPane;
	public JTextArea needsomeTA;
	public JButton bidResitBtn;
	public JComboBox peoplNumComb;
	public JComboBox foodCategoComd;
	public JComboBox locationComb;
	public JComboBox dongComb;
	public JTextField priceTf;
	public JTabbedPane tabbedPane;
	public JPanel selPn;
	
	//
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("=", null, panel_1, null);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		bidListBtn = new JButton("내역");
		panel_1.add(bidListBtn);
		
		addBidBtn = new JButton("등록");
		panel_1.add(addBidBtn);
		
		memInfoBtn = new JButton("내정보");
		panel_1.add(memInfoBtn);
		
		selPn = new JPanel();
		tabbedPane.addTab("등록", null, selPn, null);
		selPn.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_2 = new JPanel();
		selPn.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 1, 10, 10));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("인원 : ");
		panel_5.add(lblNewLabel_1, BorderLayout.NORTH);
		
		peoplNumComb = new JComboBox();
		panel_5.add(peoplNumComb, BorderLayout.CENTER);
		peoplNumComb.addItem("1~4인");
		peoplNumComb.addItem("4~8인");
		peoplNumComb.addItem("8~12인");
		peoplNumComb.addItem("12~16인");
		peoplNumComb.addItem("17인 이상");
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("카테고리 :");
		panel_7.add(lblNewLabel_2, BorderLayout.NORTH);
		//
		foodCategoComd = new JComboBox();
		panel_7.add(foodCategoComd, BorderLayout.CENTER);
		foodCategoComd.addItem("한식");
		foodCategoComd.addItem("중식");
		foodCategoComd.addItem("양식");
		foodCategoComd.addItem("일식");
		foodCategoComd.addItem("아무거나");
		
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
		locationComb.addItem("서울시");
		locationComb.addItem("인천시");
		locationComb.addItem("안양시");
		locationComb.addItem("수원시");
		
		dongComb = new JComboBox();
		panel_9.add(dongComb);
		dongComb.addItem("구로구");
		dongComb.addItem("강남구");
		dongComb.addItem("중구");
		dongComb.addItem("서구");
		dongComb.addItem("동안구");
		dongComb.addItem("권선구");
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("희망가격 (단위:만원) :");
		panel_3.add(lblNewLabel_4, BorderLayout.NORTH);
		
		priceTf = new JTextField();
		panel_3.add(priceTf, BorderLayout.CENTER);
		priceTf.setColumns(10);
		
		JPanel panel = new JPanel();
		selPn.add(panel);
		panel.setLayout(new BorderLayout(10, 10));
		
		bidResitBtn = new JButton("등록");
		panel.add(bidResitBtn, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("비고 (고려사항) :");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		needsomeTA = new JTextArea();
		panel.add(needsomeTA, BorderLayout.CENTER);
		
	}

}
