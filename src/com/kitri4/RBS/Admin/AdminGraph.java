package com.kitri4.RBS.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminGraph extends JFrame {

	private JPanel contentPane;
	private JPanel graphPn;
	private JTextField startDateTf;
	private JButton startDateBtn;
	private JTextField endDateTf;
	private JButton endDateBtn;
	private JButton bidListViewBtn;
	private JButton sixMonthBtn;
	private JButton threeMonthBtn;
	private JButton oneMonthBtn;
	private JTextField auctionCountTf;
	private JTextField bidCountTf;
	private JTextField finalBidCountTf;
	private JButton userAdjBtn;
	private JButton auctionAdjBtn;
	private JTable newBsListTable;
	private JTextField newUserCountTf;
	private JTextField newBSCountTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGraph frame = new AdminGraph();
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
	public AdminGraph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("=", null, panel_5, null);
		panel_5.setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1);
		
		auctionAdjBtn = new JButton("경매관리");
		panel_5.add(auctionAdjBtn);
		
		userAdjBtn = new JButton("회원관리");
		panel_5.add(userAdjBtn);
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("경매관리", null, panel_3, null);
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
		
		startDateTf = new JTextField();
		panel_16.add(startDateTf);
		startDateTf.setColumns(10);
		
		startDateBtn = new JButton("cal");
		panel_16.add(startDateBtn);
		
		JLabel lblNewLabel = new JLabel("~");
		panel_14.add(lblNewLabel, BorderLayout.EAST);
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		endDateTf = new JTextField();
		panel_15.add(endDateTf);
		endDateTf.setColumns(10);
		
		endDateBtn = new JButton("cal");
		panel_15.add(endDateBtn);
		
		bidListViewBtn = new JButton("조회");
		panel_15.add(bidListViewBtn);
		
		
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
		
		JPanel panel = new JPanel();
		panel_12.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("등록횟수 :");
		panel_18.add(lblNewLabel_1, BorderLayout.WEST);
		
		auctionCountTf = new JTextField();
		panel_18.add(auctionCountTf, BorderLayout.CENTER);
		auctionCountTf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("입찰횟수 :");
		panel_2.add(lblNewLabel_2, BorderLayout.WEST);
		
		bidCountTf = new JTextField();
		panel_2.add(bidCountTf, BorderLayout.CENTER);
		bidCountTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("낙찰횟수 :");
		panel_4.add(lblNewLabel_3, BorderLayout.WEST);
		
		finalBidCountTf = new JTextField();
		panel_4.add(finalBidCountTf, BorderLayout.CENTER);
		finalBidCountTf.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("신규회원수 : ");
		panel_8.add(lblNewLabel_4, BorderLayout.WEST);
		
		newUserCountTf = new JTextField();
		panel_8.add(newUserCountTf, BorderLayout.CENTER);
		newUserCountTf.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("업주등록요청수");
		panel_9.add(lblNewLabel_5, BorderLayout.WEST);
		
		newBSCountTf = new JTextField();
		panel_9.add(newBSCountTf, BorderLayout.CENTER);
		newBSCountTf.setColumns(10);
		
		newBsListTable = new JTable();
		panel_6.add(newBsListTable, BorderLayout.CENTER);
	}

}
