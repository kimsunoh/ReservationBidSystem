package com.kitri4.RBS.Member;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MemberAuctionDetail extends JFrame{

	public JButton checkBidBtn;
	public JButton cancelBidBtn;
	public MenuTable menutable;

	public MemberAuctionDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 670);
		setLayout(null);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 379, 160);
		ImageIcon Image1 = new ImageIcon("src\\com\\kitri4\\RBS\\hansin.jpg");
		Image image2 = Image1.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon storeImage1 = new ImageIcon(image2);
		imageLabel.setIcon(storeImage1);
		add(imageLabel);
		
		checkBidBtn = new JButton("³«Âû");
		checkBidBtn.setBounds(6, 555, 160, 33);
		add(checkBidBtn);
		
		cancelBidBtn = new JButton("Ãë¼Ò");
		cancelBidBtn.setBounds(201, 555, 160, 33);
		add(cancelBidBtn);
		
		menutable = new MenuTable(); 
		JScrollPane scrollPane = new JScrollPane(menutable.menuTable);
		scrollPane.setBounds(6, 170, 357, 370);
		add(scrollPane);
	}
	
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
}
