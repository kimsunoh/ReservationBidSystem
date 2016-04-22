package com.kitri4.RBS.Dao;

import java.sql.*;
import java.util.Vector;

public class RBSDao {
	Connection conn = null;
	
	public RBSDao(String driverPath) {
		try {
			conn = DriverManager.getConnection(driverPath);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int UserInsert(UserDto userDto) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "insert into RBSUSER value "+userDto;
		int cnt = 0;
		
		try {
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}
