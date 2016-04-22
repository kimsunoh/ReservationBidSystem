package com.kitri4.RBS.BSMember;

import java.awt.BorderLayout;
import java.sql.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BSAuctionLogic {
	BSAuction bsa;
	String str[] = new String[3];

	public BSAuctionLogic(BSAuction bsa) {
		this.bsa = bsa;
		
		Connection c=null;
		Statement s=null;
		ResultSet rs=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.114:1521:orcl","kitri","kitri");
			String sql = "select user_id,user_name,user_phone\nfrom rbsuser";
			s = c.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				str[0] = rs.getString("user_id");
				str[1] = rs.getString("user_name");
				str[2] = rs.getString("user_phone");
				bsa.model.addRow(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
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
}
