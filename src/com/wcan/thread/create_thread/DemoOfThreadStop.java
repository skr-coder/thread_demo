package com.wcan.thread.create_thread;

/**
 * 
 * @Title: DemoOfThreadStop.java
 * @Package: com.wcan.thread.create_thread
 * @Description: 描述该文件做什么
 * @author: wcan
 * @date: 2020年2月16日 下午2:46:44
  * @version: V1.0
 */
public class DemoOfThreadStop {

	public static void main(String[] args) {
		TrystThread trystThread = new TrystThread();
		trystThread.start();
		for(int i=0; i<100; i++) {
			System.out.println("i love you");
			if(i ==20) {
				trystThread.setFlag(false);
			}
		}
	}
}
class TrystThread extends Thread {
	boolean flag = true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override 
	public void run() {
		while(flag) {
			System.out.println("i'm chatting with my god ");
		}
	}
	
}
