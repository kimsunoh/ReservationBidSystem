package com.kitri4.RBS.BSMember;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.kitri4.RBS.BSMember.BSAuctionLogic.ButtonEditor2;
import com.kitri4.RBS.BSMember.BSAuctionLogic.ButtonRenderer2;
import com.kitri4.RBS.Common.CalendarView;

public class BSAuction extends JFrame {
	//
	ButtonRenderer2 br2;
	ButtonEditor2 be2;
	CalendarView cv ;
	//
	public JPanel contentPane;
	public JButton bidListBtn;
	public JButton storeMenuBtn;
	public JButton infoBtn;
	public JButton logoutBtn;

	public JComboBox locationComb;
	public JComboBox dongComb;
	public JTable ingAuctionTable;
	public JLabel label;
	public JTextField ingStartDateTf;
	public JButton ingStartDateBtn;
	public JButton ingViewBtn;
	public JTextField ingEndDateTf;
	public JButton ingEndDateBtn;
	
	public JPanel graphPn;
	public JTextField endStartDateTf;
	public JButton endStartDateBtn;
	//
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	//
	public JLabel lblNewLabel;
	public JTextField endEndDateTf;
	public JButton endEndDateBtn;
	public JTable endBidTable;
	public JButton sixMonthBtn;
	public JButton threeMonthBtn;
	public JButton oneMonthBtn;
	
	public JTabbedPane tabbedPane;
	public JButton BidListViewBtn;
	public JPanel panel_18;
	public JPanel tablePn;
	public DefaultTableModel model;
	
	
	//
	JButton button = new JButton();
	private JScrollPane scrollPane;
	private String ColName[] = {"예약자명", "예약시간", "인원", "가격","입찰"};
	public JPanel IngPn;
	public  JPanel panel_2 = new JPanel();
	//
	
	
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
		super("BSAuction");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("=", null, panel, null);
		panel.setLayout(new GridLayout(6, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		bidListBtn = new JButton("내역");
		panel.add(bidListBtn);
		
		storeMenuBtn = new JButton("메뉴");
		panel.add(storeMenuBtn);
		
		infoBtn = new JButton("내정보");
		panel.add(infoBtn);
		
		logoutBtn = new JButton("로그아웃");
		panel.add(logoutBtn);
		
		panel_2 = new JPanel();
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
		panel_13.setLayout(new BorderLayout(0, 0));
		
		BidListViewBtn = new JButton("조회");
		panel_13.add(BidListViewBtn, BorderLayout.EAST);
		
		panel_18 = new JPanel();
		panel_13.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_18.add(panel_14);
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
		panel_18.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		endEndDateTf = new JTextField();
		panel_15.add(endEndDateTf);
		endEndDateTf.setColumns(10);
		
		endEndDateBtn = new JButton("cal");
		panel_15.add(endEndDateBtn);
		
		
		tablePn = new JPanel();
		panel_3.add(tablePn);
		tablePn.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		tablePn.add(panel_17, BorderLayout.NORTH);
		panel_17.setLayout(new GridLayout(0, 3, 0, 0));
		
		sixMonthBtn = new JButton("6개월");
		panel_17.add(sixMonthBtn);
		
		threeMonthBtn = new JButton("3개월");
		panel_17.add(threeMonthBtn);
		
		oneMonthBtn = new JButton("1개월");
		panel_17.add(oneMonthBtn);
		
		String header[] = {"예약자명", "예약날짜","가격"};
		String contents[][]={};
		model = new DefaultTableModel(contents, header);
		endBidTable = new JTable(model);
		JScrollPane jScollPane = new JScrollPane(endBidTable);
		tablePn.add(jScollPane, BorderLayout.CENTER);
		
		BSAuctionLogic basl = new BSAuctionLogic(this);
		//
		DefaultTableModel model2 = new DefaultTableModel(ColName, 23);
		ingAuctionTable = new JTable(model2);
		
		ingAuctionTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer2());
		ingAuctionTable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor2(new JComboBox()));
		 for (int i = 0; i <ingAuctionTable.getRowCount() ; i++) {
			 ingAuctionTable.setRowHeight(i, 20);
	      }
		scrollPane = new JScrollPane(ingAuctionTable);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		//
		setResizable(false);
	}
	

}
