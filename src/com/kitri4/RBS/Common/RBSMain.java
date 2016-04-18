package com.kitri4.RBS.Common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.kitri4.RBS.BSMember.BSAuction;
import com.kitri4.RBS.Main.*;
import com.kitri4.RBS.Member.*;

public class RBSMain implements ActionListener {
	Login login;
	BSMemberJoin bsMemberJoin;
	MemberJoin memberJoin;
	MemberAuction memberAuction;
	BSAuction bsAuction;
	CalendarView cal;
	
	public RBSMain() {
		login = new Login("Login");
		bsMemberJoin = new BSMemberJoin("BSMemberJoin");
		memberJoin = new MemberJoin("MemberJoin");
		memberAuction = new MemberAuction("MemberAuction");
		bsAuction = new BSAuction("BSAuction");

		// Login창 占싱븝옙트 占쏙옙占�
		login.loginBtn.addActionListener(this);
		login.joinBtn.addActionListener(this);

		// bsMemberJoin창 占싱븝옙트 占쏙옙占�
		bsMemberJoin.bsJoinBtn.addActionListener(this);
		bsMemberJoin.checkIdBtn.addActionListener(this);

		// MemberJoin창 占싱븝옙트 占쏙옙占�
		memberJoin.checkIdBtn.addActionListener(this);
		memberJoin.memJoinBtn.addActionListener(this);

		// MemberAction
		memberAuction.bidListViewBtn.addActionListener(this);
		memberAuction.startDateCalBtn.addActionListener(this);
		memberAuction.endDateCalBtn.addActionListener(this);
		memberAuction.sixMonthBtn.addActionListener(this);
		memberAuction.threeMonthBtn.addActionListener(this);
		memberAuction.oneMonthBtn.addActionListener(this);

		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob.equals(login.loginBtn)) {
			if (JOptionPane.showConfirmDialog(null, "일반회원입니까? \n업주회원은 No를 눌러주세요.", "로그인화면선택",
					JOptionPane.YES_NO_OPTION) == 0) {
				memberAuction.setVisible(true);
				memberAuction.tabbedPane.setSelectedIndex(1);
			} else {
				bsAuction.setVisible(true);
				bsAuction.tabbedPane.setSelectedIndex(1);
			}
			login.setVisible(false);
		} else if (ob.equals(login.joinBtn)) {
			if (JOptionPane.showConfirmDialog(null, "일반회원입니까? \n업주회원은 No를 눌러주세요.", "회원유형선택",
					JOptionPane.YES_NO_OPTION) == 0) {
				memberJoin.setVisible(true);
			} else {
				bsMemberJoin.setVisible(true);
			}
			login.setVisible(false);
		} else if (ob.equals(bsMemberJoin.bsJoinBtn)) {
			JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림",
					JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
		} else if (ob.equals(bsMemberJoin.checkIdBtn)) {
			checkId(bsMemberJoin.idTf.getText());
		} else if (ob.equals(memberJoin.checkIdBtn)) {
			checkId(memberJoin.idTf.getText());
		} else if (ob.equals(memberJoin.memJoinBtn)) {
			JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림",
					JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
		} else if (ob.equals(memberAuction.bidListViewBtn)) {
			guessBidList();
		} else if (ob.equals(memberAuction.startDateCalBtn)) {
			cal = new CalendarView("CalandarView", memberAuction.startDateTf);
			cal.setVisible(true);
		} else if (ob.equals(memberAuction.endDateCalBtn)) {
			cal = new CalendarView("CalandarView", memberAuction.endDateTf);
			cal.setVisible(true);
		} else if (ob.equals(memberAuction.sixMonthBtn)) {
			setDayTf(6);
		} else if (ob.equals(memberAuction.threeMonthBtn)) {
			setDayTf(3);
		} else if (ob.equals(memberAuction.oneMonthBtn)) {
			setDayTf(1);
		}
	}

	private void guessBidList() {
		//startDateTf, endDateTf를 가져와 between에 있는 bid를 읽어옴
	}

	private void setDayTf(int gapMonth) {
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		memberAuction.endDateTf.setText(year + "/" + month + "/" + day);
		
		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		}else {
			month -= gapMonth;
		}
		memberAuction.startDateTf.setText( year + "/" + month + "/" + day);
	}

	private void checkId(String setId) {
		if(setId.isEmpty()){
			JOptionPane.showConfirmDialog(null, "아이디는 공백일수 없습니다.", "아이디 오류",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(null, "사용할 수 있는 아이디입니다.", "아이디 확인",
					JOptionPane.DEFAULT_OPTION);
		}
	}

	public static void main(String[] args) {
		new RBSMain();
	}
}
