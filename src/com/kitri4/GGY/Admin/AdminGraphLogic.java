package com.kitri4.GGY.Admin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Dao.AdminDao;
import com.kitri4.GGY.Dto.AdminDto;
//버튼 렌더를 해주는 클래스
class ButtonRenderer extends JButton implements TableCellRenderer {
	JButton button = new JButton();
	public String label;
	public boolean isPushed=false;

	public ButtonRenderer() {
		setOpaque(true);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
			setText((value == null) ? "등록" : value.toString());
		return this;
	}
}
//버튼 클릭시 처리해주는 클래스
class ButtonEditor extends DefaultCellEditor{
	public JButton button;
	public String label;
	public boolean isPushed;
	public Object str;
	public int row;
	public int column;
	AdminGraph ag;
	AdminDto dto;
	
	public ButtonEditor(JComboBox comboBox,AdminGraph ag) {
		super(comboBox);
		this.ag =ag;
		button =new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rowLocation();
				JOptionPane.showMessageDialog(button,"등록하시겠습니까?","등록확인창",JOptionPane.OK_CANCEL_OPTION);
				fireEditingStopped();
				System.out.println("selected row num : "+row);
			}
		});	
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		button.setText("등록");
		return button;
	}
	public int rowLocation(){
		row =ag.BsRegisterTable.getSelectedRow();
		return row;
	}
}
public class AdminGraphLogic implements ActionListener, ChangeListener{
	AdminGraph ag;
	AdminMain am;
	ArrayList<AdminDto> list;
	AdminDto dto;
	CalendarView cv;
	
   public AdminGraphLogic(AdminGraph ag){
	  this.ag=ag;
	  ag.findBtn.addActionListener(this);
	  ag.onemonthBtn.addActionListener(this);
	  ag.threemonthBtn.addActionListener(this);
	  ag.sixmonthBtn.addActionListener(this);
	  ag.calBtn1.addActionListener(this);
	  ag.calBtn2.addActionListener(this);
	  ag.tabbedPane.addChangeListener(this);
   }
   
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		AdminDao dao = null;
		ArrayList<AdminDto>list=null;
		if (ob == ag.findBtn) {
			dao = new AdminDao();
			list = new ArrayList<AdminDto>();
			String cal1 = ag.calendarTf1.getText();
			String cal2 = ag.calendarTf2.getText();
			list=dao.find(cal1, cal2);
			dto=list.get(0);
			ag.resgisterTf.setText(dto.getAuctionNum()+"");
			ag.bidTf.setText(dto.getBidNum()+"");
		} else if (ob == ag.onemonthBtn) {
			setDayTf(1);
			monthBtnInquiry("1");
		} else if (ob == ag.threemonthBtn) {
			setDayTf(3);
			monthBtnInquiry("3");
		} else if (ob == ag.sixmonthBtn) {
			setDayTf(6);
			monthBtnInquiry("6");
		} else if (ob == ag.calBtn1) {
			cv = new CalendarView("", ag.calendarTf1);
			cv.setVisible(true);
		} else if (ob == ag.calBtn2) {
			cv = new CalendarView("", ag.calendarTf2);
			cv.setVisible(true);
		} 
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		AdminDao dao = null;
		ArrayList<AdminDto> list =new ArrayList<AdminDto>();
		int tabnum = ag.tabbedPane.getSelectedIndex();
		if(tabnum == 1){
			DefaultTableModel model =(DefaultTableModel)ag.BsRegisterTable.getModel();
			model.setNumRows(0);
			dao = new AdminDao();
			list = dao.list();
			int size = list.size();
			for (int i = 0; i < size; i++) {
				dto = list.get(i);
				ag.BsRegisterTable.getColumnModel().getColumn(1).setPreferredWidth(20);
				ag.BsRegisterTable.getColumnModel().getColumn(3).setPreferredWidth(10);
				ag.model.addRow(new Object[]{ dto.getStoreName(), dto.getBusinessName(), dto.getBusinessNum()});
				for (int j = 0; j < ag.BsRegisterTable.getRowCount(); j++) {
					ag.BsRegisterTable.setRowHeight(j, 23);
				}
			}
		}
	}
	public void monthBtnInquiry(String num) {
		AdminDao dao;
		dao = new AdminDao();
		list=dao.auctionCount("1");
		int size=list.size();
		for (int i = 0; i < size; i++) {
			dto=list.get(i);
			ag.resgisterTf.setText(dto.getAuctionNum()+"");
			ag.bidTf.setText(dto.getBidNum()+"");
		}
	}
	
	public void setDayTf(int gapMonth) {
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		ag.calendarTf2.setText(year + "/" + month + "/" + day);
		
		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		} else {
			month -= gapMonth;
		}
		ag.calendarTf1.setText(year + "/" + month + "/" + day);
	}

}
