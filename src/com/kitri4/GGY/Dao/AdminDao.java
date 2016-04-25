package com.kitri4.GGY.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.AdminDto;

public class AdminDao {
	
	public ArrayList<AdminDto> list(){
		ArrayList<AdminDto> list=new  ArrayList<AdminDto>();
		AdminDto dto=null;
		Connection conn=null;
		Statement stmt =null;
		ResultSet rs=null;
		
		try {
			conn=DBConnection.makeConnection();
			String sql="";
			sql+="select s.store_name,r.user_name,s.business_num \n";
			sql+="from rbsuser r,store s \n";
			sql+="where r.user_id=s.user_id";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				dto=new AdminDto();
				dto.setStoreName(rs.getString("store_name"));
				dto.setBusinessName(rs.getString("user_name"));
				dto.setBusinessNum(rs.getString("business_num"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, stmt, rs);
		}
		return list;
	}
	
	public ArrayList<AdminDto> auctionCount(String month){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		AdminDto dto=null;
		ArrayList<AdminDto> list=new  ArrayList<AdminDto>();
			
		try {//³«ÂûÀº ÇÁ·Î±×·¥´Ü¿¡¼­ ÇØÁÜ
			conn= DBConnection.makeConnection();
			String sql="select count(a.auction_seq),count(b.bid_id) \n";
			sql+="from auction a, bid b \n";
			sql+="where a.auction_seq = b.auction_seq \n";
			sql+="and bid_flag=1 \n";
			sql+="and to_char(add_months(sysdate,-"+month+"),'yyyymm')=to_char(bid_date,'yyyymm')";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				dto=new AdminDto();
				dto.setAuctionNum(rs.getInt("count(a.auction_seq)"));
				dto.setBidNum(rs.getInt("count(b.bid_id)"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, stmt, rs);
		}
		return list;
	}

	public ArrayList<AdminDto> find(String cal1,String cal2){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		AdminDto dto=null;
		ArrayList<AdminDto> list=new ArrayList<AdminDto>();
		
		try {
			conn= DBConnection.makeConnection();
			String sql="";
			sql+="select count(a.auction_seq),count(b.bid_id) \n";
			sql+="from auction a,bid b \n";
			sql+="where a.auction_seq=b.auction_seq \n";
			sql+="and auction_date between to_date('"+cal1+"','yyyy-mm-dd') and to_date('"+cal2+"','yyyy-mm-dd')";	
			stmt=conn.createStatement();	
			rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				dto=new AdminDto();
				dto.setAuctionNum(rs.getInt(1));
				dto.setBidNum(rs.getInt(2));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				DBClose.close(conn, stmt, rs);
		}
		return list;
	}
	
}
