package com.kitri4.RBS.Member;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {
	protected JButton button;
	private String label;
	private boolean isPushed;
	MemberMain memberMain;
	int row;

	public ButtonEditor(JCheckBox checkBox, MemberMain memberMain) {
		super(checkBox);
		this.memberMain = memberMain;
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(row);

//				memberAuction.memberAuctionList.storetable.storemodel.fireTableDataChanged();
//				MemberAuctionDetail memberAuctionDetail = new MemberAuctionDetail();
//				memberMain.memberAuction.memberAuctionList.add("memberAuctionDetail", memberAuctionDetail);
//				memberMain.memberAuction.memberAuctionList.memberAuctionDetail.revalidate();
//				memberMain.memberAuction.memberAuctionList.memberAuctionDetail.repaint();
				
//				memberAuctionDetail.menutable.row = row;
				memberMain.memberAuctionDetail.menutable.row = row;
				memberMain.memberAuction.memberAuctionList.memberAuctionDetail.revalidate();
				memberMain.memberAuction.memberAuctionList.memberAuctionDetail.repaint();
				memberMain.memberAuction.memberAuctionList.cd.show(memberMain.memberAuction.memberAuctionList, "memberAuctionDetail");
			}
		});
		
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//		if (isSelected) {
//			button.setForeground(table.getSelectionForeground());
//			button.setBackground(table.getSelectionBackground());
//		} else {
//			button.setForeground(table.getForeground());
//			button.setBackground(table.getBackground());
//		}
//		 label = (value ==null) ? "" : value.toString();
//		 button.setText(label);
		this.row = row;
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
			 JOptionPane.showMessageDialog(button ,label + ": Ouch!");
		}
		isPushed = false;
		return new String("");
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}