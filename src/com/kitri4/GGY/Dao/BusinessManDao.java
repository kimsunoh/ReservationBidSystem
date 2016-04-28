package com.kitri4.GGY.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.BusinessManDto;;

public class BusinessManDao {
   
   public int insertBusinessManUser(BusinessManDto busUserDto) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "insert into Business_Man (user_id, business_num) \n";
         sql += "value '"+busUserDto.getBusinessNum()+"', '" +busUserDto.getUserId()+ "', '";
         
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
   
   public int updateUser(BusinessManDto businessUserDto) {
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
   
   public ArrayList<BusinessManDto> selectAllBusinessUser() {
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
   
   public BusinessManDto selectUser(String id) {//
      BusinessManDto businessUserDto = null;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "select user_password, user_name, user_phone, user_email, business_num, store_name, "
         		+ "dong_id, category_id, store_phonenum, store_peoplenum, store_img\n";
         sql += "from rbsuser,store\n";
         sql += "where rbsuser.user_id = store.user_id\n";
         sql += "and rbsuser.user_id = '"+id+"'";

         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         if (rs.next()) {
            businessUserDto = new BusinessManDto();
            businessUserDto.setUserId(id);
            businessUserDto.setUserPass(rs.getString("user_password"));
            businessUserDto.setUserName(rs.getString("user_name"));
            businessUserDto.setUserPhone(rs.getString("user_phone"));
            businessUserDto.setUserEmail(rs.getString("user_email"));
            
            businessUserDto.setBusinessNum(rs.getString("business_num"));
            businessUserDto.setStoreName(rs.getString("store_name"));
            businessUserDto.setLocation(rs.getInt("dong_id"));
            businessUserDto.setCategory(rs.getInt("category_id"));
            businessUserDto.setStorePhone(rs.getString("store_phonenum"));
            businessUserDto.setPeople(rs.getString("store_peoplenum"));
            businessUserDto.setStoreImg(rs.getString("store_img"));
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt, rs);
      }
      
      return businessUserDto;
   }
}