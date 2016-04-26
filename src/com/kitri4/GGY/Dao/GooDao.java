package com.kitri4.GGY.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.GooDto;

public class GooDao {

	public int insert(GooDto gooDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "insert into goo (goo_id, goo_name) \n";
			sql += "values ('" + gooDto.getGooId() + "', '" + gooDto.getGooName() + "') ";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int delete(String goo_id) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "delete from goo";
			sql += "where goo_id = '" + goo_id + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int update(GooDto gooDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "Update goo ";
			sql += "set goo_name = '" + gooDto.getGooName() + "' ";
			sql += "where goo_id = '" + gooDto.getGooId() + "' ";
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public ArrayList<GooDto> selectAll() {
		ArrayList<GooDto> gooList = new ArrayList<GooDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select goo_id, goo_name\n";
			sql += "from goo";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				GooDto gooDto = new GooDto();
				gooDto.setGooId(Integer.parseInt(rs.getString("goo_id")));
				gooDto.setGooName(rs.getString("goo_name"));
				gooList.add(gooDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return gooList;
	}

	public GooDto select(String goo_id) {
		GooDto gooDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select goo_id, goo_name\n";
			sql += "from goo";
			sql += "where goo_id = '" + goo_id + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				gooDto = new GooDto();
				gooDto.setGooId(Integer.parseInt(rs.getString("goo_id")));
				gooDto.setGooName(rs.getString("goo_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return gooDto;
	}
}
