package com.kitri4.GGY.Dao;

import java.sql.*;

public class DBConnection {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() {
		Connection conn = null;
		try {
			/*동현*/
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.114:1521:orcl","kitri","kitri");
			/*진우*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.121:1521:orcl","kitri","kitri");
			//내꺼
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
//			System.out.println("jdbc접속");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
