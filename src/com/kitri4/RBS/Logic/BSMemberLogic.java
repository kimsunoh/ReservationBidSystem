package com.kitri4.RBS.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.kitri4.RBS.BSMember.*;
import com.kitri4.RBS.Common.CalendarView;
import com.kitri4.RBS.Common.RBSMain;
import com.kitri4.RBS.Main.Login;

public class BSMemberLogic implements ActionListener{
	Login login = null;
	BSMain bsMain = null;
	BSAuction bsAuction = null;
	BSMenuList bsMenuList = null;
	BSInfo bsInfo = null;
	CalendarView calendarView = null;
	BSBidRegister bsBidRegister = null;
	
	public BSMemberLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.bsMain = rbsMain.bsMain;
		this.bsAuction = rbsMain.bsAuction;
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
			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == bsMain.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.InfoBtn) {
			bsInfo.setVisible(true);
//			bsInfo.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} 
		
		//업주내역
		else if (ob == bsAuction.endStartDateBtn) {
			calendarView = new CalendarView("Caledar", bsAuction.endStartDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.endEndDateBtn) {
			calendarView = new CalendarView("Caledar", bsAuction.endEndDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.sixMonthBtn) {
			calendarView.setDayTf(6,  bsAuction.ingStartDateTf, bsAuction.ingEndDateTf);
		} else if (ob == bsAuction.threeMonthBtn) {
			calendarView.setDayTf(3, bsAuction.endStartDateTf, bsAuction.endEndDateTf);
		} else if (ob == bsAuction.oneMonthBtn) {
			calendarView.setDayTf(1, bsAuction.endStartDateTf, bsAuction.endEndDateTf);
		} 
		
		//업주내역탭메인
		else if (ob == bsAuction.bidListBtn) {
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
		} 
		//업주메뉴탭메인
		else if (ob == bsMenuList.bidListBtn) {
			bsAuction.setVisible(true);
			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMenuList.setVisible(false);
		} else if (ob == bsMenuList.storeMenuBtn) {
			bsMenuList.setVisible(false);
			bsMenuList.setVisible(true);
			bsMenuList.tabbedPane.setSelectedIndex(1);
		} else if (ob == bsMenuList.infoBtn) {
			bsInfo.setVisible(true);
			bsMenuList.setVisible(false);
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
		else if(ob == bsBidRegister.homebutton) {
			System.out.println("등록 리스너 작동중");
			bsBidRegister.setVisible(false);
			bsMain.setVisible(true);
		} else if(ob == bsBidRegister.notAgree){
			bsBidRegister.setVisible(false);
		} else if(ob ==bsBidRegister.agree) {
			JOptionPane.showMessageDialog(bsBidRegister.agree, "입찰되었습니다^^ 감사합니다", "입찰확인창",JOptionPane.OK_CANCEL_OPTION);
			bsBidRegister.setVisible(false);
		} else if(ob == bsBidRegister.homebutton) {
			bsBidRegister.setVisible(false);
		}
	}

}
