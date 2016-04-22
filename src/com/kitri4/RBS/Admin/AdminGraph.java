package com.kitri4.RBS.Admin;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.kitri4.RBS.Common.CalendarView;

public class AdminGraph extends JFrame {

	public JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JPanel menuPn;
	public JPanel adminStasticsPn;
	public JPanel graphPn;
	public JPanel panel_3;
	public JPanel registercountPn;
	public JPanel calendarPn;
	public JPanel monthPn;
	public JPanel bidcountPn;
	public JPanel adminManagerPn;
	public JLabel agreeLabel;
	public JLabel registerLabel;
	public JButton findBtn;
	public JTextField calendarTf1;
	public JTextField calendarTf2;
	public JTextField bidTf;
	public JTextField resgisterTf;
	public JTextField agreeTf;
	public JLabel lblNewLabel;
	public JButton sixmonthBtn;
	public JButton threemonthBtn;
	public JButton onemonthBtn;
	public JLabel bidLabel;
	public JButton calBtn1;
	public JButton calBtn2;
	public JPanel panel_1;
	public JLabel label;
	public JTextField textField;
	public JLabel label_1;
	public JTextField textField_1;
	public JPanel panel_2;
	public DefaultTableModel model;
	public JTable BsRegisterTable;
	public JScrollPane scroll;
	public String columnName[] = { "�긽�샇紐�", "�뾽二쇰챸", "�궗�뾽�옄�벑濡앸쾲�샇", "�벑濡�" };
	public Object row [][]={{"�븳�떊�룷李�","�젙誘쇱꽍","90c8815","�벑濡�"},{"�궪嫄곕━�룷李�","諛깆쥌�쁽","90e8815","�벑濡�"}};
	public JButton adminManagerBtn;
	public JButton adminStasticsBtn;
	public JButton logoutBtn;
	AdminGraphLogic agl;
	CalendarView cv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGraph frame = new AdminGraph();
//					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminGraph() {
		setTitle("Admin \uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 384, 662);
		contentPane.add(tabbedPane);
		
		menuPn = new JPanel();
		tabbedPane.addTab("=", null, menuPn, null);
		menuPn.setLayout(null);
		
		adminStasticsBtn = new JButton("\uAD00\uB9AC\uC790 \uD1B5\uACC4");
		adminStasticsBtn.setBounds(72, 163, 214, 41);
		menuPn.add(adminStasticsBtn);
		
		adminManagerBtn = new JButton("\uAD00\uB9AC\uC790 \uD68C\uC6D0\uAD00\uB9AC");
		adminManagerBtn.setBounds(72, 298, 214, 41);
		menuPn.add(adminManagerBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(72, 415, 214, 31);
		menuPn.add(logoutBtn);
		
		adminStasticsPn = new JPanel();
		tabbedPane.addTab("관리자 통계", null, adminStasticsPn, null);
		adminStasticsPn.setLayout(null);
		
		graphPn = new JPanel();
		graphPn.setBackground(new Color(245, 245, 220));
		graphPn.setBounds(-1, 0, 380, 262);
		adminStasticsPn.add(graphPn);
		
		panel_3 = new JPanel();
		panel_3.setBounds(27, 548, 325, 31);
		adminStasticsPn.add(panel_3);
		panel_3.setLayout(null);
		
		agreeLabel = new JLabel("\uB099\uCC30\uD69F\uC218 :");
		agreeLabel.setBounds(11, 8, 70, 15);
		panel_3.add(agreeLabel);
		
		agreeTf = new JTextField();
		agreeTf.setColumns(10);
		agreeTf.setBounds(86, 0, 227, 31);
		panel_3.add(agreeTf);
		
		registercountPn = new JPanel();
		registercountPn.setBounds(27, 401, 325, 31);
		adminStasticsPn.add(registercountPn);
		registercountPn.setLayout(null);
		
		resgisterTf = new JTextField();
		resgisterTf.setColumns(10);
		resgisterTf.setBounds(86, 0, 227, 31);
		registercountPn.add(resgisterTf);
		
		registerLabel = new JLabel("\uB4F1\uB85D\uD69F\uC218 :");
		registerLabel.setBounds(10, 8, 70, 15);
		registercountPn.add(registerLabel);
		
		calendarPn = new JPanel();
		calendarPn.setBounds(27, 284, 325, 33);
		adminStasticsPn.add(calendarPn);
		calendarPn.setLayout(null);
		
		findBtn = new JButton("\uC870\uD68C");
		findBtn.setBounds(262, 5, 63, 25);
		calendarPn.add(findBtn);
		
		calendarTf2 = new JTextField();
		calendarTf2.setColumns(10);
		calendarTf2.setBounds(138, 5, 86, 24);
		calendarPn.add(calendarTf2);
		
		calendarTf1 = new JTextField();
		calendarTf1.setColumns(10);
		calendarTf1.setBounds(2, 5, 88, 25);
		calendarPn.add(calendarTf1);
		
		lblNewLabel = new JLabel("~");
		lblNewLabel.setBounds(125, 9, 17, 19);
		calendarPn.add(lblNewLabel);
		
		calBtn2 = new JButton("New button");
		calBtn2.setBounds(226, 5, 28, 25);
		calendarPn.add(calBtn2);
		
		calBtn1 = new JButton("New button");
		calBtn1.setBounds(92, 5, 28, 25);
		calendarPn.add(calBtn1);
		
		monthPn = new JPanel();
		monthPn.setBounds(27, 336, 325, 31);
		adminStasticsPn.add(monthPn);
		monthPn.setLayout(null);
		
		sixmonthBtn = new JButton("6\uAC1C\uC6D4");
		sixmonthBtn.setBounds(18, 4, 73, 23);
		monthPn.add(sixmonthBtn);
		
		threemonthBtn = new JButton("3\uAC1C\uC6D4");
		threemonthBtn.setBounds(131, 4, 73, 23);
		monthPn.add(threemonthBtn);
		
		onemonthBtn = new JButton("1\uAC1C\uC6D4");
		onemonthBtn.setBounds(237, 4, 73, 23);
		monthPn.add(onemonthBtn);
		
		bidcountPn = new JPanel();
		bidcountPn.setBounds(27, 474, 325, 31);
		adminStasticsPn.add(bidcountPn);
		bidcountPn.setLayout(null);
		
		bidLabel = new JLabel("\uC785\uCC30\uD69F\uC218 :");
		bidLabel.setBounds(11, 8, 70, 15);
		bidcountPn.add(bidLabel);
		
		bidTf = new JTextField();
		bidTf.setColumns(10);
		bidTf.setBounds(87, 0, 226, 31);
		bidcountPn.add(bidTf);
		
		adminManagerPn = new JPanel();
		tabbedPane.addTab("관리자회원관리", null, adminManagerPn, null);
		adminManagerPn.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 379, 118);
		adminManagerPn.add(panel_1);
		
		label = new JLabel("\uC2E0\uADDC \uC77C\uBC18 \uD68C\uC6D0 \uAC00\uC785\uC218");
		label.setBounds(36, 10, 136, 15);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(36, 32, 267, 21);
		panel_1.add(textField);
		
		label_1 = new JLabel("\uC2E0\uADDC \uC5C5\uC8FC \uB4F1\uB85D \uC694\uCCAD \uD69F\uC218");
		label_1.setBounds(36, 62, 148, 15);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(36, 85, 267, 21);
		panel_1.add(textField_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 117, 379, 516);
		adminManagerPn.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

//		model = new DefaultTableModel(columnName, 10);
		model =new DefaultTableModel(row, columnName);
		BsRegisterTable = new JTable(model);

		BsRegisterTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		BsRegisterTable.getColumnModel().getColumn(3).setPreferredWidth(10);
		BsRegisterTable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
		BsRegisterTable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JComboBox(),this));
		scroll = new JScrollPane(BsRegisterTable);
		for (int j = 0; j < BsRegisterTable.getRowCount(); j++) {
			BsRegisterTable.setRowHeight(j, 23);
		}
		panel_2.add(scroll);
		
		agl=new AdminGraphLogic(this);
		
	    findBtn.addActionListener(agl);
	    onemonthBtn.addActionListener(agl);
	    threemonthBtn.addActionListener(agl);
	    sixmonthBtn.addActionListener(agl);
	    calBtn1.addActionListener(agl);
	    calBtn2.addActionListener(agl);
	    adminManagerBtn.addActionListener(agl);
	    adminStasticsBtn.addActionListener(agl);
//	    logoutBtn.addActionListener(agl);
	
	}
}
