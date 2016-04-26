package com.kitri4.GGY.Member;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.*;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MemberAuctionList extends JPanel {
	
	public CardLayout cd;

	public JPanel memberAuctionList;
	public MemberAuctionDetail memberAuctionDetail = new MemberAuctionDetail();
	public StoreTable storetable;
	public MemberMain memberMain;
	public JCheckBox koCheckbox;
	public JCheckBox jpCheckbox;
	public JCheckBox chCheckbox;
	public JCheckBox westCheckbox;
	public JCheckBox etcCheckbox;
	public JScrollPane scrollPane;
	
	public MemberAuctionList(MemberMain memberMain) {
		this.memberMain = memberMain;
		memberAuctionList = new JPanel();
		memberAuctionList.setLayout(null);
		setBounds(100, 100, 373, 620);
		cd = new CardLayout();
		setLayout(cd);
		
		add("memberAuctionList", memberAuctionList);
//		add("memberAuctionDetail", memberAuctionDetail.getContentPane());
		
		cd.show(this, "memberAuctionList");
		
		Choice choice = new Choice();
		choice.setBounds(11, 41, 344, 21);
		memberAuctionList.add(choice);
		
		JLabel lblNewLabel = new JLabel("날짜");
		lblNewLabel.setBounds(23, 68, 81, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		memberAuctionList.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2016.04.16");
		lblNewLabel_1.setBounds(116, 68, 251, 30);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		memberAuctionList.add(lblNewLabel_1);
		
		JLabel label = new JLabel("가격");
		label.setBounds(23, 108, 81, 30);
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		memberAuctionList.add(label);
		
		JLabel label_1 = new JLabel("200,000");
		label_1.setBounds(116, 108, 251, 30);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		memberAuctionList.add(label_1);
		
		JLabel label_2 = new JLabel("인원");
		label_2.setBounds(23, 148, 81, 30);
		label_2.setHorizontalTextPosition(SwingConstants.LEADING);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		memberAuctionList.add(label_2);
		
		JLabel label_3 = new JLabel("15명");
		label_3.setBounds(116, 148, 251, 30);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		memberAuctionList.add(label_3);
		
		koCheckbox = new JCheckBox("한식");
		koCheckbox.setBounds(23, 194, 61, 23);
		memberAuctionList.add(koCheckbox);
		
		jpCheckbox = new JCheckBox("일식");
		jpCheckbox.setBounds(88, 194, 61, 23);
		memberAuctionList.add(jpCheckbox);
		
		chCheckbox = new JCheckBox("중식");
		chCheckbox.setBounds(153, 194, 61, 23);
		memberAuctionList.add(chCheckbox);
		
		westCheckbox = new JCheckBox("양식");
		westCheckbox.setBounds(218, 194, 61, 23);
		memberAuctionList.add(westCheckbox);
		
		etcCheckbox = new JCheckBox("기타");
		etcCheckbox.setBounds(283, 194, 61, 23);
		memberAuctionList.add(etcCheckbox);

		storetable = new StoreTable(this);
		scrollPane = new JScrollPane(storetable.storeTable);
		scrollPane.setBounds(0, 223, 373, 387);
		memberAuctionList.add(scrollPane);

	}
}
