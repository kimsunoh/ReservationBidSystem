package com.kitri4.RBS.BSMember;

import java.sql.*;

public class BSAuctionDto {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection c, Statement s, ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (s!=null) {
				s.close();
			}
			if (c!=null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
