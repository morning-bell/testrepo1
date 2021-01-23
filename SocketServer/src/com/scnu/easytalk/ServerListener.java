package com.scnu.easytalk;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		//port参数表示服务器监听的端口号，从1-65535
		try {

			ServerSocket serverSocket =new ServerSocket(12345);
			while (true) {
				Socket socket=	serverSocket.accept();//侦听事务的连接，accept是一个阻塞的方法，会阻塞当前的main线程，并且返回的是一个Socket类型
				//建立连接，表示serverSocket在监听，如果监听到有客户端连接则会调用accept方法，然后返回一个Socket，最后建立连接
				
				ChatSocket cs= new ChatSocket(socket);
			     cs.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
