package com.kitri4.RBS.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kitri4.RBS.Admin.AdminMain;
import com.kitri4.RBS.BSMember.BSMain;
import com.kitri4.RBS.Common.RBSMain;
import com.kitri4.RBS.Dao.RbsUserDao;
import com.kitri4.RBS.Dto.UserDto;
import com.kitri4.RBS.Main.*;
import com.kitri4.RBS.Member.MemberAuction;
import com.kitri4.RBS.Member.MemberMain;

import oracle.net.aso.r;


public class MainLogic implements ActionListener{
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
		
		if ( ob == memberJoin.checkIdBtn ) {
			checkId(login.idTf.getText());
		} else if ( ob == memberJoin.memJoinBtn ) {
			checkJoin();
		} else if ( ob == memberJoin.cancleBtn ) {
			JOptionPane.showConfirmDialog(null, "취소할까요?", "취소", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} else if (ob.equals(login.joinBtn)) {//메인
			if (JOptionPane.showConfirmDialog(null, "일반회원입니까? \n업주회원은 No를 눌러주세요.", "회원유형선택",
					JOptionPane.YES_NO_OPTION) == 0) {
				memberJoin.setVisible(true);
			} else {
				bsMemberJoin.setVisible(true);
			}
			login.setVisible(false);
		} else if (ob == login.loginBtn) {//로그인
			if (login.idTf.getText().equals("회원")) {
				memberMain.setVisible(true);
				login.setVisible(false);
			} else if (login.idTf.getText().equals("업주")) {
				bsMain.setVisible(true);
				login.setVisible(false);
			} else if (login.idTf.getText().equals("관리자")) {
				adminMain.setVisible(true);
				login.setVisible(false);
			}
		}
	}

	private void checkJoin() {
		if (memberJoin.pwTf.equals(memberJoin.pwCheckTf)) {
			UserDto userDto = new UserDto();
			userDto.setUserId(memberJoin.idTf.getText());
			userDto.setUserPassword(memberJoin.pwTf.getText());
			userDto.setUserName(memberJoin.nameTf.getText());				
			userDto.setUserPhoneNumber(memberJoin.phoneNumTf.getText());				
			userDto.setUserEmail(memberJoin.emailTf.getText());
			RbsUserDao userDao = new RbsUserDao();
			
			if ( userDao.insert(userDto) == 1 ) {
				JOptionPane.showConfirmDialog(null, "회원가입되었습니다.\n환영합니다~ ^^", 
												"알림", JOptionPane.DEFAULT_OPTION);
				login.setVisible(true);
				memberJoin.setVisible(false);
			} else {
				joinError();
			}
		} else {
			passwordError();
		}
	}

	private void joinError() {
		JOptionPane.showConfirmDialog(null, "회원가입실패했습니다.\n아이디를 확인해 주세요.",
										"알림", JOptionPane.ERROR_MESSAGE);
		memberJoin.idTf.setText("");
	}

	private void passwordError() {
		JOptionPane.showConfirmDialog(null, "비밀번호를 다시 확인해 주세요.",
											"알림", JOptionPane.ERROR_MESSAGE);
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
