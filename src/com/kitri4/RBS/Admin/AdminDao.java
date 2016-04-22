package com.kitri4.RBS.Admin;


import java.sql.*;
import java.util.ArrayList;

public class AdminDao {
	public AdminDao(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<AdminDto> list(){
		ArrayList<AdminDto> list=new  ArrayList<AdminDto>();
		AdminDto dto=null;
		Connection conn=null;
		Statement stmt =null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl","kitri","kitri");
			String sql="";
			sql+="select \n";
			sql+="from user u,business_man bm,store s \n";
			sql+="where u.user_id=bm.user_id \n";
			sql+="and s.business_man=bm,business_man";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				dto=new AdminDto();
				dto.setStoreName(rs.getString("store_name"));
				dto.setBusinessName(rs.getString("business_man"));
				dto.setBusinessNum(rs.getString("business_num"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return list;
	}
	
	public int auctionCount(int month){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		int auctionCnt=0;
		
		try {//³«ÂûÀº ÇÁ·Î±×·¥´Ü¿¡¼­ ÇØÁÜ
			conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl","kitri","kitri");
			String sql="";
			sql+="select count(auction_sequence),count(bid_id), \n";
			sql+="case when bid=true then '³«Âû' else 'ºñ³«Âû' \n"; 
			sql+="from auction a, bid b \n";
			sql+="where a.bid_id=b.bid_id \n";
			sql+="and add_months(sysdate,-"+month+") \n";
			sql+="group by auction_sequence, bid_id";
			conn.createStatement();
			stmt.executeQuery(sql);
			if(rs.next()){		
				auctionCnt=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return auctionCnt;
	}

	public int find(String cal1,String cal2){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		int bidCnt=0;
		
		try {
			conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl","kitri","kitri");
			String sql="";
			sql+="select count(auction_sequence),count(auction_sequence), \n";
			sql+="from a.bid_id=b.bid_id \n";
			sql+="where auction_date >= '"+cal1+"'";
			sql+="and auction_date <= '"+cal2+"'";	
			conn.createStatement();
			rs=stmt.executeQuery(sql);		
			while(rs.next()){
				bidCnt=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return bidCnt;
	}
	
}
