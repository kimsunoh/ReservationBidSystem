package com.kitri4.GGY.Member;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoreDto {

	private ImageIcon storeImage;
	private int storeId;
	private int businessNum;
	private int categoryId;
	private int storePeopleNum;
	private String phoneNum;
	private String storeName;
	private String price;
	private String locationId;

	public StoreDto(ImageIcon storeImage, int storeId, int businessNum, int categoryId, int storePeopleNum,
			String storeName, String price, String locationId) {
		super();
		this.storeImage = storeImage;
		this.storeId = storeId;
		this.businessNum = businessNum;
		this.categoryId = categoryId;
		this.storePeopleNum = storePeopleNum;
		this.storeName = storeName;
		this.price = price;
		this.locationId = locationId;
	}

	public ImageIcon getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(ImageIcon storeImage) {
		this.storeImage = storeImage;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getStorePeopleNum() {
		return storePeopleNum;
	}

	public void setStorePeopleNum(int storePeopleNum) {
		this.storePeopleNum = storePeopleNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLocation() {
		return locationId;
	}

	public void setLocation(String location) {
		this.locationId = location;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
