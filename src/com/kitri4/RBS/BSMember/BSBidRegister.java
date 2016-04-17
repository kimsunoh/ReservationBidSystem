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

	private JPanel contentPane;
	private JTextField storeNameFt;
	private JTextField storeCateTf;
	private JComboBox maxPeopleNumComb;
	private JTextField priceTf;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

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
		panel.add(label, BorderLayout.WEST);
		
		storeNameFt = new JTextField();
		panel.add(storeNameFt, BorderLayout.CENTER);
		storeNameFt.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("카테고리 ; ");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		storeCateTf = new JTextField();
		panel_1.add(storeCateTf, BorderLayout.CENTER);
		storeCateTf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("수용가능인원 : ");
		panel_2.add(lblNewLabel_1, BorderLayout.WEST);
		
		maxPeopleNumComb = new JComboBox();
		panel_2.add(maxPeopleNumComb, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("가격(1인) :");
		panel_3.add(lblNewLabel_2, BorderLayout.WEST);
		
		priceTf = new JTextField();
		panel_3.add(priceTf, BorderLayout.CENTER);
		priceTf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("가게정보제공에 동의하겠습니다.");
		panel_4.add(lblNewLabel_3, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		rdbtnNewRadioButton = new JRadioButton("네");
		panel_5.add(rdbtnNewRadioButton, BorderLayout.NORTH);
		
		rdbtnNewRadioButton_1 = new JRadioButton("아니오");
		panel_5.add(rdbtnNewRadioButton_1, BorderLayout.SOUTH);
		
		JButton bidRegistBtn = new JButton("입찰하기");
		contentPane.add(bidRegistBtn);
		
		
	}

}
