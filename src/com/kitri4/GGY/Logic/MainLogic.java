package com.kitri4.GGY.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.kitri4.GGY.Admin.AdminMain;
import com.kitri4.GGY.BSMember.BSMain;
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

//import oracle.net.aso.r;

public class MainLogic implements ActionListener {
	public Login login;
	public MemberJoin memberJoin;
	public BSMemberJoin bsMemberJoin;
	public MemberMain memberMain;
	public BSMain bsMain;
	public AdminMain adminMain;

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

		/*memberJoin*/
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
				passwordError();
			}
		} else if (ob == memberJoin.cancleBtn || ob == bsMemberJoin.cancleBtn) {
			JOptionPane.showConfirmDialog(null, "취소할까요?", "취소", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} 
		/*login*/
		else if (ob.equals(login.joinBtn)) {
			if (JOptionPane.showConfirmDialog(null, "일반회원입니까? \n업주회원은 No를 눌러주세요.", "회원유형선택",
					JOptionPane.YES_NO_OPTION) == 0) {
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
		/*bsMemberJoin*/
		else if (ob == bsMemberJoin.joinBtn) {
			if (bsMemberJoin.pwTf.getText().equals(bsMemberJoin.pwCheckTf.getText()))
				if(checkBsMemberJoin()){
					JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", "알림", JOptionPane.DEFAULT_OPTION);
				}else {
					joinError();
				}
			else {
				passwordError();
			}
		}else if (ob == bsMemberJoin.checkIdBtn) {
			checkId(bsMemberJoin.idTf.getText());
		}
	}

	private boolean checkBsMemberJoin() {
		boolean joinUser = checkMemberJoin(bsMemberJoin.idTf.getText().trim(), bsMemberJoin.pwTf.getText().trim(),
				bsMemberJoin.nameTf.getText().trim(), bsMemberJoin.phoneTf.getText().trim(), bsMemberJoin.emailTf.getText().trim(), 3);
		if (!joinUser) {
			joinError();
			return false;
		}

		boolean joinStore = checkStoreJoin(bsMemberJoin.idTf.getText().trim(), bsMemberJoin.bsNumTf.getText().trim(), bsMemberJoin.storeNameTf.getText().trim(),
										bsMemberJoin.locationComb.getSelectedIndex(), bsMemberJoin.categoryComb.getSelectedIndex(),
										bsMemberJoin.storePhoneTf.getText().trim(),bsMemberJoin.storePeopleTf.getText().trim(), bsMemberJoin.storeImgTf.getText().trim());
		
		if (!joinStore) {
			new RbsUserDao().delete(bsMemberJoin.idTf.getText().trim());
			return false;
		}else {
			return true;
		}
		
	}

	private boolean checkStoreJoin(String id, String bsNum, String storeName, int dongIdx, int categoryIdx, String storePhoneNum,
			String peopleNum, String imgPath) {
		StoreDao storeDao = new StoreDao();

		dongDao dongDao = new dongDao();
		String dongName = bsMemberJoin.locationComb.getItemAt(dongIdx).toString();
		System.out.println("동이름 : " + dongName);
		int locationId = dongDao.select(dongName).getDongId();
				
		String category = bsMemberJoin.categoryComb.getItemAt(categoryIdx).toString();
		rbsCategoryDao categoryDao = new rbsCategoryDao();
		int categoryId = categoryDao.select(category).getCategoryId();
		
		StoreDto storeDto = new StoreDto();
		storeDto.setUserId(id);
		storeDto.setBusinessNum(bsNum);
		storeDto.setStoreName(storeName);
		storeDto.setDongId(locationId);
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
		userDto.setUserFlag(flag+"");

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

	private void passwordError() {
		JOptionPane.showConfirmDialog(null, "비밀번호를 다시 확인해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
		memberJoin.pwCheckTf.setText("");
		memberJoin.pwTf.setText("");
	}

	private void checkId(String setId) {
		if (setId.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "아이디는 공백일수 없습니다.", "아이디 오류", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(null, "사용할 수 있는 아이디입니다.", "아이디 확인", JOptionPane.DEFAULT_OPTION);
		}
	}
}
