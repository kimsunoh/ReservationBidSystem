package com.kitri4.GGY.Dto;

public class StoreDto {
	private int StoreId;
	private String businessNum;
	private String storeName;
	private int dongId;
	private int categoryId;
	private String storePhoneNum;
	private String peopleNum;
	private String userId;
	private String storeImg;
	private int businessFlag;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getDongId() {
		return dongId;
	}

	public void setDongId(int dongId) {
		this.dongId = dongId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getStorePhoneNum() {
		return storePhoneNum;
	}

	public void setStorePhone(String storePhoneNum) {
		this.storePhoneNum = storePhoneNum;
	}

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

	public int getBusinessFlag() {
		return businessFlag;
	}

	public void setBusinessFlag(int storeFlag) {
		this.businessFlag = storeFlag;
	}

}