package com.kitri4.GGY.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Color;

public class MemberAuctionHistory extends JFrame {

	public JPanel contentPane;
	public JTextField startDateTf;
	public JTextField endDateTf;
	public JTable endBidTable;
	public JButton sixMonthBtn;
	public JButton threeMonthBtn;
	public JButton oneMonthBtn;
	public JButton startDateCalBtn;
	public JButton endDateCalBtn;
	public JButton bidListViewBtn;
	public JPanel graphPn;

	public DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAuctionHistory frame = new MemberAuctionHistory();
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
	public MemberAuctionHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startDateCalBtn = new JButton("cal");
		startDateCalBtn.setBounds(93, 233, 56, 23);
		contentPane.add(startDateCalBtn);
		
		startDateTf = new JTextField();
		startDateTf.setBounds(4, 234, 85, 21);
		contentPane.add(startDateTf);
		startDateTf.setColumns(10);
		
		bidListViewBtn = new JButton("보기");
		bidListViewBtn.setBounds(316, 233, 56, 23);
		bidListViewBtn.setMargin(new Insets(2, 5, 2, 5));
		contentPane.add(bidListViewBtn);
		
		endDateTf = new JTextField();
		endDateTf.setBounds(169, 234, 85, 21);
		endDateTf.setColumns(10);
		contentPane.add(endDateTf);
		
		endDateCalBtn = new JButton("cal");
		endDateCalBtn.setBounds(257, 233, 56, 23);
		contentPane.add(endDateCalBtn);
		
		JLabel empty = new JLabel("~");
		empty.setBounds(144, 237, 25, 15);
		empty.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(empty);
		
		sixMonthBtn = new JButton("6개월");
		sixMonthBtn.setBounds(4, 266, 114, 31);
		contentPane.add(sixMonthBtn);
		
		threeMonthBtn = new JButton("3개월");
		threeMonthBtn.setBounds(132, 266, 114, 31);
		contentPane.add(threeMonthBtn);
		
		oneMonthBtn = new JButton("1개월");
		oneMonthBtn.setBounds(258, 266, 114, 31);
		contentPane.add(oneMonthBtn);

		
		String header[] = {"상호명", "예약시간", "가격"};
		String contents[][] = {};
		model = new DefaultTableModel(contents, header);
		
		endBidTable = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(endBidTable);
		scrollPane.setBounds(4, 307, 368, 339);
		contentPane.add(scrollPane);
		
		graphPn = new JPanel();
		graphPn.setBackground(Color.DARK_GRAY);
		graphPn.setBounds(10, 9, 362, 214);
		contentPane.add(graphPn);
	}
}
