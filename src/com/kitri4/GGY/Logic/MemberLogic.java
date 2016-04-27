package com.kitri4.GGY.Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dao.MemberHistoryDao;
import com.kitri4.GGY.Dao.RbsUserDao;
import com.kitri4.GGY.Dao.rbsCategoryDao;
import com.kitri4.GGY.Dto.MemberHistoryDto;
import com.kitri4.GGY.Dto.UserDto;
import com.kitri4.GGY.Dto.rbsCategoryDto;
import com.kitri4.GGY.Main.Login;
import com.kitri4.GGY.Member.*;

public class MemberLogic implements ActionListener {
	CalendarView calendarView;
	MemberMain memberMain;
	MemberAuctionList memberAuctionList;
	MemberInfo memberInfo;
	MemberAuctionHistory memberAuctionHistory;
	Login login;

	public MemberLogic(RBSMain rbsMain) {
		this.memberMain = rbsMain.memberMain;
		this.memberAuctionList = rbsMain.memberAuctionList;
		this.memberInfo = rbsMain.memberInfo;
		this.calendarView = rbsMain.calendarView;
		this.memberAuctionHistory = memberMain.memberAuction.memberAuctionHistory;
		this.login = rbsMain.login;
		setDayTf(6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String storeName = "한신포차";
		int price = 20000;

		Object ob = e.getSource();

		// MemberMain
		if (ob == memberMain.bidListBtn) {
			memberMain.cd.show(memberMain.getContentPane(), "AuctionList");
		} else if (ob == memberMain.addBidBtn) {
			memberMain.cd.show(memberMain.getContentPane(), "Regi");
		} else if (ob == memberMain.memInfoBtn) {
			memberMain.cd.show(memberMain.getContentPane(), "Info");
		}

		// MemeberAuction
		else if (ob == memberMain.memberAuction.memberAuctionDetail.checkBidBtn) {
			Object[] options = { "확인", "취소" };
			int selectedNum = JOptionPane.showOptionDialog(memberMain.memberAuction.memberAuctionDetail,
					"가게 : " + storeName + "\n금액 : " + price + "원", "옵션 다이얼로그", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		} else if (ob == memberMain.memberAuction.memberAuctionList.memberAuctionDetail.cancelBidBtn) { // 메뉴리스트
																										// 취소
			memberMain.memberAuction.memberAuctionList.cd.show(memberMain.memberAuction.memberAuctionList,
					"memberAuctionList");
			memberMain.memberAuction.tabbedPane.setSelectedComponent(memberMain.memberAuction.memberAuctionList);
		} else if (ob == memberMain.memberAuction.homebutton) {
			System.out.println("홈버튼");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		}

		// MemberAuctionList
		else if (ob == memberMain.memberAuction.memberAuctionList.koCheckbox) {
			System.out.println("한식버튼");
			memberMain.memberAuction.memberAuctionList.storetable.category = 1;
			memberMain.memberAuction.memberAuctionList.scrollPane = new JScrollPane(
					memberMain.memberAuction.memberAuctionList.storetable.storeTable);
		}

		// MemberAuctionHistory
		else if (ob == memberAuctionHistory.bidListViewBtn) {// 회원내역
			guessBidList();
		} else if (ob == memberAuctionHistory.startDateCalBtn) {
			calendarView = new CalendarView("", memberAuctionHistory.startDateTf);
			calendarView.setVisible(true);
		} else if (ob == memberAuctionHistory.endDateCalBtn) {
			calendarView = new CalendarView("", memberAuctionHistory.endDateTf);
			calendarView.setVisible(true);
		} else if (ob == memberAuctionHistory.sixMonthBtn) {
			setDayTf(6);
		} else if (ob == memberAuctionHistory.threeMonthBtn) {
			setDayTf(3);
		} else if (ob == memberAuctionHistory.oneMonthBtn) {
			setDayTf(1);
		}

		// MemberRegi
		else if (ob == memberMain.memberAuctionRegister.homebutton) {
			System.out.println("버튼홈");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} else if (ob == memberMain.memberAuctionRegister.okb) {
			JOptionPane.showConfirmDialog(null, "등록되었습니다.", "등록 확인", JOptionPane.DEFAULT_OPTION);
			memberMain.cd.show(memberMain.getContentPane(), "AuctionList");
		} else if (ob == memberMain.memberAuctionRegister.cancelb) {
			memberMain.cd.show(memberMain.getContentPane(), "home");
		}

		// MemberInfo
		else if (ob == memberMain.memberInfo.homebutton) {
			System.out.println("버튼홈");
			memberMain.cd.show(memberMain.getContentPane(), "home");
			RbsUserDao dao = new RbsUserDao();
			UserDto dto = dao.select(login.idTf.getText());
			memberInfo.idTf.setText(dto.getUserId());
			memberInfo.phoneNumTf.setText(dto.getUserId());
			memberInfo.emailTF.setText(dto.getUserId());
		} else if (ob == memberMain.memberInfo.renameBtn) {
			RbsUserDao dao = new RbsUserDao();
			UserDto dto = dao.select(login.idTf.getText());
			dto.setUserId(memberInfo.idTf.getText());
			dto.setUserPassword(memberInfo.pwTf.getText());
			dto.setUserPhoneNumber(memberInfo.phoneNumTf.getText());
			dto.setUserEmail(memberInfo.emailTF.getText());
		}
	}

	private void guessBidList() {
		String startDate = memberAuctionHistory.startDateTf.getText().trim();
		String endDate = memberAuctionHistory.endDateTf.getText().trim();
		MemberHistoryDao mHistoryDto = new MemberHistoryDao();
		ArrayList<MemberHistoryDto> auctionSeqList = mHistoryDto.selectEndAuction(startDate, endDate, login.idTf.getText().trim());

		// Table
		int size = memberAuctionHistory.endBidTable.getRowCount();
		for (int i = 0; i < size; i++) {
			memberAuctionHistory.model.removeRow(0);
		}

		String str[] = new String[3];
		size = auctionSeqList.size();
		for (int i = 0; i < size; i++) {
			str[0] = auctionSeqList.get(i).getStoreName();
			str[1] = auctionSeqList.get(i).getAuctionLimitedTime();
			str[2] = auctionSeqList.get(i).getAuctionPrice() + "";
			memberAuctionHistory.model.addRow(str);
		}

		// Chart
		// categoty별 chart
		int categoryCount[] = {0,0,0,0,0};
		for (int i = 0; i < size; i++) {
			//categoryId-1 을 인덱스로 갖음
			categoryCount[auctionSeqList.get(i).getCategoryId()-1]++;
		}
		
		String category[] = {"한식", "일식", "중식", "양식", "기타"};
		
		CategoryDataset dataset = createDataset(category,categoryCount);
		JFreeChart chart = createChart(dataset);		
		
		memberAuctionHistory.graphPn = new ChartPanel(chart);
		memberAuctionHistory.graphPn.setPreferredSize(new java.awt.Dimension(362, 308));
		memberAuctionHistory.add(memberAuctionHistory.graphPn);
		memberAuctionHistory.graphPn.setBounds(12, 6, 355, 227);

		/*
		 * int size = auctionSeqList.size(); String tableData[][] = new
		 * String[size][3];
		 * 
		 * for (int i = 0; i < size; i++) { tableData[i][0] =
		 * auctionSeqList.get(i).getStoreName(); tableData[i][1] =
		 * auctionSeqList.get(i).getAuctionLimitedTime(); tableData[i][2] =
		 * auctionSeqList.get(i).getAuctionPrice()+""; }
		 * 
		 * 
		 * ActionDao 를 통해서 where 조건 제시, date를 yyyy-mm-dd로 읽어와서 beatween
		 * strD,endDate일때 읽어와서 int size = date.size();
		 * 
		 * for (int i = 0 ; i < size ; i++) { tableData[i][0] =
		 * data[i].getStoreName(); tableData[i][1] = data[i].getDate();
		 * tableData[i][2] = data[i].getPrice(); }
		 * 
		 * memberActionHistory.GraphPn 에 그래프를 그리고 한식, 중식, 양식 별 예약 횟수
		 * 
		 * 
		 * 
		 * String column[] = { "상호명", "예약시간", "가격" };
		 * memberAuctionHistory.endBidTable = new JTable(tableData, column);
		 * System.out.println("set endBidTable");
		 * 
		 * refresh();
		 */
	}

	private JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart(
	            "카테고리별 집계", "Category", "Count", dataset, PlotOrientation.VERTICAL, true, false, false); 
	            // chart title, domain axis label, range axis label
	            // data, include legend, tooltips?, URLs?

	   return chart;
	}

	private CategoryDataset createDataset(String[] category, int[] categoryCount) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int length = 5;
        for (int i = 0 ; i < length ; i++)
        		dataset.addValue(categoryCount[i], category[i], "");
        return dataset;
		
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
		guessBidList();
	}
}
