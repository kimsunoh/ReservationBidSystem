package com.kitri4.GGY.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.rbsCategoryDto;

public class rbsCategoryDao {

	public int insert(rbsCategoryDto categoryDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "insert into rbscategory (category_id, category_name) \n";
			sql += "values ('" + categoryDto.getCategoryId() + "', '" + categoryDto.getCategoryName() + "') ";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int delete(String category_id) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "delete from rbscategory";
			sql += "where category_id = '" + category_id + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int update(rbsCategoryDto categoryDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "Update rbscategory ";
			sql += "set goo_name = '" + categoryDto.getCategoryName() + "' ";
			sql += "where goo_id = '" + categoryDto.getCategoryId() + "' ";
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public ArrayList<rbsCategoryDto> selectAll() {
		ArrayList<rbsCategoryDto> categoryList = new ArrayList<rbsCategoryDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select category_id, category_name\n";
			sql += "from rbscategory";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				rbsCategoryDto categoryDto = new rbsCategoryDto();
				categoryDto.setCategoryId(Integer.parseInt(rs.getString("category_id")));
				categoryDto.setCategoryName(rs.getString("category_name"));
				categoryList.add(categoryDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return categoryList;
	}

	public rbsCategoryDto select(String category_name) {
		rbsCategoryDto categoryDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select category_id, category_name\n";
			sql += "from rbscategory\n";
			sql += "where category_name = '" + category_name + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				categoryDto = new rbsCategoryDto();
				categoryDto.setCategoryId(Integer.parseInt(rs.getString("category_id")));
				categoryDto.setCategoryName(rs.getString("category_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return categoryDto;
	}
}
