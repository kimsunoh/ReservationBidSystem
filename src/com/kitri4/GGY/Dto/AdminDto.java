package com.kitri4.GGY.Dto;

import java.util.Vector;

public class AdminDto {
	public String storeName;
	public String businessName;
	public String businessNum;
	public int auctionNum;
	public int bidNum;
	public int agreebidNum;
	
	public int getAuctionNum() {
		return auctionNum;
	}

	public void setAuctionNum(int auctionNum) {
		this.auctionNum = auctionNum;
	}

	public int getBidNum() {
		return bidNum;
	}

	public void setBidNum(int bidNum) {
		this.bidNum = bidNum;
	}

	public int getAgreebidNum() {
		return agreebidNum;
	}

	public void setAgreebidNum(int agreebidNum) {
		this.agreebidNum = agreebidNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
}
