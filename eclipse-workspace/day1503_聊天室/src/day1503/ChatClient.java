package day1503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private Socket s;
	private BufferedReader in;
	private PrintWriter out;
	
	public void start() {
		try {
			s = new Socket("127.0.0.1", 8000);
			in = 
			 new BufferedReader(
			 new InputStreamReader(
			 s.getInputStream(), "GBK"));     
			
			out = 
			 new PrintWriter(
			 new OutputStreamWriter(
			 s.getOutputStream(), "GBK"));
			
			//输入昵称，发送到服务器
			System.out.print("昵称：");
			String name = new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();
			
			//等待输入聊天内容，并发送
			new Thread() {
				public void run() {
					input();
				}
			}.start();
			
			//等待接收聊天室内容，并显示
			new Thread() {
				public void run() {
					receive();
				}
			}.start();
		} catch (Exception e) {
			System.out.println("连接失败");
		}
	}

	protected void receive() {
		try {
			String line;
			while((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			
		}
		System.out.println("连接已断开");
	}

	protected void input() {
		while(true) {
			System.out.print("输入聊天内容：");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();
		}
	}
	
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.start();
	}
	
}








