package com.kitri4.RBS.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class BSAuction extends JFrame {
	
	JPanel contentPane;
	JButton bidListBtn;
	JButton storeMenuBtn;
	JButton infoBtn;

	JComboBox locationComb;
	JComboBox dongComb;
	JTable ingAuctionTable;
	JLabel label;
	JTextField ingStartDateTf;
	JButton ingStartDateBtn;
	JButton ingViewBtn;
	JTextField ingEndDateTf;
	JButton ingEndDateBtn;
	
	JPanel graphPn;
	JTextField endStartDateTf;
	JButton endStartDateBtn;
	JLabel lblNewLabel;
	JTextField endEndDateTf;
	JButton endEndDateBtn;
	JButton endBidListViewBtn;
	JTable endBidTable;
	JButton sixMonthBtn;
	JButton threeMonthBtn;
	JButton oneMonthBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSAuction frame = new BSAuction();
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
	public BSAuction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("=", null, panel, null);
		panel.setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		bidListBtn = new JButton("내역");
		panel.add(bidListBtn);
		
		storeMenuBtn = new JButton("메뉴");
		panel.add(storeMenuBtn);
		
		infoBtn = new JButton("내정보");
		panel.add(infoBtn);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("진행중내역", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		locationComb = new JComboBox();
		panel_5.add(locationComb);
		
		dongComb = new JComboBox();
		panel_5.add(dongComb);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		ingStartDateTf = new JTextField();
		panel_9.add(ingStartDateTf, BorderLayout.CENTER);
		ingStartDateTf.setColumns(10);
		
		ingStartDateBtn = new JButton("cal");
		panel_9.add(ingStartDateBtn, BorderLayout.EAST);
		
		label = new JLabel("~");
		panel_7.add(label, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		ingEndDateTf = new JTextField();
		ingEndDateTf.setEditable(false);
		panel_10.add(ingEndDateTf, BorderLayout.CENTER);
		ingEndDateTf.setColumns(10);
		
		ingEndDateBtn = new JButton("cal");
		panel_10.add(ingEndDateBtn, BorderLayout.EAST);
		
		ingViewBtn = new JButton("조회");
		panel_8.add(ingViewBtn, BorderLayout.EAST);
		
		ingAuctionTable = new JTable();
		panel_2.add(ingAuctionTable, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("지난내역", null, panel_3, null);
		panel_3.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		graphPn = new JPanel();
		panel_11.add(graphPn, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.SOUTH);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16);
		panel_16.setLayout(new GridLayout(0, 2, 0, 0));
		
		endStartDateTf = new JTextField();
		panel_16.add(endStartDateTf);
		endStartDateTf.setColumns(10);
		
		endStartDateBtn = new JButton("cal");
		panel_16.add(endStartDateBtn);
		
		lblNewLabel = new JLabel("~");
		panel_14.add(lblNewLabel, BorderLayout.EAST);
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		endEndDateTf = new JTextField();
		panel_15.add(endEndDateTf);
		endEndDateTf.setColumns(10);
		
		endEndDateBtn = new JButton("cal");
		panel_15.add(endEndDateBtn);
		
		endBidListViewBtn = new JButton("조회");
		panel_15.add(endBidListViewBtn);
		
		
		JPanel panel_12 = new JPanel();
		panel_3.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_12.add(panel_17, BorderLayout.NORTH);
		panel_17.setLayout(new GridLayout(0, 3, 0, 0));
		
		sixMonthBtn = new JButton("6개월");
		panel_17.add(sixMonthBtn);
		
		threeMonthBtn = new JButton("3개월");
		panel_17.add(threeMonthBtn);
		
		oneMonthBtn = new JButton("1개월");
		panel_17.add(oneMonthBtn);
		
		endBidTable = new JTable();
		panel_12.add(endBidTable, BorderLayout.CENTER);
	}

}
