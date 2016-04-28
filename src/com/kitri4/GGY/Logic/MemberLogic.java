package com.kitri4.GGY.Logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dao.*;
import com.kitri4.GGY.Dto.MemberHistoryDto;
import com.kitri4.GGY.Main.Login;
import com.kitri4.GGY.Member.*;

public class MemberLogic implements ActionListener {
	CalendarView calendarView;
	MemberMain memberMain;
	//선오
	MemberAuctionList memberAuctionList;
	MemberInfo memberInfo;
	MemberAuctionHistory memberAuctionHistory;
	//
	Login login;

	public MemberLogic(RBSMain rbsMain) {
		this.memberMain = rbsMain.memberMain;
		this.calendarView = rbsMain.calendarView;
		this.login = rbsMain.login;
		//선오
//		this.memberAuctionList = rbsMain.memberAuctionList;
//		this.memberInfo = rbsMain.memberInfo;
		this.memberAuctionHistory = memberMain.memberAuction.memberAuctionHistory;
		
		//
		setDong();
		//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String storeName = "한신포차";
		int price = 20000;

		Object ob = e.getSource();
		
		//MemberMain
		if (ob == memberMain.bidListBtn){
			memberMain.cd.show(memberMain.getContentPane(), "AuctionList");
			setDayTf(6);
		} else if (ob == memberMain.addBidBtn){
			memberMain.cd.show(memberMain.getContentPane(), "Regi");
		} else if (ob == memberMain.memInfoBtn) {
			memberMain.cd.show(memberMain.getContentPane(), "Info");
		} else if (ob == memberMain.logoutBtn) {//
			memberMain.setVisible(false);
			login.setVisible(true);
			login.idTf.setText("");
			login.pwTf.setText("");
		} 

		//MemeberAuction
		else if (ob == memberMain.memberAuction.memberAuctionDetail.checkBidBtn) {
			Object[] options = { "확인", "취소" };
			int selectedNum = JOptionPane.showOptionDialog(memberMain.memberAuction.memberAuctionDetail,
					"가게 : " + storeName + "\n금액 : " + price + "원", "옵션 다이얼로그", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		} else if ( ob == memberMain.memberAuction.memberAuctionList.memberAuctionDetail.cancelBidBtn) { // 메뉴리스트 취소
			memberMain.memberAuction.memberAuctionList.cd.show(memberMain.memberAuction.memberAuctionList, "memberAuctionList");
			memberMain.memberAuction.tabbedPane.setSelectedComponent(memberMain.memberAuction.memberAuctionList);
		} else if (ob == memberMain.memberAuction.homebutton) {
			System.out.println("홈버튼");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} 
		
		//MemberAuctionHistory
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
		
		//MemberRegi
		else if (ob == memberMain.memberAuctionRegister.homebutton) {//
			System.out.println("버튼홈");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} else if (ob == memberMain.memberAuctionRegister.okBtn) {
			Register();//경매 등록
			JOptionPane.showConfirmDialog(null, "등록되었습니다.", "등록 확인", JOptionPane.DEFAULT_OPTION);
			memberMain.cd.show(memberMain.getContentPane(), "AuctionList");
		} else if (ob == memberMain.memberAuctionRegister.cancelBtn) {
			JOptionPane.showConfirmDialog(null, "취소되었습니다.", "취소 확인", JOptionPane.DEFAULT_OPTION);
			memberMain.cd.show(memberMain.getContentPane(), "home");//
		}
		
		//MemberInfo
		else if (ob == memberMain.memberInfo.homebutton) {
			System.out.println("버튼홈");
			memberMain.cd.show(memberMain.getContentPane(), "home");
		} 
	}
	
	private void guessBidList() {
		// startDateTf, endDateTf를 가져와 between에 있는 bid를 읽어옴
		String startDate = memberAuctionHistory.startDateTf.getText().trim();
		String endDate = memberAuctionHistory.endDateTf.getText().trim();
		MemberHistoryDao mHistoryDto = new MemberHistoryDao();
		ArrayList<MemberHistoryDto> auctionSeqList = mHistoryDto.selectEndAuction(startDate, endDate,
				login.idTf.getText().trim());

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
		int categoryCount[] = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < size; i++) {
			// categoryId-1 을 인덱스로 갖음
			categoryCount[auctionSeqList.get(i).getCategoryId() - 1]++;
		}

		String category[] = { "한식", "일식", "중식", "양식", "기타" };

		CategoryDataset dataset = createDataset(category, categoryCount);
		JFreeChart chart = createChart(dataset);

		memberAuctionHistory.graphPn = new ChartPanel(chart);
		
		memberAuctionHistory.graphPn.setPreferredSize(new java.awt.Dimension(362, 308));
		memberAuctionHistory.add(memberAuctionHistory.graphPn);
		memberAuctionHistory.graphPn.setBounds(12, 6, 355, 227);
	}
	
	private JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart("", "Category", "Count", dataset);
		// chart title, domain axis label, range axis label
		// data, include legend, tooltips?, URLs?
		
		chart.getLegend().setItemFont(new Font("나눔바른고딕",Font.BOLD, 13));
		
		CategoryPlot plot = chart.getCategoryPlot();
		// X 축의 라벨 설정입니다. (보조 타이틀)
		plot.getDomainAxis().setLabelFont(new Font("나눔바른고딕", Font.BOLD, 13));
		// X 축의 도메인 설정입니다.
		plot.getDomainAxis().setTickLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));
		// Y 축의 라벨 설정입니다. (보조 타이틀)
		plot.getRangeAxis().setLabelFont(new Font("나눔바른고딕", Font.BOLD, 13));
		// Y 축의 도메인 설정입니다.
		plot.getRangeAxis().setTickLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));
		
		
		return chart;
	}

	private CategoryDataset createDataset(String[] category, int[] categoryCount) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int length = 5;
		for (int i = 0; i < length; i++)
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
	
	//우람
	public void Register(){//경매 등록
		String id=login.idTf.getText();
		String title=memberMain.memberAuctionRegister.titleTf.getText();
		int people=Integer.parseInt(memberMain.memberAuctionRegister.peopleNumTf.getText());
		int dong=memberMain.memberAuctionRegister.dongComb.getSelectedIndex();
		int price=Integer.parseInt(memberMain.memberAuctionRegister.priceTf.getText());
		String content=memberMain.memberAuctionRegister.needsomeTa.getText();
		
		Connection c = null;
		Statement s = null;

		try {
			c = DBConnection.makeConnection();
			
			String sql = "insert into auction\n";
			sql += "values (8,'"+title+"','"+id+"',"+people+",'"+content
					+"', to_char(sysdate,'yyyy-mm-dd'), '',0,"+price+","+dong+")";
			
			s = c.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(c, s);
		}
	}
	
	public void setDong(){//동combobox
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = DBConnection.makeConnection();
			
			String sql = "select dong_name\n";
			sql += "from dong";
			
			s = c.createStatement();
			rs=s.executeQuery(sql);
			while (rs.next()) {
				memberMain.memberAuctionRegister.dongComb.addItem(rs.getString("dong_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(c, s, rs);
		}
	}
		
	//
}










