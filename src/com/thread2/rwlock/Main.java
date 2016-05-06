package com.thread2.rwlock;

public class Main {
	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo();
		
		Reader[] readers = new Reader[5];
		Thread[] theadsReader = new Thread[5];
		for (int i = 0; i < 5; i ++) {
			readers[i] = new Reader(pricesInfo);
			theadsReader[i] = new Thread(readers[i]);
		}
		
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);
		for (int i = 0; i < 5; i ++) {
			theadsReader[i].start();			
		}
		threadWriter.start();
	}
}
