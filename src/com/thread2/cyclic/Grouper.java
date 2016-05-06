package com.thread2.cyclic;

public class Grouper implements Runnable{
	private Results results;
	public Grouper(Results results) {
		this.results = results;
	}
	@Override
	public void run() {
		int finalResult = 0;
		System.out.printf("Grouper: Processing results...\n");
		int[] data = results.getData();
		for (int numer : data) {
			finalResult += numer;
		}
		System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}
}
