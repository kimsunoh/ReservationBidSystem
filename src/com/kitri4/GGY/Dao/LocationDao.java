package com.kitri4.GGY.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.LocationDto;

public class LocationDao {

	public int insert(LocationDto locationDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "insert into Location (location_id, location_name, goo_id) \n";
			sql += "values ('" + locationDto.getLocationId() + "', '" + locationDto.getLocationName() + "', '";
			sql += "'" + locationDto.getGooId() + "') ";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int delete(String location_id) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "delete from location";
			sql += "where location_id = '" + location_id + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int update(LocationDto locationDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "Update location ";
			sql += "set location_name = '" + locationDto.getLocationName() + "', ";
			sql += "goo_id = '" + locationDto.getGooId() + "' ";
			sql += "where location_id = '" + locationDto.getLocationId() + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public ArrayList<LocationDto> selectAll() {
		ArrayList<LocationDto> locationList = new ArrayList<LocationDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select location_id, location_name, goo_id\n";
			sql += "from location";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				LocationDto locationDto = new LocationDto();
				locationDto.setLocationId(Integer.parseInt(rs.getString("location_id")));
				locationDto.setLocationName(rs.getString("location_name"));
				locationDto.setGooId(Integer.parseInt(rs.getString("goo_id")));
				locationList.add(locationDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return locationList;
	}

	public LocationDto select(String location_name) {
		LocationDto locationDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select location_id, location_name, goo_id\n";
			sql += "from location";
			sql += "where location_name = '" + location_name + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				locationDto = new LocationDto();
				locationDto.setLocationId(Integer.parseInt(rs.getString("location_id")));
				locationDto.setLocationName(rs.getString("location_name"));
				locationDto.setGooId(Integer.parseInt(rs.getString("goo_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return locationDto;
	}
}
