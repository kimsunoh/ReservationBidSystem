package com.kitri4.RBS.Member;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri4.RBS.Logic.MemberLogic;

import java.awt.*;

import javax.swing.JButton;

public class MemberMain extends JFrame {

	public JPanel contentPane;
	public JButton bidListBtn;
	public JButton addBidBtn;
	public JButton memInfoBtn;
	public JPanel home = new JPanel();

	public CardLayout cd;
	
	public MemberAuction memberAuction= new MemberAuction(this);
	public MemberAuctionDetail memberAuctionDetail = new MemberAuctionDetail();
	public MemberAuctionRegister memberAuctionRegister = new MemberAuctionRegister();
	public MemberInfo memberInfo = new MemberInfo();
	public StoreTable storeTable = new StoreTable(this);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		cd = new CardLayout();
		contentPane.setLayout(cd);
		
		home = new JPanel();
		home.setBounds(100, 100, 400, 700);
		home.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.add("home", home);
		contentPane.add("AuctionList", memberAuction);
		contentPane.add("Info", memberInfo.contentPane);
		contentPane.add("Regi", memberAuctionRegister.contentPane);
		int cnt = 0;
		cnt++;
		System.out.println(cnt);
		cd.show(getContentPane(), "home");
		home.setLayout(null);

		bidListBtn = new JButton("경매 보기");
		bidListBtn.setBounds(60, 175, 256, 65);
		home.add(bidListBtn);

		addBidBtn = new JButton("경매 등록");
		addBidBtn.setBounds(60, 269, 256, 65);
		home.add(addBidBtn);

		memInfoBtn = new JButton("내 정보");
		memInfoBtn.setBounds(60, 365, 256, 65);
		home.add(memInfoBtn);
	}
}
