package com.kitri4.GGY.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberJoin extends JFrame{

   public JPanel contentPane;
   public JTextField idTf;
   public JTextField pwTf;
   public JTextField pwCheckTf;
   public JTextField emailTf;
   public JTextField phoneNumTf;
   public JButton checkIdBtn;
   public JButton memJoinBtn;
   public JButton cancleBtn;
   public JTextField nameTf;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MemberJoin frame = new MemberJoin("MemberJoin");
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
   public MemberJoin(String string) {
      super(string);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 400, 700);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(10, 10));
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(7, 1, 10, 30));
      
      JLabel label_1 = new JLabel("\uC77C\uBC18 \uD68C\uC6D0\uAC00\uC785");
      panel.add(label_1);
      
      JPanel panel_1 = new JPanel();
      panel.add(panel_1);
      panel_1.setLayout(new BorderLayout(0, 0));
      
      JLabel lblNewLabel = new JLabel("ID :");
      lblNewLabel.setBounds(new Rectangle(0, 0, 100, 0));
      panel_1.add(lblNewLabel, BorderLayout.NORTH);
      
      idTf = new JTextField();
      panel_1.add(idTf, BorderLayout.CENTER);
      idTf.setColumns(10);
      
      checkIdBtn = new JButton("\uD655\uC778");
      panel_1.add(checkIdBtn, BorderLayout.EAST);
      
      JPanel panel_7 = new JPanel();
      panel.add(panel_7);
      panel_7.setLayout(new BorderLayout(0, 0));
      
      JLabel lblNewLabel_3 = new JLabel("\uC774\uB984 :");
      panel_7.add(lblNewLabel_3, BorderLayout.NORTH);
      
      nameTf = new JTextField();
      panel_7.add(nameTf, BorderLayout.CENTER);
      nameTf.setColumns(10);
      
      JPanel panel_2 = new JPanel();
      panel.add(panel_2);
      panel_2.setLayout(new BorderLayout(0, 0));
      
      JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
      panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
      
      pwTf = new JTextField();
      panel_2.add(pwTf, BorderLayout.CENTER);
      pwTf.setColumns(10);
      
      JPanel panel_3 = new JPanel();
      panel.add(panel_3);
      panel_3.setLayout(new BorderLayout(0, 0));
      
      JLabel lblNewLabel_2 = new JLabel("PASSWORD (check) : ");
      panel_3.add(lblNewLabel_2, BorderLayout.NORTH);
      
      pwCheckTf = new JTextField();
      panel_3.add(pwCheckTf, BorderLayout.CENTER);
      pwCheckTf.setColumns(10);
      
      JPanel panel_4 = new JPanel();
      panel.add(panel_4);
      panel_4.setLayout(new BorderLayout(0, 0));
      
      JLabel lblPhone = new JLabel("PHONE ( - \uC5C6\uC774\uC785\uB825 )");
      panel_4.add(lblPhone, BorderLayout.NORTH);
      
      phoneNumTf = new JTextField();
      phoneNumTf.setColumns(10);
      panel_4.add(phoneNumTf, BorderLayout.CENTER);
      
      JPanel panel_5 = new JPanel();
      panel.add(panel_5);
      panel_5.setLayout(new BorderLayout(0, 0));
      
      JLabel lblNewLabel_4 = new JLabel("EMAIL : ");
      panel_5.add(lblNewLabel_4, BorderLayout.NORTH);
      
      emailTf = new JTextField();
      panel_5.add(emailTf, BorderLayout.CENTER);
      emailTf.setColumns(10);
      
      JPanel panel_6 = new JPanel();
      contentPane.add(panel_6, BorderLayout.SOUTH);
      
      memJoinBtn = new JButton("\uAC00\uC785\uD558\uAE30");
      panel_6.add(memJoinBtn);
      
      cancleBtn = new JButton("\uCDE8\uC18C");
      panel_6.add(cancleBtn);
      
   }
}