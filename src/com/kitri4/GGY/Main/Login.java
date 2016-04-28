package com.kitri4.GGY.Main;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;

public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField idTf;
	public JTextField pwTf;
	public JButton loginBtn;
	public JButton joinBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login("Login");
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
	public Login(String string) {
		super(string);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/kitri4/GGY/Img/ggyo4.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 43, 374, 294);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel loginImg = new JLabel("");
		loginImg.setBounds(0, 0, 374, 294);
		loginImg.setHorizontalAlignment(SwingConstants.CENTER);
		loginImg.setIcon(new ImageIcon(Login.class.getResource("/com/kitri4/GGY/Img/ggyo4.jpg")));
		panel_2.add(loginImg);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(5, 379, 30, 40);
		contentPane.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		
		idTf = new JTextField();
		idTf.setBounds(47, 380, 200, 40);
		contentPane.add(idTf);
		idTf.setHorizontalAlignment(SwingConstants.CENTER);
		idTf.setColumns(10);
		
		pwTf = new JTextField();
		pwTf.setBounds(48, 432, 200, 40);
		contentPane.add(pwTf);
		pwTf.setHorizontalAlignment(SwingConstants.CENTER);
		pwTf.setColumns(10);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(5, 432, 30, 40);
		contentPane.add(lblPw);
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(257, 374, 108, 70);
		contentPane.add(loginBtn);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBounds(257, 450, 108, 20);
		contentPane.add(joinBtn);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC2DD\uC7A5\uC18C \uC815\uD558\uAE30 \uD504\uB85C\uADF8\uB7A8");
		lblNewLabel_1.setBounds(12, 533, 350, 35);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("by sokim, wrkim, jwkim, dhback, shyou, msjung");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 614, 374, 38);
		contentPane.add(lblNewLabel);
	}
}
