package com.kitri4.GGY.BSMember;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BSInfo extends JFrame {

	public JPanel contentPane;
	public JTabbedPane tabbedPane;
	
	public JLabel lblNewLabel;
	public JLabel idLabel;
	public JLabel pwLabel;
	public JLabel pwcLabel;
	public JLabel nameLabel;
	public JLabel emailLabel;
	public JLabel phoneLabel;
	
	public JTextField idTf;
	public JTextField pwTf;
	public JTextField pwCheckTf;
	public JTextField nameTf;
	public JTextField emailTf;
	public JTextField phoneTf;
	
	public JButton homebutton;
	public JButton renameBtn;
	public JButton secessionBtn;
	private JPanel panel_1;
	public JTextField storeNameTf;
	public JTextField bsNumTf;
	public JTextField storePhoneTf;
	public JTextField storePeopleTf;
	public JTextField storeImgTf;
	//
	public JComboBox categoryCombo;
	public JComboBox dongCombo;
	//

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSInfo frame = new BSInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BSInfo() {
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 662);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("³» Á¤º¸", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(" ¾÷ÁÖ È¸¿ø Á¤º¸");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 379, 41);
		panel.add(lblNewLabel);
		
		idLabel = new JLabel("¾ÆÀÌµð");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		idLabel.setBounds(10, 51, 357, 25);
		panel.add(idLabel);
		
		idTf = new JTextField();
		idTf.setBounds(12, 86, 355, 25);
		panel.add(idTf);
		idTf.setColumns(10);
		
		pwLabel = new JLabel("ºñ¹Ð¹øÈ£");
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pwLabel.setBounds(10, 123, 357, 25);
		panel.add(pwLabel);
		
		pwTf = new JTextField();
		pwTf.setColumns(10);
		pwTf.setBounds(12, 160, 355, 25);
		panel.add(pwTf);
		
		pwcLabel = new JLabel("ºñ¹Ð¹øÈ£(È®ÀÎ)");
		pwcLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwcLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pwcLabel.setBounds(10, 195, 357, 25);
		panel.add(pwcLabel);
		
		pwCheckTf = new JTextField();
		pwCheckTf.setColumns(10);
		pwCheckTf.setBounds(10, 232, 357, 25);
		panel.add(pwCheckTf);
		
		nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		nameLabel.setBounds(12, 267, 355, 25);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("\uC5F0\uB77D\uCC98(000-0000-000)");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		phoneLabel.setBounds(12, 337, 355, 25);
		panel.add(phoneLabel);
		
		nameTf = new JTextField();
		nameTf.setColumns(10);
		nameTf.setBounds(10, 302, 357, 25);
		panel.add(nameTf);
		
		emailLabel = new JLabel("\uC774\uBA54\uC77C");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		emailLabel.setBounds(12, 407, 355, 25);
		panel.add(emailLabel);
		
		emailTf = new JTextField();
		emailTf.setColumns(10);
		emailTf.setBounds(10, 442, 357, 25);
		panel.add(emailTf);

		
		phoneTf = new JTextField();
		phoneTf.setColumns(10);
		phoneTf.setBounds(10, 372, 357, 25);
		panel.add(phoneTf);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("\uAC00\uAC8C \uC815\uBCF4", null, panel_1, null);
		panel_1.setLayout(null);
		
		renameBtn = new JButton("¼öÁ¤");
		renameBtn.setBounds(46, 555, 133, 23);
		panel_1.add(renameBtn);
		
		secessionBtn = new JButton("Å»Åð");
		secessionBtn.setBounds(184, 555, 133, 23);
		panel_1.add(secessionBtn);
		
		JLabel label = new JLabel(" \uC5C5\uC8FC \uAC00\uAC8C \uC815\uBCF4");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(0, 0, 379, 41);
		panel_1.add(label);
		
		JLabel storeNameLabel = new JLabel("\uC0C1\uD638\uBA85");
		storeNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeNameLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		storeNameLabel.setBounds(10, 51, 357, 25);
		panel_1.add(storeNameLabel);
		
		storeNameTf = new JTextField();
		storeNameTf.setColumns(10);
		storeNameTf.setBounds(12, 86, 355, 25);
		panel_1.add(storeNameTf);
		
		JLabel bsNumLabel = new JLabel("\uC0AC\uC5C5\uC790\uB4F1\uB85D\uBC88\uD638");
		bsNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		bsNumLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		bsNumLabel.setBounds(10, 123, 357, 25);
		panel_1.add(bsNumLabel);
		
		bsNumTf = new JTextField();
		bsNumTf.setColumns(10);
		bsNumTf.setBounds(12, 160, 355, 25);
		panel_1.add(bsNumTf);
		
		JLabel storePhoneLabel = new JLabel("\uAC00\uAC8C \uC804\uD654\uBC88\uD638");
		storePhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storePhoneLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		storePhoneLabel.setBounds(10, 195, 357, 25);
		panel_1.add(storePhoneLabel);
		
		storePhoneTf = new JTextField();
		storePhoneTf.setColumns(10);
		storePhoneTf.setBounds(10, 232, 357, 25);
		panel_1.add(storePhoneTf);
		
		JLabel storeLocalLabel = new JLabel("\uAC00\uAC8C \uC8FC\uC18C");
		storeLocalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeLocalLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		storeLocalLabel.setBounds(12, 267, 355, 25);
		panel_1.add(storeLocalLabel);
		
		JLabel categoryLabel = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		categoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		categoryLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		categoryLabel.setBounds(12, 337, 355, 25);
		panel_1.add(categoryLabel);
		
		JLabel storePeopleLabel = new JLabel("\uC218\uC6A9\uC778\uC6D0");
		storePeopleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storePeopleLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		storePeopleLabel.setBounds(12, 407, 355, 25);
		panel_1.add(storePeopleLabel);
		
		storePeopleTf = new JTextField();
		storePeopleTf.setColumns(10);
		storePeopleTf.setBounds(10, 442, 357, 25);
		panel_1.add(storePeopleTf);
		
		JLabel storeImgLabel = new JLabel("\uAC00\uAC8C \uC0AC\uC9C4");
		storeImgLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeImgLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		storeImgLabel.setBounds(12, 477, 355, 25);
		panel_1.add(storeImgLabel);
		
		storeImgTf = new JTextField();
		storeImgTf.setColumns(10);
		storeImgTf.setBounds(10, 512, 357, 25);
		panel_1.add(storeImgTf);
		
		categoryCombo = new JComboBox();//
		categoryCombo.setBounds(12, 365, 355, 32);
		panel_1.add(categoryCombo);
		categoryCombo.addItem("");
		
		dongCombo = new JComboBox();//
		dongCombo.setBounds(10, 295, 355, 32);
		panel_1.add(dongCombo);
		dongCombo.addItem("");
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}
}
