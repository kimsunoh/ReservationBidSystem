package com.kitri4.GGY.Dto;

import java.io.File;

import javax.swing.ImageIcon;

public class MenuDto {
	private ImageIcon menuPicturePath;
	private int menuId;
	private int storeId;
	private String menuName;
	private String menuprice;
	private String menucontents;
	private String menuPictureAdress;
	private File file;

	public MenuDto(ImageIcon menuPicturePath, int menuId, int storeId, String menuName, String menuprice,
			String menucontents) {
		super();
	    this.menuPicturePath=menuPicturePath;
		this.menuId = menuId;
		this.storeId = storeId;
		this.menuName = menuName;
		this.menuprice = menuprice;
		this.menucontents = menucontents;
	//	this.menuPictureAdress = menuPictureAdress;
	}
	public ImageIcon getMenuPicturePath() {
		return menuPicturePath;
	}
	public void setMenuPicturePath(ImageIcon menuPicturePath) {
		this.menuPicturePath = menuPicturePath;
	}
	public String getMenuPictureAdress() {
		return menuPictureAdress;
	}
	
	public void setMenuPictureAdress(String menuPictureAdress) {
		this.menuPictureAdress = menuPictureAdress;
	}

//	
//
//	public ImageIcon getMenuPicturePath() {
//		return menuPicturePath;
//	}
//
//	public void setMenuPicturePath(ImageIcon menuPicturePath) {
//		this.menuPicturePath = menuPicturePath;
//	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuprice() {
		return menuprice;
	}

	public void setMenuprice(String menuprice) {
		this.menuprice = menuprice;
	}
	public String getMenucontents() {
		return menucontents;
	}

	public void setMenucontents(String menucontents) {
		this.menucontents = menucontents;
	}

}
