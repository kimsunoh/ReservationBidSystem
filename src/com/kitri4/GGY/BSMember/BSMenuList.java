package com.kitri4.GGY.BSMember;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.kitri4.GGY.Dto.MenuDto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BSMenuList extends JFrame {

	public JPanel contentPane;
	public JButton homebutton;
	public JTextField menuNameTf;
	public JTextField priceTf;
	public JTextField menuInfoTf;
	public JButton openPicturBtn;
	public JButton addMenuBtn;
	public JButton renameMenuBtn;
	public JButton removeMenuBtn;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel Seepicture;
	public JLabel label_2;
	public JTabbedPane tabbedPane;
	public JPanel panel_2;
	public JPanel panel_3;
	public JButton menuAddBtn;

	// 삭제 다이얼로그
	public JDialog dialog; // 삭제할 창 dialog
	public JButton okBtn; // 삭제할 ok버튼
	public JButton cancleBtn; // 삭제할 cancel버튼
	public JFrame frm;
	public JPanel jdialogPanel;
	public JButton jdialogBtn;
	// public JButton storeMenuBtn;

	public JFileChooser fc = new JFileChooser();// 파일불러오기
	public JButton fileOpen; // 파일불러오기의 열기버튼
	JTable BStable;
	BSMenuListLogic bsmenulistlogic;
	
	// 0422 벡터테이블때문에 쓰는 부분
	Vector<Object> menudata;
	DefaultTableModel Menumodel;

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
		
		

		//ArrayList<MenuDto> menu = new ArrayList<MenuDto>();
		// 메뉴 리스트 생성
		MenuDto menu1 = new MenuDto(importImage("zzimdak.jpg"), 1, 101, "찜닭", "22000", "치즈토핑이 올라간 닭");
		MenuDto menu2 = new MenuDto(importImage("bodram.jpg"), 2, 102, "치킨", "17000", "바사사사사삭!");
		MenuDto menu3 = new MenuDto(importImage("pizza.jpg"), 3, 103, "피자", "28000", "해산무우우우울 추가");

		ArrayList<MenuDto> menu = new ArrayList<MenuDto>();

//		// 메뉴추가
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);

		// 테이블 헤더 부분 --> 메뉴이름, 가격, 사진, 수정
		Vector<String> menuHeader = new Vector<String>();
		menuHeader.addElement("메뉴");
		menuHeader.addElement("가격");
		menuHeader.addElement("사진");
		menuHeader.addElement("수정");

		Menumodel = new DefaultTableModel(menuHeader, 0);

		// 벡터 컨텐츠 추가 부분
		int menusize = menu.size();

		for (int i = 0; i < menusize; i++) {
			menudata = new Vector<Object>();
			insertMenu(menu.get(i).getMenuName(), menu.get(i).getMenuprice(), menu.get(i).getMenuPicturePath());
			Menumodel.addRow(menudata);
		}

		// 이미지를 넣기 위한 JTable 오버라이드
		BStable = new JTable(Menumodel) {
			public Class getColumnClass(int column) {
				return getValueAt(2, column).getClass();
			}
		};
		BStable.setRowHeight(80);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 384, 662);
		contentPane.add(tabbedPane);

		panel_2 = new JPanel();
		tabbedPane.addTab("메뉴리스트", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 379, 498);
		scrollPane.setViewportView(BStable);
		panel_2.add(scrollPane);

		menuAddBtn = new JButton("\uC2E0\uADDC\uBA54\uB274\uB4F1\uB85D");
		menuAddBtn.setBounds(23, 508, 330, 88);
		panel_2.add(menuAddBtn);

		panel_3 = new JPanel();
		tabbedPane.addTab("등록/수정", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel infolabel = new JLabel("<메뉴 등록/수정>");
		infolabel.setBounds(12, 10, 219, 36);
		panel_3.add(infolabel);

		lblNewLabel = new JLabel("메뉴이름");
		lblNewLabel.setBounds(12, 56, 102, 36);
		panel_3.add(lblNewLabel);

		menuNameTf = new JTextField();
		menuNameTf.setBounds(12, 88, 355, 30);
		panel_3.add(menuNameTf);
		menuNameTf.setColumns(10);

		lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setBounds(12, 128, 102, 36);
		panel_3.add(lblNewLabel_1);

		priceTf = new JTextField();
		priceTf.setColumns(10);
		priceTf.setBounds(12, 160, 355, 30);
		panel_3.add(priceTf);

		lblNewLabel_2 = new JLabel("사진");
		lblNewLabel_2.setBounds(12, 200, 102, 36);
		panel_3.add(lblNewLabel_2);

		openPicturBtn = new JButton("사진 불러오기");
		openPicturBtn.setBounds(54, 200, 122, 36);
		panel_3.add(openPicturBtn);

		Seepicture = new JLabel("사진뿌릴거");
		Seepicture.setBounds(12, 245, 277, 157);
		panel_3.add(Seepicture);

		label_2 = new JLabel("메뉴설명");
		label_2.setBounds(12, 403, 102, 36);
		panel_3.add(label_2);

		menuInfoTf = new JTextField();
		menuInfoTf.setBounds(12, 434, 355, 71);
		panel_3.add(menuInfoTf);
		menuInfoTf.setColumns(10);

		addMenuBtn = new JButton("등록");
		addMenuBtn.setBounds(12, 529, 102, 45);
		panel_3.add(addMenuBtn);

		renameMenuBtn = new JButton("수정");
		renameMenuBtn.setBounds(140, 529, 102, 45);
		panel_3.add(renameMenuBtn);

		removeMenuBtn = new JButton("삭제");
		removeMenuBtn.setBounds(264, 529, 102, 45);
		panel_3.add(removeMenuBtn);

		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);

		// SET CUSTOM RENDERER TO TEAMS COLUMN
		BStable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

		// SET CUSTOM EDITOR TO TEAMS COLUMNS
		BStable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JComboBox(), this));

		// 삭제 변수부터, dialog 붙이기
		jdialogPanel = new JPanel();
		jdialogBtn = new JButton("삭제 하시겠습니까?");
		dialog = new JDialog();
		okBtn = new JButton("확인");
		cancleBtn = new JButton("취소");

		jdialogPanel.add(jdialogBtn);
		dialog.getContentPane().setLayout(new FlowLayout());
		dialog.getContentPane().add(okBtn);
		dialog.getContentPane().add(cancleBtn);

	}

	public void insertMenu(String menuName, String menuprice, ImageIcon menuPicturePath) {
		menudata.addElement(menuName);
		menudata.addElement(menuprice);
		menudata.addElement(menuPicturePath);
	}

	public ImageIcon importImage(String imageName) {
		ImageIcon Image1 = new ImageIcon("src\\com\\kitri4\\GGY\\img\\menu\\" + imageName);
		Image image2 = Image1.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
		return new ImageIcon(image2);
	}

}
