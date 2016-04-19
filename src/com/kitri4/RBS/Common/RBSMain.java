package com.kitri4.RBS.Common;

import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.kitri4.RBS.Admin.*;
import com.kitri4.RBS.BSMember.*;
import com.kitri4.RBS.Main.*;
import com.kitri4.RBS.Member.*;

public class RBSMain implements ActionListener {
	Login login;

	BSMemberJoin bsMemberJoin;
	BSAuction bsAuction;
	BSMain bsMain;
	BSInfo bsInfo;
	BSBidRegister bsBidRegister;

	MemberJoin memberJoin;
	MemberAuction memberAuction;
	MemberMain memberMain;
	MemberInfo memberInfo;
	MemberAuctionRegister memberAuctionRegister;

	CalendarView calendarView;

	AdminMain adminMain;
	AdminGraph adminGraph;

	public RBSMain() {
		login = new Login("Login");
		
		bsMemberJoin = new BSMemberJoin("BSMemberJoin");
		memberJoin = new MemberJoin("MemberJoin");
		memberAuction = new MemberAuction("MemberAuction");
		bsAuction = new BSAuction("BSAuction");
		adminMain = new AdminMain();
		memberAuctionRegister = new MemberAuctionRegister();
		memberInfo = new MemberInfo();
		bsInfo = new BSInfo();
		bsMain = new BSMain();
		memberMain = new MemberMain();
		calendarView = new CalendarView();
		bsBidRegister = new BSBidRegister();
		adminGraph = new AdminGraph();
		adminMain = new AdminMain();
		
		WindowListener wl = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("꺼지나?");
				bsMemberJoin.setVisible(false);
				bsAuction.setVisible(false);
				bsInfo.setVisible(false);
				bsMain.setVisible(false);
				bsBidRegister.setVisible(false);

				memberMain.setVisible(false);
				memberJoin.setVisible(false);
				memberAuction.setVisible(false);
				memberAuctionRegister.setVisible(false);
				memberInfo.setVisible(false);

				adminMain.setVisible(false);
				calendarView.setVisible(false);
				adminGraph.setVisible(false);
				
				login.setVisible(true);
			}
		};

		// Login창 이벤트등록
		login.loginBtn.addActionListener(this);
		login.joinBtn.addActionListener(this);

		// bsMemberJoin창 이벤트등록
		bsMemberJoin.bsJoinBtn.addActionListener(this);
		bsMemberJoin.checkIdBtn.addActionListener(this);
		bsMemberJoin.addWindowListener(wl);

		// MemberJoin창 이벤트등록
		memberJoin.checkIdBtn.addActionListener(this);
		memberJoin.memJoinBtn.addActionListener(this);
		memberJoin.addWindowListener(wl);

		// MemberAction
		memberAuction.bidListViewBtn.addActionListener(this);
		memberAuction.startDateCalBtn.addActionListener(this);
		memberAuction.endDateCalBtn.addActionListener(this);
		memberAuction.sixMonthBtn.addActionListener(this);
		memberAuction.threeMonthBtn.addActionListener(this);
		memberAuction.oneMonthBtn.addActionListener(this);
		memberAuction.addWindowListener(wl);

		// MemberMain
		memberMain.addBidBtn.addActionListener(this);
		memberMain.bidListBtn.addActionListener(this);
		memberMain.memInfoBtn.addActionListener(this);
		memberMain.addWindowListener(wl);

		// BSMain
		bsMain.bidListBtn.addActionListener(this);
		bsMain.InfoBtn.addActionListener(this);
		bsMain.storeMenuBtn.addActionListener(this);
		bsMain.addWindowListener(wl);

		// AdminMain
		adminMain.auctionManagBtn.addActionListener(this);
		adminMain.userManagBtn.addActionListener(this);
		adminMain.addWindowListener(wl);
		
		//AdminGraph
		adminGraph.auctionAdjBtn.addActionListener(this);
		adminGraph.bidListViewBtn.addActionListener(this);
		adminGraph.oneMonthBtn.addActionListener(this);
		adminGraph.threeMonthBtn.addActionListener(this);
		adminGraph.sixMonthBtn.addActionListener(this);
		adminGraph.startDateBtn.addActionListener(this);
		adminGraph.endDateBtn.addActionListener(this);
		adminGraph.userAdjBtn.addActionListener(this);
		
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob.equals(login.joinBtn)) {
			if (JOptionPane.showConfirmDialog(null, "일반회원입니까? \n업주회원은 No를 눌러주세요.", "회원유형선택",
					JOptionPane.YES_NO_OPTION) == 0) {
				memberJoin.setVisible(true);
			} else {
				bsMemberJoin.setVisible(true);
			}
			login.setVisible(false);
		} else if (ob == login.loginBtn) {
			if (login.idTf.getText().equals("회원")) {
				memberMain.setVisible(true);
				login.setVisible(false);
			} else if (login.idTf.getText().equals("업주")) {
				bsMain.setVisible(true);
				login.setVisible(false);
			} else if (login.idTf.getText().equals("관리자")) {
				adminMain.setVisible(true);
				login.setVisible(false);
			}
		} else if (ob == memberMain.bidListBtn) {
			memberAuction.setVisible(true);
			memberAuction.tabbedPane.setSelectedComponent(memberAuction.ingPn);
			memberMain.setVisible(false);
		} else if (ob == memberMain.addBidBtn) {
			memberAuctionRegister.setVisible(true);
			memberAuctionRegister.tabbedPane.setSelectedComponent(memberAuctionRegister.selPn);
			memberMain.setVisible(false);
		} else if (ob == memberMain.memInfoBtn) {
			memberInfo.setVisible(true);
			memberMain.setVisible(false);
		} else if (ob == bsMain.bidListBtn) {
			bsAuction.setVisible(true);
			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == bsMain.storeMenuBtn) {
			bsBidRegister.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.InfoBtn) {
			bsInfo.setVisible(true);
			bsInfo.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == adminMain.auctionManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
			adminMain.setVisible(false);
		} else if (ob == adminMain.userManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
			adminMain.setVisible(false);
		} else if (ob == adminMain.auctionManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(2);
			adminMain.setVisible(false);
		}else if (ob == bsAuction.endStartDateBtn) {
			calendarView.setVisible(true);
		}else if (ob.equals(bsMemberJoin.bsJoinBtn)) {
			JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			bsMemberJoin.setVisible(false);
		} else if (ob == bsMemberJoin.checkIdBtn) {
			checkId(bsMemberJoin.idTf.getText());
		} else if (ob == memberJoin.checkIdBtn) {
			checkId(memberJoin.idTf.getText());
		} else if (ob == memberJoin.memJoinBtn) {
			JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} else if (ob == memberAuction.bidListViewBtn) {
			guessBidList();
		} else if (ob == memberAuction.startDateCalBtn) {
			memberAuction.startDateTf.setText("");
			calendarView.setVisible(true);
		} else if (ob == memberAuction.endDateCalBtn) {
			calendarView.setVisible(true);
		} else if (ob == memberAuction.sixMonthBtn) {
			setDayTf(6);
		} else if (ob == memberAuction.threeMonthBtn) {
			setDayTf(3);
		} else if (ob == memberAuction.oneMonthBtn) {
			setDayTf(1);
		}
	}

	private void guessBidList() {
		// startDateTf, endDateTf를 가져와 between에 있는 bid를 읽어옴
	}

	private void setDayTf(int gapMonth) {
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		memberAuction.endDateTf.setText(year + "/" + month + "/" + day);

		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		} else {
			month -= gapMonth;
		}
		memberAuction.startDateTf.setText(year + "/" + month + "/" + day);
	}

	private void checkId(String setId) {
		if (setId.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "아이디는 공백일수 없습니다.", "아이디 오류", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(null, "사용할 수 있는 아이디입니다.", "아이디 확인", JOptionPane.DEFAULT_OPTION);
		}
	}

	public static void main(String[] args) {
		new RBSMain();
	}
}
