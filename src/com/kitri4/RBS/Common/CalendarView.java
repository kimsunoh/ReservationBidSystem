package com.kitri4.RBS.Common;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.MathContext;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalendarView extends JFrame implements ActionListener {
	String[] days = { "?¼","?›”", "?™”", "?ˆ˜", "ëª?", "ê¸?", "?† "};
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

		today = Calendar.getInstance(); //ï¿½ì‚¤ï¿½ë’› ï¿½ê¶‡ï§ï¿½ åª›ï¿½ï¿½ì¡‡ï¿½ì‚¤
										
		/*ï¿½ê¸½ï¿½ë–’ ï¿½ì†•ï§ï¿½*/ 
		cal = new GregorianCalendar();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;// ï¿½ë––ï¿½ì“£ 0-11æºëš¯ï¿½æ¿¡ï¿? ï¿½ë¦ºï¿½ë¼±ï¿½ì—³ï¿½ë¼±ï¿½ê½Œ +1
		
		JPanel yearMonth = new JPanel();
		yearMonth.add(btnBefore = new JButton("Before"));
		yearMonth.add(txtYear = new JTextField(year + "?…„"));
		yearMonth.add(txtMonth = new JTextField(month + "?‹¬", 3));
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

		/*ï¿½ë¸¯ï¿½ë–’ ï¿½ì†•*/
		panWest = new JPanel(new GridLayout(6,7)); //ï¿½ë––ï¿½ì“½ ï¿½ì”ª è¸°ê¾ª?“‰ï¿½ì”  ï¿½ë±¾ï¿½ë¼±åª›ï¿½ Pn

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
		cal.set(Calendar.YEAR, year); //ï¿½ë––ï¿½ì °ï¿½ë¿‰ ?‚‰?š®?”« Calendar åª›ì•¹ê»œï¿½?“½ ï¿½ë?ˆï¿½ë£? ï¿½ê½•ï¿½ì ™
		cal.set(Calendar.MONTH, (month - 1)); //ï¿½ë––ï¿½ì °ï¿½ë¿‰ ?‚‰?š®?”« Calendar åª›ì•¹ê»œï¿½?“½ ï¿½ì¡ ï¿½ê½•ï¿½ì ™, ï¿½ë¿°ï¿½ê¶›ï¿½ë¿‰ ï¿½ê¶—ï¿½ìŠœï¿½ë¹ï¿½ë¹ ï¿½ë¸¯èª˜ï¿½æ¿¡ï¿½ ï¿½ë–ï¿½ë–† -1
		cal.set(Calendar.DATE, 1);	//ï¿½ë––ï¿½ì °ï¿½ë¿‰ ?‚‰?š®?”æ¹²ï¿½ ï¿½ë–†ï¿½ì˜‰ï¿½ë¸· å¯ƒê»‹ï¿? 1ï¿½ì”ª ï¿½ì” ï¿½ë¿¬ï¿½ë¹ ï¿½ë¸¯èª˜ï¿½æ¿¡ï¿½ 1ï¿½ì”ª
		/*
		 * SUNDAY,MONDAY,TUESDAY,WEDNESDAY ,THURSDAY,FRIDAY, SATURDAY
		 */
		
		int firstDayOfWeekForMonth = cal.get(Calendar.DAY_OF_WEEK) - 1; //SUNDAYåª›ï¿½ 1, ï¿½ë––ï¿½ì“½ ï§£ãƒ«ê¶? ï¿½ìŠ‚ï¿½ì”ªï¿½ì“£ ï¿½êµ¹ï¿½ï¿½ï¿½ê¶¡ï¿½ë’— è¹‚ï¿½ 
		
		/*
		 * 1.ï¿½ë––ï¿½ì“½ ï§£ãƒ¬ï¼? ï§£ãƒ«ê¶? ï¿½ìŸ¾æºëš¯ï¿½ï¿½?“½ ï¿½ê¶‡ ï¿½ë¾¾ï¿½ë’— ï¿½ê¶‡æ¿¡ï¿½ ï¿½ë?‘ï¿½?˜¿ï¿½ë¸¯æ¹²ï¿½
		 * 2.ï¿½ë?ˆï¿½?¡ï¿½ì“½ ï§£ãƒ«ê¶‡æ?¨ï¿½ ï¿½ê±¹ï¿½ê¶‡ï¿½ë¸£æ¹²ï¿½
		 * 3.1ï¿½ì”ª?ºï¿½ï¿½ê½? ï§ë‰ï¿½ï§ï¿? ï¿½ê¶‡æºëš¯ï¿? ï¿½ë?‘ï¿½?˜¿
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
			//ï¿½ë––ï¿½ì“½ ï§£ãƒ«ê¶? ï¿½ìŠ‚ï¿½ì”ª + cal.1ï¿½ì”ª = ï¿½ë––ï¿½ì“½ ï§£ãƒ«ê¶‡ï¿½?Š‚ï¿½ì”ªï¿½ì”  ï¿½ë¦ºï¿½ë¹ï¿½ë¸¿
			btnNum = day-1 + firstDayOfWeekForMonth;
			calBtn[btnNum].setForeground(new Color(0, 0, 0));
			
			if ((btnNum) % 7 == 0) {//ï¿½ì”ªï¿½ìŠ‚ï¿½ì”ªï¿½ì”ªï¿½ë¸£ ï§£ì„?”
				calBtn[btnNum].setForeground(new Color(255, 0, 0));
			}else if ((btnNum) % 7 == 6) {//ï¿½ë„—ï¿½ìŠ‚ï¿½ì”ªï¿½ì”ªï¿½ë¸£ ï¿½ê¹‹ ï§£ì„?”
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
			this.txtYear.setText(year + "?…„");
			this.txtMonth.setText(month + "?›”");
		} else if (ae.getSource() == btnAfter) {
			this.panWest.removeAll();
			calInput(1);
			gridInit();
			panWest.setLayout(new GridLayout(6,7));
			calSet();
			hideInit();
			this.txtYear.setText(year + "?…„");
			this.txtMonth.setText(month + "?›”");
		} else if (Integer.parseInt(ae.getActionCommand()) >= 1 && Integer.parseInt(ae.getActionCommand()) <= 31) {
			day = Integer.parseInt(ae.getActionCommand());
			//ï¿½ê¶‡ï§ï¿½ è¸°ê¾ª?“‰ï¿½ì”  ï¿½ë‹ƒ?”±ê³Œêµ…ï§ï¿½ system.out ï§£ì„?”
			setTf.setText(year + "/" + month + "/" + day);
			setVisible(false);
		}
	}

	/*btnï¿½ï¿½ ï§ëš®ë±¾ï¿½ë¼? è­°ëš¯ï¿½ï§ï¿?, ï¿½ê¶‡ï§ì’“ï¿? ï¿½ë¾¾ï¿½ë’— è¸°ê¾ª?“‰ ï¿½ë‹ƒ?”±?Šï¿½ ï¿½ë¸¡å¯ƒï¿½ ï¿½ê½•ï¿½ì ™ï¿½ë¸¯ï¿½ë’— ï§ë¶¿?ƒ¼ï¿½ë±¶*/
	public void hideInit() { 
		for (int i = 0; i < calBtn.length; i++) {
			if ((calBtn[i].getText()).equals(""))
				calBtn[i].setEnabled(false);
		}
	}

	/*GridLayoutï¿½ë¿‰ è¸°ê¾ª?“‰ ï¿½ê½”æ¹²ï¿½*/
	public void gridInit() { 
		for (int i = 0; i < 42; i++) {
			panWest.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}
	}

	/*ï¿½ì” ï¿½ìŸ¾,ï¿½ì” ï¿½ì‘ è¸°ê¾ª?“‰ï¿½ì”  ï¿½ë‹ƒï¿½ì¡‡ï¿½ì“£ï¿½ë¸£ ï¿½ì¡, ï¿½ë?ˆï¿½ë£? ï¿½ê½•ï¿½ì ™ï¿½ë¹äºŒì‡¨ë¦?*/
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
	
	public void setDayTf(int gapMonth, JTextField startDateTf, JTextField endDateTf) {
		Calendar today = Calendar.getInstance();
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;

		if (month <= gapMonth) {
			month = 12 - (gapMonth - month);
			year--;
		} else {
			month -= gapMonth;
		}
		startDateTf.setText(year + "/" + month + "/" + day);
		endDateTf.setText(year + "/" + month + "/" + day);
	}
}
