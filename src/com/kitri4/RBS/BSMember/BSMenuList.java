package com.kitri4.RBS.BSMember;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
//<Tabbed Pane> = > BSMenuList + BSMenuAdj 

public class BSMenuList extends JFrame{
   
   private JPanel contentPane;
   public JButton bidListBtn;
   public JButton storeMenuBtn;
   public JButton infoBtn;
   JPanel panel_2;
   JButton menuAddBtn;
   JPanel panel_3;
   private JPanel panel_4;
   private JPanel panel_5;
   private JPanel panel_6;
   private JPanel panel_7;
   private JPanel panel_8;
   private JPanel panel_9;
   private JPanel panel_10;
   JTextField menuNameTf;
   JTextField priceTf;
   JTextArea menuInfoTf;
   JButton addMenuBtn;
   JButton renameMenuBtn;
   JButton removeMenuBtn;
   private JTable BStable;
   JLabel Seepicture;
   private JPanel panel_12;
   JButton openPicturBtn;
   public JTabbedPane tabbedPane;   
   private JFrame frm;   
   private JPanel jdialogPanel ;
   private JButton jdialogBtn ;   
   JDialog dialog;
   JButton okBtn ;
   JButton cencelBtn;
   JFileChooser fc = new JFileChooser();//파일불러오기 
   JButton fileOpen; //파일불러오기의 열기버튼
   BSMenuListLogic bsmenulistlogic;
   BSMenuList bsmenulist;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {            
               BSMenuList frame = new BSMenuList();
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
   public BSMenuList() {
      bsmenulistlogic=new BSMenuListLogic(this);
      
      
      //Data for our table
      Object [][]data ={
            {"찜닭","22000","jpg","수정"},
            {"치킨","17000","jpg","수정"},
            {"피자","30000","jpg","수정"},            
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"}   ,
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"}   ,
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"}   ,
            {"","","","수정"},
            {"","","","수정"},
            {"","","","수정"}   
      };
      
      //Column Headers
      String columnHeader[]={"메뉴이름","가격","사진","수정"};
      
      //Create our table and set header 
      JTable BStable = new JTable(data,columnHeader);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 400, 700);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      contentPane.add(tabbedPane, BorderLayout.CENTER);
      
      JPanel panel = new JPanel();
      tabbedPane.addTab("=", null, panel, null);
      panel.setLayout(new GridLayout(5, 1, 10, 10));
      
      JPanel panel_1 = new JPanel();
      panel.add(panel_1);
      
      bidListBtn = new JButton("내역");
      panel.add(bidListBtn);
      
      storeMenuBtn = new JButton("메뉴");
      panel.add(storeMenuBtn);
      
      infoBtn = new JButton("내 정보");
      panel.add(infoBtn);
      
      panel_2 = new JPanel();
      tabbedPane.addTab("메뉴리스트", null, panel_2, null);
      
      menuAddBtn = new JButton("신규메뉴등록");
      menuAddBtn.setBounds(0, 600, 369, 23);
      menuAddBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      panel_2.setLayout(null);
      panel_2.add(menuAddBtn);
      
      JPanel panel_11 = new JPanel();
      panel_11.setBounds(0, 10, 357, 580);
      panel_2.add(panel_11);
      panel_11.setLayout(new BorderLayout(0, 0));
      
      JScrollPane scrollPane = new JScrollPane();
      panel_11.add(scrollPane, BorderLayout.CENTER);
      
      BStable = new JTable(data,columnHeader);
      scrollPane.setViewportView(BStable);
      
      panel_3 = new JPanel();
      tabbedPane.addTab("등록/수정", null, panel_3, null);
      panel_3.setLayout(new GridLayout(3, 1, 10, 10));
      
      panel_4 = new JPanel();
      panel_3.add(panel_4);
      panel_4.setLayout(new GridLayout(2, 0, 10, 10));
      
      panel_7 = new JPanel();
      panel_4.add(panel_7);
      panel_7.setLayout(new BorderLayout(10, 10));
      
      JLabel lblNewLabel = new JLabel("메뉴이름 :");
      panel_7.add(lblNewLabel, BorderLayout.NORTH);
      
      menuNameTf = new JTextField();
      panel_7.add(menuNameTf, BorderLayout.CENTER);
      menuNameTf.setColumns(10);
      
      panel_8 = new JPanel();
      panel_4.add(panel_8);
      panel_8.setLayout(new BorderLayout(10, 10));
      
      JLabel lblNewLabel_1 = new JLabel("가격 :");
      panel_8.add(lblNewLabel_1, BorderLayout.NORTH);
      
      priceTf = new JTextField();
      panel_8.add(priceTf, BorderLayout.CENTER);
      priceTf.setColumns(10);
      
      panel_5 = new JPanel();
      panel_3.add(panel_5);
      panel_5.setLayout(new BorderLayout(10, 10));
      
      Seepicture = new JLabel("");
      panel_5.add(Seepicture, BorderLayout.CENTER);
      
      panel_12 = new JPanel();
      panel_5.add(panel_12, BorderLayout.NORTH);
      
      JLabel lblNewLabel_2 = new JLabel("사진 :");
      panel_12.add(lblNewLabel_2);
      
      openPicturBtn = new JButton("사진 불러오기");
      panel_12.add(openPicturBtn);
      
      panel_6 = new JPanel();
      panel_3.add(panel_6);
      panel_6.setLayout(new GridLayout(2, 0, 10, 10));
      
      panel_9 = new JPanel();
      panel_6.add(panel_9);
      panel_9.setLayout(new BorderLayout(0, 0));
      
      JLabel lblNewLabel_3 = new JLabel("메뉴설명 :");
      panel_9.add(lblNewLabel_3, BorderLayout.NORTH);
      
      menuInfoTf = new JTextArea();
      panel_9.add(menuInfoTf, BorderLayout.CENTER);
      
      panel_10 = new JPanel();
      panel_6.add(panel_10);
      panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      addMenuBtn = new JButton("등록");
      panel_10.add(addMenuBtn);
      
      renameMenuBtn = new JButton("수정");
      panel_10.add(renameMenuBtn);
      
      removeMenuBtn = new JButton("삭제");
      panel_10.add(removeMenuBtn);
      
      //SET CUSTOM RENDERER TO TEAMS COLUMN
      BStable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());;
            
      //SET CUSTOM EDITOR TO TEAMS COLUMNS
      BStable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JComboBox(),this));
      
      
      // 삭제 변수부터, dialog 붙이기       
      jdialogPanel = new JPanel();
      jdialogBtn = new JButton("삭제 하시겠습니까?");   
      dialog = new JDialog();
      okBtn = new JButton("확인");
      cencelBtn = new JButton("취소");
                 
        jdialogPanel.add(jdialogBtn);
        dialog.getContentPane().setLayout(new FlowLayout());
        dialog.getContentPane().add(okBtn);
        dialog.getContentPane().add(cencelBtn);
      
      
      
      //리스너들
      menuAddBtn.addActionListener(bsmenulistlogic);// 신규메뉴 등록버튼
      openPicturBtn.addActionListener(bsmenulistlogic);// 사진 불러오기
      addMenuBtn.addActionListener(bsmenulistlogic);//등록 버튼
      renameMenuBtn.addActionListener(bsmenulistlogic);//수정 버튼
      removeMenuBtn.addActionListener(bsmenulistlogic);//삭제 버튼
      jdialogBtn.addActionListener(bsmenulistlogic);//삭제 dialog 버튼
      okBtn.addActionListener(bsmenulistlogic);//삭제 확인 버튼
        cencelBtn.addActionListener(bsmenulistlogic);//삭제 취소 버튼   
        storeMenuBtn.addActionListener(bsmenulistlogic);  
 
   }

   

      
}

