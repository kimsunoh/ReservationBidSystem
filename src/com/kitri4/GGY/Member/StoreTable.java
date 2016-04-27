package com.kitri4.GGY.Member;

import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.kitri4.GGY.Dao.StoreDao;
import com.kitri4.GGY.Dto.StoreDto;

public class StoreTable {

	public JTable storeTable;
	Vector<Object> storeData;
	ButtonRenderer buttonrenderer;
	ButtonEditor buttoneditor;
	MemberMain memberMain;
	DefaultTableModel storemodel;
	MemberAuctionList memberAuctionList;
	public int category;

	public StoreTable(MemberAuctionList memberAuctionList) {
		super();
		this.memberAuctionList = memberAuctionList;
		int bn = 10;
		int stpn = 20;
		category = 0;

		StoreDao storedao = new StoreDao();
		ArrayList<StoreDto> store = new ArrayList<StoreDto>();
		store = storedao.selectAllBusinessUser();

		// 가게 구성
		Vector<String> storeColumn = storeColumn = new Vector<String>();
		storeColumn.addElement("사진");
		storeColumn.addElement("가게 이름");
		storeColumn.addElement("가격");
		storeColumn.addElement("장소");

		storemodel = new DefaultTableModel(storeColumn, 0);

		// 가게 추가
		int storesize = store.size();
		for (int i = 0; i < storesize; i++) {
			storeData = new Vector<Object>();
			System.out.println("카테고리 : " + store.get(i).getCategoryId());
			if (category == store.get(i).getCategoryId() || category == 0) {
				insertStore(importImage(store.get(i).getStoreImg()), store.get(i).getStoreName(), "20000", store.get(i).getDongId());
				storemodel.addRow(storeData);
			}
		}

		// 이미지를 넣기 위한 JTable 오버라이드
		storeTable = new JTable(storemodel) {

			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		storeTable.setRowHeight(80);

		// ImageIcon img = importImage("hansin.jpg");
		int size = store.size();
		ImageIcon[] img = new ImageIcon[size];
		for (int i = 0; i < size; i++) {
			img[i] = importImage(store.get(i).getStoreImg());
		}

		buttonrenderer = new ButtonRenderer(img);
		buttoneditor = new ButtonEditor(new JCheckBox());

		storeTable.getColumn("사진").setCellRenderer(buttonrenderer);
		storeTable.getColumn("사진").setCellEditor(buttoneditor);
	}

	private ImageIcon importImage(String imageName) {
		ImageIcon Image1 = new ImageIcon("src\\com\\kitri4\\GGY\\img\\store\\" + imageName);
		Image image2 = Image1.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
		return new ImageIcon(image2);
	}

	private void insertStore(ImageIcon storeImage, String storeName, String price, int location) {
		storeData.addElement(storeImage);
		storeData.addElement(storeName);
		storeData.addElement(price);
		storeData.addElement(location);
	}
}
