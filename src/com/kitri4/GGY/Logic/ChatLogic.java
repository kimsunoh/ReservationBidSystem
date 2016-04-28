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
			sendServer("새 회원 경매 등록");

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
//			sendServer("회원경매등록");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void run() {
		while (flag) {
			try {
				String msg = in.readLine();
				System.out.println("클라이언트가 받은 메세지 : " + msg);
			} catch (IOException e) {
				e.printStackTrace();
				flag = false;
			}
		}
	}
	//
}
