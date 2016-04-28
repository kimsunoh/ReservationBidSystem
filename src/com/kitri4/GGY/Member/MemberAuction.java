package com.kitri4.GGY.Member;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MemberAuction extends JPanel {

	public JTabbedPane tabbedPane;
	public MemberAuctionDetail memberAuctionDetail;
	public MemberAuctionList memberAuctionList;
	public JButton homebutton;
	int row;
	public MemberMain memberMain;
	public MemberAuctionHistory memberAuctionHistory = new MemberAuctionHistory();

	public MemberAuction(MemberMain memberMain) {
		this.memberMain = memberMain;
		memberAuctionDetail = new MemberAuctionDetail();
		memberAuctionList = new MemberAuctionList(memberMain);
		
		System.out.println("memberauction row : " + row);
		setBounds(0, 0, 373, 620);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 373, 620);
		add(tabbedPane);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		add(homebutton);

		tabbedPane.addTab("현재 경매", null, memberAuctionList, null);

		tabbedPane.addTab("경매 내역", null, memberAuctionHistory.contentPane, null);	
	}
}
