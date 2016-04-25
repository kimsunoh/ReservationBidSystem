package com.kitri4.GGY.Dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.kitri4.GGY.Dao.DBClose;
import com.kitri4.GGY.Dao.DBConnection;
import com.kitri4.GGY.Dto.MenuDto;

public class MenuDao {
	
   public int insert(MenuDto menuDto) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
    
      try {
         conn = DBConnection.makeConnection();
         
         String sql = "insert into Menu (menu_id, store_id, menu_name, menu_price,menu_contents,menu_picture_path) \n";
         sql += "values ('"+menuDto.getMenuId()+"'," +
        		 		   menuDto.getStoreId()+ ",'"+
        		 		   menuDto.getMenuName()+"','"+
        		 		   "'"+menuDto.getMenuprice()+"','"+
        		 		   "'"+menuDto.getMenucontents()+"','"+
        		 		   "'"+menuDto.getMenuPicturePath()+"')";          
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   public int delete(String menuName) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBConnection.makeConnection();
         
        String sql = "delete from menu \n";        
		sql += "where menu_name = '" + menuName + "'";
         
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   
   public int update(MenuDto menuDto) {
      int cnt = 0;
      Connection conn = null;
      Statement stmt = null;
      
      try {
         conn = DBConnection.makeConnection();
       
         String sql = "Update menu ";
         sql += "set menu_id = '" + menuDto.getMenuId() + "', ";
         sql += "store_id = "+menuDto.getStoreId()+ ",";
         sql += "menu_name = '"+menuDto.getMenuName()+"'";    
         sql += "menu_price = '"+menuDto.getMenuprice()+"'";        
         sql += "menu_contents = '"+menuDto.getMenucontents()+"'";
         sql += "menu_picture_path = '"+menuDto.getMenuPicturePath()+"'"; 
         
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   
   
}