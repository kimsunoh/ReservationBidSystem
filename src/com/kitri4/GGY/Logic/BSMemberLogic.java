package com.kitri4.GGY.Logic;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.kitri4.GGY.BSMember.*;
import com.kitri4.GGY.Common.CalendarView;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dto.MenuDto;
import com.kitri4.GGY.Main.Login;

import com.kitri4.GGY.Dao.*;

public class BSMemberLogic implements ActionListener{
	Login login = null;
	BSMain bsMain = null;
	BSAuction bsAuction = null;
	BSAuctionHistory bsAuctionHistory = null;
	BSAuctionLogic bsAuctionLogic = null;
	BSMenuList bsMenuList = null;
	BSInfo bsInfo = null;
	CalendarView calendarView = null;
	BSBidRegister bsBidRegister = null;
	MenuDao menudao = new MenuDao();
	MenuDto menudto = null;
	ArrayList<MenuDto> list = null;
	String filename;
	String filepath;
	
	public BSMemberLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.bsMain = rbsMain.bsMain;
		this.bsAuction = rbsMain.bsAuction;
		this.bsAuctionLogic = rbsMain.bsAuctionLogic;
	//	this.bsAuctionHistory = rbsMain.bsAuctionHistory;
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
//			bsAuction.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} else if (ob == bsMain.storeMenuBtn) {
			bsMenuList.setVisible(true);
			bsMain.setVisible(false);
		} else if (ob == bsMain.InfoBtn) {
			bsInfo.setVisible(true);
//			bsInfo.tabbedPane.setSelectedIndex(1);
			bsMain.setVisible(false);
		} 
		//업주내역탭메인
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
		
		//업주내역
		else if (ob == bsAuction.bsAuctionHistory.endStartDateBtn) {
			System.out.println("업주내역 cal 버튼");
			calendarView = new CalendarView("", bsAuction.bsAuctionHistory.endStartDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.bsAuctionHistory.endEndDateBtn) {
			calendarView = new CalendarView("", bsAuction.bsAuctionHistory.endEndDateTf);
			calendarView.setVisible(true);
		} else if (ob == bsAuction.bsAuctionHistory.sixMonthBtn) {
			calendarView.setDayTf(6,  bsAuction.bsAuctionHistory.endStartDateTf, bsAuction.bsAuctionHistory.endEndDateTf);
		} else if (ob == bsAuction.bsAuctionHistory.threeMonthBtn) {
			calendarView.setDayTf(3, bsAuction.bsAuctionHistory.endStartDateTf, bsAuction.bsAuctionHistory.endEndDateTf);
		} else if (ob == bsAuction.bsAuctionHistory.oneMonthBtn) {
			calendarView.setDayTf(1, bsAuction.bsAuctionHistory.endStartDateTf, bsAuction.bsAuctionHistory.endEndDateTf);
		} 
		
		//성훈업주메뉴탭메인
		else if (ob == bsMenuList.homebutton) {
			bsMenuList.setVisible(false);
			bsMain.setVisible(true);	
//			menudao =new MenuDao();
//	        list=menudao.list();
			
		}
		else if (ob == bsMenuList.menuAddBtn) {
			// 신규 메뉴 등록 버튼

			bsMenuList.tabbedPane.setSelectedComponent(bsMenuList.panel_3);

		} else if (ob == bsMenuList.openPicturBtn) {
			// 사진 불러오기
			// 열기

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(BMP,JPEG,PNG, extensions)", "bmp",
					"jpg", "png");
			bsMenuList.fc.setDialogTitle("image 를 선택하세요");
			bsMenuList.fc.setFileFilter(filter);
			bsMenuList.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			if (bsMenuList.fc.showOpenDialog(bsMenuList.fileOpen) == JFileChooser.APPROVE_OPTION) {
				bsMenuList.Seepicture.setText("");
				File saveFile = bsMenuList.fc.getSelectedFile(); // 파일 저장됨 지금
																	
				filename = bsMenuList.fc.getSelectedFile().getName(); // 업로드 파일 이름
				filepath = bsMenuList.fc.getSelectedFile().getAbsolutePath();				// 경로.getAbsolutePath();													// 저장
				ImageIcon imageicon = new ImageIcon(filename); // 경로로 이미지아이콘생성
				Image image = imageicon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH); // 사이즈지정
				bsMenuList.Seepicture.setIcon(new ImageIcon(image));// Seepicture
																	// 라벨에 이미지
																	// 뿌리기
			} else {
				// 취소 버튼을 누르면
				bsMenuList.Seepicture.setIcon(new ImageIcon());
				bsMenuList.Seepicture.setText("파일을 열지 못했습니다");
			}
		} else if (ob == bsMenuList.addMenuBtn) {// 등록
			System.out.println("경로 "+filename);
			String menuName = bsMenuList.menuNameTf.getText();
			String menuPrice = bsMenuList.priceTf.getText();
			String menuInformation = bsMenuList.menuInfoTf.getText();
			Icon imagicon= bsMenuList.Seepicture.getIcon();
			System.out.println(imagicon);
			bsMenuList.tabbedPane.setSelectedComponent(bsMenuList.panel_2);

		} else if (ob == bsMenuList.renameMenuBtn) {// 수정

			String menuName = bsMenuList.menuNameTf.getText();
			String menuPrice = bsMenuList.priceTf.getText();
			String menuInformation = bsMenuList.menuInfoTf.getText();
			bsMenuList.tabbedPane.setSelectedComponent(bsMenuList.panel_2);

		} else if (ob == bsMenuList.removeMenuBtn) {// 삭제버튼

			bsMenuList.dialog.setTitle("삭제 하시겠습니까?");
			bsMenuList.dialog.setSize(200, 80);
			bsMenuList.dialog.setLocation(900, 500);
			bsMenuList.dialog.setVisible(true);
		} else if (e.getSource() == bsMenuList.okBtn) {
			bsMenuList.dialog.dispose();
			/*
			 * 0422 삭제소스
			 * 
			 */
			String menuName = bsMenuList.menuNameTf.getText();

			//menudao.delete(menuName);

			// 삭제 Source 필요
			bsMenuList.tabbedPane.setSelectedComponent(bsMenuList.panel_2);
		} else if (e.getSource() == bsMenuList.cancleBtn) {
			bsMenuList.dialog.dispose();
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
		else if(ob == bsAuctionLogic.bsBidRegister.homebutton) {
			System.out.println("등록 리스너 작동중");
			bsAuctionLogic.bsBidRegister.setVisible(false);
			bsMain.setVisible(true);
		} else if(ob == bsAuctionLogic.bsBidRegister.notAgree){
			bsAuctionLogic.bsBidRegister.setVisible(false);
		} else if(ob ==bsAuctionLogic.bsBidRegister.agree) {
			JOptionPane.showMessageDialog(bsAuctionLogic.bsBidRegister.agree, "입찰되었습니다^^ 감사합니다", "입찰확인창",JOptionPane.OK_CANCEL_OPTION);
			bsAuctionLogic.bsBidRegister.setVisible(false);
		} else if(ob == bsAuctionLogic.bsBidRegister.homebutton) {
			bsAuctionLogic.bsBidRegister.setVisible(false);
		}
	}
}
