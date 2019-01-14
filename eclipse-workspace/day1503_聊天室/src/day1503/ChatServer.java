package day1503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	//用来收集所有的通信线程对象
	private List<TongXinThread> list = 
			new ArrayList<>();
	
	public void start() {
		new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket ss =
					 new ServerSocket(8000);
					System.out.println("服务已启动");        
					while(true) {
						Socket s = ss.accept();
						TongXinThread t = new TongXinThread(s);
						synchronized (list) {
							list.add(t);
						}
						t.start();
					}					
				} catch (Exception e) {
					System.out.println(
					 "端口被占用，或者服务已停止");
				}
			}
		}.start();
	}
	
	class TongXinThread extends Thread {
		Socket s;
		BufferedReader in;
		PrintWriter out;
		String name;
		public TongXinThread(Socket s) {
			this.s = s;
		}
		
		//向当前客户端发送
		public void send(String msg) {
			out.println(msg);
			out.flush();
		}
		
		//向所有客户端发送
		public void sendAll(String msg) {
			//遍历通信线程对象，调用send方法
			for (TongXinThread t : list) {
				t.send(msg);
			}
		}
		
		@Override
		public void run() {
			try {
				in = 
				 new BufferedReader(
				 new InputStreamReader(
				 s.getInputStream(), "GBK"));     
				
				out = 
				 new PrintWriter(
				 new OutputStreamWriter(
				 s.getOutputStream(), "GBK"));
				
				//接收客户端昵称
				name = in.readLine();
				//群发消息xx进入聊天室
				synchronized (list) {
					sendAll(
						name+"进入了聊天室，在线人数："+list.size());    
				}
				
				//循环接收聊天内容，并群发
				String line;
				while((line = in.readLine()) != null) {
					synchronized (list) {
						sendAll(name+"说："+line);
					}
				}
				
			} catch (Exception e) {
			}
			//当前客户端连接断开
			//当前通信线程对象，从集合移除
			synchronized (list) {
				list.remove(this);
				//群发消息，xxx离开
				sendAll(
 				 name+"离开了聊天室，在线人数："+list.size());
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
	}
	
}









