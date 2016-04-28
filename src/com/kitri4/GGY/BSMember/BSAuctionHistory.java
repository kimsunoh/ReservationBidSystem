package com.kitri4.GGY.BSMember;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;


public class BSAuctionHistory extends JPanel {

	public ChartPanel graphPn;//
	public JTextField endStartDateTf;
	public JTextField endEndDateTf;
	public JTable endBidTable;
	public JButton sixMonthBtn;
	public JButton threeMonthBtn;
	public JButton oneMonthBtn;
	public JButton endStartDateBtn;
	public JButton endEndDateBtn;
	public JButton bidListViewBtn;

	public static DefaultTableModel model;
	String str[] = new String[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSAuctionHistory frame = new BSAuctionHistory();
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
	public BSAuctionHistory() {
		setBounds(100, 100, 400, 700);
		setLayout(null);

		endStartDateTf = new JTextField();
		endStartDateTf.setBounds(12, 243, 94, 33);
		add(endStartDateTf);
		endStartDateTf.setColumns(10);

		endStartDateBtn = new JButton("cal");
		endStartDateBtn.setMargin(new Insets(2, 5, 2, 5));
		endStartDateBtn.setBounds(108, 243, 49, 33);
		add(endStartDateBtn);

		endEndDateBtn = new JButton("cal");
		endEndDateBtn.setMargin(new Insets(2, 5, 2, 5));
		endEndDateBtn.setBounds(265, 243, 49, 33);
		add(endEndDateBtn);

		endEndDateTf = new JTextField();
		endEndDateTf.setColumns(10);
		endEndDateTf.setBounds(169, 243, 94, 33);
		add(endEndDateTf);

		JLabel empty = new JLabel("~");
		empty.setHorizontalAlignment(SwingConstants.CENTER);
		empty.setBounds(158, 252, 9, 15);
		add(empty);

		bidListViewBtn = new JButton("보기");
		bidListViewBtn.setMargin(new Insets(2, 5, 2, 5));
		bidListViewBtn.setBounds(318, 243, 49, 33);
		add(bidListViewBtn);

		sixMonthBtn = new JButton("6개월");
		sixMonthBtn.setBounds(12, 286, 116, 33);
		add(sixMonthBtn);

		threeMonthBtn = new JButton("3개월");
		threeMonthBtn.setBounds(132, 286, 116, 33);
		add(threeMonthBtn);

		oneMonthBtn = new JButton("1개월");
		oneMonthBtn.setBounds(251, 286, 116, 33);
		add(oneMonthBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 329, 355, 275);
		add(scrollPane);

		String header[] = { "예약자명", "예약날짜", "가격" };//
		String contents[][] = {};
		model = new DefaultTableModel(contents, header);

		endBidTable = new JTable(model);
		scrollPane.setViewportView(endBidTable);
		
	}

}
