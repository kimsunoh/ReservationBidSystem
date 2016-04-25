package com.kitri4.GGY.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.kitri4.GGY.BSMember.*;
import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Main.Login;

public class BSMemberLogic implements ActionListener{
	Login login = null;
	BSMain bsMain = null;
	BSAuction bsAuction = null;
	BSAuctionHistory bsAuctionHistory = null;
	BSAuctionLogic bsAuctionLogic = null;
	BSMenuList bsMenuList = null;
	BSInfo bsInfo = null;
	CalendarView calendarView = null;
	BSBidRegister bsBidRegister = null;
	
	public BSMemberLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.bsMain = rbsMain.bsMain;
		this.bsAuction = rbsMain.bsAuction;
		this.bsAuctionLogic = rbsMain.bsAuctionLogic;
	//	this.bsAuctionHistory = rbsMain.bsAuctionHistory;
		this.bsMenuList = rbsMain.bsMenuList;
		this.bsInfo = rbsMain.bsInfo;
		this.calendarView = rbsMain.calendarView;
		this.bsBidRegister = rbsMain.bsBidRegister;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		//업주메인
		if (ob == bsMain.bidListBtn) {
			bsAuction.setVisible(true);
//			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == bsMain.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.InfoBtn) {
			bsInfo.setVisible(true);
//			bsInfo.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} 
		//업주내역탭메인
		else if (ob == bsAuction.homebutton) {
			bsAuction.setVisible(false);
			bsMain.setVisible(true);
		} else if (ob == bsAuction.ingStartDateBtn) {
			calendarView = new CalendarView("", bsAuction.ingStartDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.ingEndDateBtn) {
			calendarView = new CalendarView("", bsAuction.ingEndDateTf);
			calendarView.setVisible(true);
		}
		
		//업주내역
		else if (ob == bsAuction.bsAuctionHistory.endStartDateBtn) {
			System.out.println("업주내역 cal 버튼");
			calendarView = new CalendarView("", bsAuction.bsAuctionHistory.endStartDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.bsAuctionHistory.endEndDateBtn) {
			calendarView = new CalendarView("", bsAuction.bsAuctionHistory.endEndDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.bsAuctionHistory.sixMonthBtn) {
			calendarView.setDayTf(6,  bsAuction.bsAuctionHistory.endStartDateTf, bsAuction.bsAuctionHistory.endEndDateTf);
		} else if (ob == bsAuction.bsAuctionHistory.threeMonthBtn) {
			calendarView.setDayTf(3, bsAuction.bsAuctionHistory.endStartDateTf, bsAuction.bsAuctionHistory.endEndDateTf);
		} else if (ob == bsAuction.bsAuctionHistory.oneMonthBtn) {
			calendarView.setDayTf(1, bsAuction.bsAuctionHistory.endStartDateTf, bsAuction.bsAuctionHistory.endEndDateTf);
		} 
		
		//업주메뉴탭메인
		else if (ob == bsMenuList.homebutton) {
			bsMenuList.setVisible(false);
			bsMain.setVisible(true);
		}
		
		//업주정보탭메인
		else if(ob == bsInfo.homebutton) {
			bsInfo.setVisible(false);
			bsMain.setVisible(true);
		} else if (ob == bsInfo.renameBtn) {
			JOptionPane.showConfirmDialog(null, "수정되었습니다.", "수정 확인", JOptionPane.DEFAULT_OPTION);
			bsMain.setVisible(true);
		} else if (ob == bsInfo.secessionBtn) {
			JOptionPane.showConfirmDialog(null, "탈퇴되었습니다.", "탈퇴 확인", JOptionPane.DEFAULT_OPTION);
			bsInfo.setVisible(false);
			login.setVisible(true);
			login.idTf.setText("");
		} 
		
		//업주 등록
		else if(ob == bsAuctionLogic.bsBidRegister.homebutton) {
			System.out.println("등록 리스너 작동중");
			bsAuctionLogic.bsBidRegister.setVisible(false);
			bsMain.setVisible(true);
		} else if(ob == bsAuctionLogic.bsBidRegister.notAgree){
			bsAuctionLogic.bsBidRegister.setVisible(false);
		} else if(ob ==bsAuctionLogic.bsBidRegister.agree) {
			JOptionPane.showMessageDialog(bsAuctionLogic.bsBidRegister.agree, "입찰되었습니다^^ 감사합니다", "입찰확인창",JOptionPane.OK_CANCEL_OPTION);
			bsAuctionLogic.bsBidRegister.setVisible(false);
		} else if(ob == bsAuctionLogic.bsBidRegister.homebutton) {
			bsAuctionLogic.bsBidRegister.setVisible(false);
		}
	}
}
