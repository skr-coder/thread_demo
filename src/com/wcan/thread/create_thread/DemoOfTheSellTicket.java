package com.wcan.thread.create_thread;

/**
 * 
 * @Title: DemoOfTheSellTicket.java
 * @Package: com.wcan.thread.create_thread
 * @Description: 模拟多个窗口售票的案例
 * @author: wcan
 * @date: 2020年1月4日 上午12:04:38
  * @version: V1.0
 */
public class DemoOfTheSellTicket {

//	public static void main(String[] args) {
//		//TheWayOfExtendsThreadClass
//		TheWayOfExtendsThreadClass  theWayOfExtendsThreadClass1 = new TheWayOfExtendsThreadClass();
//		theWayOfExtendsThreadClass1.start();
//		
//		TheWayOfExtendsThreadClass  theWayOfExtendsThreadClass2 = new TheWayOfExtendsThreadClass();
//		theWayOfExtendsThreadClass2.start();
//		
//		TheWayOfExtendsThreadClass  theWayOfExtendsThreadClass3 = new TheWayOfExtendsThreadClass();
//		theWayOfExtendsThreadClass3.start();
//	}
	
	public static void main(String[] args) {
		TheWayOfImplements theWayOfImplements = new TheWayOfImplements();
		new Thread(theWayOfImplements).start();
		new Thread(theWayOfImplements).start();
		new Thread(theWayOfImplements).start();
	}
}


class TheWayOfExtendsThreadClass extends Thread {
	int tickets = 10;
	@Override
	public void run() {
		while(true) {
			if(tickets <= 0) {
				System.err.println("********票已售完********");
				break;
			}
			System.out.println(getName()+"卖了一张票，票数余额："+(--tickets));
		}
	}
}


class TheWayOfImplements implements Runnable {
	int tickets = 100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(tickets <= 0) {
				System.err.println("********票已售完********");
				break;
			}
			System.out.println(Thread.currentThread().getName()+"卖了一张票，票数余额："+(--tickets));
		}
	}
	
}


