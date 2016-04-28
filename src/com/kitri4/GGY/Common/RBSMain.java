package com.kitri4.GGY.Common;

import java.awt.Color;

import com.kitri4.GGY.Admin.*;
import com.kitri4.GGY.BSMember.*;
import com.kitri4.GGY.Logic.*;
import com.kitri4.GGY.Main.*;
import com.kitri4.GGY.Member.*;

public class RBSMain {
	public Login login;

	public BSMemberJoin bsMemberJoin;
	public BSMain bsMain;
	public BSAuction bsAuction;
	public BSAuctionHistory bsAuctionHistory;
	public BSInfo bsInfo;
	public BSAuctionLogic bsAuctionLogic;
	public BSBidRegister bsBidRegister;
	public BSMenuList bsMenuList;

	public MemberJoin memberJoin;
	public MemberMain memberMain;
	public MemberAuction memberAuction;
	public MemberInfo memberInfo;
	public MemberAuctionRegister memberAuctionRegister;

	public CalendarView calendarView;

	public AdminMain adminMain;
	public AdminGraph adminGraph;
	
	public RBSMain() {
		login = new Login("°Å±â¿ä");
		login.setBackground(new Color(255,255,255));
		bsMemberJoin = new BSMemberJoin();
		bsMemberJoin.setBackground(new Color(255,255,255));
		bsMain = new BSMain();
		bsAuction = new BSAuction();
		bsAuctionHistory = new BSAuctionHistory();
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
		bsMemberJoin.joinBtn.addActionListener(jr);
		bsMemberJoin.getStoreImgBtn.addActionListener(jr);
		bsMemberJoin.checkIdBtn.addActionListener(jr);
		bsMemberJoin.cancleBtn.addActionListener(jr);
		//
		bsMemberJoin.homebutton.addActionListener(jr);
		//
		
		/*MemberLogic event*/
		MemberLogic ml = new MemberLogic(this);
		
		//MemberMain
		memberMain.bidListBtn.addActionListener(ml);
		memberMain.addBidBtn.addActionListener(ml);
		memberMain.memInfoBtn.addActionListener(ml);
		memberMain.logoutBtn.addActionListener(ml);


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
		memberMain.memberAuctionRegister.okBtn.addActionListener(ml);
		memberMain.memberAuctionRegister.cancelBtn.addActionListener(ml);
		
		//MemberInfo
		memberMain.memberInfo.homebutton.addActionListener(ml);

		
		/*BSMemberLogic*/
		BSMemberLogic bsMemberLogic = new BSMemberLogic(this);
		
		// BSMain
		bsMain.bidListBtn.addActionListener(bsMemberLogic);
		bsMain.InfoBtn.addActionListener(bsMemberLogic);
		bsMain.storeMenuBtn.addActionListener(bsMemberLogic);
		bsMain.logoutBtn.addActionListener(bsMemberLogic);//
		
		//BSAuction
		bsAuction.homebutton.addActionListener(bsMemberLogic);
		bsAuction.ingStartDateBtn.addActionListener(bsMemberLogic);
		bsAuction.ingEndDateBtn.addActionListener(bsMemberLogic);
		
		//BSAuctionHistory
		bsAuction.bsAuctionHistory.endStartDateBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.endEndDateBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.sixMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.threeMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.oneMonthBtn.addActionListener(bsMemberLogic);
		bsAuction.bsAuctionHistory.bidListViewBtn.addActionListener(bsMemberLogic);
		
		
		//BSMenulist
		bsMenuList.homebutton.addActionListener(bsMemberLogic);

		//BSInfo
		bsInfo.homebutton.addActionListener(bsMemberLogic);
		bsInfo.renameBtn.addActionListener(bsMemberLogic);
		bsInfo.secessionBtn.addActionListener(bsMemberLogic);
		
		//BSBidBidRegister
		bsAuctionLogic.bsBidRegister.homebutton.addActionListener(bsMemberLogic);
		bsAuctionLogic.bsBidRegister.notAgree.addActionListener(bsMemberLogic);
		bsAuctionLogic.bsBidRegister.agree.addActionListener(bsMemberLogic);

		
		/*AdminLogic*/
		AdminLogic adminLogic = new AdminLogic(this);
		
		// AdminMain
		adminMain.auctionManagBtn.addActionListener(adminLogic);
		adminMain.userManagBtn.addActionListener(adminLogic);
		adminMain.logoutBtn.addActionListener(adminLogic);
		
		// AdminGraph
		adminGraph.homebutton.addActionListener(adminLogic);
		
		login.setVisible(true);

	}

	public static void main(String[] args) {
		new RBSMain();
	}
	
}
