package com.kitri4.RBS.common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.MathContext;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CalendarView extends JFrame implements ActionListener {
	String[] days = { "일","월", "화", "수", "목", "금", "토"};
	int year, month, day, todays, memoday = 0;
	Font f;
	Color bc, fc;
	Calendar today;
	Calendar cal;
	JButton btnBefore, btnAfter;
	JButton[] calBtn = new JButton[42];
	JLabel thing;
	JLabel time;
	JPanel panWest;
	JPanel panSouth;
	JPanel panNorth;
	JTextField txtMonth, txtYear;
	JTextField txtTime;
	BorderLayout bLayout = new BorderLayout();
	
	JTextField setTf;
	
	public CalendarView(String string, JTextField setTf) {
		super(string);
		this.setTf = setTf;
		panNorth = new JPanel(new GridLayout(2, 1, 10, 10));

		today = Calendar.getInstance(); //�삤�뒛 �궇吏� 媛��졇�삤
										
		/*�긽�떒 �솕硫�*/ 
		cal = new GregorianCalendar();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;// �떖�쓣 0-11源뚯�濡� �릺�뼱�엳�뼱�꽌 +1
		
		JPanel yearMonth = new JPanel();
		yearMonth.add(btnBefore = new JButton("Before"));
		yearMonth.add(txtYear = new JTextField(year + "년"));
		yearMonth.add(txtMonth = new JTextField(month + "달", 3));
		yearMonth.add(btnAfter = new JButton("After"));
		
		txtYear.setEnabled(false); 
		txtMonth.setEnabled(false);
		
		f = new Font("Sherif", Font.BOLD, 18);
		txtYear.setFont(f);
		txtMonth.setFont(f);

		panNorth.add(yearMonth);
		
		JPanel week = new JPanel(new GridLayout(1, 7));
		int size = days.length;
		JLabel dayOfWeek[] = new JLabel[7];
		for (int i = 0; i < size ; i++) {
			dayOfWeek[i] = new JLabel(days[i]);
			week.add(dayOfWeek[i]);
		}
		
		dayOfWeek[0].setForeground(new Color(255,0,0));
		dayOfWeek[6].setForeground(new Color(0,0,255));
		
		panNorth.add(week);
		
		add(panNorth, "North");

		/*�븯�떒 �솕*/
		panWest = new JPanel(new GridLayout(6,7)); //�떖�쓽 �씪 踰꾪듉�씠 �뱾�뼱媛� Pn

		f = new Font("Sherif", Font.BOLD, 12);
		gridInit();
		calSet();
		hideInit();
		add(panWest, "Center");

		btnBefore.addActionListener(this);
		btnAfter.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Swing");
		setBounds(200, 200, 400, 250);
		setResizable(false);
		setVisible(true);
	}

	public void calSet() {
		int btnNum;
		cal.set(Calendar.YEAR, year); //�떖�젰�뿉 肉뚮┫ Calendar 媛앹껜�쓽 �뀈�룄 �꽕�젙
		cal.set(Calendar.MONTH, (month - 1)); //�떖�젰�뿉 肉뚮┫ Calendar 媛앹껜�쓽 �썡 �꽕�젙, �뿰�궛�뿉 �궗�슜�빐�빞 �븯誘�濡� �떎�떆 -1
		cal.set(Calendar.DATE, 1);	//�떖�젰�뿉 肉뚮━湲� �떆�옉�븷 寃껋� 1�씪 �씠�뿬�빞 �븯誘�濡� 1�씪
		/*
		 * SUNDAY,MONDAY,TUESDAY,WEDNESDAY ,THURSDAY,FRIDAY, SATURDAY
		 */
		
		int firstDayOfWeekForMonth = cal.get(Calendar.DAY_OF_WEEK) - 1; //SUNDAY媛� 1, �떖�쓽 泥ル궇 �슂�씪�쓣 �굹���궡�뒗 蹂� 
		
		/*
		 * 1.�떖�쓽 泥レ＜ 泥ル궇 �쟾源뚯��쓽 �궇 �뾾�뒗 �궇濡� �뀑�똿�븯湲�
		 * 2.�뀈�썡�쓽 泥ル궇怨� �걹�궇�븣湲�
		 * 3.1�씪遺��꽣 留덉�留� �궇源뚯� �뀑�똿
		 */
		
		for (int i = 0; i < firstDayOfWeekForMonth; i++)
			calBtn[i].setText("");
		
		int maxDay = 0;
		if ( month < 8) {
			if (month % 2 == 1)
				maxDay = 31;
			else
				maxDay = 30;
		}else {
			if (month % 2 == 0)
				maxDay = 31;
			else
				maxDay = 30;			
		}
		
		
		//i : btnNum, day
		int day = 1;
		
		while(day <= maxDay){
			//�떖�쓽 泥ル궇 �슂�씪 + cal.1�씪 = �떖�쓽 泥ル궇�슂�씪�씠 �릺�빞�븿
			btnNum = day-1 + firstDayOfWeekForMonth;
			calBtn[btnNum].setForeground(new Color(0, 0, 0));
			
			if ((btnNum) % 7 == 0) {//�씪�슂�씪�씪�븣 泥섎━
				calBtn[btnNum].setForeground(new Color(255, 0, 0));
			}else if ((btnNum) % 7 == 6) {//�넗�슂�씪�씪�븣 �깋 泥섎━
				calBtn[btnNum].setForeground(new Color(0, 0, 255));
			}
			
			calBtn[btnNum].setText(day+"");
			day++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnBefore) {
			this.panWest.removeAll();
			calInput(-1);
			gridInit();
			panWest.setLayout(new GridLayout(6,7));
			calSet();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMonth.setText(month + "월");
		} else if (ae.getSource() == btnAfter) {
			this.panWest.removeAll();
			calInput(1);
			gridInit();
			panWest.setLayout(new GridLayout(6,7));
			calSet();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMonth.setText(month + "월");
		} else if (Integer.parseInt(ae.getActionCommand()) >= 1 && Integer.parseInt(ae.getActionCommand()) <= 31) {
			day = Integer.parseInt(ae.getActionCommand());
			//�궇吏� 踰꾪듉�씠 �닃由곌굅硫� system.out 泥섎━
			setTf.setText(year + "/" + month + "/" + day);
			setVisible(false);
		}
	}

	/*btn�� 留뚮뱾�뼱 議뚯�留�, �궇吏쒓� �뾾�뒗 踰꾪듉 �닃由ъ� �븡寃� �꽕�젙�븯�뒗 硫붿냼�뱶*/
	public void hideInit() { 
		for (int i = 0; i < calBtn.length; i++) {
			if ((calBtn[i].getText()).equals(""))
				calBtn[i].setEnabled(false);
		}
	}

	/*GridLayout�뿉 踰꾪듉 �꽔湲�*/
	public void gridInit() { 
		for (int i = 0; i < 42; i++) {
			panWest.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}
	}

	/*�씠�쟾,�씠�썑 踰꾪듉�씠 �닃�졇�쓣�븣 �썡, �뀈�룄 �꽕�젙�빐二쇨린*/
	public void calInput(int gap) {
		month += (gap);
		if (month <= 0) {
			month = 12;
			year = year - 1;
		} else if (month >= 13) {
			month = 1;
			year = year + 1;
		}
	}
}
