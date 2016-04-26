package com.kitri4.GGY.BSMember;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BSBidRegister extends JFrame {

	public JPanel contentPane;
	public JTabbedPane tabbedPane;
	
	public JLabel lblNewLabel;
	public JLabel rNameLabel;
	public JLabel rTimeLabel;
	public JLabel personLabel;
	public JLabel rePriceLabel;
	public JLabel busseNumLabel;
	public JLabel priceLabel;
	public JLabel storeNameLabel;
	public JLabel RNameValue;
	public JLabel RTimeValue;
	public JLabel personValue;
	public JLabel label;
	
	public JTextField busseNumTf;
	public JTextField priceTf;
	public JTextField storeNameTf;
	
	public JButton homebutton;
	public JButton agree;
	public JButton notAgree;
//	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSBidRegister frame = new BSBidRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BSBidRegister() {
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 662);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("?ûÖÏ∞∞ÌïòÍ∏?", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(" ?ûÖÏ∞? ?†ïÎ≥?");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 379, 41);
		panel.add(lblNewLabel);
		
		rNameLabel = new JLabel("?òà?ïΩ?ûêÎ™?");
		rNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rNameLabel.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		rNameLabel.setBounds(10, 51, 357, 25);
		panel.add(rNameLabel);
		
		rTimeLabel = new JLabel("?òà?ïΩ?ãúÍ∞?");
		rTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rTimeLabel.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		rTimeLabel.setBounds(10, 123, 357, 25);
		panel.add(rTimeLabel);
		
		personLabel = new JLabel("?ù∏?õê");
		personLabel.setHorizontalAlignment(SwingConstants.LEFT);
		personLabel.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		personLabel.setBounds(10, 195, 357, 25);
		panel.add(personLabel);
		
		rePriceLabel = new JLabel("Í∞?Í≤?");
		rePriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rePriceLabel.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		rePriceLabel.setBounds(12, 267, 355, 25);
		panel.add(rePriceLabel);
		
		priceLabel = new JLabel("?ûÖÏ∞? Í∏àÏï°");
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceLabel.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		priceLabel.setBounds(12, 337, 355, 25);
		panel.add(priceLabel);
		
		agree = new JButton("?ûÖÏ∞?");
		agree.setBounds(12, 555, 161, 41);
		panel.add(agree);
		
		notAgree = new JButton("Ï∑®ÏÜå");
		notAgree.setBounds(206, 555, 161, 41);
		panel.add(notAgree);

		
		priceTf = new JTextField();
		priceTf.setColumns(10);
		priceTf.setBounds(10, 372, 357, 25);
		panel.add(priceTf);
		
		RNameValue = new JLabel("");
		RNameValue.setBorder(new LineBorder(new Color(0, 0, 0)));
		RNameValue.setHorizontalAlignment(SwingConstants.LEFT);
		RNameValue.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		RNameValue.setBounds(10, 86, 357, 25);
		panel.add(RNameValue);
		
		RTimeValue = new JLabel("");
		RTimeValue.setBorder(new LineBorder(new Color(0, 0, 0)));
		RTimeValue.setHorizontalAlignment(SwingConstants.LEFT);
		RTimeValue.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		RTimeValue.setBounds(10, 160, 357, 25);
		panel.add(RTimeValue);
		
		personValue = new JLabel("");
		personValue.setHorizontalAlignment(SwingConstants.LEFT);
		personValue.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		personValue.setBorder(new LineBorder(new Color(0, 0, 0)));
		personValue.setBounds(10, 232, 357, 25);
		panel.add(personValue);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 14));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBounds(10, 302, 357, 25);
		panel.add(label);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}
}