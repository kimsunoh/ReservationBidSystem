package com.kitri4.GGY.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.DongDto;

public class dongDao {

	public int insert(DongDto dongDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "insert into Location (dong_id, dong_name, goo_id) \n";
			sql += "values ('" + dongDto.getDongId() + "', '" + dongDto.getDongName() + "', '";
			sql += "'" + dongDto.getGooId() + "') ";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int delete(String dongId) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "delete from dong";
			sql += "where dong_id = '" + dongId + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int update(DongDto dongDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "Update dong ";
			sql += "set dong_name = '" + dongDto.getDongName() + "', ";
			sql += "goo_id = '" + dongDto.getGooId() + "' ";
			sql += "where dong_id = '" + dongDto.getDongId() + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public ArrayList<DongDto> selectAll() {
		ArrayList<DongDto> dongList = new ArrayList<DongDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select dong_id, dong_name, goo_id\n";
			sql += "from dong";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				DongDto locationDto = new DongDto();
				locationDto.setDongId(Integer.parseInt(rs.getString("dong_id")));
				locationDto.setDongName(rs.getString("dong_name"));
				locationDto.setGooId(Integer.parseInt(rs.getString("goo_id")));
				dongList.add(locationDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return dongList;
	}

	public DongDto select(String dongName) {
		DongDto dongDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select dong_id, dong_name, goo_id\n";
			sql += "from dong\n";
			sql += "where dong_name = '" + dongName + "'";
			System.out.println(sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dongDto = new DongDto();
				dongDto.setDongId(Integer.parseInt(rs.getString("dong_id")));
				dongDto.setDongName(rs.getString("dong_name"));
				dongDto.setGooId(Integer.parseInt(rs.getString("goo_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return dongDto;
	}
	
	public static void main(String[] args) {
		DongDto dong = new dongDao().select("°¡¸®ºÀ1µ¿");
		System.out.println(dong.getDongName() + ", " + dong.getDongId());
	}
}
