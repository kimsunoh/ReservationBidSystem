//package com.kitri4.RBS.BSMember;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class BSBidRegisterLogic implements ActionListener {
//	BSBidRegister bsbidregister;
//	BSAuction bsauction = new BSAuction();
//	
//	
//	public BSBidRegisterLogic(BSBidRegister bsbidregister){
//		this.bsbidregister = bsbidregister;
//		
//		bsbidregister.notAgree.addActionListener(this);
//		bsbidregister.agree.addActionListener(this);
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object ob = e.getSource();
//		if(ob == bsbidregister.notAgree){
//			System.out.println(123);
//			bsbidregister.setVisible(false);
//			bsauction.setVisible(true);
//			bsauction.tabbedPane.setSelectedComponent(bsauction.panel_2);
////			bsauction.setVisible(true);
//		} else if(ob ==bsbidregister. agree) {
//			
//		}
//		
//	}
//
//}

package com.kitri4.GGY.BSMember;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kitri4.GGY.BSMember.BSAuction;

public class BSBidRegisterLogic implements ActionListener {
	BSBidRegister bsbidregister;
//	BSAuction bsauction = new BSAuction();
//	BSAuction bsauction;
	
	public BSBidRegisterLogic(BSBidRegister bsbidregister){
		this.bsbidregister = bsbidregister;
		
		bsbidregister.notAgree.addActionListener(this);
		bsbidregister.agree.addActionListener(this);
		bsbidregister.homebutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == bsbidregister.notAgree){
			System.out.println(123);
			bsbidregister.setVisible(false);
		} else if(ob ==bsbidregister.agree) {
			JOptionPane.showMessageDialog(bsbidregister.agree, "입찰되었습니다^^ 감사합니다", "입찰확인창",JOptionPane.OK_CANCEL_OPTION);
			bsbidregister.setVisible(false);
		} else if(ob == bsbidregister.homebutton) {
			bsbidregister.setVisible(false);
		}
		
	}

}
