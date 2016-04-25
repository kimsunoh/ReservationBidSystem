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

public class BSMenuListLogic implements ActionListener {
	BSMenuList bsmenulist;

	MenuDao menudao = new MenuDao();
	MenuDto menudto = null;

	public BSMenuListLogic(BSMenuList bsmenulist) {
		this.bsmenulist = bsmenulist;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == bsmenulist.menuAddBtn) {
			// �ű� �޴� ��� ��ư

			bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_3);

		} else if (ob == bsmenulist.openPicturBtn) {
			// ���� �ҷ�����
			// ����

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(BMP,JPEG,PNG, extensions)", "bmp",
					"jpg", "png");
			bsmenulist.fc.setDialogTitle("image �� �����ϼ���");
			bsmenulist.fc.setFileFilter(filter);
			bsmenulist.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			if (bsmenulist.fc.showOpenDialog(bsmenulist.fileOpen) == JFileChooser.APPROVE_OPTION) {
				bsmenulist.Seepicture.setText("");
				File saveFile = bsmenulist.fc.getSelectedFile(); // ���� ����� ����
																	// �ƹ��͵�
																	// ���ϰ�����.
				String filename = bsmenulist.fc.getSelectedFile().getAbsolutePath(); // ���
																						// ����
				ImageIcon imageicon = new ImageIcon(filename); // ��η� �̹��������ܻ���
				Image image = imageicon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH); // ����������
				bsmenulist.Seepicture.setIcon(new ImageIcon(image));// Seepicture
																	// �󺧿� �̹���
																	// �Ѹ���
			} else {
				// ��� ��ư�� ������
				bsmenulist.Seepicture.setIcon(new ImageIcon());
				bsmenulist.Seepicture.setText("������ ���� ���߽��ϴ�");
			}
		} else if (ob == bsmenulist.addMenuBtn) {// ���

			String menuName = bsmenulist.menuNameTf.getText();
			String menuPrice = bsmenulist.priceTf.getText();
			String menuInformation = bsmenulist.menuInfoTf.getText();

			bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);

		} else if (ob == bsmenulist.renameMenuBtn) {// ����

			String menuName = bsmenulist.menuNameTf.getText();
			String menuPrice = bsmenulist.priceTf.getText();
			String menuInformation = bsmenulist.menuInfoTf.getText();
			bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);

		} else if (ob == bsmenulist.removeMenuBtn) {// ������ư

			bsmenulist.dialog.setTitle("���� �Ͻðڽ��ϱ�?");
			bsmenulist.dialog.setSize(200, 80);
			bsmenulist.dialog.setLocation(900, 500);
			bsmenulist.dialog.setVisible(true);
		} else if (e.getSource() == bsmenulist.okBtn) {
			bsmenulist.dialog.dispose();
			/*
			 * 0422 �����ҽ�
			 * 
			 */
			String menuName = bsmenulist.menuNameTf.getText();

			menudao.delete(menuName);

			// ���� Source �ʿ�
			bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);
		} else if (e.getSource() == bsmenulist.cancleBtn) {
			bsmenulist.dialog.dispose();
		}

	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	JButton button = new JButton("����");
	public String label;
	public boolean isPushed;

	public ButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable ingAuctionTable, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		setText((value == null) ? "����" : value.toString());
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
				System.out.println(row + "��°���̺�");
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
