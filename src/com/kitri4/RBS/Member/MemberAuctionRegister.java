package com.kitri4.RBS.Member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class MemberAuctionRegister extends JPanel {

	public JPanel contentPane;
	public JTextField priceTf;
	public JComboBox locationComb;
	public JComboBox dongComb;
	public JComboBox foodCategoComd;
	public JComboBox peopleNumComb;
	public JButton okb;
	public JButton cancelb;
	public JTextArea needsomeTa;
	public JButton homebutton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAuctionRegister frame = new MemberAuctionRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberAuctionRegister() {
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 636);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("등록", null, panel, null);
		panel.setLayout(null);
		
		JLabel locaationLabel = new JLabel("지역");
		locaationLabel.setFont(new Font("굴림", Font.BOLD, 14));
		locaationLabel.setBounds(12, 168, 72, 31);
		panel.add(locaationLabel);
		
		locationComb = new JComboBox();
		locationComb.setBounds(96, 168, 126, 31);
		panel.add(locationComb);
		locationComb.addItem("서울시");
		locationComb.addItem("인천시");
		locationComb.addItem("안양시");
		locationComb.addItem("수원시");
		
		priceTf = new JTextField();
		priceTf.setBounds(96, 240, 271, 45);
		panel.add(priceTf);
		priceTf.setColumns(10);
		
		dongComb = new JComboBox();
		dongComb.setBounds(241, 168, 126, 31);
		panel.add(dongComb);
		dongComb.addItem("구로구");
		dongComb.addItem("강남구");
		dongComb.addItem("중구");
		dongComb.addItem("서구");
		dongComb.addItem("동안구");
		dongComb.addItem("권선구");
		
		foodCategoComd = new JComboBox();
		foodCategoComd.setBounds(96, 117, 271, 31);
		panel.add(foodCategoComd);
		foodCategoComd.addItem("한식");
		foodCategoComd.addItem("일식");
		foodCategoComd.addItem("중식");
		foodCategoComd.addItem("기타");
		
		JLabel categoryLabel = new JLabel("종류");
		categoryLabel.setFont(new Font("굴림", Font.BOLD, 14));
		categoryLabel.setBounds(12, 117, 72, 31);
		panel.add(categoryLabel);
		
		peopleNumComb = new JComboBox();
		peopleNumComb.setBounds(96, 66, 271, 31);
		panel.add(peopleNumComb);
		peopleNumComb.addItem("1~4인");
		peopleNumComb.addItem("4~8인");
		peopleNumComb.addItem("8~12인");
		peopleNumComb.addItem("12~16인");
		peopleNumComb.addItem("17인 이상");
		
		JLabel peopleNumLabel = new JLabel("인원");
		peopleNumLabel.setFont(new Font("굴림", Font.BOLD, 14));
		peopleNumLabel.setBounds(12, 66, 72, 31);
		panel.add(peopleNumLabel);
		
		
		JLabel title = new JLabel("경매 등록 정보");
		title.setFont(new Font("굴림", Font.BOLD, 14));
		title.setBounds(12, 10, 355, 46);
		panel.add(title);
		
		JLabel priceLabel = new JLabel("희망가격");
		priceLabel.setFont(new Font("굴림", Font.BOLD, 14));
		priceLabel.setBounds(12, 240, 72, 45);
		panel.add(priceLabel);
		
		JLabel needsomeLabel = new JLabel("비고");
		needsomeLabel.setFont(new Font("굴림", Font.BOLD, 14));
		needsomeLabel.setBounds(12, 304, 72, 45);
		panel.add(needsomeLabel);
		
		okb = new JButton("등록");
		okb.setBounds(12, 552, 168, 45);
		panel.add(okb);
		
		cancelb = new JButton("취소");
		cancelb.setBounds(199, 552, 168, 45);
		panel.add(cancelb);
		
		needsomeTa = new JTextArea();
		needsomeTa.setBounds(96, 316, 271, 199);
		panel.add(needsomeTa);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}
}
