package com.kitri4.RBS.Admin;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminMain extends JFrame implements ActionListener{

   public JPanel contentPane;
   public JButton userManagBtn;
   public JButton auctionManagBtn;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	AdminMain frame = new AdminMain();
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
   public AdminMain() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 400, 700);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new GridLayout(4, 0, 10, 10));
      
      JPanel panel = new JPanel();
      contentPane.add(panel);
      
      userManagBtn = new JButton("내역통계");
      contentPane.add(userManagBtn);
      
      auctionManagBtn = new JButton("회원관리");
      contentPane.add(auctionManagBtn);
      
      
      userManagBtn.addActionListener(this);
      auctionManagBtn.addActionListener(this);
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object ob = e.getSource();
      if(ob==userManagBtn){
         this.setVisible(false);
      }else if(ob==auctionManagBtn){
         this.setVisible(false);
      }
   }
}

   //method (기능)
   //actionListener 2개 달기 1/회원관리 2/경매관리
   //ex) 1: Mangement_Member();
   //     2: Mangement_Action();

