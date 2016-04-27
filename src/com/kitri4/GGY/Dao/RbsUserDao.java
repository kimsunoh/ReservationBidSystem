package com.kitri4.GGY.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.UserDto;

public class RbsUserDao {
   
   public int insert(UserDto userDto) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "insert into RBSUSER (user_id, user_password, user_name, user_phone, user_email, user_flag) \n";
         sql += "values ('"+userDto.getUserId()+"', '" +userDto.getUserPassword()+ "', '";
         sql +=  userDto.getUserName() +"', '" + userDto.getUserPassword() + "', ' " + userDto.getUserEmail() + "' , ";
         sql += "'" + userDto.getUserFlag() +"') ";
         
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
         
         String sql = "delete from rbsuser";
         sql += "where id = '" + id + "'";
         
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   public int update(UserDto userDto) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "Update rbsuser ";
         sql += "set User_Password = '" + userDto.getUserPassword() + "', ";
         sql += "User_Name = '" + userDto.getUserName() + "', ";
         sql += "User_Phone = '" + userDto.getUserPhoneNumber() + "', ";         
         sql += "userEmail = '" + userDto.getUserEmail() + "' \n";         
         sql += "where User_id = '" + userDto.getUserId() + "'";
         
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   public ArrayList<UserDto> selectAll() {
      ArrayList<UserDto> userList = new ArrayList<UserDto>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "select User_id, User_Password, User_Name, User_Phone, User_Email, User_Flag \n";
         sql += "from rbsuser";
         
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         while (rs.next()) {
            UserDto userDto = new UserDto();
            userDto.setUserId(rs.getString("User_id"));
            userDto.setUserPassword(rs.getString("User_Password"));
            userDto.setUserName(rs.getString("User_Name"));            
            userDto.setUserPhoneNumber(rs.getString("User_Phone"));            
            userDto.setUserEmail(rs.getString("User_Email"));                        
            userDto.setUserFlag(rs.getString("User_Flag"));                        
            userList.add(userDto);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt, rs);
      }
      
      return userList;
   }
   
   public UserDto select(String id) {
      UserDto userDto = null;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "select User_id, User_Password, User_Name, User_Phone, User_Email, User_Flag \n";
         sql += "from rbsuser \n";
         sql += "where user_Id = '" + id + "'";

         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         if (rs.next()) {
            userDto = new UserDto();
            userDto.setUserId(rs.getString("User_id"));
            userDto.setUserPassword(rs.getString("User_Password"));
            userDto.setUserName(rs.getString("User_Name"));            
            userDto.setUserPhoneNumber(rs.getString("User_Phone"));            
            userDto.setUserEmail(rs.getString("User_Email"));                        
            userDto.setUserFlag(rs.getString("User_Flag"));                        
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt, rs);
      }
      
      return userDto;
   }
   
   public static void main(String[] args) {
      RbsUserDao dao = new RbsUserDao();
      ArrayList<UserDto> userList = dao.selectAll();
      
      if (userList != null)
         for (UserDto user : userList) {
            System.out.println("id : " + user.getUserId() + ",\tname : " + user.getUserName());
         }
      else 
         System.out.println("사용자가 없습니다.");
   }
}