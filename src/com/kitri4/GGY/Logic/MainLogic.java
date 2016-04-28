package com.kitri4.GGY.Logic;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.kitri4.GGY.Admin.AdminMain;
import com.kitri4.GGY.BSMember.BSMain;
import com.kitri4.GGY.Common.FileCopy;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dao.rbsCategoryDao;
import com.kitri4.GGY.Dao.GooDao;
import com.kitri4.GGY.Dao.dongDao;
import com.kitri4.GGY.Dao.RbsUserDao;
import com.kitri4.GGY.Dao.StoreDao;
import com.kitri4.GGY.Dto.*;
import com.kitri4.GGY.Main.*;
import com.kitri4.GGY.Member.MemberAuction;
import com.kitri4.GGY.Member.MemberMain;

public class MainLogic implements ActionListener {
	public Login login;
	public MemberJoin memberJoin;
	public BSMemberJoin bsMemberJoin;
	public MemberMain memberMain;
	public BSMain bsMain;
	public AdminMain adminMain;
	public String filepath = null;
	public String filename = null;
	
	public MainLogic(RBSMain rbsMain) {
		this.login = rbsMain.login;
		this.memberJoin = rbsMain.memberJoin;
		this.bsMemberJoin = rbsMain.bsMemberJoin;
		this.memberMain = rbsMain.memberMain;
		this.bsMain = rbsMain.bsMain;
		this.adminMain = rbsMain.adminMain;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		/* memberJoin */
		if (ob == memberJoin.checkIdBtn) {
			checkId(memberJoin.idTf.getText());
		} else if (ob == memberJoin.memJoinBtn) {
			if (memberJoin.pwTf.getText().equals(memberJoin.pwCheckTf.getText())) {
				boolean joinB = checkMemberJoin(memberJoin.idTf.getText(), memberJoin.pwTf.getText(),
						memberJoin.nameTf.getText(), memberJoin.phoneNumTf.getText(), memberJoin.emailTf.getText(), 2);
				if (joinB) {
					JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
					login.setVisible(true);
					memberJoin.setVisible(false);
				} else {
					joinError();
				}
			} else {
				passwordError(memberJoin);
			}
		} else if (ob == memberJoin.cancleBtn || ob == bsMemberJoin.cancleBtn) {
			JOptionPane.showConfirmDialog(null, "취소할까요?", "취소", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		}
		/* login */
		else if (ob.equals(login.joinBtn)) {
			Object[] options = {"일반회원", "업주회원"};
            int selectedNum = JOptionPane.showOptionDialog(login, "회원유형을 선택해주세요.", "회원유형선택", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
			if (selectedNum == 0) {
				memberJoin.setVisible(true);
			} else {
				bsMemberJoin.setVisible(true);
			}
			login.setVisible(false);
		} else if (ob == login.loginBtn) {
			String loginId = login.idTf.getText();
			String loginPw = login.pwTf.getText();

			RbsUserDao userDao = new RbsUserDao();

			UserDto selectUser = userDao.select(loginId);

			if (selectUser == null) {
				JOptionPane.showConfirmDialog(null, "not found Id", "ID Error", JOptionPane.DEFAULT_OPTION);
				return;
			}

			if (selectUser.getUserPassword().equals(loginPw)) {
				int flag = Integer.parseInt(selectUser.getUserFlag());

				if (flag == 2) {
					memberMain.setVisible(true);
					login.setVisible(false);
				} else if (flag == 3) {
					bsMain.setVisible(true);
					login.setVisible(false);
				} else if (flag == 1) {
					adminMain.setVisible(true);
					login.setVisible(false);
				}
			}
		}
		//
		/* bsMemberJoin */
		else if (ob == bsMemberJoin.joinBtn) {
			if (bsMemberJoin.pwTf.getText().equals(bsMemberJoin.pwCheckTf.getText()))
				if (checkBsMemberJoin()) {
					addStoreImg();
					JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
				} else {
					joinError();
					login.setVisible(true);
					bsMemberJoin.setVisible(false);
			} else {
				passwordError(bsMemberJoin);
			}
		} else if (ob == bsMemberJoin.checkIdBtn) {
			checkId(bsMemberJoin.idTf.getText());
		} else if (ob == bsMemberJoin.getStoreImgBtn) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(BMP,JPEG,PNG, extensions)", "bmp",
					"jpg", "png");
			bsMemberJoin.fc.setDialogTitle("image 를 선택하세요");
			bsMemberJoin.fc.setFileFilter(filter);
			bsMemberJoin.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			if (bsMemberJoin.fc.showOpenDialog(bsMemberJoin.getStoreImgBtn) == JFileChooser.APPROVE_OPTION) {
				filename = bsMemberJoin.fc.getSelectedFile().getName();
				filepath = bsMemberJoin.fc.getSelectedFile().getAbsolutePath();
				
				bsMemberJoin.storeImgTf.setText(filepath);

			}
		} else if (ob == bsMemberJoin.homebutton) {
			login.setVisible(true);
			bsMemberJoin.setVisible(false);
		}
		//
	}

	private void addStoreImg() {
		//String storeImgPath = "C:\\Users\\KITRI\\Desktop\\ggyo0428\\ggyobeta\\src\\com\\kitri4\\GGY\\img\\store\\" ;
		String storeImgPath = "C:\\Users\\KITRI\\Documents\\GitHub\\ReservationBidSystem\\src\\com\\kitri4\\GGY\\img\\store\\" ; //선오
		FileCopy s = new FileCopy();// FileCopy 클래스 생성.
		String outputFile = storeImgPath + filename;// 선택된 파일네임으로 경로 지정
		try {
			s.copy(filepath, outputFile); // inputFile 로 , outFile 메소드
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	private boolean checkBsMemberJoin() {
		boolean joinUser = checkMemberJoin(bsMemberJoin.idTf.getText().trim(), bsMemberJoin.pwTf.getText().trim(),
				bsMemberJoin.nameTf.getText().trim(), bsMemberJoin.phoneTf.getText().trim(),
				bsMemberJoin.emailTf.getText().trim(), 3);
		if (!joinUser) {
			joinError();
			return false;
		}

		boolean joinStore = checkStoreJoin(bsMemberJoin.idTf.getText().trim(), bsMemberJoin.bsNumTf.getText().trim(),
				bsMemberJoin.storeNameTf.getText().trim(), bsMemberJoin.dongComb.getSelectedIndex(),
				bsMemberJoin.categoryComb.getSelectedIndex(), bsMemberJoin.storePhoneTf.getText().trim(),
				bsMemberJoin.storePeopleTf.getText().trim(), filename);
		/*
		 * String id, String bsNum, String storeName, int dongIdx, int
		 * categoryIdx, String storePhoneNum, String peopleNum, String imgPath
		 */
		if (!joinStore) {
			new RbsUserDao().delete(bsMemberJoin.idTf.getText().trim());
			return false;
		} else {
			return true;
		}

	}

	private boolean checkStoreJoin(String id, String bsNum, String storeName, int dongIdx, int categoryIdx,
			String storePhoneNum, String peopleNum, String imgPath) {
		StoreDao storeDao = new StoreDao();

		dongDao dongDao = new dongDao();
		String dongName = bsMemberJoin.dongComb.getItemAt(dongIdx).toString();
		System.out.println("동이름 : " + dongName);
		int dongId = dongDao.select(dongName).getDongId();

		String category = bsMemberJoin.categoryComb.getItemAt(categoryIdx).toString();
		rbsCategoryDao categoryDao = new rbsCategoryDao();
		int categoryId = categoryDao.select(category).getCategoryId();

		StoreDto storeDto = new StoreDto();
		storeDto.setUserId(id);
		storeDto.setBusinessNum(bsNum);
		storeDto.setStoreName(storeName);
		storeDto.setDongId(dongId);
		storeDto.setCategoryId(categoryId);
		storeDto.setStorePhone(storePhoneNum);
		storeDto.setPeopleNum(peopleNum);
		storeDto.setStoreImg(imgPath);
		storeDto.setBusinessFlag(0);

		if (storeDao.insert(storeDto) == 1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkMemberJoin(String id, String pw, String name, String phoneNum, String email, int flag) {
		RbsUserDao userDao = new RbsUserDao();

		UserDto selectUserDto = userDao.select(id);

		if (selectUserDto != null)
			return false;

		UserDto userDto = new UserDto();
		userDto.setUserId(id);
		userDto.setUserPassword(pw);
		userDto.setUserName(name);
		userDto.setUserPhoneNumber(phoneNum);
		userDto.setUserEmail(email);
		userDto.setUserFlag(flag + "");

		if (userDao.insert(userDto) == 1) {
			return true;
		} else {
			return false;
		}
	}

	private void joinError() {
		JOptionPane.showConfirmDialog(null, "회원가입실패했습니다.\n아이디를 확인해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
		memberJoin.idTf.setText("");
	}

	private void passwordError(Object ob) {
		JOptionPane.showConfirmDialog(null, "비밀번호를 다시 확인해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
		if (ob == memberJoin) {
			memberJoin.pwCheckTf.setText("");
			memberJoin.pwTf.setText("");
		} else {
			bsMemberJoin.pwCheckTf.setText("");
			bsMemberJoin.pwTf.setText("");
		}
	}

	private void checkId(String setId) {
		UserDto userDto = new RbsUserDao().select(setId);
		if (userDto != null) {
			JOptionPane.showConfirmDialog(null, "사용중인 아이디입니다.", "아이디 오류", JOptionPane.ERROR_MESSAGE);
		} else if (setId.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "아이디는 공백일수 없습니다.", "아이디 오류", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(null, "사용할 수 있는 아이디입니다.", "아이디 확인", JOptionPane.DEFAULT_OPTION);
		}
	}
}
