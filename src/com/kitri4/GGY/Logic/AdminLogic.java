package com.kitri4.GGY.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri4.GGY.Admin.AdminGraph;
import com.kitri4.GGY.Admin.AdminMain;
import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Main.Login;

public class AdminLogic implements ActionListener {
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
		//관리자메인
		if (ob == adminMain.auctionManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
			adminMain.setVisible(false);
		} else if (ob == adminMain.userManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(0);
			adminMain.setVisible(false);
		
		
		} else if (ob == adminMain.logoutBtn) {
			adminMain.setVisible(false);
			login.setVisible(true);
			login.idTf.setText("");
			login.pwTf.setText("");
		
		//업주내역
		} else if (ob == adminGraph.calBtn1) {
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
		} else if (ob == adminGraph.homebutton) {
			adminMain.setVisible(true);
			adminGraph.setVisible(false);
		}
	}

}
