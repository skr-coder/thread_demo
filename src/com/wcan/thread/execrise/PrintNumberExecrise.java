package com.wcan.thread.execrise;

import java.util.Scanner;

public class PrintNumberExecrise {
	
	public static void main(String[] args) {
		PrintNumberThread numberThread = new PrintNumberThread();
		InputWordThread inputWordThread = new InputWordThread(numberThread);
		numberThread.start();
		inputWordThread.start();
		
	}
}

/**
 * 
 * @Title: PrintNumberExecrise.java
 * @Package: com.wcan.thread.execrise
 * @Description: 打印100以内的随机数
 * @author: wcan
 * @date: 2020年1月9日 上午12:18:17
  * @version: V1.0
 */
class PrintNumberThread extends Thread {
	
	private boolean flag;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int num = (int)(Math.random()*100);
			System.out.println(num);
		}
	}
	
}

/**
 * 
 * @Title: PrintNumberExecrise.java
 * @Package: com.wcan.thread.execrise
 * @Description: 从键盘上读取字符
 * @author: wcan
 * @date: 2020年1月9日 上午12:18:56
  * @version: V1.0
 */
class InputWordThread extends Thread {
	Scanner in = new Scanner(System.in);
	PrintNumberThread pnt;
	public InputWordThread(PrintNumberThread pnt) {
		// TODO Auto-generated constructor stub
		this.pnt = pnt;
	}
	@Override
	public void run() {
		while (true) {
			System.out.println("请输入：");
			char at = in.next().toUpperCase().charAt(0);
			if(at == 'Q') {
				pnt.setFlag(false);
				break;
			}
		}
	}
}