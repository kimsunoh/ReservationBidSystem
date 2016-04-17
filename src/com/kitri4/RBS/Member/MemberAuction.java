package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MemberAuction extends JFrame {

	private JPanel contentPane;
	private JTable ingBidTable;
	private JButton bidListBtn;
	private JButton addBidBtn;
	private JButton memInfoBtn;
	private JComboBox bidCombox;
	private JButton bidViewBtn;
	private JTable endBidTable;
	private JButton btnListNewButton;
	private JButton sixMonthBtn;
	private JButton threeMonthBtn;
	private JButton oneMonthBtn;
	private JTextField startDateTf;
	private JTextField endDateTf;
	private JButton startDateCalBtn;
	private JButton endDateCalBtn;
	private JPanel GraphPn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAuction frame = new MemberAuction();
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
	public MemberAuction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_186275914895161");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("=", null, panel_1, null);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		bidListBtn = new JButton("입찰");
		panel_1.add(bidListBtn);
		
		addBidBtn = new JButton("등록");
		panel_1.add(addBidBtn);
		
		memInfoBtn = new JButton("내 정보");
		panel_1.add(memInfoBtn);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("진행중내역", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_4.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		bidCombox = new JComboBox();
		panel.add(bidCombox, BorderLayout.CENTER);
		
		bidViewBtn = new JButton("보기");
		panel.add(bidViewBtn, BorderLayout.EAST);
		
		ingBidTable = new JTable();
		panel_4.add(ingBidTable, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("지난내역", null, panel_2, null);
		panel_2.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		btnListNewButton = new JButton("조회");
		panel_8.add(btnListNewButton, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(1, 5, 5, 5));
		
		startDateTf = new JTextField();
		panel_9.add(startDateTf);
		startDateTf.setColumns(10);
		
		startDateCalBtn = new JButton("cal");
		panel_9.add(startDateCalBtn);
		
		JLabel lblNewLabel = new JLabel("~");
		panel_9.add(lblNewLabel);
		
		endDateTf = new JTextField();
		panel_9.add(endDateTf);
		endDateTf.setColumns(10);
		
		endDateCalBtn = new JButton("cal");
		panel_9.add(endDateCalBtn);
		
		GraphPn = new JPanel();
		panel_3.add(GraphPn, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new GridLayout(1, 3, 10, 10));
		
		sixMonthBtn = new JButton("6개월");
		panel_7.add(sixMonthBtn);
		
		threeMonthBtn = new JButton("3개월");
		panel_7.add(threeMonthBtn);
		
		oneMonthBtn = new JButton("1개월");
		panel_7.add(oneMonthBtn);
		
		endBidTable = new JTable();
		panel_5.add(endBidTable, BorderLayout.CENTER);
	}
}
