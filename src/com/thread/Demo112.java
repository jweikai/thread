package com.thread;

import java.util.Random;

public class Demo112 {
	public static void main(String[] args) {
		MyThreadGroup threadGroup = new MyThreadGroup("MythreadGroup");
		Task1 task = new Task1();
		for (int i = 0; i < 2; i ++) {
			Thread t = new Thread(threadGroup,task);
			t.start();
		}
	}
}
class MyThreadGroup extends ThreadGroup {
	public MyThreadGroup(String name) {
		super(name);
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has thrown an Exception\n", t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();	//中断
	}
}

class Task1 implements Runnable {
	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while ( true ) {
			result = 1000 / (int)(random.nextDouble()*1000);
			System.out.printf("%s: %d\n", Thread.currentThread().getId(), result);
			if ( Thread.currentThread().isInterrupted() ) {
				System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
				return ;
			}
		}
	}
}