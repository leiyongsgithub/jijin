package com.test.spring.boot.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread extends Thread{
	Lock lock = new ReentrantLock();
	
	public void run(){
		System.out.println(this.getName()+" 开始");
		
	}
	public static void main(String[] args) {
		new TestThread().start();
		new TestThread().start();
	}
	
}
