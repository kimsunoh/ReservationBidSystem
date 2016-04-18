package com.kitri4.RBS.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class BSBidRegister extends JFrame {

	JPanel contentPane;
	JTextField storeNameFt;
	JTextField peopleMax;
	JComboBox categoryComb;
	JTextField priceTf;
	JRadioButton agree;
	JRadioButton notAgree;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public BSBidRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 10, 10));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("상호명 :");
		panel.add(label, BorderLayout.NORTH);
		
		storeNameFt = new JTextField();
		panel.add(storeNameFt, BorderLayout.CENTER);
		storeNameFt.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("최대인원 ; ");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		peopleMax = new JTextField();
		panel_1.add(peopleMax, BorderLayout.CENTER);
		peopleMax.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("카테고리 : ");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		categoryComb = new JComboBox();
		panel_2.add(categoryComb, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("가격(1인) :");
		panel_3.add(lblNewLabel_2, BorderLayout.NORTH);
		
		priceTf = new JTextField();
		panel_3.add(priceTf, BorderLayout.CENTER);
		priceTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("제3자 정보제공에 동의하십니까?");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		
		agree = new JRadioButton("네");
		panel_5.add(agree);
		
		notAgree = new JRadioButton("아니오");
		panel_5.add(notAgree);
		
		panel_4.add(panel_5, BorderLayout.CENTER);

		JButton bidRegistBtn = new JButton("등록");
		contentPane.add(bidRegistBtn);
		
		
	}

}
