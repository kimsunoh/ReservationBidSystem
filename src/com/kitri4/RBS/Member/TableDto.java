package com.kitri4.RBS.Member;

import java.util.Date;

public class TableDto {
	String storename;

	Date time;
	int price;
	
	public TableDto(String storename, Date time, int price){
		this.storename = storename;
		this.time = time;
		this.price = price;
	}

	public String getStorename() {
		return storename;
	}
	
	public void setStorename(String storename) {
		this.storename = storename;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
