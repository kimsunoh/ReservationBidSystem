package com.kitri4.RBS.Dto;

public class StoreDto {
	private int storeId;
	private String businessNum;
	private String storeName;
	private int locationId;
	private int categoryId;
	private String storePhoneNum;
	private int peopleNum;

	public int getStoreId() {
		return storeId;
	}
	
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId(int locationId) {
		this.locationId = locationId;
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
	
	public void setStorePhoneNum(String storePhoneNum) {
		this.storePhoneNum = storePhoneNum;
	}
	
	public int getPeopleNum() {
		return peopleNum;
	}
	
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}	
}
