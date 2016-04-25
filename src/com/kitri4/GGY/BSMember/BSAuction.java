package com.kitri4.GGY.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.kitri4.GGY.BSMember.BSAuctionLogic.*;

import com.kitri4.GGY.Common.CalendarView;

import java.awt.Insets;

public class BSAuction extends JFrame {
	
//	ButtonRenderer2 br2;
//	ButtonEditor2 be2;

	public JPanel contentPane;
	public JButton homebutton;
	public JTextField ingStartDateTf;
	public JTable ingAuctionTable;
	public JTextField ingEndDateTf;
	public JComboBox locationComb;
	public JComboBox gooComb;
	public JButton ingStartDateBtn;
	public JButton ingEndDateBtn;
	public JButton ingViewBtn;
	public CalendarView cv;
	
	public BSAuctionHistory bsAuctionHistory = new BSAuctionHistory();
	
	public String ColName[] = {"예약자명", "예약시간", "인원", "가격","입찰"};


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
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 662);
		contentPane.add(tabbedPane);
		
		JPanel bsAuction = new JPanel();
		tabbedPane.addTab("경매 목록", null, bsAuction, null);
		bsAuction.setLayout(null);
		
		locationComb = new JComboBox();
		locationComb.setBounds(12, 10, 167, 29);
		bsAuction.add(locationComb);
		
		gooComb = new JComboBox();
		gooComb.setBounds(200, 10, 167, 29);
		bsAuction.add(gooComb);
		
		ingStartDateTf = new JTextField();
		ingStartDateTf.setBounds(12, 49, 89, 29);
		bsAuction.add(ingStartDateTf);
		ingStartDateTf.setColumns(10);
		
		ingStartDateBtn = new JButton("Cal");
		ingStartDateBtn.setMargin(new Insets(2, 5, 2, 5));
		ingStartDateBtn.setBounds(105, 49, 42, 29);
		bsAuction.add(ingStartDateBtn);
		
		ingViewBtn = new JButton("조회");
		ingViewBtn.setBounds(302, 49, 65, 29);
		bsAuction.add(ingViewBtn);
		
		JLabel lblNewLabel = new JLabel("~");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 56, 19, 15);
		bsAuction.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 88, 355, 513);
		bsAuction.add(scrollPane);
		
		ingAuctionTable = new JTable();
		
		DefaultTableModel model2 = new DefaultTableModel(ColName, 23);
		ingAuctionTable = new JTable(model2);
		ingAuctionTable.setRowHeight(40);
		ingAuctionTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer2());
		ingAuctionTable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor2(new JComboBox()));
		scrollPane.setViewportView(ingAuctionTable);
		
		ingEndDateTf = new JTextField();
		ingEndDateTf.setColumns(10);
		ingEndDateTf.setBounds(164, 49, 89, 29);
		bsAuction.add(ingEndDateTf);
		
		ingEndDateBtn = new JButton("Cal");
		ingEndDateBtn.setMargin(new Insets(2, 5, 2, 5));
		ingEndDateBtn.setBounds(257, 49, 42, 29);
		bsAuction.add(ingEndDateBtn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("낙찰 내역", null, bsAuctionHistory, null);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}
}
