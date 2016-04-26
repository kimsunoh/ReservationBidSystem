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
                        "'"+menuDto.getMenuPictureAdress()+"')";          
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   public int delete(String menuName) {// delete 삭제 되는거 확인.
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
         sql += "menu_picture_path = '"+menuDto.getMenuPictureAdress()+"'"; 
         
         stmt = conn.createStatement();
         cnt = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBClose.close(conn, stmt);
      }
      
      return cnt;
   }
   
   public ArrayList<MenuDto> list(){
      ArrayList<MenuDto> list=new  ArrayList<MenuDto>();
      MenuDto dto=null;
      Connection conn=null;
      Statement stmt =null;
      ResultSet rs=null;
      
      try {
         conn=DBConnection.makeConnection();
         String sql="";
         sql+="select menu_name,menu_price,menu_picture_path \n";
         sql+="from menu  \n";
         
         System.out.println(sql);
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
         while(rs.next()){
            
            dto.setMenuName(rs.getString("menu_name"));
            dto.setMenuprice(rs.getString("menu_price"));
            //dto.setMenuPicturePath(rs.getClass().getResource("menu_picture_path"));
            list.add(dto);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {      
         DBClose.close(conn, stmt, rs);
      }
      
      return list;
   }
   
   
   
}