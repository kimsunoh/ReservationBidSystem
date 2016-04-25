package com.kitri4.GGY.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.CategoryDto;

public class CategoryDao {

	public int insert(CategoryDto categoryDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "insert into category (category_id, category_name) \n";
			sql += "values '" + categoryDto.getCategoryId() + "', '" + categoryDto.getCategoryName() + "' ";

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

			String sql = "delete from category";
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

	public int update(CategoryDto categoryDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "Update category ";
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

	public ArrayList<CategoryDto> selectAll() {
		ArrayList<CategoryDto> categoryList = new ArrayList<CategoryDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select category_id, category_name\n";
			sql += "from category";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CategoryDto categoryDto = new CategoryDto();
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

	public CategoryDto select(String category_name) {
		CategoryDto categoryDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select category_id, category_name\n";
			sql += "from category";
			sql += "where category_name = '" + category_name + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				categoryDto = new CategoryDto();
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
