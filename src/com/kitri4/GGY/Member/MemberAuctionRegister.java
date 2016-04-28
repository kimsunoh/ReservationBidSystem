package com.kitri4.GGY.Member;

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
	public JComboBox dongComb;
	public JButton okBtn;
	public JButton cancelBtn;
	public JTextArea needsomeTa;
	public JButton homebutton;
	public JLabel titleLabel;
	public JTextField titleTf;
	public JTextField peopleNumTf;
	private JLabel label;

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
		tabbedPane.addTab("µî·Ï", null, panel, null);
		panel.setLayout(null);
		
		JLabel locaationLabel = new JLabel("Áö¿ª");
		locaationLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		locaationLabel.setBounds(12, 170, 72, 31);
		panel.add(locaationLabel);
		
		priceTf = new JTextField();
		priceTf.setBounds(96, 223, 271, 35);
		panel.add(priceTf);
		priceTf.setColumns(10);
		
		dongComb = new JComboBox();
		dongComb.setBounds(96, 170, 271, 31);
		panel.add(dongComb);
		dongComb.addItem("");
		
		JLabel peopleNumLabel = new JLabel("\uC778\uC6D0");
		peopleNumLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		peopleNumLabel.setBounds(12, 117, 72, 35);
		panel.add(peopleNumLabel);
		
		
		JLabel title = new JLabel("°æ¸Å µî·Ï Á¤º¸");
		title.setFont(new Font("±¼¸²", Font.BOLD, 14));
		title.setBounds(12, 10, 355, 46);
		panel.add(title);
		
		JLabel priceLabel = new JLabel("Èñ¸Á°¡°Ý");
		priceLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		priceLabel.setBounds(12, 223, 72, 37);
		panel.add(priceLabel);
		
		JLabel needsomeLabel = new JLabel("\uBE44\uACE0");
		needsomeLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		needsomeLabel.setBounds(12, 292, 72, 46);
		panel.add(needsomeLabel);
		
		okBtn = new JButton("µî·Ï");
		okBtn.setBounds(12, 539, 168, 45);
		panel.add(okBtn);
		
		cancelBtn = new JButton("Ãë¼Ò");
		cancelBtn.setBounds(199, 539, 168, 45);
		panel.add(cancelBtn);
		
		needsomeTa = new JTextArea();
		needsomeTa.setBounds(96, 293, 271, 199);
		panel.add(needsomeTa);
		
		titleLabel = new JLabel("\uACBD\uB9E4 \uC81C\uBAA9");
		titleLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		titleLabel.setBounds(12, 66, 72, 35);
		panel.add(titleLabel);
		
		titleTf = new JTextField();
		titleTf.setColumns(10);
		titleTf.setBounds(96, 66, 271, 35);
		panel.add(titleTf);
		
		peopleNumTf = new JTextField();
		peopleNumTf.setColumns(10);
		peopleNumTf.setBounds(96, 117, 271, 35);
		panel.add(peopleNumTf);
		
		label = new JLabel("(\uC0C1\uC138\uC124\uBA85)");
		label.setFont(new Font("±¼¸²", Font.BOLD, 14));
		label.setBounds(12, 325, 83, 46);
		panel.add(label);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}
}
