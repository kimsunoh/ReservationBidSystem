package com.kitri4.RBS.Member;

import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class StoreTable{

	JTable storeTable;
	Vector<Object> storeData;
	ButtonRenderer buttonrenderer;
	ButtonEditor buttoneditor;
	MemberMain memberMain;
	DefaultTableModel storemodel;

	public StoreTable(MemberMain memberMain) {
		super();
		this.memberMain= memberMain;
		int bn = 10;
		int stpn = 20;
		
		//���� ����
		StoreDto store1 = new StoreDto( importImage("hansin.jpg"), 1, bn, 1, stpn, "�ѽ�����", "150000", "����� ���α�");
		StoreDto store2 = new StoreDto( importImage("hou.jpg"), 2, bn, 1, stpn, "ȣ��粿ġ", "185000", "����� ���۱�");
		StoreDto store3 = new StoreDto( importImage("bonggu.jpg"), 3, bn, 1, stpn, "�������", "100000", "����� ������");
		
		ArrayList<StoreDto> store = new ArrayList<StoreDto>();
		store.add(store1);
		store.add(store2);
		store.add(store3);
		
		System.out.println(store.get(0).getStoreImage());
	
		// ���� ����
		
		Vector<String> storeColumn = storeColumn = new Vector<String>();
		storeColumn.addElement("����");
		storeColumn.addElement("���� �̸�");
		storeColumn.addElement("����");
		storeColumn.addElement("���");

		storemodel = new DefaultTableModel(storeColumn, 0);
	
		//���� �߰�
		
		int storesize = store.size();
		for (int i = 0; i < storesize; i++) {
			storeData = new Vector<Object>();
			insertStore(store.get(i).getStoreImage(), store.get(i).getStoreName(), store.get(i).getPrice(), store.get(i).getLocation());
			storemodel.addRow(storeData);
		}

		// �̹����� �ֱ� ���� JTable �������̵�
		storeTable = new JTable(storemodel) {

			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		storeTable.setRowHeight(80);
		
		//ImageIcon img = importImage("hansin.jpg");
		int size = storeData.size();
		ImageIcon[] img = new ImageIcon[size];
		
		img[0] = importImage("hansin.jpg");
		img[1] = importImage("hou.jpg");
		img[2] = importImage("bonggu.jpg");
		
		buttonrenderer = new ButtonRenderer(img);
		buttoneditor = new ButtonEditor(new JCheckBox(), memberMain);
		
		storeTable.getColumn("����").setCellRenderer(buttonrenderer);
		storeTable.getColumn("����").setCellEditor(buttoneditor);
	}

	private ImageIcon importImage(String imageName) {
		ImageIcon Image1 = new ImageIcon("src\\com\\kitri4\\RBS\\img\\" + imageName);
		Image image2 = Image1.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
		return new ImageIcon(image2);
	}

	private void insertStore(ImageIcon storeImage, String storeName, String price, String location) {
		storeData.addElement(storeImage);
		storeData.addElement(storeName);
		storeData.addElement(price);
		storeData.addElement(location);
	}
}
