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
import java.awt.Font;

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
      panel.setLayout(null);
      
      JLabel label_1 = new JLabel("\uC77C\uBC18 \uD68C\uC6D0\uAC00\uC785");
      label_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
      label_1.setBounds(143, 38, 94, 40);
      panel.add(label_1);
      
      JLabel lblNewLabel = new JLabel("ID :");
      lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
      lblNewLabel.setBounds(20, 95, 47, 24);
      panel.add(lblNewLabel);
      
      idTf = new JTextField();
      idTf.setBounds(20, 128, 280, 24);
      panel.add(idTf);
      idTf.setColumns(10);
      
      checkIdBtn = new JButton("\uD655\uC778");
      checkIdBtn.setBounds(305, 125, 57, 29);
      panel.add(checkIdBtn);
      
      JLabel lblNewLabel_3 = new JLabel("\uC774\uB984 :");
      lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 12));
      lblNewLabel_3.setBounds(20, 173, 41, 15);
      panel.add(lblNewLabel_3);
      
      nameTf = new JTextField();
      nameTf.setBounds(20, 197, 319, 24);
      panel.add(nameTf);
      nameTf.setColumns(10);
      
      JLabel lblNewLabel_1 = new JLabel("PASS :");
      lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
      lblNewLabel_1.setBounds(20, 236, 47, 15);
      panel.add(lblNewLabel_1);
      
      pwTf = new JTextField();
      pwTf.setBounds(20, 261, 319, 24);
      panel.add(pwTf);
      pwTf.setColumns(10);
      
      JLabel lblNewLabel_2 = new JLabel("PASS : ");
      lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 12));
      lblNewLabel_2.setBounds(20, 303, 56, 20);
      panel.add(lblNewLabel_2);
      
      pwCheckTf = new JTextField();
      pwCheckTf.setBounds(20, 323, 319, 24);
      panel.add(pwCheckTf);
      pwCheckTf.setColumns(10);
      
      JLabel lblPhone = new JLabel("PHONE:");
      lblPhone.setFont(new Font("±¼¸²", Font.BOLD, 12));
      lblPhone.setBounds(20, 365, 62, 15);
      panel.add(lblPhone);
      
      phoneNumTf = new JTextField();
      phoneNumTf.setBounds(20, 385, 319, 26);
      panel.add(phoneNumTf);
      phoneNumTf.setColumns(10);
      
      JLabel lblNewLabel_4 = new JLabel("EMAIL : ");
      lblNewLabel_4.setFont(new Font("±¼¸²", Font.BOLD, 12));
      lblNewLabel_4.setBounds(22, 433, 60, 15);
      panel.add(lblNewLabel_4);
      
      emailTf = new JTextField();
      emailTf.setBounds(20, 458, 319, 29);
      panel.add(emailTf);
      emailTf.setColumns(10);
      
      JLabel lblNewLabel_5 = new JLabel(" ( - \uC5C6\uC774\uC785\uB825 )");
      lblNewLabel_5.setFont(new Font("±¼¸²", Font.PLAIN, 10));
      lblNewLabel_5.setBounds(76, 368, 68, 11);
      panel.add(lblNewLabel_5);
      
      memJoinBtn = new JButton("\uAC00\uC785\uD558\uAE30");
      memJoinBtn.setBounds(68, 536, 94, 31);
      panel.add(memJoinBtn);
      
      cancleBtn = new JButton("\uCDE8\uC18C");
      cancleBtn.setBounds(178, 537, 101, 29);
      panel.add(cancleBtn);
      
      JLabel lblNewLabel_6 = new JLabel("(check)");
      lblNewLabel_6.setFont(new Font("±¼¸²", Font.PLAIN, 10));
      lblNewLabel_6.setBounds(68, 307, 41, 15);
      panel.add(lblNewLabel_6);
      
   }
}
