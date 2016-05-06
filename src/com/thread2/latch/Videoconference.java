package com.thread2.latch;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable{
	private final CountDownLatch controller;
	public Videoconference(int number) {
		controller = new CountDownLatch(number);		
	}
	
	@Override
	public void run() {
		System.out.printf("init: %d participants.\n", controller.getCount());
		try {
			controller.await();
			System.out.printf("all have come\n");
			System.out.println("let's start...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void arrive(String name) {
		System.out.printf("%s has arrived.", name);
		controller.countDown();
		System.out.printf("wait for %d participants.\n", controller.getCount());
	}
}
