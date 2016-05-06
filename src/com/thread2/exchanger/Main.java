package com.thread2.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		Exchanger<List<String>> exchanger = new Exchanger<>();
		
		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);
		
		Thread proThread = new Thread(producer);
		Thread comThread = new Thread(consumer);
		proThread.start();
		comThread.start();
	}
	
}
