package com.kitri4.RBS.Member;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuTable {

	JTable menuTable;
	Vector<Object> menuData;
	int row;

	public MenuTable() {
		MenuDto menu1 = new MenuDto(importImage("chikenfoot.jpg"), 1, 1, "한신닭발", "15000");
		MenuDto menu2 = new MenuDto(importImage("seadduck.jpg"), 2, 1, "해물떡볶이", "15000");
		MenuDto menu3 = new MenuDto(importImage("tomatoegg.jpg"), 3, 1, "토마토소스 계란말이", "14000");
		MenuDto menu4 = new MenuDto(importImage("chikenfoot.jpg"), 1, 2, "한신닭발2", "15000");
		MenuDto menu5 = new MenuDto(importImage("seadduck.jpg"), 2, 2, "해물떡볶이2", "15000");
		MenuDto menu6 = new MenuDto(importImage("tomatoegg.jpg"), 3, 2, "토마토소스 계란말이2", "14000");

		ArrayList<MenuDto> menu = new ArrayList<MenuDto>();
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu4);
		menu.add(menu5);
		menu.add(menu6);

		Vector<String> menuColumn = new Vector<String>();
		menuColumn.addElement("사진");
		menuColumn.addElement("메뉴 이름");
		menuColumn.addElement("가격");

		DefaultTableModel menumodel = new DefaultTableModel(menuColumn, 0);
		System.out.println("row : "+ row);

		// 메뉴추가
		int menusize = menu.size();
		for (int i = 0; i < menusize; i++) {
			menuData = new Vector<Object>();
			if(menu.get(i).getStoreId() == row+1) {
				insertMenu(menu.get(i).getMenuPicturePath(), menu.get(i).getMenuName(), menu.get(i).getMenuprice());
				menumodel.addRow(menuData);
			}
		}
		
		menuTable = new JTable(menumodel) {

			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		menuTable.setRowHeight(80);

	}

	private ImageIcon importImage(String imageName) {
		ImageIcon Image1 = new ImageIcon("src\\com\\kitri4\\RBS\\img\\" + imageName);
		Image image2 = Image1.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
		return new ImageIcon(image2);
	}

	private void insertMenu(ImageIcon menuImage, String menuName, String price) {
		menuData.addElement(menuImage);
		menuData.addElement(menuName);
		menuData.addElement(price);
	}
}
