package com.kitri4.GGY.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kitri4.GGY.Admin.AdminMain;
import com.kitri4.GGY.BSMember.BSMain;
import com.kitri4.GGY.Common.RBSMain;
import com.kitri4.GGY.Dao.CategoryDao;
import com.kitri4.GGY.Dao.GooDao;
import com.kitri4.GGY.Dao.LocationDao;
import com.kitri4.GGY.Dao.RbsUserDao;
import com.kitri4.GGY.Dao.StoreDao;
import com.kitri4.GGY.Dto.LocationDto;
import com.kitri4.GGY.Dto.StoreDto;
import com.kitri4.GGY.Dto.UserDto;
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
						memberJoin.nameTf.getText(), memberJoin.phoneNumTf.getText(), memberJoin.emailTf.getText(), 1);
				if (joinB) {
					JOptionPane.showConfirmDialog(null, "ȸ�����ԵǾ����ϴ�.\nȯ���մϴ�~ ^^", "�˸�", JOptionPane.DEFAULT_OPTION);
					login.setVisible(true);
					memberJoin.setVisible(false);
				} else {
					joinError();
				}
			} else {
				passwordError();
			}
		} else if (ob == memberJoin.cancleBtn || ob == bsMemberJoin.cancleBtn) {
			JOptionPane.showConfirmDialog(null, "����ұ��?", "���", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} 
		/*login*/
		else if (ob.equals(login.joinBtn)) {
			if (JOptionPane.showConfirmDialog(null, "�Ϲ�ȸ���Դϱ�? \n����ȸ���� No�� �����ּ���.", "ȸ����������",
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
				int flag = selectUser.getUserFlag();

				if (flag == 1) {
					memberMain.setVisible(true);
					login.setVisible(false);
				} else if (flag == 2) {
					bsMain.setVisible(true);
					login.setVisible(false);
				} else if (flag == 0) {
					adminMain.setVisible(true);
					login.setVisible(false);
				}
			}
		}
		/*bsMemberJoin*/
		else if (ob == bsMemberJoin.joinBtn) {
			if (bsMemberJoin.pwTf.getText().equals(bsMemberJoin.pwCheckTf.getText()))
				if(checkBsMemberJoin()){
					JOptionPane.showConfirmDialog(null, "ȸ�����ԵǾ����ϴ�.\nȯ���մϴ�~ ^^", "�˸�", JOptionPane.DEFAULT_OPTION);
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
		boolean joinB = checkMemberJoin(bsMemberJoin.idTf.getText(), bsMemberJoin.pwTf.getText(),
				bsMemberJoin.nameTf.getText(), bsMemberJoin.phoneTf.getText(), bsMemberJoin.emailTf.getText(), 2);
		if (!joinB) {
			joinError();
			return false;
		}

		return checkStoreJoin(bsMemberJoin.idTf.getText(), bsMemberJoin.bsNumTf.getText(), bsMemberJoin.storeNameTf.getText(),
										bsMemberJoin.storeLocalTf.getText(), bsMemberJoin.categoryTf.getText(),
										bsMemberJoin.storePhoneTf.getText(), bsMemberJoin.storePeopleTf.getText(),
										bsMemberJoin.storeImgTf.getText());
	}

	private boolean checkStoreJoin(String id, String bsNum, String storeName, String location, String category, String storePhoneNum,
			String peopleNum, String imgPath) {
		StoreDao storeDao = new StoreDao();

		LocationDao locationDao = new LocationDao();
		int locationId = locationDao.select(location).getLocationId();
		
		CategoryDao categoryDao = new CategoryDao();
		int categoryId = categoryDao.select(category).getCategoryId();
		
		StoreDto storeDto = new StoreDto();
		storeDto.setUserId(id);
		storeDto.setBusinessNum(bsNum);
		storeDto.setStoreName(storeName);
		storeDto.setLocation(locationId);			
		storeDto.setCategory(categoryId);			
		storeDto.setStorePhone(storePhoneNum);
		storeDto.setPeople(peopleNum);
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
		userDto.setUserFlag(flag);

		if (userDao.insert(userDto) == 1) {
			return true;
		} else {
			return false;
		}
	}

	private void joinError() {
		JOptionPane.showConfirmDialog(null, "ȸ�����Խ����߽��ϴ�.\n���̵� Ȯ���� �ּ���.", "�˸�", JOptionPane.ERROR_MESSAGE);
		memberJoin.idTf.setText("");
	}

	private void passwordError() {
		JOptionPane.showConfirmDialog(null, "��й�ȣ�� �ٽ� Ȯ���� �ּ���.", "�˸�", JOptionPane.ERROR_MESSAGE);
		memberJoin.pwCheckTf.setText("");
		memberJoin.pwTf.setText("");
	}

	private void checkId(String setId) {
		if (setId.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "���̵�� �����ϼ� �����ϴ�.", "���̵� ����", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(null, "����� �� �ִ� ���̵��Դϴ�.", "���̵� Ȯ��", JOptionPane.DEFAULT_OPTION);
		}
	}
}