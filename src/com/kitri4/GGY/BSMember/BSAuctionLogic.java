package com.kitri4.GGY.BSMember;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Dao.DBClose;
import com.kitri4.GGY.Dao.DBConnection;

public class BSAuctionLogic{
	public static BSBidRegister bsBidRegister = new BSBidRegister();
	String str[] = new String[3];
	BSAuctionDto bsAutionDto = new BSAuctionDto();

	public BSAuctionLogic(BSAuction bsauction) {
		/*
		 * Connection c=null; Statement s=null; ResultSet rs=null;
		 * 
		 * try { c = DBConnection.makeConnection(); String sql =
		 * "select r.user_id, auction_date, bid_price\nfrom rbsuser r,auction,bid"
		 * ; sql+="where r.user_id=auction.user_id\n"; sql+=
		 * "and auction.auction_seq=bid.auction_seq"; s = c.createStatement();
		 * rs = s.executeQuery(sql); while (rs.next()) { str[0] =
		 * rs.getString("user_id"); str[1] = rs.getString("auction_date");
		 * str[2] = rs.getString("bid_price"); bsauction.model.addRow(str); } }
		 * catch (SQLException e) { e.printStackTrace(); } finally {
		 * DBClose.close(c, s, rs); }
		 */

	}
	
	public static class ButtonRenderer2 extends JButton implements TableCellRenderer {
		JButton button = new JButton();
		public String label;
		public boolean isPushed;

		public ButtonRenderer2() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable ingAuctionTable, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			// TODO Auto-generated method stub
			setText((value == null) ? "?���?" : value.toString());
			return this;
		}
	}

	public static class ButtonEditor2 extends DefaultCellEditor {
		protected JButton button;
		private String label;
		private boolean isPushed;

		public ButtonEditor2(JComboBox comboBox) {
			super(comboBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					// setVisible(false);
					bsBidRegister.setVisible(true);
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			button.setText("?���?");
			return button;
		}

	}

}
