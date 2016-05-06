package com.book.demo;

import java.util.Map;

public class MonitorVehicleTracker {
	private final Map<String, MutablePoint> locations;
	public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
		this.locations = locations;
	}
	
	public synchronized Map<String, MutablePoint> getLocations() {
		return locations;
	}
	public static void main(String[] args) {
		Test test = new Test();
		for (int i = 0; i < 5; i ++) {
			new Thread(test).start();
		}
		
	}
}
class Test implements Runnable {
	private int a = 0;
	@Override
	public void run() {
		for (int i = 0; i < 10; i ++) {
			synchronized (Test.class) {
				a ++;
				System.out.println(Thread.currentThread().getName() + " : " + a);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
