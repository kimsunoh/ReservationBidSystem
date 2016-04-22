package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
	public JPanel GraphPn;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startDateCalBtn = new JButton("cal");
		startDateCalBtn.setBounds(91, 328, 56, 23);
		contentPane.add(startDateCalBtn);
		
		startDateTf = new JTextField();
		startDateTf.setBounds(4, 329, 85, 21);
		contentPane.add(startDateTf);
		startDateTf.setColumns(10);
		
		bidListViewBtn = new JButton("보기");
		bidListViewBtn.setMargin(new Insets(2, 5, 2, 5));
		bidListViewBtn.setBounds(308, 328, 56, 23);
		contentPane.add(bidListViewBtn);
		
		endDateTf = new JTextField();
		endDateTf.setColumns(10);
		endDateTf.setBounds(162, 329, 85, 21);
		contentPane.add(endDateTf);
		
		endDateCalBtn = new JButton("cal");
		endDateCalBtn.setBounds(249, 328, 56, 23);
		contentPane.add(endDateCalBtn);
		
		JLabel empty = new JLabel("~");
		empty.setHorizontalAlignment(SwingConstants.CENTER);
		empty.setBounds(142, 332, 25, 15);
		contentPane.add(empty);
		
		sixMonthBtn = new JButton("6개월");
		sixMonthBtn.setBounds(4, 361, 114, 31);
		contentPane.add(sixMonthBtn);
		
		threeMonthBtn = new JButton("3개월");
		threeMonthBtn.setBounds(126, 361, 114, 31);
		contentPane.add(threeMonthBtn);
		
		oneMonthBtn = new JButton("1개월");
		oneMonthBtn.setBounds(250, 361, 114, 31);
		contentPane.add(oneMonthBtn);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 396, 362, 250);
		contentPane.add(scrollPane);
		
		String colName[] = {"상호명", "예약시간", "가격"};
		Object rowData[][] = {
			{ "꼬꼬치킨", "2016.4.15 7:00", 10000},
			{ "치닭치닭", "2016.4.12 8:00", 20000},
			{ "달아달아밝은닭아", "2016.4.15 6:00", 30000} };
		
		
		endBidTable = new JTable(rowData, colName);
		scrollPane.setViewportView(endBidTable);
		
		GraphPn = new JPanel();
		GraphPn.setBounds(4, 10, 362, 308);
		contentPane.add(GraphPn);
	}
}
