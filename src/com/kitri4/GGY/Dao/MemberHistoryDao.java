package com.kitri4.GGY.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri4.GGY.Dto.DongDto;
import com.kitri4.GGY.Dto.MemberHistoryDto;

public class MemberHistoryDao {
	
	public ArrayList<MemberHistoryDto> selectEndAuction(String startDate, String endDate, String userId) {
		ArrayList<MemberHistoryDto> auctionSeqList = new ArrayList<MemberHistoryDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();

			String sql = "select to_char(auction_limitedtime, 'yyyy/mm/dd') limited_date, bid_price, store_name, category_id\n";
			sql += "from auction a, bid b, store s \n";
			sql += "where a.auction_seq = b.auction_seq \n";
			sql += "and b.store_id = s.store_id \n";
			sql += "and a.user_id = '" + userId + "' \n";
			sql += "and to_char(auction_limitedtime, 'yyyy/mm/dd') between '" + startDate + "' and '" + endDate + "' \n";
			//sql += "and b.bid_flag = 1 ";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberHistoryDto memberHistoryDto = new MemberHistoryDto();
				memberHistoryDto.setAuctionLimitedTime(rs.getString("limited_date"));
				memberHistoryDto.setAuctionPrice(Integer.parseInt(rs.getString("bid_price")));
				memberHistoryDto.setCategoryId(Integer.parseInt(rs.getString("category_id")));
				memberHistoryDto.setStoreName(rs.getString("store_name"));
				auctionSeqList.add(memberHistoryDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return auctionSeqList;
	}
	
	public static void main(String[] args) {
		ArrayList<MemberHistoryDto> auctionSeqList = new MemberHistoryDao().selectEndAuction("2016/04/01", "2016/04/30", "jwkim");
		for(int i = 0 ; i < auctionSeqList.size() ; i++) {
			System.out.println(auctionSeqList.get(i).getAuctionLimitedTime() + ", " + auctionSeqList.get(i).getAuctionPrice() + ", " + auctionSeqList.get(i).getStoreName()
								+ ", " + auctionSeqList.get(i).getCategoryId());
		}
	}
}
