package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class MemberAuctionDetail extends JFrame {

	JPanel contentPane;
	JTable table;
	JTable storeInfoTable;
	JPanel panel_1;
	JButton cancelBtn;
	JButton finalBidBtn;
	JTable menuTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAuctionDetail frame = new MemberAuctionDetail();
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
	public MemberAuctionDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		storeInfoTable = new JTable();
		panel.add(storeInfoTable);
		
		menuTable = new JTable();
		contentPane.add(menuTable, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		cancelBtn = new JButton("Ãë¼Ò");
		panel_1.add(cancelBtn);
		
		finalBidBtn = new JButton("³«Âû");
		panel_1.add(finalBidBtn);
		
		
	}

}
