package com.kitri4.RBS.BSMember;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class BSMenuList extends JFrame {

	private JPanel contentPane;
	private JButton bidListBtn;
	private JButton storeMenuBtn;
	private JButton infoBtn;
	private JPanel panel_2;
	private JButton menuAddBtn;
	private JTable menuListTable;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JTextField menuNameTf;
	private JTextField priceTf;
	private JPanel menuImgPn;
	private JTextArea menuInfoTf;
	private JButton addMenuBtn;
	private JButton renameMenuBtn;
	private JButton removeMenuBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSMenuList frame = new BSMenuList();
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
	public BSMenuList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("=", null, panel, null);
		panel.setLayout(new GridLayout(5, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		bidListBtn = new JButton("내역");
		panel.add(bidListBtn);
		
		storeMenuBtn = new JButton("메뉴");
		panel.add(storeMenuBtn);
		
		infoBtn = new JButton("내정보");
		panel.add(infoBtn);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("목록", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(10, 10));
		
		menuAddBtn = new JButton("신규메뉴등록");
		panel_2.add(menuAddBtn, BorderLayout.SOUTH);
		
		menuListTable = new JTable();
		panel_2.add(menuListTable, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("등록", null, panel_3, null);
		panel_3.setLayout(new GridLayout(3, 1, 10, 10));
		
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 10, 10));
		
		panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel = new JLabel("메뉴이름 :");
		panel_7.add(lblNewLabel, BorderLayout.WEST);
		
		menuNameTf = new JTextField();
		panel_7.add(menuNameTf, BorderLayout.CENTER);
		menuNameTf.setColumns(10);
		
		panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel_1 = new JLabel("가격 :");
		panel_8.add(lblNewLabel_1, BorderLayout.WEST);
		
		priceTf = new JTextField();
		panel_8.add(priceTf, BorderLayout.CENTER);
		priceTf.setColumns(10);
		
		panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel_2 = new JLabel("사진 :");
		panel_5.add(lblNewLabel_2, BorderLayout.NORTH);
		
		menuImgPn = new JPanel();
		panel_5.add(menuImgPn, BorderLayout.CENTER);
		
		panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 10, 10));
		
		panel_9 = new JPanel();
		panel_6.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("메뉴설명 :");
		panel_9.add(lblNewLabel_3, BorderLayout.NORTH);
		
		menuInfoTf = new JTextArea();
		panel_9.add(menuInfoTf, BorderLayout.CENTER);
		
		panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		addMenuBtn = new JButton("등록");
		panel_10.add(addMenuBtn);
		
		renameMenuBtn = new JButton("수정");
		panel_10.add(renameMenuBtn);
		
		removeMenuBtn = new JButton("삭제");
		panel_10.add(removeMenuBtn);
		
	}

}
