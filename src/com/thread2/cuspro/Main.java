package com.thread2.cuspro;

public class Main {
	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread proThread = new Thread(producer);
		Cunsumer cunsumer = new Cunsumer(storage);
		Thread cunThread = new Thread(cunsumer);
		
		cunThread.start();
		proThread.start();
	}
}
