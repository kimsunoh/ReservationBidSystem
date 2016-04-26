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

	// ���� ���̾�α�
	public JDialog dialog; // ������ â dialog
	public JButton okBtn; // ������ ok��ư
	public JButton cancleBtn; // ������ cancel��ư
	public JFrame frm;
	public JPanel jdialogPanel;
	public JButton jdialogBtn;
	// public JButton storeMenuBtn;

	public JFileChooser fc = new JFileChooser();// ���Ϻҷ�����
	public JButton fileOpen; // ���Ϻҷ������� �����ư
	JTable BStable;
	BSMenuListLogic bsmenulistlogic;
	
	// 0422 �������̺����� ���� �κ�
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
		// �޴� ����Ʈ ����
		MenuDto menu1 = new MenuDto(importImage("zzimdak.jpg"), 1, 101, "���", "22000", "ġ�������� �ö� ��");
		MenuDto menu2 = new MenuDto(importImage("bodram.jpg"), 2, 102, "ġŲ", "17000", "�ٻ�����!");
		MenuDto menu3 = new MenuDto(importImage("pizza.jpg"), 3, 103, "����", "28000", "�ػ깫����� �߰�");

		ArrayList<MenuDto> menu = new ArrayList<MenuDto>();

//		// �޴��߰�
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);

		// ���̺� ��� �κ� --> �޴��̸�, ����, ����, ����
		Vector<String> menuHeader = new Vector<String>();
		menuHeader.addElement("�޴�");
		menuHeader.addElement("����");
		menuHeader.addElement("����");
		menuHeader.addElement("����");

		Menumodel = new DefaultTableModel(menuHeader, 0);

		// ���� ������ �߰� �κ�
		int menusize = menu.size();

		for (int i = 0; i < menusize; i++) {
			menudata = new Vector<Object>();
			insertMenu(menu.get(i).getMenuName(), menu.get(i).getMenuprice(), menu.get(i).getMenuPicturePath());
			Menumodel.addRow(menudata);
		}

		// �̹����� �ֱ� ���� JTable �������̵�
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
		tabbedPane.addTab("�޴�����Ʈ", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 379, 498);
		scrollPane.setViewportView(BStable);
		panel_2.add(scrollPane);

		menuAddBtn = new JButton("\uC2E0\uADDC\uBA54\uB274\uB4F1\uB85D");
		menuAddBtn.setBounds(23, 508, 330, 88);
		panel_2.add(menuAddBtn);

		panel_3 = new JPanel();
		tabbedPane.addTab("���/����", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel infolabel = new JLabel("<�޴� ���/����>");
		infolabel.setBounds(12, 10, 219, 36);
		panel_3.add(infolabel);

		lblNewLabel = new JLabel("�޴��̸�");
		lblNewLabel.setBounds(12, 56, 102, 36);
		panel_3.add(lblNewLabel);

		menuNameTf = new JTextField();
		menuNameTf.setBounds(12, 88, 355, 30);
		panel_3.add(menuNameTf);
		menuNameTf.setColumns(10);

		lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(12, 128, 102, 36);
		panel_3.add(lblNewLabel_1);

		priceTf = new JTextField();
		priceTf.setColumns(10);
		priceTf.setBounds(12, 160, 355, 30);
		panel_3.add(priceTf);

		lblNewLabel_2 = new JLabel("����");
		lblNewLabel_2.setBounds(12, 200, 102, 36);
		panel_3.add(lblNewLabel_2);

		openPicturBtn = new JButton("���� �ҷ�����");
		openPicturBtn.setBounds(54, 200, 122, 36);
		panel_3.add(openPicturBtn);

		Seepicture = new JLabel("�����Ѹ���");
		Seepicture.setBounds(12, 245, 277, 157);
		panel_3.add(Seepicture);

		label_2 = new JLabel("�޴�����");
		label_2.setBounds(12, 403, 102, 36);
		panel_3.add(label_2);

		menuInfoTf = new JTextField();
		menuInfoTf.setBounds(12, 434, 355, 71);
		panel_3.add(menuInfoTf);
		menuInfoTf.setColumns(10);

		addMenuBtn = new JButton("���");
		addMenuBtn.setBounds(12, 529, 102, 45);
		panel_3.add(addMenuBtn);

		renameMenuBtn = new JButton("����");
		renameMenuBtn.setBounds(140, 529, 102, 45);
		panel_3.add(renameMenuBtn);

		removeMenuBtn = new JButton("����");
		removeMenuBtn.setBounds(264, 529, 102, 45);
		panel_3.add(removeMenuBtn);

		homebutton = new JButton("=");
		homebutton.setBounds(0, 0, 97, 23);
		contentPane.add(homebutton);

		// SET CUSTOM RENDERER TO TEAMS COLUMN
		BStable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

		// SET CUSTOM EDITOR TO TEAMS COLUMNS
		BStable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JComboBox(), this));

		// ���� ��������, dialog ���̱�
		jdialogPanel = new JPanel();
		jdialogBtn = new JButton("���� �Ͻðڽ��ϱ�?");
		dialog = new JDialog();
		okBtn = new JButton("Ȯ��");
		cancleBtn = new JButton("���");

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
