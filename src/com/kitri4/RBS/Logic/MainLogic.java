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
			JOptionPane.showConfirmDialog(null, "����ұ��?", "���", JOptionPane.DEFAULT_OPTION);
			login.setVisible(true);
			memberJoin.setVisible(false);
		} else if (ob.equals(login.joinBtn)) {//����
			if (JOptionPane.showConfirmDialog(null, "�Ϲ�ȸ���Դϱ�? \n����ȸ���� No�� �����ּ���.", "ȸ����������",
					JOptionPane.YES_NO_OPTION) == 0) {
				memberJoin.setVisible(true);
			} else {
				bsMemberJoin.setVisible(true);
			}
			login.setVisible(false);
		} else if (ob == login.loginBtn) {//�α���
			if (login.idTf.getText().equals("ȸ��")) {
				memberMain.setVisible(true);
				login.setVisible(false);
			} else if (login.idTf.getText().equals("����")) {
				bsMain.setVisible(true);
				login.setVisible(false);
			} else if (login.idTf.getText().equals("������")) {
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
				JOptionPane.showConfirmDialog(null, "ȸ�����ԵǾ����ϴ�.\nȯ���մϴ�~ ^^", 
												"�˸�", JOptionPane.DEFAULT_OPTION);
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
		JOptionPane.showConfirmDialog(null, "ȸ�����Խ����߽��ϴ�.\n���̵� Ȯ���� �ּ���.",
										"�˸�", JOptionPane.ERROR_MESSAGE);
		memberJoin.idTf.setText("");
	}

	private void passwordError() {
		JOptionPane.showConfirmDialog(null, "��й�ȣ�� �ٽ� Ȯ���� �ּ���.",
											"�˸�", JOptionPane.ERROR_MESSAGE);
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
