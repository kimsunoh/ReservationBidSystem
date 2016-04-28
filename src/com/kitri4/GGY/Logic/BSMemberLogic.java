package com.kitri4.GGY.Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kitri4.GGY.BSMember.*;
import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dao.BusinessManDao;
import com.kitri4.GGY.Dao.DBClose;
import com.kitri4.GGY.Dao.DBConnection;
import com.kitri4.GGY.Dto.BusinessManDto;
import com.kitri4.GGY.Dto.BSAuctionDto;
import com.kitri4.GGY.Main.Login;

public class BSMemberLogic implements ActionListener {
	Login login = null;
	BSMain bsMain = null;
	BSAuction bsAuction = null;
	// BSAuctionHistory bsAuctionHistory = null;
	BSAuctionLogic bsAuctionLogic = null;
	BSMenuList bsMenuList = null;
	BSInfo bsInfo = null;
	BSBidRegister bsBidRegister = null;
	CalendarView calendarView = null;
	
	//함수에서 사용
	String str[] = new String[3];
	StringTokenizer st;
	StringTokenizer st2;
	StringTokenizer st3;
	StringTokenizer st4;
	
	StringTokenizer t1;
	StringTokenizer t2;
	
	//

	public BSMemberLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.bsMain = rbsMain.bsMain;
		this.bsAuction = rbsMain.bsAuction;
		this.bsAuctionLogic = rbsMain.bsAuctionLogic;
		// this.bsAuctionHistory = rbsMain.bsAuctionHistory;
		this.bsMenuList = rbsMain.bsMenuList;
		this.bsInfo = rbsMain.bsInfo;
		this.calendarView = rbsMain.calendarView;
		this.bsBidRegister = rbsMain.bsBidRegister;
		
		setCategory();//
		setDong();//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		// 업주메인
		if (ob == bsMain.bidListBtn) {
			setDayTf(6);//디폴트 6개월 내역
			SearchAllList();//
			bsAuction.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.InfoBtn) {
			bsGet();
			bsInfo.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.logoutBtn) {//
			bsMain.setVisible(false);
			login.setVisible(true);
			login.idTf.setText("");
			login.pwTf.setText("");
		}
		// 업주내역
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

		// 업주지난내역
		else if (ob == bsAuction.bsAuctionHistory.endStartDateBtn) {
			calendarView = new CalendarView("", bsAuction.bsAuctionHistory.endStartDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.bsAuctionHistory.endEndDateBtn) {
			calendarView = new CalendarView("", bsAuction.bsAuctionHistory.endEndDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.bsAuctionHistory.sixMonthBtn) {
			setDayTf(6);
		} else if (ob == bsAuction.bsAuctionHistory.threeMonthBtn) {
			setDayTf(3);
		} else if (ob == bsAuction.bsAuctionHistory.oneMonthBtn) {
			setDayTf(1);
		} else if (ob == bsAuction.bsAuctionHistory.bidListViewBtn) {
			SetHistory(bsAuction.bsAuctionHistory.endStartDateTf.getText(),bsAuction.bsAuctionHistory.endEndDateTf.getText());
			getBarChart(bsAuction.bsAuctionHistory.endStartDateTf.getText(),bsAuction.bsAuctionHistory.endEndDateTf.getText());
		}

		// 업주메뉴탭메인
		else if (ob == bsMenuList.homebutton) {
			bsMenuList.setVisible(false);
			bsMain.setVisible(true);
		} 

		// 업주정보탭메인
		else if (ob == bsInfo.homebutton) {
			bsInfo.setVisible(false);
			bsMain.setVisible(true);
		} else if (ob == bsInfo.renameBtn) {
			rename();
		} else if (ob == bsInfo.secessionBtn) {
			out();
		}

		// 업주 등록
		else if (ob == bsAuctionLogic.bsBidRegister.homebutton) {
			System.out.println("등록 리스너 작동중");
			bsAuctionLogic.bsBidRegister.setVisible(false);
			bsMain.setVisible(true);
		} else if (ob == bsAuctionLogic.bsBidRegister.notAgree) {
			bsAuctionLogic.bsBidRegister.setVisible(false);
		} else if (ob == bsAuctionLogic.bsBidRegister.agree) {
			JOptionPane.showMessageDialog(bsAuctionLogic.bsBidRegister.agree, "입찰되었습니다^^ 감사합니다", "입찰확인창",
					JOptionPane.OK_CANCEL_OPTION);
			bsAuctionLogic.bsBidRegister.setVisible(false);
		} else if (ob == bsAuctionLogic.bsBidRegister.homebutton) {
			bsAuctionLogic.bsBidRegister.setVisible(false);
		}
	}

	// 추가함수
	
	private void setDayTf(int gapMonth) {//개월별 보기
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		bsAuction.bsAuctionHistory.endEndDateTf.setText(year + "/" + month + "/" + day);

		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		} else {
			month -= gapMonth;
		}
		bsAuction.bsAuctionHistory.endStartDateTf.setText(year + "/" + month + "/" + day);

		String sd = bsAuction.bsAuctionHistory.endStartDateTf.getText();
		String ed = bsAuction.bsAuctionHistory.endEndDateTf.getText();
		SetHistory(sd, ed);
		getBarChart(sd, ed);

	}

	public void SetHistory(String sd, String ed) {//테이블내역생성함수
		int size=bsAuction.bsAuctionHistory.endBidTable.getRowCount();//테이블 초기화
		 System.out.println(size);
		 for (int i = 0; i < size; i++) {
		 bsAuction.bsAuctionHistory.model.removeRow(0);
		 }
		 //
		 String id = login.idTf.getText();//id받아오기
		 //
		st = new StringTokenizer(sd, "/");
		int sYear = Integer.parseInt(st.nextToken());// 2016
		int sMonth = Integer.parseInt(st.nextToken());// 03
		int sDay = Integer.parseInt(st.nextToken());// 22
		int year = 0;
		int month = 0;
		int day = 0;
		
		st3 = new StringTokenizer(ed, "/");
		int eYear = Integer.parseInt(st3.nextToken());;//2016
		int eMonth = Integer.parseInt(st3.nextToken());;//04
		int eDay = Integer.parseInt(st3.nextToken());;//22

		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBConnection.makeConnection();
			String sql = "select user_id, to_char(bid_date,'yyyy-mm-dd') b, bid_price\n";
			sql += "from auction,bid\n";
			sql += "where auction.auction_seq=bid.auction_seq\n";
			sql += "and auction.auction_flag=1";
			sql += "and bid.store_id=(select store_id\nfrom store\nwhere user_id='"+id+"')";
			
			s = c.createStatement();
			rs = s.executeQuery(sql);
			
			while (rs.next()) {
				str[0] = rs.getString("user_id");
				str[1] = rs.getString("b");
				str[2] = rs.getString("bid_price");

				st2 = new StringTokenizer(str[1], "-");
				year = Integer.parseInt(st2.nextToken());// 2016
				month = Integer.parseInt(st2.nextToken());// 04
				day = Integer.parseInt(st2.nextToken().substring(0,2));// 22

				if (year > sYear || year == sYear && month > sMonth || year == sYear && month == sMonth && day >= sDay) {
					if (year < eYear || year == eYear && month < eMonth || year == eYear && month == eMonth && day <= eDay) {
						bsAuction.bsAuctionHistory.model.addRow(str);
					}
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(c, s, rs);
		}
	}

	public void rename() {//수정
		
		String id = bsInfo.idTf.getText();
		String pw = bsInfo.pwTf.getText();
		String pwCheck = bsInfo.pwCheckTf.getText();
		String name = bsInfo.nameTf.getText();
		String phone = bsInfo.phoneTf.getText();
		String email = bsInfo.emailTf.getText();
		
		String storeName = bsInfo.storeNameTf.getText();
		String busseNum = bsInfo.bsNumTf.getText();
		String storePhone = bsInfo.storePhoneTf.getText();
		int location = bsInfo.dongCombo.getSelectedIndex();
		int category = bsInfo.categoryCombo.getSelectedIndex();
		String people = bsInfo.storePeopleTf.getText();
		String img = bsInfo.storeImgTf.getText();

		if (!pw.equals(pwCheck)) {
			JOptionPane.showConfirmDialog(null, "비밀번호 확인!", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
		} else {

			Connection c = null;
			Statement s = null;
			int cnt = 0;
			int cnt2 = 0;

			try {
				c = DBConnection.makeConnection();
				
				String sql = "update rbsuser\n";
				sql += "set user_password='" + pw + "', user_name='"+name
						+"', user_phone='" + phone+"', user_email='"+email+"'\n";
				sql += "where user_id='" + id + "'";
				
				String sql2 = "update store\n";
				sql2 += "set business_num='"+busseNum+"', store_name='"+storeName+"', dong_id="+location
						+ ", category_id="+category+", store_phonenum='" + storePhone
						+ "', store_peoplenum='"+people+"', store_img='"+img+"'\n";
				sql2 += "where user_id='" + id + "'";
				
				s = c.createStatement();
				cnt = s.executeUpdate(sql);
				cnt2 = s.executeUpdate(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(c, s);
			}
			if (cnt!=0 && cnt2!=0) {
				JOptionPane.showConfirmDialog(null, "수정되었습니다.", "수정 확인", JOptionPane.DEFAULT_OPTION);
				bsInfo.pwCheckTf.setText("");
				bsInfo.setVisible(false);
				bsMain.setVisible(true);
			}
		}
	}
	
	public void out(){//탈퇴
		String id = bsInfo.idTf.getText();
		String pw = bsInfo.pwTf.getText();
		String pwCheck = bsInfo.pwCheckTf.getText();
		
		if (!pw.equals(pwCheck)) {
			JOptionPane.showConfirmDialog(null, "비밀번호 확인!", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
		} else {
			Connection c = null;
			Statement s = null;
			int cnt = 0;
			int cnt2 = 0;
			int cnt3 = 0;
			int cnt4 = 0;
	
			try {
				c = DBConnection.makeConnection();
				
				String sql = "delete from menu\n";
				sql += "where store_id=(select store_id\nfrom store\nwhere user_id='"+id+"')";
				
				String sql2 = "delete from bid\n";
				sql2 += "where store_id=(select store_id\nfrom store\nwhere user_id='"+id+"')";
				
				String sql3 = "delete from store\n";
				sql3 += "where user_id='"+id+"'";
				
				String sql4 = "delete from rbsuser\n";
				sql4 += "where user_id='"+id+"'";
				
				s = c.createStatement();
				cnt = s.executeUpdate(sql);
				cnt2 = s.executeUpdate(sql2);
				cnt3 = s.executeUpdate(sql3);
				cnt4 = s.executeUpdate(sql4);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(c, s);
			}
			
			if (cnt!=0 && cnt2 !=0 && cnt3 !=0 && cnt4 !=0) {
				JOptionPane.showConfirmDialog(null, "탈퇴되었습니다.", "탈퇴 확인", JOptionPane.DEFAULT_OPTION);
				bsInfo.pwCheckTf.setText("");
				bsInfo.setVisible(false);
				login.setVisible(true);
				login.idTf.setText("");
			}
		}
	}
	
	public void bsGet(){//정보불러오기
		
		String id=login.idTf.getText();//
		
		BusinessManDao bmd = new BusinessManDao();
		BusinessManDto bmt = new BusinessManDto();
		bmt = bmd.selectUser(id);
		
		bsInfo.idTf.setText(bmt.getUserId());
		bsInfo.pwTf.setText(bmt.getUserPass());
		bsInfo.nameTf.setText(bmt.getUserName());
		bsInfo.phoneTf.setText(bmt.getUserPhone());
		bsInfo.emailTf.setText(bmt.getUserEmail());

		bsInfo.storeNameTf.setText(bmt.getStoreName());
		bsInfo.bsNumTf.setText(bmt.getBusinessNum());
		bsInfo.storePhoneTf.setText(bmt.getStorePhone());
		bsInfo.dongCombo.setSelectedIndex(bmt.getLocation());
		bsInfo.categoryCombo.setSelectedIndex(bmt.getCategory());
		bsInfo.storePeopleTf.setText(bmt.getPeople());
		bsInfo.storeImgTf.setText(bmt.getStoreImg());
	}
	
	public void getBarChart(String sd, String ed) {//차트생성
		t1 = new StringTokenizer(sd, "/");
		t1.nextToken();
		t2 = new StringTokenizer(ed, "/");
		t2.nextToken();
		
		//시작tf와 끝tf month얻어와서 비교하기
		String st = t1.nextToken();//"12"
		String en = t2.nextToken();//"2"
		
		int sm=0;
		int em=0;
		
		String mon[] = {"11","12","01","02","03","04"};
		for (int i = 0; i < mon.length; i++) {
			if (Integer.parseInt(mon[i])==Integer.parseInt((st))) {
				sm=i;
			}
			if (Integer.parseInt(mon[i])==Integer.parseInt((en))) {
				em=i+1;
			}
		}
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = sm; i < em; i++) {
			dataset.setValue(countMonth(mon[i]), "낙찰", mon[i]+"월");//차트데이터
		}
		
		JFreeChart chart = ChartFactory.createBarChart	(//차트
			"","월", "낙찰", dataset, PlotOrientation.VERTICAL, false,true, false);
		chart.setBackgroundPaint(Color.yellow);
		chart.getTitle().setPaint(Color.blue); 
		CategoryPlot p = chart.getCategoryPlot(); 
		p.setRangeGridlinePaint(Color.red); 
		
		p.getDomainAxis().setLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));// X 축의 라벨 설정입니다. (보조 타이틀)
		p.getDomainAxis().setTickLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));// X 축의 도메인 설정입니다.
		p.getRangeAxis().setLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));// Y 축의 라벨 설정입니다. (보조 타이틀)
		p.getRangeAxis().setTickLabelFont(new Font("나눔바른고딕", Font.BOLD, 8));// Y 축의 도메인 설정입니다.
		
		bsAuction.bsAuctionHistory.graphPn = new ChartPanel(chart);
		bsAuction.bsAuctionHistory.add(bsAuction.bsAuctionHistory.graphPn);
		bsAuction.bsAuctionHistory.graphPn.setBounds(12, 6, 355, 227);

	}//
	
	public int countMonth(String m){//월별내역횟수
		//
		String id = login.idTf.getText();
		//
		String month=m;
		int cm=0;
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBConnection.makeConnection();
			String sql = "select count(bc) mc\n";
			sql += "from (select to_char(bid_date,'mm') bc\n";
			sql += "from auction,bid\n";
			sql += "where auction.auction_seq=bid.auction_seq\n";
			sql += "and auction.auction_flag=1\n";
			sql += "and bid.store_id=(select store_id\nfrom store\nwhere user_id='"+id+"'))\n";
			sql += "group by bc\n";
			sql += "having bc='"+m+"'";
			
			s = c.createStatement();
			rs = s.executeQuery(sql);
			while (rs.next()) {
				cm = Integer.parseInt(rs.getString("mc"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(c, s, rs);
		}
		
		return cm;
	}
	
	public void SearchAllList(){
		int size=bsAuction.ingAuctionTable.getRowCount();//테이블 초기화
		 System.out.println(size);
		 for (int i = 0; i < size; i++) {
		 bsAuction.model2.removeRow(0);
		 }
		
      String str[] = new String[4];
      BSAuctionDto BSdto=null;
      Connection conn=null;
      Statement stmt =null;
      ResultSet rs=null;
      
      try {
//         conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.114:1521:orcl","kitri","kitri");
    	 conn=DBConnection.makeConnection();
         String sql="";
         sql+="select u.User_name, a.Auction_date, a.Auction_people, a.Auction_price  \n";
         sql+="from Auction a, RBSUser u \n ";
         sql+="where u.user_id = a.user_id \n";
         sql+="and a.auction_flag =0 ";
//         sql+="from RBSUser u, Auction a, Goo g, Location l, Store s\n";
//         sql+="where g.Goo_id = l.Goo_id \n";
//         sql+="and u.user_id = a.user_id \n";
//         sql+="and s.location_id = l.location_id  \n";
//         sql+="and s.user_id = u.user_id  \n";
//         sql+="and a.Bid_flag =  \n";
         
//         sql+="and Goo_name = '구로구' \n";
//         sql+="and Location_name = '구로동'"; //구,동 dao를 따로 만들어서  이전에 실행해줘야하는지???
         //sql+="달력조회의 기간사이의 데이터 불러올 sql문";
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
         while(rs.next()){
            BSdto = new BSAuctionDto();
            BSdto.setUser_name(rs.getString("User_name"));
            BSdto.setAuction_date(rs.getString("Auction_date"));
            BSdto.setAuction_People(rs.getInt("Auction_people"));
            BSdto.setAuction_Price(rs.getInt("Auction_price"));
            
            str[0] = BSdto.getUser_name();
            str[1] = BSdto.getAuction_date();
            str[2] = Integer.toString(BSdto.getAuction_People());
            str[3] = Integer.toString(BSdto.getAuction_Price());
            bsAuction.model2.addRow(str);
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
            try {
               if(rs!=null)
                  rs.close();
               if(stmt!=null)
                  stmt.close();
               if(conn!=null)
                  conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
         }
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
				bsInfo.dongCombo.addItem(rs.getString("dong_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(c, s, rs);
		}
	}
	
	public void setCategory(){//카테고리combobox
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = DBConnection.makeConnection();
			
			String sql = "select category_name\n";
			sql += "from rbscategory";
			
			s = c.createStatement();
			rs=s.executeQuery(sql);
			while (rs.next()) {
				bsInfo.categoryCombo.addItem(rs.getString("category_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(c, s, rs);
		}
	}

	//
}
