package com.kitri4.RBS.Common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri4.RBS.Main.*;
import com.kitri4.RBS.Member.*;

public class BSMain implements ActionListener{
	Login login;
	BSMemberJoin bsMemberJoin;
	MemberJoin memberJoin;
	MemberAuction memberAuction;

	public BSMain() {
		login = new Login();
		bsMemberJoin = new BSMemberJoin();
		memberJoin = new MemberJoin();
		memberAuction = new MemberAuction();
		
		//Login창 이벤트 등록
		login.loginBtn.addActionListener(this);
		login.joinBtn.addActionListener(this);
		
		//bsMemberJoin창 이벤트 등록
		bsMemberJoin.bsJoinBtn.addActionListener(this);
		bsMemberJoin.checkIdBtn.addActionListener(this);
		
		//MemberJoin창 이벤트 등록
		memberJoin.checkIdBtn.addActionListener(this);
		memberJoin.memJoinBtn.addActionListener(this);
		
		//MemberAction
		memberAuction.bidListViewBtn.addActionListener(this);
		memberAuction.startDateCalBtn.addActionListener(this);
		memberAuction.endDateCalBtn.addActionListener(this);
		memberAuction.sixMonthBtn.addActionListener(this);
		memberAuction.threeMonthBtn.addActionListener(this);
		memberAuction.oneMonthBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob.equals(login.loginBtn)) {
			
		}else if (ob.equals(login.joinBtn)) {
			
		}else if (ob.equals(bsMemberJoin.bsJoinBtn)) {
			
		}else if (ob.equals(bsMemberJoin.checkIdBtn)) {
			
		}else if (ob.equals(memberJoin.checkIdBtn)) {
			
		}else if (ob.equals(memberJoin.memJoinBtn)) {
			
		}else if (ob.equals(memberAuction.bidListViewBtn)) {
			
		}else if (ob.equals(memberAuction.startDateCalBtn)) {
			
		}else if (ob.equals(memberAuction.endDateCalBtn)) {
			
		}else if (ob.equals(memberAuction.sixMonthBtn)) {
			
		}else if (ob.equals(memberAuction.threeMonthBtn)) {
			
		}else if (ob.equals(memberAuction.oneMonthBtn)) {
			
		}
	}
}