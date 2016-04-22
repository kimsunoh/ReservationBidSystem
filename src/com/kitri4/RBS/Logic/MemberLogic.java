package com.kitri4.RBS.Logic;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

import com.kitri4.RBS.Common.CalendarView;
import com.kitri4.RBS.Common.RBSMain;
import com.kitri4.RBS.Member.MemberMain;

public class MemberLogic implements ActionListener {
	CalendarView calendarView;
	MemberMain memberMain;

	public MemberLogic(RBSMain rbsMain) {
		this.memberMain = rbsMain.memberMain;
		this.calendarView = rbsMain.calendarView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String storeName = "�ѽ�����";
		int price = 20000;

		Object ob = e.getSource();
		
		//MemberMain
		if (ob == memberMain.bidListBtn){
			memberMain.cd.show(memberMain.getContentPane(), "AuctionList");
		} else if (ob == memberMain.addBidBtn){
			memberMain.cd.show(memberMain.getContentPane(), "Regi");
		} else if (ob == memberMain.memInfoBtn) {
			memberMain.cd.show(memberMain.getContentPane(), "Info");
		} 

		//MemeberAuction
		else if (ob == memberMain.memberAuction.memberAuctionDetail.checkBidBtn) {
			Object[] options = { "Ȯ��", "���" };
			int selectedNum = JOptionPane.showOptionDialog(memberMain.memberAuction.memberAuctionDetail,
					"���� : " + storeName + "\n�ݾ� : " + price + "��", "�ɼ� ���̾�α�", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		} else if ( ob == memberMain.memberAuction.memberAuctionList.memberAuctionDetail.cancelBidBtn) { // �޴�����Ʈ ���
			memberMain.memberAuction.memberAuctionList.cd.show(memberMain.memberAuction.memberAuctionList, "memberAuctionList");
			memberMain.memberAuction.tabbedPane.setSelectedComponent(memberMain.memberAuction.memberAuctionList);
		} else if (ob == memberMain.memberAuction.homebutton) {
			System.out.println("Ȩ��ư");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} 
		
		//MemberAuctionHistory
		else if (ob == memberMain.memberAuction.memberAuctionHistory.bidListViewBtn) {//ȸ������
			guessBidList();
		} else if (ob == memberMain.memberAuction.memberAuctionHistory.startDateCalBtn) {
			memberMain.memberAuction.memberAuctionHistory.startDateTf.setText("");
			calendarView = new CalendarView("", memberMain.memberAuction.memberAuctionHistory.startDateTf);
			calendarView.setVisible(true);
		} else if (ob == memberMain.memberAuction.memberAuctionHistory.endDateCalBtn) {
			calendarView = new CalendarView("", memberMain.memberAuction.memberAuctionHistory.endDateTf);
			calendarView.setVisible(true);
		} else if (ob == memberMain.memberAuction.memberAuctionHistory.sixMonthBtn) {
			setDayTf(6);
		} else if (ob == memberMain.memberAuction.memberAuctionHistory.threeMonthBtn) {
			setDayTf(3);
		} else if (ob == memberMain.memberAuction.memberAuctionHistory.oneMonthBtn) {
			setDayTf(1);
		}
		
		//MemberRegi
		else if (ob == memberMain.memberAuctionRegister.homebutton) {
			System.out.println("��ưȨ");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} else if (ob == memberMain.memberAuctionRegister.okb) {
			JOptionPane.showConfirmDialog(null, "��ϵǾ����ϴ�.", "��� Ȯ��", JOptionPane.DEFAULT_OPTION);
			memberMain.cd.show(memberMain.getContentPane(), "AuctionList");
		} else if (ob == memberMain.memberAuctionRegister.cancelb) {
			memberMain.cd.show(memberMain.getContentPane(), "home");
		}
		
		//MemberInfo
		else if (ob == memberMain.memberInfo.homebutton) {
			System.out.println("��ưȨ");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} 
	}
	
	private void guessBidList() {
		// startDateTf, endDateTf�� ������ between�� �ִ� bid�� �о��
	}

	private void setDayTf(int gapMonth) {
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		memberMain.memberAuction.memberAuctionHistory.endDateTf.setText(year + "/" + month + "/" + day);

		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		} else {
			month -= gapMonth;
		}
		memberMain.memberAuction.memberAuctionHistory.startDateTf.setText(year + "/" + month + "/" + day);
	}
}
