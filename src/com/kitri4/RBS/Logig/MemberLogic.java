package com.kitri4.RBS.Logig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kitri4.RBS.Common.CalendarView;
import com.kitri4.RBS.Common.RBSMain;
import com.kitri4.RBS.Main.Login;
import com.kitri4.RBS.Member.*;

public class MemberLogic implements ActionListener{
	Login login = null;
	MemberAuction memberAuction = null;
	MemberAuctionRegister memberAuctionRegister = null;
	MemberMain memberMain = null;
	MemberInfo memberInfo = null;
	CalendarView calendarView = null;
	
	public MemberLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.memberAuction = rbsMain.memberAuction;
		this.memberAuctionRegister = rbsMain.memberAuctionRegister;
		this.memberMain = rbsMain.memberMain;
		this.memberInfo = rbsMain.memberInfo;
		this.calendarView = rbsMain.calendarView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == memberMain.bidListBtn) {//회원메인
			memberAuction.setVisible(true);
			memberAuction.tabbedPane.setSelectedComponent(memberAuction.ingPn);
			memberMain.setVisible(false);
		} else if (ob == memberMain.addBidBtn) {
			memberAuctionRegister.setVisible(true);
			memberAuctionRegister.tabbedPane.setSelectedComponent(memberAuctionRegister.selPn);
			memberMain.setVisible(false);
		} else if (ob == memberMain.memInfoBtn) {
			memberInfo.setVisible(true);
			memberInfo.tabbedPane.setSelectedComponent(memberInfo.myPn);
			memberMain.setVisible(false);
		}
		
		//회원내역
		else if (ob == memberAuction.bidListViewBtn) {
			guessBidList();
		} else if (ob == memberAuction.startDateCalBtn) {
			calendarView = new CalendarView("Caledar", memberAuction.startDateTf);
			calendarView.setVisible(true);
		} else if (ob == memberAuction.endDateCalBtn) {
			calendarView = new CalendarView("Caledar", memberAuction.endDateTf);
			calendarView.setVisible(true);
		} else if (ob == memberAuction.sixMonthBtn) {
			calendarView.setDayTf(6, memberAuction.startDateTf, memberAuction.endDateTf);
		} else if (ob == memberAuction.threeMonthBtn) {
			calendarView.setDayTf(3, memberAuction.startDateTf, memberAuction.endDateTf);
		} else if (ob == memberAuction.oneMonthBtn) {
			calendarView.setDayTf(1,  memberAuction.startDateTf, memberAuction.endDateTf);
		}
		
		//회원내역탭메인
		else if (ob == memberAuction.bidListBtn) {
			memberAuction.setVisible(false);
			memberAuction.setVisible(true);
			memberAuction.tabbedPane.setSelectedComponent(memberAuction.ingPn);
		} else if (ob == memberAuction.addBidBtn) {
			memberAuctionRegister.setVisible(true);
			memberAuctionRegister.tabbedPane.setSelectedComponent(memberAuctionRegister.selPn);
			memberAuction.setVisible(false);
		} else if (ob == memberAuction.memInfoBtn) {
			memberInfo.setVisible(true);
			memberInfo.tabbedPane.setSelectedIndex(1);
			memberAuction.setVisible(false);
		} 
		
		//회원등록탭메인
		else if (ob == memberAuctionRegister.bidListBtn) {
			memberAuction.setVisible(true);
			memberAuction.tabbedPane.setSelectedComponent(memberAuction.ingPn);
			memberAuctionRegister.setVisible(false);
		} else if (ob == memberAuctionRegister.addBidBtn) {
			memberAuctionRegister.setVisible(false);
			memberAuctionRegister.setVisible(true);
			memberAuctionRegister.tabbedPane.setSelectedComponent(memberAuctionRegister.selPn);
		} else if (ob == memberAuctionRegister.memInfoBtn) {
			memberAuctionRegister.setVisible(false);
			memberInfo.setVisible(true);	
			memberInfo.tabbedPane.setSelectedComponent(memberInfo.myPn);
		} else if (ob == memberAuctionRegister.bidResitBtn) {
			JOptionPane.showConfirmDialog(null, "등록되었습니다.", "등록 확인", JOptionPane.DEFAULT_OPTION);
			memberAuction.setVisible(true);
			memberAuction.tabbedPane.setSelectedComponent(memberAuction.ingPn);
		}
		
		//회원정보탭메인
		else if (ob == memberInfo.bidListBtn) {
			memberAuction.setVisible(true);
			memberAuction.tabbedPane.setSelectedComponent(memberAuction.ingPn);
			memberInfo.setVisible(false);
		} else if (ob == memberInfo.addBidBtn) {
			memberAuctionRegister.setVisible(true);
			memberAuctionRegister.tabbedPane.setSelectedComponent(memberAuctionRegister.selPn);
			memberInfo.setVisible(false);
		} else if (ob == memberInfo.memInfoBtn) {
			memberInfo.setVisible(false);
			memberInfo.setVisible(true);	
			memberInfo.tabbedPane.setSelectedComponent(memberInfo.myPn);
		}
	}
	

	private void guessBidList() {
		// startDateTf, endDateTf를 가져와 between에 있는 bid를 읽어옴
	}

}
