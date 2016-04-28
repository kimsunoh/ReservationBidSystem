package com.kitri4.GGY.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatLogic implements Runnable{
	//
	BufferedReader in;
	OutputStream out;
	Socket s;
	boolean flag = true;
	//
	//
	public void connectProcess() {

		String host = "localhost";

		try {
			s = new Socket(host, 9876);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			sendServer("�� ȸ�� ��� ���");

			new Thread(this).start();
		} catch (UnknownHostException e) {// host
			e.printStackTrace();
		} catch (IOException e) {// port
			e.printStackTrace();
		}

	}
	
	private void sendServer(String msg) throws IOException {
		out.write((msg + "\n").getBytes());
	}
	
//	public void paper(){
//		try {
//			sendServer("ȸ����ŵ��");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void run() {
		while (flag) {
			try {
				String msg = in.readLine();
				System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + msg);
			} catch (IOException e) {
				e.printStackTrace();
				flag = false;
			}
		}
	}
	//
}
