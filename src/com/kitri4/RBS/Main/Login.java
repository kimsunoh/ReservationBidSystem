package com.kitri4.RBS.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	JPanel contentPane;
	JButton loginBtn;
	JButton joinBtn;
	JPanel loginImgPn;
	JTextField idTf;
	JTextField pwTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		loginBtn = new JButton("·Î±×ÀÎ");
		panel.add(loginBtn);
		
		joinBtn = new JButton("È¸¿ø°¡ÀÔ");
		panel.add(joinBtn);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel_2 = new JLabel("¿À´Ã¹¹¸ÔÁö?");
		panel_2.add(lblNewLabel_2, BorderLayout.NORTH);
		
		loginImgPn = new JPanel();
		panel_2.add(loginImgPn, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel = new JLabel("ID :");
		panel_4.add(lblNewLabel, BorderLayout.NORTH);
		
		idTf = new JTextField();
		panel_4.add(idTf, BorderLayout.CENTER);
		idTf.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(10, 10));
		
		pwTf = new JTextField();
		panel_5.add(pwTf, BorderLayout.CENTER);
		pwTf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PW :");
		panel_5.add(lblNewLabel_1, BorderLayout.NORTH);
	}

}
