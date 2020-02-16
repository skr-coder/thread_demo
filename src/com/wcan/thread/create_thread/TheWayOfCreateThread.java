package com.wcan.thread.create_thread;

/**
 * 
 * @Title: TheWayOfCreateThread.java
 * @Package: com.wcan.thread.create_thread
 * @Description: 创建线程的方式
 * @author: wcan
 * @date: 2020年1月3日 下午11:26:53
  * @version: V1.0
 */
public class TheWayOfCreateThread {

	public static void main(String[] args) {
		//第一种创建线程的方式
		DemoOfExtendsTheThreadClass demoOfExtendsTheThreadClass = new DemoOfExtendsTheThreadClass();
		demoOfExtendsTheThreadClass.start();
		
		//第二种创建线程的方式
		new Thread(new DemoOfImplementsRunnable()).start();
	}
}

/**
 * 
 * @Title: TheWayOfCreateThread.java
 * @Package: com.wcan.thread.create_thread
 * @Description: 继承Thread的方式来创建线程
 * @author: wcan
 * @date: 2020年1月3日 下午11:25:30
  * @version: V1.0
 */
class DemoOfExtendsTheThreadClass extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++ ) {
			if(i%2 == 0) {
				System.out.println(getName()+"---------"+i);
			}
		}
	}
}

/**
 * 
 * @Title: TheWayOfCreateThread.java
 * @Package: com.wcan.thread.create_thread
 * @Description: 实现Runnable接口的形式创建线程
 * @author: wcan
 * @date: 2020年1月3日 下午11:26:12
  * @version: V1.0
 */
class DemoOfImplementsRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++ ) {
			if(i%2 != 0) {
				System.out.println(Thread.currentThread().getName()+"*********"+i);
			}
		}
	}
}


