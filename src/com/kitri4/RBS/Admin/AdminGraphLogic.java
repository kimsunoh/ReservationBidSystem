package com.kitri4.RBS.Admin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.kitri4.RBS.Common.CalendarView;
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
	Vector<AdminDto> vc=new Vector<AdminDto>();
	
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
public class AdminGraphLogic implements ActionListener{
	AdminGraph ag;
	CalendarView cv;
	
   public AdminGraphLogic(AdminGraph ag){
	  this.ag=ag;
   }
  
   @Override
   public void actionPerformed(ActionEvent e) {
      Object ob = e.getSource();
      AdminDao dao=null;
      if(ob==ag.findBtn){
    	  dao =new AdminDao();
    	  String cal1=ag.calendarTf1.getText();
    	  String cal2=ag.calendarTf2.getText();
    	  dao.find(cal1, cal2);
    	  
      }else if(ob==ag.onemonthBtn){
         
      }else if(ob==ag.threemonthBtn){
         
      }else if(ob==ag.sixmonthBtn){
         
      }else if(ob==ag.calBtn1){
    	  cv=new CalendarView("",ag.calendarTf1);
    	  cv.setVisible(true);
      }else if(ob==ag.calBtn2){
    	  cv=new CalendarView("",ag.calendarTf2);
    	  cv.setVisible(true);
      }else if(ob==ag.adminStasticsBtn){
    	  ag.tabbedPane.setSelectedIndex(1);
      }else if(ob==ag.adminManagerBtn){
    	  ag.tabbedPane.setSelectedIndex(2);
      }      
   }
}
