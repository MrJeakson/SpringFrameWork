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
			
			//�����ǳƣ����͵�������
			System.out.print("�ǳƣ�");
			String name = new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();
			
			//�ȴ������������ݣ�������
			new Thread() {
				public void run() {
					input();
				}
			}.start();
			
			//�ȴ��������������ݣ�����ʾ
			new Thread() {
				public void run() {
					receive();
				}
			}.start();
		} catch (Exception e) {
			System.out.println("����ʧ��");
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
		System.out.println("�����ѶϿ�");
	}

	protected void input() {
		while(true) {
			System.out.print("�����������ݣ�");
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








