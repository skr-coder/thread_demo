package com.wcan.thread.method;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 * @Title: DemoOfThreadMethod.java
 * @Package: com.wcan.thread.method
 * @Description: Thread中常用的方法
 * @author: wcan
 * @date: 2020年1月8日 下午11:21:38
  * @version: V1.0
 */
public class DemoOfThreadMethod {

	//设置线程的名字
//	public static void main(String[] args) {
//		//DemoOfSetThreadName thread = new DemoOfSetThreadName("Java Thread ");
//		DemoOfSetThreadName thread = new DemoOfSetThreadName();
//		thread.setName("Thread");
//		thread.start();
//	}
	
	
	//sleep  interrupt  方法
//	public static void main(String[] args) {
//		System.out.println("main:"+Thread.currentThread().getPriority());
//		DemoOfSleepAndInterrupt st = new DemoOfSleepAndInterrupt();
//		st.start();
//		System.out.println("st:"+st.getPriority());
//		
//		for(int i=1;i<=100;i++){
//			System.out.println("岳灵珊小师妹在练剑"+i);
//			if(i==10){
//				st.interrupt();
//				break;
//			}
//		}
//	}
	
	//设置线程的优先级
//	public static void main(String[] args) {
//		
//		DemoSetPriority one = new DemoSetPriority("One");
//		one.setPriority(Thread.MAX_PRIORITY);
//		one.start();
//		
//		DemoSetPriority two = new DemoSetPriority("Two");
//		two.setPriority(Thread.MIN_PRIORITY);
//		two.start();
//		
//		DemoSetPriority three = new DemoSetPriority("Three");
//		three.setPriority(Thread.NORM_PRIORITY);
//		three.start();
//	}
	
	
	public static void main(String[] args) {
//    	DemoYeildThread demoYeildThread = new DemoYeildThread();
//    	demoYeildThread.start();
		
		DemoJoinAndYield joinAndYield = new DemoJoinAndYield();
		joinAndYield.start();
		for(int i=1;i<=500;i++){
			System.out.println("tom在买包子~~"+i);
			if(i>=5){
				try {
					joinAndYield.join();//让joinAndYield线程插队在当前线程前面去，先执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
}


class DemoJoinAndYield extends Thread {
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我要买包子~~"+i);
		}
	}
}

class DemoYeildThread extends Thread {
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		
		String str="";
		for(int i=1;i<=5000;i++){
			str+="hello"+i;
			Thread.yield();//让当前线程礼让
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时时间："+(end-start));
	}
}


/**
 * 
 * @Title: DemoOfThreadMethod.java
 * @Package: com.wcan.thread.method
 * @Description: 设置线程的优先级
 * @author: wcan
 * @date: 2020年1月8日 下午11:43:10
  * @version: V1.0
 */
class DemoSetPriority extends Thread {
	
	public DemoSetPriority(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		for(int i=1;i<=100;i++){
			System.out.println(Thread.currentThread()+"-----"+i);
		}
	}
}


/**
 * 
 * @Title: DemoOfThreadMethod.java
 * @Package: com.wcan.thread.method
 * @Description: 线程中断和休眠的方法
 * @author: wcan
 * @date: 2020年1月8日 下午11:41:03
  * @version: V1.0
 */
class DemoOfSleepAndInterrupt extends Thread {
	@Override
	public void run() {
		for(int i=1;i<=50;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("令狐冲睡醒啦，开始好好学习");
				break;
			}
			
		}
	}
}



/**
 * 
 * @Title: DemoOfThreadMethod.java
 * @Package: com.wcan.thread.method
 * @Description: 设置线程的名称
 * @author: wcan
 * @date: 2020年1月8日 下午11:29:44
  * @version: V1.0
 */
class DemoOfSetThreadName extends Thread {
//	public DemoOfSetThreadName (String name) {
//		// TODO Auto-generated constructor stub
//		super(name);
//	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++){
			System.out.println(getName()+"----"+i);
		}
	}
}