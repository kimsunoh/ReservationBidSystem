package com.kitri4.GGY.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class RBSServer implements Runnable{
	Vector<ChatClient> vc = new Vector<ChatClient>();
	ServerSocket ss;

	public RBSServer() {
		try {
			ss = new ServerSocket(9876);
			System.out.println("Client 접속 대기중...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// client 접속 처리
		boolean flag = true;
		while (flag) {
			try {
				Socket socket = ss.accept();
				System.out.println("클라이언트 접속 성공!! : " + socket);
				new ChatClient(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ChatClient extends Thread {
		BufferedReader in;
		OutputStream out;
		Socket socket;
		String name;// 대화명

		public ChatClient(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			boolean flag = true;
			
			while (flag) {
				try {
					String msg = in.readLine();
					System.out.println("서버가 받은 메세지 : " + msg);
					multicast(msg);
					vc.add(this);					
				} catch (IOException e) {
					e.printStackTrace();
					flag = false;
				}
			}
		}
		
		private void multicast(String msg){
			int size = vc.size();
			for (int i = 0; i < size; i++) {
				ChatClient client = vc.get(i);
				client.unicast(msg);
			}
		}
		
		private synchronized void unicast(String msg){
			try {
				out.write((msg+"\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		new Thread(new RBSServer()).start();

	}
}
