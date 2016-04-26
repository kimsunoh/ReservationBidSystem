package com.kitri4.GGY.BSMember;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;

import com.kitri4.GGY.Dao.MenuDao;
import com.kitri4.GGY.Dto.MenuDto;

public class BSMenuListLogic  {
	
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	JButton button = new JButton("수정");
	public String label;
	public boolean isPushed;

	public ButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable ingAuctionTable, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		setText((value == null) ? "수정" : value.toString());
		return this;
	}
}

class ButtonEditor extends DefaultCellEditor {

	BSMenuList bsmenulist;
	int row = 0;
	protected JButton button;
	private String label;
	private boolean isPushed;

	public ButtonEditor(JComboBox comboBox, BSMenuList bsmenulist) {
		super(comboBox);
		this.bsmenulist = bsmenulist;
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				System.out.println(row + "번째테이블");
				bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_3);
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.row = row;
		return button;
	}

}
