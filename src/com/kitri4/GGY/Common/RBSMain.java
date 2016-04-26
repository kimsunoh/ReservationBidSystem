package com.kitri4.GGY.Common;

import java.awt.Dialog;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.kitri4.GGY.Admin.*;
import com.kitri4.GGY.BSMember.*;
import com.kitri4.GGY.Logic.*;
import com.kitri4.GGY.Main.*;
import com.kitri4.GGY.Member.*;

public class RBSMain {
	public Login login;

	public BSMemberJoin bsMemberJoin;
	public BSAuction bsAuction;
	public BSAuctionHistory bsAuctionHistory;
	public BSAuctionLogic bsAuctionLogic;
	public BSMain bsMain;
	public BSInfo bsInfo;
	public BSBidRegister bsBidRegister;
	public BSMenuList bsMenuList;

	public MemberJoin memberJoin;
	public MemberAuction memberAuction;
	public MemberAuctionList memberAuctionList;
	public MemberMain memberMain;
	public MemberInfo memberInfo;
	public MemberAuctionRegister memberAuctionRegister;

	public CalendarView calendarView;

	public AdminMain adminMain;
	public AdminGraph adminGraph;

	public RBSMain() {
		login = new Login("Login");

		bsMemberJoin = new BSMemberJoin();
		bsMain = new BSMain();
		bsAuction = new BSAuction();
		bsAuctionHistory = new BSAuctionHistory();
		bsBidRegister = new BSBidRegister();
		bsMenuList = new BSMenuList();
		bsInfo = new BSInfo();

		memberJoin = new MemberJoin("MemberJoin");
		memberMain = new MemberMain();
		memberAuction = new MemberAuction(memberMain);
		memberAuctionList = new MemberAuctionList(memberMain);
		memberAuctionRegister = new MemberAuctionRegister();
		memberInfo = new MemberInfo();

		adminMain = new AdminMain();
		adminGraph = new AdminGraph();

		/* MainLogic event */
		MainLogic jr = new MainLogic(this);

		// login
		login.loginBtn.addActionListener(jr);
		login.joinBtn.addActionListener(jr);

		// memberJoin
		memberJoin.checkIdBtn.addActionListener(jr);
		memberJoin.memJoinBtn.addActionListener(jr);
		memberJoin.cancleBtn.addActionListener(jr);

		// bsMemberJoin
		bsMemberJoin.joinBtn.addActionListener(jr);
		bsMemberJoin.checkIdBtn.addActionListener(jr);
		bsMemberJoin.cancleBtn.addActionListener(jr);

		/* MemberLogic event */
		MemberLogic ml = new MemberLogic(this);

		// MemberMain
		memberMain.bidListBtn.addActionListener(ml);
		memberMain.addBidBtn.addActionListener(ml);
		memberMain.memInfoBtn.addActionListener(ml);

		// MemberAuction
		memberMain.memberAuction.memberAuctionList.memberAuctionDetail.cancelBidBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionDetail.checkBidBtn.addActionListener(ml);
		memberMain.memberAuction.homebutton.addActionListener(ml);

		// MemberAuctionList
		memberMain.memberAuction.memberAuctionList.koCheckbox.addActionListener(ml);
		memberAuction.memberAuctionList.jpCheckbox.addActionListener(ml);
		memberAuction.memberAuctionList.chCheckbox.addActionListener(ml);
		memberAuction.memberAuctionList.westCheckbox.addActionListener(ml);
		memberAuction.memberAuctionList.etcCheckbox.addActionListener(ml);

		// MemberAuctionHistory
		memberMain.memberAuction.memberAuctionHistory.bidListViewBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.startDateCalBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.endDateCalBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.sixMonthBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.threeMonthBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.oneMonthBtn.addActionListener(ml);

		// MemberAuctionRegister
		memberMain.memberAuctionRegister.homebutton.addActionListener(ml);
		memberMain.memberAuctionRegister.okb.addActionListener(ml);
		memberMain.memberAuctionRegister.cancelb.addActionListener(ml);

		// MemberInfo
		memberMain.memberInfo.homebutton.addActionListener(ml);

		/* BSMemberLogic */
		BSMemberLogic bsMemberLogic = new BSMemberLogic(this);

		// BSMain
		bsMain.bidListBtn.addActionListener(bsMemberLogic);
		bsMain.InfoBtn.addActionListener(bsMemberLogic);
		bsMain.storeMenuBtn.addActionListener(bsMemberLogic);

		// BSAuction
		bsAuction.homebutton.addActionListener(bsMemberLogic);
		bsAuction.ingStartDateBtn.addActionListener(bsMemberLogic);
		bsAuction.ingEndDateBtn.addActionListener(bsMemberLogic);

		// BSAuctionHistory
		bsAuction.bsAuctionHistory.endStartDateBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.endEndDateBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.sixMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.threeMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.oneMonthBtn.addActionListener(bsMemberLogic);

		// BSMenulist
		bsMenuList.homebutton.addActionListener(bsMemberLogic);
		// 리스너들
		
		bsMenuList.openPicturBtn.addActionListener(bsMemberLogic);// 사진 불러오기
		bsMenuList.addMenuBtn.addActionListener(bsMemberLogic);// 등록 버튼
		bsMenuList.renameMenuBtn.addActionListener(bsMemberLogic);// 수정 버튼
		bsMenuList.removeMenuBtn.addActionListener(bsMemberLogic);// 삭제 버튼
		bsMenuList.jdialogBtn.addActionListener(bsMemberLogic);// 삭제 dialog 버튼
		bsMenuList.okBtn.addActionListener(bsMemberLogic);// 삭제 확인 버튼
		bsMenuList.cancleBtn.addActionListener(bsMemberLogic);// 삭제 취소 버튼

		// BSInfo
		bsInfo.homebutton.addActionListener(bsMemberLogic);
		bsInfo.renameBtn.addActionListener(bsMemberLogic);
		bsInfo.secessionBtn.addActionListener(bsMemberLogic);

		// BSBidBidRegister
		bsAuctionLogic.bsBidRegister.homebutton.addActionListener(bsMemberLogic);
		bsAuctionLogic.bsBidRegister.notAgree.addActionListener(bsMemberLogic);
		bsAuctionLogic.bsBidRegister.agree.addActionListener(bsMemberLogic);

		/* AdminLogic */
		AdminLogic adminLogic = new AdminLogic(this);

		// AdminMain
		adminMain.auctionManagBtn.addActionListener(adminLogic);
		adminMain.userManagBtn.addActionListener(adminLogic);

		// AdminGraph
		adminGraph.homebutton.addActionListener(adminLogic);

		login.setVisible(true);
	}

	public static void main(String[] args) {
		new RBSMain();
	}
}
