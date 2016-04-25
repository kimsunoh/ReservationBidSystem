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
	public JLabel phoneLabel;
	public JLabel busseNumLabel;
	public JLabel storePhonelabel;
	public JLabel storeNameLabel;
	
	public JTextField idTf;
	public JTextField pwTf;
	public JTextField pwCheckTf;
	public JTextField phoneNumTf;
	public JTextField busseNumTf;
	public JTextField storePhoneTf;
	public JTextField storeNameTf;
	
	public JButton homebutton;
	public JButton renameBtn;
	public JButton secessionBtn;

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
		tabbedPane.addTab("내 정보", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel(" 업주 회원 정보");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 379, 41);
		panel.add(lblNewLabel);
		
		idLabel = new JLabel("아이디");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("굴림", Font.BOLD, 14));
		idLabel.setBounds(10, 51, 357, 25);
		panel.add(idLabel);
		
		idTf = new JTextField();
		idTf.setBounds(12, 86, 355, 25);
		panel.add(idTf);
		idTf.setColumns(10);
		
		pwLabel = new JLabel("비밀번호");
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 14));
		pwLabel.setBounds(10, 123, 357, 25);
		panel.add(pwLabel);
		
		pwTf = new JTextField();
		pwTf.setColumns(10);
		pwTf.setBounds(12, 160, 355, 25);
		panel.add(pwTf);
		
		pwcLabel = new JLabel("비밀번호(확인)");
		pwcLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwcLabel.setFont(new Font("굴림", Font.BOLD, 14));
		pwcLabel.setBounds(10, 195, 357, 25);
		panel.add(pwcLabel);
		
		pwCheckTf = new JTextField();
		pwCheckTf.setColumns(10);
		pwCheckTf.setBounds(10, 232, 357, 25);
		panel.add(pwCheckTf);
		
		phoneLabel = new JLabel("연락처(000-0000-000)");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLabel.setFont(new Font("굴림", Font.BOLD, 14));
		phoneLabel.setBounds(12, 267, 355, 25);
		panel.add(phoneLabel);
		
		storePhonelabel = new JLabel("가게 연락처(000-0000-000)");
		storePhonelabel.setHorizontalAlignment(SwingConstants.LEFT);
		storePhonelabel.setFont(new Font("굴림", Font.BOLD, 14));
		storePhonelabel.setBounds(12, 337, 355, 25);
		panel.add(storePhonelabel);
		
		phoneNumTf = new JTextField();
		phoneNumTf.setColumns(10);
		phoneNumTf.setBounds(10, 302, 357, 25);
		panel.add(phoneNumTf);
		
		busseNumLabel = new JLabel("사업자번호");
		busseNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		busseNumLabel.setFont(new Font("굴림", Font.BOLD, 14));
		busseNumLabel.setBounds(12, 407, 355, 25);
		panel.add(busseNumLabel);
		
		storeNameLabel = new JLabel("상호명");
		storeNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeNameLabel.setFont(new Font("굴림", Font.BOLD, 14));
		storeNameLabel.setBounds(12, 477, 355, 25);
		panel.add(storeNameLabel);
		
		busseNumTf = new JTextField();
		busseNumTf.setColumns(10);
		busseNumTf.setBounds(10, 442, 357, 25);
		panel.add(busseNumTf);
		
		renameBtn = new JButton("수정");
		renameBtn.setBounds(12, 555, 161, 41);
		panel.add(renameBtn);
		
		secessionBtn = new JButton("탈퇴");
		secessionBtn.setBounds(206, 555, 161, 41);
		panel.add(secessionBtn);

		
		storePhoneTf = new JTextField();
		storePhoneTf.setColumns(10);
		storePhoneTf.setBounds(10, 372, 357, 25);
		panel.add(storePhoneTf);
		
		storeNameTf = new JTextField();
		storeNameTf.setColumns(10);
		storeNameTf.setBounds(10, 512, 357, 25);
		panel.add(storeNameTf);
		
		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}

}
