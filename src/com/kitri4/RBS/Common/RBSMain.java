package com.kitri4.RBS.Common;

import java.awt.Dialog;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.kitri4.RBS.Admin.*;
import com.kitri4.RBS.BSMember.*;
import com.kitri4.RBS.Logic.*;
import com.kitri4.RBS.Main.*;
import com.kitri4.RBS.Member.*;

public class RBSMain{
	public Login login;

	public BSMemberJoin bsMemberJoin;
	public BSAuction bsAuction;
	public BSMain bsMain;
	public BSInfo bsInfo;
	public BSBidRegister bsBidRegister;
	public BSMenuList bsMenuList;

	public MemberJoin memberJoin;
	public MemberAuction memberAuction;
	public MemberMain memberMain;
	public MemberInfo memberInfo;
	public MemberAuctionRegister memberAuctionRegister;

	public CalendarView calendarView;

	public AdminMain adminMain;
	public AdminGraph adminGraph;

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
		memberAuction = new MemberAuction(memberMain);
		memberAuctionRegister = new MemberAuctionRegister();
		memberInfo = new MemberInfo();
				
		adminMain = new AdminMain();
		adminGraph = new AdminGraph();
		
		
		/*MainLogic event*/
		MainLogic jr = new MainLogic(this);
		
		//login
		login.loginBtn.addActionListener(jr);
		login.joinBtn.addActionListener(jr);		
		
		//memberJoin
		memberJoin.checkIdBtn.addActionListener(jr);
		memberJoin.memJoinBtn.addActionListener(jr);
		memberJoin.cancleBtn.addActionListener(jr);
		
		//bsMemberJoin
		bsMemberJoin.bsJoinBtn.addActionListener(jr);
		bsMemberJoin.checkIdBtn.addActionListener(jr);
		bsMemberJoin.cancleBtn.addActionListener(jr);

		
		/*MemberLogic event*/
		MemberLogic ml = new MemberLogic(this);
		
		//MemberMain
		memberMain.bidListBtn.addActionListener(ml);
		memberMain.addBidBtn.addActionListener(ml);
		memberMain.memInfoBtn.addActionListener(ml);


		// MemberAuction
		memberMain.memberAuction.memberAuctionList.memberAuctionDetail.cancelBidBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionDetail.checkBidBtn.addActionListener(ml);		
		memberMain.memberAuction.homebutton.addActionListener(ml);
		
		//MemberAuctionHistory
		memberMain.memberAuction.memberAuctionHistory.bidListViewBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.startDateCalBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.endDateCalBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.sixMonthBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.threeMonthBtn.addActionListener(ml);
		memberMain.memberAuction.memberAuctionHistory.oneMonthBtn.addActionListener(ml);
		
		//MemberAuctionRegister
		memberMain.memberAuctionRegister.homebutton.addActionListener(ml);
		memberMain.memberAuctionRegister.okb.addActionListener(ml);
		memberMain.memberAuctionRegister.cancelb.addActionListener(ml);
		
		//MemberInfo
		memberMain.memberInfo.homebutton.addActionListener(ml);

		
		/*BSMemberLogic*/
		BSMemberLogic bsMemberLogic = new BSMemberLogic(this);
		
		// BSMain
		bsMain.bidListBtn.addActionListener(bsMemberLogic);
		bsMain.InfoBtn.addActionListener(bsMemberLogic);
		bsMain.storeMenuBtn.addActionListener(bsMemberLogic);
		
		//BSAuction
		bsAuction.endStartDateBtn.addActionListener(bsMemberLogic);
		bsAuction.endEndDateBtn.addActionListener(bsMemberLogic);
		bsAuction.storeMenuBtn.addActionListener(bsMemberLogic);
		bsAuction.bidListBtn.addActionListener(bsMemberLogic);
		bsAuction.storeMenuBtn.addActionListener(bsMemberLogic);
		bsAuction.infoBtn.addActionListener(bsMemberLogic);
		bsAuction.sixMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.threeMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.oneMonthBtn.addActionListener(bsMemberLogic);
		
		//BSMenulist
		bsMenuList.bidListBtn.addActionListener(bsMemberLogic);
		bsMenuList.storeMenuBtn.addActionListener(bsMemberLogic);
		bsMenuList.infoBtn.addActionListener(bsMemberLogic);
		
		//BSInfo
		bsInfo.homebutton.addActionListener(bsMemberLogic);
		bsInfo.renameBtn.addActionListener(bsMemberLogic);
		bsInfo.secessionBtn.addActionListener(bsMemberLogic);
		
		//BSBidBidRegister
		bsBidRegister.homebutton.addActionListener(bsMemberLogic);
		bsBidRegister.notAgree.addActionListener(bsMemberLogic);
		bsBidRegister.agree.addActionListener(bsMemberLogic);

		
		/*AdminLogic*/
		AdminLogic adminLogic = new AdminLogic(this);
		
		// AdminMain
		adminMain.auctionManagBtn.addActionListener(adminLogic);
		adminMain.userManagBtn.addActionListener(adminLogic);
		
		login.setVisible(true);
	}

	public static void main(String[] args) {
		new RBSMain();
	}
}
