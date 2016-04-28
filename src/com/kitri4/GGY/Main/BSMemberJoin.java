package com.kitri4.GGY.Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri4.GGY.Dao.*;
import com.kitri4.GGY.Dto.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BSMemberJoin extends JFrame {
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
	public JButton cancleBtn;
	public JButton joinBtn;
	
	private JPanel panel_1;
	public JTextField storeNameTf;
	public JTextField bsNumTf;
	public JTextField storePhoneTf;
	public JTextField storePeopleTf;
	public JTextField storeImgTf;
	public JButton checkIdBtn;
	public JComboBox dongComb;
	public JComboBox gooComb;
	public JComboBox categoryComb;
	public JButton getStoreImgBtn;
	public JFileChooser fc = new JFileChooser();
	private JLabel lblNewLabel_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSMemberJoin frame = new BSMemberJoin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BSMemberJoin() {
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 662);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("\uC5C5\uC8FC\uC815\uBCF4", null, panel, null);
		panel.setLayout(null);

		lblNewLabel = new JLabel("\uC5C5\uC8FC\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setBounds(114, 10, 130, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel);

		idLabel = new JLabel("ID");
		idLabel.setBounds(10, 51, 357, 25);
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(idLabel);

		idTf = new JTextField();
		idTf.setBounds(12, 86, 263, 25);
		panel.add(idTf);
		idTf.setColumns(10);

		pwLabel = new JLabel("Password");
		pwLabel.setBounds(10, 123, 357, 25);
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(pwLabel);

		pwTf = new JTextField();
		pwTf.setBounds(12, 160, 355, 25);
		pwTf.setColumns(10);
		panel.add(pwTf);

		pwcLabel = new JLabel("Password(\uD655\uC778)");
		pwcLabel.setBounds(10, 209, 357, 25);
		pwcLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwcLabel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(pwcLabel);

		pwCheckTf = new JTextField();
		pwCheckTf.setBounds(10, 246, 357, 25);
		pwCheckTf.setColumns(10);
		panel.add(pwCheckTf);

		nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(12, 290, 355, 25);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(nameLabel);

		phoneLabel = new JLabel("\uC5F0\uB77D\uCC98");
		phoneLabel.setBounds(12, 372, 53, 25);
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLabel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(phoneLabel);

		nameTf = new JTextField();
		nameTf.setBounds(10, 325, 357, 25);
		nameTf.setColumns(10);
		panel.add(nameTf);

		emailLabel = new JLabel("\uC774\uBA54\uC77C");
		emailLabel.setBounds(12, 466, 355, 25);
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("굴림", Font.BOLD, 14));
		panel.add(emailLabel);

		emailTf = new JTextField();
		emailTf.setBounds(10, 501, 357, 25);
		emailTf.setColumns(10);
		panel.add(emailTf);

		phoneTf = new JTextField();
		phoneTf.setBounds(10, 407, 357, 25);
		phoneTf.setColumns(10);
		panel.add(phoneTf);
		
		checkIdBtn = new JButton("ID\uD655\uC778");
		checkIdBtn.setBounds(281, 84, 86, 29);
		panel.add(checkIdBtn);
		
		lblNewLabel_1 = new JLabel("(-\uBE7C\uACE0 \uC785\uB825)");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(63, 377, 65, 13);
		panel.add(lblNewLabel_1);

		panel_1 = new JPanel();
		tabbedPane.addTab("\uAC00\uAC8C \uC815\uBCF4", null, panel_1, null);
		panel_1.setLayout(null);

		cancleBtn = new JButton("\uCDE8\uC18C");
		cancleBtn.setBounds(186, 555, 133, 33);
		panel_1.add(cancleBtn);

		joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		joinBtn.setBounds(44, 555, 133, 33);
		panel_1.add(joinBtn);

		JLabel label = new JLabel(" \uC5C5\uC8FC \uAC00\uAC8C \uC815\uBCF4");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(0, 0, 379, 41);
		panel_1.add(label);

		JLabel storeNameLabel = new JLabel("\uC0C1\uD638\uBA85");
		storeNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeNameLabel.setFont(new Font("굴림", Font.BOLD, 14));
		storeNameLabel.setBounds(10, 51, 357, 25);
		panel_1.add(storeNameLabel);

		storeNameTf = new JTextField();
		storeNameTf.setColumns(10);
		storeNameTf.setBounds(12, 86, 355, 25);
		panel_1.add(storeNameTf);

		JLabel bsNumLabel = new JLabel("\uC0AC\uC5C5\uC790\uB4F1\uB85D\uBC88\uD638");
		bsNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		bsNumLabel.setFont(new Font("굴림", Font.BOLD, 14));
		bsNumLabel.setBounds(10, 123, 357, 25);
		panel_1.add(bsNumLabel);

		bsNumTf = new JTextField();
		bsNumTf.setColumns(10);
		bsNumTf.setBounds(12, 160, 355, 25);
		panel_1.add(bsNumTf);

		JLabel storePhoneLabel = new JLabel("\uAC00\uAC8C \uC804\uD654\uBC88\uD638");
		storePhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storePhoneLabel.setFont(new Font("굴림", Font.BOLD, 14));
		storePhoneLabel.setBounds(10, 195, 357, 25);
		panel_1.add(storePhoneLabel);

		storePhoneTf = new JTextField();
		storePhoneTf.setColumns(10);
		storePhoneTf.setBounds(10, 232, 357, 25);
		panel_1.add(storePhoneTf);

		JLabel storeLocalLabel = new JLabel("\uAC00\uAC8C \uC8FC\uC18C(00\uC2DC/00\uAD6C)");
		storeLocalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeLocalLabel.setFont(new Font("굴림", Font.BOLD, 14));
		storeLocalLabel.setBounds(12, 267, 355, 25);
		panel_1.add(storeLocalLabel);

		JLabel categoryLabel = new JLabel(
				"\uCE74\uD14C\uACE0\uB9AC(\uD55C\uC2DD,\uC911\uC2DD,\uC591\uC2DD,\uC77C\uC2DD)");
		categoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		categoryLabel.setFont(new Font("굴림", Font.BOLD, 14));
		categoryLabel.setBounds(12, 337, 355, 25);
		panel_1.add(categoryLabel);

		JLabel storePeopleLabel = new JLabel("\uC218\uC6A9\uC778\uC6D0");
		storePeopleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storePeopleLabel.setFont(new Font("굴림", Font.BOLD, 14));
		storePeopleLabel.setBounds(12, 407, 355, 25);
		panel_1.add(storePeopleLabel);

		storePeopleTf = new JTextField();
		storePeopleTf.setColumns(10);
		storePeopleTf.setBounds(10, 442, 357, 25);
		panel_1.add(storePeopleTf);

		JLabel storeImgLabel = new JLabel("\uAC00\uAC8C \uC0AC\uC9C4");
		storeImgLabel.setHorizontalAlignment(SwingConstants.LEFT);
		storeImgLabel.setFont(new Font("굴림", Font.BOLD, 14));
		storeImgLabel.setBounds(12, 477, 355, 25);
		panel_1.add(storeImgLabel);

		storeImgTf = new JTextField();
		storeImgTf.setColumns(10);
		storeImgTf.setBounds(10, 512, 242, 25);
		panel_1.add(storeImgTf);
		
		dongDao locationDao = new dongDao();
		ArrayList<DongDto> locationDtoList = locationDao.selectAll();
		int size = locationDtoList.size();
		String locationList[] = new String[size];
		for (int i = 0; i < size; i++) {
			locationList[i] = locationDtoList.get(i).getDongName();
		}
		
		dongComb = new JComboBox(locationList);
		dongComb.setBounds(22, 294, 157, 33);
		panel_1.add(dongComb);
		
		rbsCategoryDao categoryDao = new rbsCategoryDao();
		ArrayList<rbsCategoryDto> categoryDtoList = categoryDao.selectAll();
		size = categoryDtoList.size();
		String categoryList[] = new String[size];
		for (int i = 0; i < size; i++) {
			categoryList[i] = categoryDtoList.get(i).getCategoryName();
		}
		categoryComb = new JComboBox(categoryList);
		categoryComb.setBounds(22, 364, 190, 33);
		panel_1.add(categoryComb);
		
		getStoreImgBtn = new JButton("\uC774\uBBF8\uC9C0\uD30C\uC77C");
		getStoreImgBtn.setBounds(252, 512, 103, 23);
		panel_1.add(getStoreImgBtn);

		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);
	}
}
