package com.kitri4.RBS.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri4.RBS.Dto.BusinessManDto;;

public class BusinessManDao {
	
	public int insertBusinessMan(BusinessManDto busUserDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			
			String sql = "insert into Business_Man (user_id, business_num) \n";
			sql += "values '"+busUserDto.getBusinessNum()+"', '" +busUserDto.getUserId()+ "', '";
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}
		
		return cnt;
	}
	
	public int delete(String id) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			
			String sql = "delete from Business_Man";
			sql += "where user_id = '" + id + "'";
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}
		
		return cnt;
	}
	
	public int update(BusinessManDto businessUserDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			
			String sql = "Update Business_Man ";
			sql += "set user_id = '" + businessUserDto.getBusinessNum() + "' \n";
			sql += "where id = '" + businessUserDto.getUserId() + "'";
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}
		
		return cnt;
	}
	
	public ArrayList<BusinessManDto> selectAllBusiness() {
		ArrayList<BusinessManDto> userList = new ArrayList<BusinessManDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			
			String sql = "select user_id, business_num\n";
			sql += "from Business_Man";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				BusinessManDto businessUserDto = new BusinessManDto();
				businessUserDto.setBusinessNum(rs.getString("business_num"));			
				businessUserDto.setUserId(rs.getString("user_id"));			
				userList.add(businessUserDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return userList;
	}
	
	public BusinessManDto select(String id) {
		BusinessManDto businessUserDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			
			String sql = "select user_id, business_num\n";
			sql += "from Business_Man\n";
			sql += "where user_id = '" + id + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				businessUserDto = new BusinessManDto();
				businessUserDto.setBusinessNum(rs.getString("business_num"));			
				businessUserDto.setUserId(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return businessUserDto;
	}
}