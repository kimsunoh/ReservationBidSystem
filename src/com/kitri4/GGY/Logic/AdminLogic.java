package com.kitri4.GGY.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.kitri4.GGY.Admin.AdminGraph;
import com.kitri4.GGY.Admin.AdminMain;
import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dao.AdminDao;
import com.kitri4.GGY.Dto.AdminDto;
import com.kitri4.GGY.Main.Login;

public class AdminLogic implements ActionListener {
	Login login = null;
	AdminMain adminMain = null;
	AdminGraph adminGraph = null;
	ArrayList<AdminDto> list;
	AdminDto dto;
	CalendarView calendarView = null;

	public AdminLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.adminMain = rbsMain.adminMain;
		this.adminGraph = rbsMain.adminGraph;
		this.calendarView = rbsMain.calendarView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		AdminDao dao = null;
		//�����ڸ���
		if (ob == adminMain.auctionManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
			adminMain.setVisible(false);
		} else if (ob == adminMain.userManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(0);
			adminMain.setVisible(false);		
		//���ֳ���
		} else if (ob == adminGraph.calBtn1) {
			calendarView = new CalendarView("Caledar", adminGraph.calendarTf1);
			calendarView.setVisible(true);
		} else if (ob == adminGraph.calBtn2) {
			calendarView = new CalendarView("Caledar", adminGraph.calendarTf2);
			calendarView.setVisible(true);
		} else if (ob == adminGraph.homebutton) {
			adminMain.setVisible(true);
			adminGraph.setVisible(false);	
		} 
	}
}
