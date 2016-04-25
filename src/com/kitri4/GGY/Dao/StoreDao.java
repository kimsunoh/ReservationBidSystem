package com.kitri4.GGY.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.StoreDto;
import com.kitri4.GGY.Dto.UserDto;

public class StoreDao {

	public int insert(StoreDto storeDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "insert into Store (user_id, store_id, business_num, store_name, location_id, category, store_phonenum,";
			sql += " store_peoplenum, business_flag, store_img) \n";
			sql += "value '" + storeDto.getUserId() + "', '" + storeDto.getStoreId() + "', ";
			sql += "'" + storeDto.getBusinessNum() + "', '" + storeDto.getStoreName() + "', ";
			sql += "'" + storeDto.getLocation() + "', '" + storeDto.getCategory() + "', ";
			sql += "'" + storeDto.getStorePhone() + "', '" + storeDto.getPeople()+ "', ";
			sql += "'" + storeDto.getBusinessFlag() + "', '" + storeDto.getStoreImg()+ "' ";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public int deleteUser(String id) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "delete from Store";
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

	public int updateUser(StoreDto storeDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "Update Store ";
			sql += "set store_id = '" + storeDto.getStoreId() + "', ";
			sql += "business_num = '" + storeDto.getBusinessNum() + "', ";
			sql += "store_name = '" + storeDto.getStoreName() + "', ";
			sql += "location_id = '" + storeDto.getLocation() + "', ";
			sql += "category_id = '" + storeDto.getCategory() + "', ";
			sql += "store_phoneNum = '" + storeDto.getStorePhone() + "', ";
			sql += "store_peopleNum = '" + storeDto.getPeople() + "', ";
			sql += "store_img = '" + storeDto.getStoreImg() + "', ";
			sql += "business_flag = '" + storeDto.getBusinessFlag() + "', ";
			sql += "where id = '" + storeDto.getUserId() + "'";

			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}

		return cnt;
	}

	public ArrayList<StoreDto> selectAllBusinessUser() {
		ArrayList<StoreDto> userList = new ArrayList<StoreDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select user_id, store_id, business_num, store_name, location_id, category, store_phonenum,";
			sql += " store_peoplenum, business_flag, store_img \n";
			sql += "from Store";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StoreDto storeDto = new StoreDto();
				storeDto.setUserId(rs.getNString("user_id"));
				storeDto.setBusinessNum(rs.getString("business_num"));
				storeDto.setStoreName(rs.getString("store_name"));
				storeDto.setLocation(Integer.parseInt(rs.getString("location_id")));
				storeDto.setCategory(Integer.parseInt(rs.getString("category_id")));
				storeDto.setStorePhone(rs.getString("store_phonenum"));
				storeDto.setPeople(rs.getString("store_peoplenum"));
				storeDto.setBusinessFlag(Integer.parseInt(rs.getString("business_flag")));
				storeDto.setStoreImg(rs.getString("store_img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return userList;
	}

	public StoreDto selectUser(String id) {//
		StoreDto storeDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			String sql = "select user_password, user_name, user_phone, user_email, business_num, store_name, "
					+ "location_id, category_id, store_phonenum, store_peoplenum, store_img\n";
			sql += "from rbsuser,store\n";
			sql += "where rbsuser.user_id = store.user_id\n";
			sql += "and rbsuser.user_id = '" + id + "'";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				storeDto = new StoreDto();
				storeDto.setUserId(id);
				storeDto.setBusinessNum(rs.getString("business_num"));
				storeDto.setStoreName(rs.getString("store_name"));
				storeDto.setLocation(Integer.parseInt(rs.getString("location_id")));
				storeDto.setCategory(Integer.parseInt(rs.getString("category_id")));
				storeDto.setStorePhone(rs.getString("store_phonenum"));
				storeDto.setPeople(rs.getString("store_peoplenum"));
				storeDto.setBusinessFlag(Integer.parseInt(rs.getString("business_flag")));
				storeDto.setStoreImg(rs.getString("store_img"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return storeDto;
	}
}