package com.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class Demo19 {
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.setUncaughtExceptionHandler(new ExceptionHandler());	//设置线程异常处理
		thread.start();
	}
}

class ExceptionHandler implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}
	
}
class Task implements Runnable {
	@Override
	public void run() {
		int nuumero = Integer.parseInt("T");
	}
}