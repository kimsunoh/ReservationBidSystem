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
		MenuDto menu1 = new MenuDto(importImage("chikenfoot.jpg"), 1, 1, "�ѽŴ߹�", "15000");
		MenuDto menu2 = new MenuDto(importImage("seadduck.jpg"), 2, 1, "�ع�������", "15000");
		MenuDto menu3 = new MenuDto(importImage("tomatoegg.jpg"), 3, 1, "�丶��ҽ� �������", "14000");
		MenuDto menu4 = new MenuDto(importImage("chikenfoot.jpg"), 1, 2, "�ѽŴ߹�2", "15000");
		MenuDto menu5 = new MenuDto(importImage("seadduck.jpg"), 2, 2, "�ع�������2", "15000");
		MenuDto menu6 = new MenuDto(importImage("tomatoegg.jpg"), 3, 2, "�丶��ҽ� �������2", "14000");

		ArrayList<MenuDto> menu = new ArrayList<MenuDto>();
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu4);
		menu.add(menu5);
		menu.add(menu6);

		Vector<String> menuColumn = new Vector<String>();
		menuColumn.addElement("����");
		menuColumn.addElement("�޴� �̸�");
		menuColumn.addElement("����");

		DefaultTableModel menumodel = new DefaultTableModel(menuColumn, 0);
		System.out.println("row : "+ row);

		// �޴��߰�
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
