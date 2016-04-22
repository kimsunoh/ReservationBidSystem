package com.kitri4.RBS.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri4.RBS.Admin.AdminGraph;
import com.kitri4.RBS.Admin.AdminMain;
import com.kitri4.RBS.Common.CalendarView;
import com.kitri4.RBS.Common.RBSMain;
import com.kitri4.RBS.Main.Login;

public class AdminLogic implements ActionListener{
	Login login = null;
	AdminMain adminMain = null;
	AdminGraph adminGraph = null;
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
		
		if (ob == adminMain.auctionManagBtn) {//관리자메인
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(2);
			adminMain.setVisible(false);
		} else if (ob == adminMain.userManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
			adminMain.setVisible(false);
		} else if (ob == adminGraph.calBtn1) {//업주내역
			calendarView = new CalendarView("Caledar", adminGraph.calendarTf1);
			calendarView.setVisible(true);
		} else if (ob == adminGraph.calBtn2) {
			calendarView = new CalendarView("Caledar", adminGraph.calendarTf2);
			calendarView.setVisible(true);
		} else if (ob == adminGraph.sixmonthBtn) {
			calendarView.setDayTf(6,  adminGraph.calendarTf1, adminGraph.calendarTf2);
		} else if (ob == adminGraph.threemonthBtn) {
			calendarView.setDayTf(3, adminGraph.calendarTf1, adminGraph.calendarTf2);
		} else if (ob == adminGraph.onemonthBtn) {
			calendarView.setDayTf(1, adminGraph.calendarTf1, adminGraph.calendarTf2);
		}
	}

}
