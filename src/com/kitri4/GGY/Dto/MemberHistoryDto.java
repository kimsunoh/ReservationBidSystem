package com.kitri4.GGY.Dto;

public class MemberHistoryDto {
	private String auctionLimitedTime = null;
	private int auctionPrice;
	private String storeName = null;
	private int categoryId;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int category) {
		this.categoryId = category;
	}
	public String getAuctionLimitedTime() {
		return auctionLimitedTime;
	}
	public void setAuctionLimitedTime(String auctionLimitedTime) {
		this.auctionLimitedTime = auctionLimitedTime;
	}
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
