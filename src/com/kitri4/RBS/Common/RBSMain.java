package com.kitri4.RBS.Common;

import java.awt.Dialog;
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
	BSMenuList bsMenuList;

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
		bsMain = new BSMain();
		bsAuction = new BSAuction();
		bsBidRegister = new BSBidRegister();
		bsMenuList = new BSMenuList();
		bsInfo = new BSInfo();
		
		memberJoin = new MemberJoin("MemberJoin");
		memberMain = new MemberMain();
		memberAuction = new MemberAuction("MemberAuction");
		memberAuctionRegister = new MemberAuctionRegister();
		memberInfo = new MemberInfo();
				
		adminMain = new AdminMain();
		adminGraph = new AdminGraph();
		
		calendarView = new CalendarView();
				
		// Login창 이벤트등록
		login.loginBtn.addActionListener(this);
		login.joinBtn.addActionListener(this);

		// bsMemberJoin창 이벤트등록
		bsMemberJoin.bsJoinBtn.addActionListener(this);
		bsMemberJoin.checkIdBtn.addActionListener(this);
		bsMemberJoin.cancleBtn.addActionListener(this);

		// MemberJoin창 이벤트등록
		memberJoin.checkIdBtn.addActionListener(this);
		memberJoin.memJoinBtn.addActionListener(this);
		memberJoin.cancleBtn.addActionListener(this);

		// MemberAuction
		memberAuction.bidListViewBtn.addActionListener(this);
		memberAuction.startDateCalBtn.addActionListener(this);
		memberAuction.endDateCalBtn.addActionListener(this);
		memberAuction.sixMonthBtn.addActionListener(this);
		memberAuction.threeMonthBtn.addActionListener(this);
		memberAuction.oneMonthBtn.addActionListener(this);
		memberAuction.bidListBtn.addActionListener(this);
		memberAuction.addBidBtn.addActionListener(this);
		memberAuction.memInfoBtn.addActionListener(this);
		
		//MemberAuctionRegister
		memberAuctionRegister.bidListBtn.addActionListener(this);
		memberAuctionRegister.addBidBtn.addActionListener(this);
		memberAuctionRegister.memInfoBtn.addActionListener(this);
		memberAuctionRegister.bidResitBtn.addActionListener(this);

		// MemberMain
		memberMain.addBidBtn.addActionListener(this);
		memberMain.bidListBtn.addActionListener(this);
		memberMain.memInfoBtn.addActionListener(this);
		
		//MemberInfo
		memberInfo.addBidBtn.addActionListener(this);
		memberInfo.bidListBtn.addActionListener(this);
		memberInfo.memInfoBtn.addActionListener(this);

		// BSMain
		bsMain.bidListBtn.addActionListener(this);
		bsMain.InfoBtn.addActionListener(this);
		bsMain.storeMenuBtn.addActionListener(this);

		// AdminMain
		adminMain.auctionManagBtn.addActionListener(this);
		adminMain.userManagBtn.addActionListener(this);
		
		//AdminGraph
		adminGraph.auctionAdjBtn.addActionListener(this);
		adminGraph.bidListViewBtn.addActionListener(this);
		adminGraph.oneMonthBtn.addActionListener(this);
		adminGraph.threeMonthBtn.addActionListener(this);
		adminGraph.sixMonthBtn.addActionListener(this);
		adminGraph.startDateBtn.addActionListener(this);
		adminGraph.endDateBtn.addActionListener(this);
		adminGraph.userAdjBtn.addActionListener(this);
		
		//BSAuction
		bsAuction.endStartDateBtn.addActionListener(this);
		bsAuction.endEndDateBtn.addActionListener(this);
		bsAuction.storeMenuBtn.addActionListener(this);
		bsAuction.bidListBtn.addActionListener(this);
		bsAuction.storeMenuBtn.addActionListener(this);
		bsAuction.infoBtn.addActionListener(this);
		bsAuction.sixMonthBtn.addActionListener(this);
		bsAuction.threeMonthBtn.addActionListener(this);
		bsAuction.oneMonthBtn.addActionListener(this);
		
		//BSMenulist
		bsMenuList.bidListBtn.addActionListener(this);
		bsMenuList.storeMenuBtn.addActionListener(this);
		bsMenuList.infoBtn.addActionListener(this);
		
		//BSInfo
		bsInfo.bidListBtn.addActionListener(this);
		bsInfo.storeMenuBtn.addActionListener(this);
		bsInfo.infoBtn.addActionListener(this);
		bsInfo.renameBtn.addActionListener(this);
		bsInfo.secessionBtn.addActionListener(this);
		
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob.equals(login.joinBtn)) {//메인
			if (JOptionPane.showConfirmDialog(null, "일반회원입니까? \n업주회원은 No를 눌러주세요.", "회원유형선택",
					JOptionPane.YES_NO_OPTION) == 0) {
				memberJoin.setVisible(true);
			} else {
				bsMemberJoin.setVisible(true);
			}
			login.setVisible(false);
		} else if (ob == login.loginBtn) {//로그인
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
		} else if (ob == memberMain.bidListBtn) {//회원메인
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
		} else if (ob == bsMain.bidListBtn) {//업주메인
			bsAuction.setVisible(true);
			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == bsMain.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.InfoBtn) {
			bsInfo.setVisible(true);
			bsInfo.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == adminMain.auctionManagBtn) {//관리자메인
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(2);
			adminMain.setVisible(false);
		} else if (ob == adminMain.userManagBtn) {
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
			adminMain.setVisible(false);
		} else if (ob == bsAuction.endStartDateBtn) {//업주내역
			calendarView.setVisible(true);
		} else if (ob.equals(bsMemberJoin.bsJoinBtn)) {//회원가입
			JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			bsMemberJoin.setVisible(false);
		} else if (ob == bsMemberJoin.checkIdBtn) {//업주회원가입
			checkId(bsMemberJoin.idTf.getText());
		} else if (ob == memberJoin.checkIdBtn) {
			checkId(memberJoin.idTf.getText());
		} else if (ob == memberJoin.memJoinBtn) {
			JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} else if (ob == memberJoin.cancleBtn) {
			JOptionPane.showConfirmDialog(null, "취소할까요?", "취소", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} else if (ob == memberJoin.cancleBtn) {
			JOptionPane.showConfirmDialog(null, "취소할까요?", "취소", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} else if (ob == memberAuction.bidListViewBtn) {//회원내역
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
		} else if (ob == bsAuction.endStartDateBtn) {//업주내역
			calendarView.setVisible(true);
		} else if (ob == bsAuction.endEndDateBtn) {
			calendarView.setVisible(true);
		} else if (ob == bsAuction.sixMonthBtn) {
			setDayTf(6);
		} else if (ob == bsAuction.threeMonthBtn) {
			setDayTf(3);
		} else if (ob == bsAuction.oneMonthBtn) {
			setDayTf(1);
		} else if (ob == bsAuction.bidListBtn) {//업주내역탭메인
			bsAuction.setVisible(false);
			bsAuction.setVisible(true);
			bsAuction.tabbedPane.setSelectedIndex(1);
		} else if (ob == bsAuction.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMenuList.tabbedPane.setSelectedIndex(1);
			bsAuction.setVisible(false);
		} else if (ob == bsAuction.infoBtn) {
			bsInfo.setVisible(true);
			bsInfo.tabbedPane.setSelectedIndex(1);
			bsAuction.setVisible(false);
		} else if (ob == bsMenuList.bidListBtn) {//업주메뉴탭메인
			bsAuction.setVisible(true);
			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMenuList.setVisible(false);
		} else if (ob == bsMenuList.storeMenuBtn) {
			bsMenuList.setVisible(false);
			bsMenuList.setVisible(true);
			bsMenuList.tabbedPane.setSelectedIndex(1);
		} else if (ob == bsMenuList.infoBtn) {
			bsInfo.setVisible(true);
			bsInfo.tabbedPane.setSelectedIndex(1);
			bsMenuList.setVisible(false);
		} else if (ob == bsInfo.bidListBtn) {//업주정보탭메인
			bsAuction.setVisible(true);
			bsAuction.tabbedPane.setSelectedIndex(1);
			bsInfo.setVisible(false);
		} else if (ob == bsInfo.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMenuList.tabbedPane.setSelectedIndex(1);
			bsInfo.setVisible(false);
		} else if (ob == bsInfo.infoBtn) {
			bsInfo.setVisible(false);
			bsInfo.setVisible(true);
			bsInfo.tabbedPane.setSelectedIndex(1);
		} else if (ob == bsInfo.renameBtn) {
			JOptionPane.showConfirmDialog(null, "수정되었습니다.", "수정 확인", JOptionPane.DEFAULT_OPTION);
			bsMain.setVisible(true);
		} else if (ob == bsInfo.secessionBtn) {
			JOptionPane.showConfirmDialog(null, "탈퇴되었습니다.", "탈퇴 확인", JOptionPane.DEFAULT_OPTION);
			bsInfo.setVisible(false);
			login.setVisible(true);
			login.idTf.setText("");
		} else if (ob == memberAuction.bidListBtn) {//회원내역탭메인
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
		} else if (ob == memberAuctionRegister.bidListBtn) {//회원등록탭메인
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
		} else if (ob == memberInfo.bidListBtn) {//회원정보탭메인
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
		} else if (ob == adminGraph.auctionAdjBtn) {//관리자탭메인
			adminGraph.setVisible(false);
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(1);
		} else if (ob == adminGraph.userAdjBtn) {
			adminGraph.setVisible(false);
			adminGraph.setVisible(true);
			adminGraph.tabbedPane.setSelectedIndex(2);
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
		bsAuction.endEndDateTf.setText(year + "/" + month + "/" + day);

		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		} else {
			month -= gapMonth;
		}
		memberAuction.startDateTf.setText(year + "/" + month + "/" + day);
		bsAuction.endStartDateTf.setText(year + "/" + month + "/" + day);
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
